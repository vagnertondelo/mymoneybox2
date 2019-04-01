const saveUrl = 'save';
const errorMessage = 'Ocorreu um erro ao tentar salvar o registro.';
const confirmButton = 'Ir para a tela de login';

$(document).ready(function() {
    validate()
});

function save() {
    var obj = $(formId).serializeObject()
    var data = JSON.stringify(obj);
    saveFireSw('<h1>Finalizar Compra</h1>', 'dd', saveUrl, data);
    return 0;
}

function saveFireSw(title, text, url, data) {
    var fetchRequest = sendRequest(saveUrl, data);
    
    fetchRequest
        .then(response => response.json())
        .catch((obj) => {
	        Swal.insertQueueStep({
	            type: 'error',
	            title: 'erro'
	        })
	        errorSw("erro")
	        return false;
        }).then(obj => {
	        if (!obj.hasError) {
	        	successAlertConfirmCustom(obj, 'Sucesso!', 'Senha alterada com sucesso', confirmButton)
	        } else {
	        	errorSw(obj.error.error)
	        }
        })
}
        
function successAlertConfirmCustom(obj, title, text, confirmButtonText) {
	Swal.fire({
		  type: 'success',
		  html: HtmlSw(title, text),
		  showCloseButton: true,
		  focusConfirm: true,
		  confirmButtonText: confirmButtonText,
		  confirmButtonAriaLabel: 'Thumbs up, great!',
	}).then((result) => {
		window.location.href = contextPath + "freely/login";
	})
}
        
function sendRequest(url, data) {
    return fetch(url, {
        method: 'POST',
        headers: {
            "Content-Type": "application/json",
        },
        body: data
    })
}

function validate() {
    $(formId).validate({
        submitHandler: function(form) {
            save();
        },
        rules: {
            confirmNewPassword: {
                equalTo: "#newPassword"
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
            error.insertAfter(element).append;
        }
    });
}