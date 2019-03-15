const saveUrl = 'save';
var object;

const param = getParamUrl();

$(document).ready(function() {
	console.log(param)
	stepsValidation();
	select2Initialize()
	getLocationsToFillUpSelect2Inputs()
	setSponsorAccountNo()
	mask()
});

function setSponsorAccountNo() {
	try {
		$(sponsorAccountNo).val(param.sponsorAccountNo);
	} catch (e) {
		console.log(e)
	}
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
		onInit: function () {
			$('.app-content .wizard>.actions>ul').prepend('<li aria-hidden="false" aria-disabled="false"><a href="login" role="menuitem">Voltar a tela de Login</a></li>')
		},
		labels : {
			previous : 'Voltar',
			next : "Próximo",
			finish : "Salvar"
		},
		onStepChanging: function(e, t, i) {
			$('.actions > ul > li:first-child').attr('style', 'display:block');
			form.valid()
			
			var a = (form.validate().settings.ignore = ":disabled,:hidden", form.valid());
			
			return a;
		},
		onFinishing : function(e, i) {
			return form.validate().settings.ignore = ":disabled", form.valid()
		},
		onFinished : function(e, i) {
			save()
		}
	});
}

function save() {
	if($("#addressCityCode").val() === '') {
		$("#addressRegionCode").val('')
	}
	
	var data = JSON.stringify($(formId).serializeObject());
	var obj = saveFireSw('<h1>Finalizar Registro</h1>', 'Clique abaixo para continuar.', saveUrl, data);
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
		  		Swal.insertQueueStep({
		  			type: 'error',
		  			title: 'erro'
		  		})
		  		return false;
		  	})
		  }
		}).then(function(obj) {
			if (obj.value != undefined) {
				obj = obj.value;
				updateToken(obj.token)
				if (!obj.hasError) {
					successAlert(obj, title, text)
					window.location.href = contextPath + "dashboard";
				} else {
					errorSw(obj.error.error)
				}
			} 
		})
}

function validate(form) {
	form.validate({
		onsubmit: true,
		onkeyup: false,
		onclick: false,
		onfocusout: false,
		rules : {
			 countryIsoCode : {
				valueNotEquals: true
			 },
			 passwordConfirm : {
                 equalTo : "#password"
             },
             login: {
            	 remote : {
 					url : "islogin",
 					type : "GET",
 					data : {
 						login : function() {
 							return $("#login").val()
 						}
 					},
 					dataFilter : function(obj) {
 						obj = jQuery.parseJSON(obj);
 						updateToken(obj.token)
						if (obj.isvalid) {
							return true;
						}
						return false;
					}
            	 }
             },
             email: {
            	 remote : {
  					url : "isemail",
  					type : "GET",
  					data : {
  						email : function() {
  							return $("#email").val()
  						}
  					},
  					dataFilter : function(obj) {
  						obj = jQuery.parseJSON(obj);
  						updateToken(obj.token)
						if (obj.isvalid) {
							return true;
						}
						return false;
					}
            	 } 
             }
		},
		messages: {
			email: {
				remote: "Email já está cadastrado no sistema"
			},
			login: {
				remote: "Login já está cadastrado no sistema"
			}
		},
		errorClass : 'help-block',
		errorElement : 'div',
		success : function(label, element) {
			label.parent().removeClass('error')
		},
		highlight : function(element, errorClass, validClass) {
			$(element).parent().addClass('error')
		},
		errorPlacement : function(error, element) {
		    if (element.prop('id') === 'countryIsoCode') {
                error.appendTo(element.parent());
            } else {
            	error.insertAfter(element);
            }
		}
	});
}

function getLocationsToFillUpSelect2Inputs() {
	$.ajax({
		url : "locations",
		type: 'POST',
		beforeSend: function() {
			block()
	    },
	}).done(function(data) {
		if (data === '') {
			errorGenericSw("Erro", "Países não cadastrados")
		}
		updateToken(data.token);
		var countries = data.countries;
		setCountriesSelect2(countries)
		setOnChangeCountriesEvent(countries)
	});
}

function updateToken(token) {
	$("#token").val(token)
}

function select2Initialize() {
	$('.countries').select2()
	$('.state').select2();
	$('.city').select2();
}

function setCountriesSelect2(c) {
	$('.countries').select2({
		data: cMappedCountries(c)
	})
	
	$('.country').select2({
		data: cMappedCountry(c)
	})
}

function setOnChangeCountriesEvent(countries) {
	$('.countries').change(function () {
		var selectedCountry = getWhichCountryIsSelected();
		setSelect2RegionsByCountry(countries, selectedCountry)
	});
}

function setSelect2RegionsByCountry(countries, selectedCountry) {
	var hasSelectedCountry = false;
	sorop(selectedCountry)
	countries.forEach( c => {
		if(c.name === selectedCountry) {
			sorop(c.regionName)
			setRegionsSelect2(c.regions)
			setOnChangeRegionsEvent(c.regions)
			hasSelectedCountry = true;
		}
	})
	if (!hasSelectedCountry) {
		$('.state').empty()
		$('.city').empty()
	}
}

function sorop(regionName) {
	$('.sorop').html(regionName)
}

function setRegionsSelect2(regions){
	$('.state').select2({
		data: rMapped(regions)
	})
}

function setOnChangeRegionsEvent(regions) {
	$('.state').change(function () {	
		selectedRegion = getWhichRegionIsSelected();
		setSelect2CitiesByRegions(regions, selectedRegion)
	}).change();
}

function setSelect2CitiesByRegions(regions, selectedRegion) {
	regions.forEach( r => {
		if(r.name == selectedRegion) {
			$('.city').select2({
				data: ciMapped(r.cities)
			})
		}
    });
} 

function getWhichCountryIsSelected() {
	var str = "";	
	$('.countries option:selected').each(function () {
		str += $(this).text();
	});
	return str;
}

function getWhichRegionIsSelected() {
	var str = "";	
	$('.state option:selected').each(function () {
		str += $(this).text();
	});
	return str;
}

function cMappedCountries(c) {
	var mappedCountries = [{id: '', text: 'Selecione uma opção'}];
	$('.countries').empty()
	var mapped = c.map(c => {
		return {id: c.isoCode, text: c.name}
	});
	var returnedTarget = $.merge(mappedCountries, mapped);
	return returnedTarget;
}

function cMappedCountry(c) {
	return c.map(c => {
		return {id: c.isoCode, text: c.name}
	});
}

function rMapped(r) {
	$('.state').empty()
	return r.map(c => {
		return {id: c.code, text: c.name}
	});
}

function ciMapped(ci) {
	$('.city').empty()
	return ci.map(c => {
		return {id: c.code, text: c.name}
	});
}
