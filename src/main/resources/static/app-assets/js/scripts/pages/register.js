$(document).ready(function() {
	stepsValidation();
	flagsSelect2()
	select2Initialize()
	var input = document.querySelector("#phone");
	getLocations()
});



function getLocations() {
	$.ajax({
		url : "locations",
		type: 'POST',
	}).done(function(data) {
		var items = [];
		var countries = data.countries;
		
		countries.forEach( c => {
			$('.countries').append(new Option(c.name, c.isoCode, false, false)).trigger('change');
        });

		$(".countries").change(function () {	
			var str = "";					
			$(".countries option:selected").each(function () {
				str += $(this).text();
			});
			
			countries.forEach( c => {
				if(c.name == str) {
					var regions = c.regions;
					$('.state').empty()
					
					regions.forEach( r => {
						$('.state').append(new Option(r.name, r.isoCode, false, false)).trigger('change');
			        });
					
					$(".state").change(function () {	
						var state = "";					
						$(".state option:selected").each(function () {
							state += $(this).text();
						});
						
						regions.forEach( r => {
							if(r.name == state) {
								var cities = r.cities;
								$('.city').empty()
								cities.forEach( r => {
									$('.city').append(new Option(r.name, r.isoCode, false, false)).trigger('change');
						        });
							}
				        });
					}).change();
				}
	        });
			
		}).change();

//		$(".state").change(function () {	
//			var options_cidades = '';
//			var str = "";					
//			$(".state option:selected").each(function () {
//				str += $(this).text();
//			});
//			
//			$.each(data, function (key, val) {
//				if(val.nome == str) {
//					console.log(val.cidades)
//					$('.city').empty()
//					$(".city").select2({
//						  data: val.cidades
//					})
//				}
//			});
//			
//		}).change();
		
	});
}

function select2Initialize() {
	$('.countries').select2()
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
