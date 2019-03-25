const saveUrl = 'save';
const errorMessage = 'Ocorreu um erro ao tentar salvar o registro.';
const confirmButton = 'Registrar Nova Compra';
const cancelButton = 'Sair';

var codeRule = $('#codeRule');

$(document).ready(function() {
	select2Initialize()
	validate()
	mask()
});

function save() {
	
	let floatSaleAmountTempt = brlToFloat( $('#saleAmount').val() ).toFixed(2)
	let floatSaleAmount = parseFloat(floatSaleAmountTempt)
	var brlSaleAmount = floatToBrl( floatSaleAmount );
	$('#saleAmount').val( floatSaleAmount )
	
	var obj = $(formId).serializeObject()
	var data = JSON.stringify(obj);
	saveFireSw('<h1>Finalizar Compra</h1>', '<br><h5>Valor da doação: '+brlSaleAmount+' </5> <h5>Valor da final: '+getCashBack(floatSaleAmount)+' </5>', saveUrl, data);
	return 0;
}

function getCashBack(value) {
	let cashBack = parseFloat($("#codeRule option:selected").data("cashback"));
	let p = cashBack * value;
	let r  = p/100;
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
		}).then(function (r) {
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
        ignore: [],
        rules: {
            codeRule: {
                valueNotEquals: true
            },
            codeAccount: {
            	digits: true
            },
            accountNo: {
            	digits: true
            },
            identity: {
                required: function(element) {
                	if (!isBlank($("#codeAccount").val())) 
                		return false;
                	if (!isBlank($("#taxid").val()))
                		return false;
                	if (!isBlank($("#phone").val()))
                		return false;
                	if (!isBlank($("#accountNo").val()))
                		return false;
                	return true;
                }
            }
        },
        messages: {
        	identity: {
        		required: "Preencha um dos seguintes campos: Documento do Consumidor, Código da Conta, Número da Conta, Telefone"
        	}
        },
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






