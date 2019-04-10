const saveUrl = 'save';
const accounts = 'sale/getaccounts';
const rules = 'sale/getrules';
var delay = 300;

const errorMessage = 'Ocorreu um erro ao tentar salvar o registro.';
const confirmButton = 'Registrar Nova Compra';
const cancelButton = 'Listar';
var accountNoTypeHead;

var codeRule = $('#codeRule');

$(document).ready(function() {
    select2Initialize()
    validate()
    mask()
    typeHead()
    getRulesToFillUpSelect2Inputs()
});

function getRulesToFillUpSelect2Inputs() {
	let getRulesPromise = getRules();
	getRulesPromise.then(r => {
		if (r) {
			let rules = r;
			setRulesSelect2(rules)
			unblock('.blockit')
		} else {
			getRulesToFillUpSelect2Inputs()
		}
	})
}

function setRulesSelect2(c) {
	$('.codeRule').select2({
		data: cMappedRules(c)
	})
}

function cMappedRules(c) {
    var mappedRules = [{
        id: '',
        text: 'Selecione uma opção'
    }];
    $('.rules').empty()
    var mapped = c.map(c => {
        return {
            id: c.code,
            text: c.pcCashback + "%"
        }
    });
    var returnedTarget = $.merge(mappedRules, mapped);
    return returnedTarget;
}

function getRules() {
	return new Promise((resolve, reject) => {
		$.ajax({
			url : contextPath + rules,
			type: 'POST',
			beforeSend: function() {
				block('.blockit')
		    },
		}).done(function(data) {
			if (data != undefined) {
				resolve(data);
			}
		});
	});
}

function typeHead() {
	accountNoTypeHead = new Bloodhound({
        datumTokenizer: Bloodhound.tokenizers.obj.whitespace,
        queryTokenizer: Bloodhound.tokenizers.whitespace,
        rateLimitWait: 1000,
        rateLimitBy: 'throttle',
        remote: {
            url: contextPath + accounts + '#%QUERY',
            wildcard: '%QUERY',
            transport: function(opts, onSuccess, onError) {
                var url = opts.url.split("#")[0];
                var query = opts.url.split("#")[1];
                
                setTimeout(() => { 
                	 $.ajax({
                         url: url,
                         data: "query=" + query,
                         type: "POST",
                         success: onSuccess,
                         error: onError,
                     })
                }, delay)
            },
            filter: function(data) {
                return data;
            }
        }
    })
	accountNoTypeHead.initialize();
    $('.typeahead-basic').typeahead(null, {
        name: 'Conta',
        display: function(data) {
            return data.text;
        },
        limit: Infinity,
        templates: {
            empty: [
                '<div class="empty-message">',
                'Nem um registro encontrado',
                '</div>'
            ].join('\n'),
            suggestion: function(data) {
                return "<div class='omniboxresult'><div class='caseName'>" + data.text + "</div></div>";
            }
        },
        source: accountNoTypeHead.ttAdapter()
    }).on('typeahead:select', function(ev, obj) {
        $('#accountNo').val(obj.id);
    });
}

function save() {
    let floatSaleAmountTempt = brlToFloat($('#saleAmount').val()).toFixed(2)
    let floatSaleAmount = parseFloat(floatSaleAmountTempt)
    var brlSaleAmount = floatToBrl(floatSaleAmount);
    $('#saleAmount').val(floatSaleAmount)

    var obj = $(formId).serializeObject()
    var data = JSON.stringify(obj);
    saveFireSw('<h1>Finalizar Compra</h1>', '<br><h5>Valor da doação: ' + brlSaleAmount + ' </5> <h5>Valor da final: ' + getCashBack(floatSaleAmount) + ' </5>', saveUrl, data);
    return 0;
}

function getCashBack(value) {
    let cashBack = parseFloat( $('#codeRule').val() );
    let p = cashBack * value;
    let r = p / 100;
    return floatToBrl(r);
}

function saveFireSw(title, text, url, data) {
    Swal.fire({
        html: HtmlSw(title, text),
        showLoaderOnConfirm: true,
        confirmButtonClass: 'btn btn-primary btn-min-width btn-glow mr-1 mb-1',
        confirmButtonText: 'Enviar',
        buttonsStyling: false,
        preConfirm: function() {
            return fetch(url, {
                    method: 'POST',
                    headers: {
                        "Content-Type": "application/json",
                    },
                    body: data
                })
                .then(response => response.json())
                .catch((obj) => {
                    debugger
                    Swal.insertQueueStep({
                        type: 'error',
                        title: 'erro'
                    })
                    return false;
                })
        }
    }).then(function(obj) {
        return new Promise(resolve => {
            if (obj.value != undefined) {
                obj = obj.value;
                if (!obj.hasError) {
                    successAlert(obj, 'Sucesso!', 'Compra Registrada com Sucesso', resolve, confirmButton, cancelButton)
                } else {
                    errorSw(obj.error.error)
                }
            }
        })
    }).then(function(r) {
        if (r) {
            window.location.href = contextPath + "sale/register";
        } else {
            window.location.href = contextPath + "sale/list";
        }
    })
}

function isBlank(str) {
    return (!str || /^\s*$/.test(str));
}

function validate() {
    $(formId).validate({
        submitHandler: function(form) {
            save();
        },
        rules: {
            codeRule: {
                valueNotEquals: true
            },
            accountNoTypeHead: {
            	required: true
            }
        },
        messages: {},
        errorClass: 'help-block',
        errorElement: 'div',
        success: function(label, element) {
            label.parent().removeClass('error')
        },
        highlight: function(element, errorClass, validClass) {
            $(element).parent().addClass('error')
        },
        errorPlacement: function(error, element) {
            if (element.prop('id') === 'codeRule') {
                error.appendTo(element.parent());
            } else {
                error.insertAfter(element);
            }
        }
    });
}

function select2Initialize() {
    $('.select2').select2()
}