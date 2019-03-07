$(document).ready(function() {
	stepsValidation();
	flagsSelect2()
	select2Initialize()
	getCidadesByEstadosBrazil()
});

function select2Initialize() {
	$('.state').select2();
	$('.city').select2();
}

function stepsValidation() {
	var form = $(".steps-validation").show();
    validate(form)
	$(".steps-validation").steps({
		headerTag : "h6",
		bodyTag : "fieldset",
		transitionEffect : "fade",
		titleTemplate : '<span class="step">#index#</span> #title#',
		enablePreviusButton : true,
		onCanceled : function(event) {
			window.location.href = contextPath + "/admin/credenciado/lista";
		},
		labels : {
			previous : '<i class="fa fa-chevron-left"></i> Voltar',
			next : "Próximo",
			finish : "Voltar a página anterior"
		},
//		onStepChanging: function(e, t, i) {
//			 return form.validate().settings.ignore = ":disabled,:hidden",
//			 form.valid();
//		},
		onInit : function(event, current) {
			$('.actions > ul > li:first-child').attr('style', 'display:none');
			$('.actions > ul > li:last-child a').html('Salvar');
		},
		onFinishing : function(e, i) {
			return form.validate().settings.ignore = ":disabled", form.valid()
		},
		onFinished : function(e, i) {
			save()
		}
	});
}

function getCidadesByEstadosBrazil() {
	$.getJSON(contextPath + '/app-assets/json/estados_cidades.json', function (data) {
		var items = [];
		var options = '<option value="">Escolha um estado</option>';	
		
		$.each(data, function (key, val) {
			$('.state').append(new Option(val.nome, val.sigla, false, false)).trigger('change');
		});		
		
		$(".state").change(function () {	
			var options_cidades = '';
			var str = "";					
			$(".state option:selected").each(function () {
				str += $(this).text();
			});
			$.each(data, function (key, val) {
				if(val.nome == str) {
					console.log(val.cidades)
					$('.city').empty()
					$(".city").select2({
						  data: val.cidades
					})
				}
			});
		}).change();		
	});
}

function validate(form) {
	form.validate({
		submitHandler : function(form) {
			$(formId)[0].submit();
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
			error.insertAfter(element).append;
		}
	});

}
