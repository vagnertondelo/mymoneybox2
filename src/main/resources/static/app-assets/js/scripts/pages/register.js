$(document).ready(function() {
	stepsValidation();
	select2Initialize()
	getLocationsToFillUpSelect2Inputs()
});

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
			previous : 'Voltar',
			next : "Próximo",
			finish : "Salvar"
		},
		onStepChanging: function(e, t, i) {
			 return form.validate().settings.ignore = ":disabled,:hidden",
			 form.valid();
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
	$.ajax({
		type : "POST",
		data : $(formId).serializeObject(),
		url : contextPath + "/admin/credenciado/salvar",
		success : function(obj) {
			if (obj.sucesso) {
				savePercentage(obj.obj.id, obj);
			} else {
				swal("Cancelado", obj.message, "error");
				return 0;
			}
		}
	})
	return false;
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

function getLocationsToFillUpSelect2Inputs() {
	$.ajax({
		url : "locations",
		type: 'POST',
	}).done(function(data) {
		var countries = data.countries;
		setCountriesSelect2(countries)
		setOnChangeCountriesEvent(countries)
	});
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
	}).change();
}

function setSelect2RegionsByCountry(countries, selectedCountry) {
	sorop(selectedCountry)
	countries.forEach( c => {
			if(c.name == selectedCountry) {
				sorop(c.regionName)
				setRegionsSelect2(c.regions)
				setOnChangeRegionsEvent(c.regions)
			}
	})
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
	$('.countries').empty()
	return c.map(c => {
		return {id: c.isoCode, text: c.name}
	});
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
