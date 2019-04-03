let saveUrl = "recoverypassword"
const confirmButton = 'Login';

$(document).ready(function() {
    validate();
});

function validate() {
    $(formId).validate({
        submitHandler: function(form, event) {
            save();
        },
        rules: {},
        errorClass: 'help-block',
        errorElement: 'div',
        success: function(label, element) {
            label.parent().removeClass('error')
        },
        highlight: function(element, errorClass, validClass) {
            $(element).parent().addClass('error')
        },
        errorPlacement: function(error, element) {
            error.insertAfter(element);
        }
    });
}

function save() {
    var data = $(formId).serializeObject()
    var saveRequestAjaxPromise = saveRequestAjax(data);
    block2('.blockit')
    saveRequestAjaxPromise.then(obj => {
    	unblock('.blockit')
    	successAlertPassword(obj, "Sucesso", "Um email foi enviado para voce.", confirmButton);
    })
    return 0;
}

function successAlertPassword(obj, title, text, confirmButtonText) {
    Swal.fire({
        type: 'success',
        html: HtmlSw(title, text),
    }).then((result) => {
    	window.location.href = contextPath + "freely/login";
    })
}

function saveFireSw(title, text, url, data) {
    Swal.fire({
        html: HtmlSw(title, text),
        target: $("content-body"),
        showLoaderOnConfirm: true,
        confirmButtonClass: 'btn btn-primary btn-min-width btn-glow mr-1 mb-1',
        confirmButtonText: 'Enviar',
        buttonsStyling: false,
        preConfirm: function() {
        	return saveRequestAjax(data);
        }
    }).then(function(obj) {
        return new Promise(resolve => {
            if (obj.value != undefined) {
            	successAlertPassword(obj, title, text, resolve, confirmButton)
            }
        })
    }).then(function(r) {
        window.location.href = contextPath + "freely/login";
    })
}

function saveRequestAjax(data) {
	return new Promise(res  => {
		$.ajax({
		    type: "post", 
		    url: saveUrl,
		    data: data,
		    success: function (data) {
		        res(data)
		    },
		    error: function (request, status, error) {
		    	errorSw(request.responseText);
		    	res(false);
		    }
		});
    })
}










