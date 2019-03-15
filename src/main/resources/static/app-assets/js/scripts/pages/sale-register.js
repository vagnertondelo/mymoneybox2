const saveUrl = 'save';
const errorMessage = 'Ocorreu um erro ao tentar salvar o registro.';

$(document).ready(function() {
	select2Initialize()
	validate()
	mask()
});

function save() {
	$('#saleAmount').val(realToNumber( $('#saleAmount').val() ))
	var obj = $(formId).serializeObject()
	var data = JSON.stringify(obj);
	saveFireSw('<h1>Finalizar Registro</h1>', 'Clique abaixo para continuar.', saveUrl, data);
	return 0;
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
			debugger
			if (obj.value != undefined && obj.value.status === undefined) {
				obj = obj.value;
				if (!obj.hasError) {
					successAlert(obj, 'Sucesso!', 'Compra registrada como sucesso.')
				} else {
					errorSw(errorMessage, obj.error.error);
				}
			} else {
				errorSw(errorMessage, obj.value.status);
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






