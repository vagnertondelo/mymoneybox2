$(document).ready(function() {
	validator();
});

function validator() {
	$(formId).validate({
		submitHandler : function(form, event) {
			 event.preventDefault();
		},
		rules : {},
		errorClass : 'help-block',
		errorElement : 'div',
		success : function(label, element) {
			label.parent().removeClass('error')
		},
		highlight : function(element, errorClass, validClass) {
			$(element).parent().addClass('error')
		},
		errorPlacement : function(error, element) {
			error.insertAfter(element);
		}
	});
}