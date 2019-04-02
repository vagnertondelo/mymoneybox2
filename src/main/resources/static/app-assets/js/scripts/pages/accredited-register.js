const saveUrl = 'save';
var table;
const errorMessage = 'Ocorreu um erro ao tentar salvar o registro.';
const confirmButton = 'Cadastrar Novo';
const cancelButton = 'Listar';

var rowIndex;
var clearPccashbackForm = '#clear-pccashback-form';
var removePccashback = '#remove-pccashback';
var addPccashback = '#add-pccashback';
var pccashbackId = '#pccashback-id';

var isBrazil = false;

$(document).ready(function() {
	select2Initialize()
	getLocationsToFillUpSelect2Inputs()
	validate()
	mask()
	addPercentageClick()
	onClickClearForm()
	removePercentageClick()
	openTable()
	changeAddressZipcode()
});

//percentage begin //////////////////////
function openTable() {
	$.ajax({
		url : contextPath + "accredited/rules",
		data: {
			id: 'null'
		},
		success : function(obj) {
			if (table != undefined && table != '') {
				table.clear().rows.add(obj).draw();
	    	} else {
	    		tableItself(obj)
	    	}
		}
	})
}

function addPercentageClick() {
	$(addPccashback).click(function () {
		addPercentage();
	})
}

function addPercentage() {
	var id = $(addPccashback).val();
	
	if ( validatePercentageFields() ) {
		if (rowIndex === null || rowIndex === undefined || rowIndex === '') {
			table.row.add( {
		        "id": '',
		        "description": $("#description").val(),
		        "currency": $("#currency").val(),
		        "pcCashback": $("#pcCashback").val()
		    } ).draw();
		} else {
			table.row(rowIndex).data({
				"id": '',
		        "description": $("#description").val(),
		        "currency": $("#currency").val(),
		        "pcCashback": $("#pcCashback").val()
		    }).draw()
		}
		
		resetAddButton()
		clearPercentageFields()
	}
	return 0;
}

function removePercentageClick() {
	$(removePccashback).click(function() {
		var idPercentage = $(pccashbackId).val();
		
		if (rowIndex !== '' && rowIndex !== null && idPercentage !== '' && idPercentage !== null) {
			removePercentage(idPercentage);
		} else {
			table.row(rowIndex).remove().draw();
			resetAddButton()
			clearPercentageFields()
		}
	})
}

function savePercentage(id, obj) {
	var percentageList = getPercentages();
	
	if (percentageList.length > 0) {
		percentageList.forEach(p => {
			savePercentageFinal(p, id);
		})
	} else {
		success = true;
	}
	saveLoader()
	setTimeout(function(){ print(obj) }, 1000)
}

function validatePercentageFields() {
	var isValid = true;
	$("#description-error").addClass('hidden');
	$("#pcCashback-error").addClass('hidden');
	$("#currency-error").addClass('hidden');
	
	if ( $('#description').val() === '' || $('#description').val() === null || $('#description').val() === undefined) {
		$("#description-error").removeClass('hidden');
		isValid = false;
	}
	
	if ( $('#pcCashback').val() > 99 || $('#pcCashback').val() === '' || $('#pcCashback').val() === null || $('#pcCashback').val() === undefined) {
		$("#pcCashback-error").removeClass('hidden');
		isValid = false;
	}
	
	if ( $('#currency').val() === '' || $('#currency').val() === null || $('#currency').val() === undefined) {
		$("#currency-error").removeClass('hidden');
		isValid = false;
	}
	return isValid;
}

function onClickClearForm() {
	$(clearPccashbackForm).click(function () {
		resetAddButton()
		clearPercentageFields()
	})
}

function clearPercentageFields() {
	rowIndex = "";
	$(pccashbackId).val("")
	$("#description").val("")
	$("#pcCashback").val("")
	$('#currency').val('').trigger('change');
	table.rows('.selected').deselect();
}

function resetAddButton() {
	$(clearPccashbackForm).addClass("hidden")
	$(removePccashback).addClass("hidden")
	$(addPccashback).html("<i class=\"step-icon ft-plus\"></i>Adicionar")
}

function resetForm() {
	$(':input', formId).not(':button, :submit, :reset, :hidden').val('').prop(
			'checked', false).prop('selected', false);
}

function getPercentages() {
	var credenciadoPercentualDoacaos = [];
	table.rows().every( function ( rowIdx, tableLoop, rowLoop ) {
		  var data = this.data();
		  credenciadoPercentualDoacaos.push(data);
	} );
	return credenciadoPercentualDoacaos;
}
//percentage end ////////////////////////
//cep begin ////////////////////////
function changeAddressZipcode() {
	$('#addressZipcode').change(() => {
		if (isBrazil) {
			getByCep( $('#addressZipcode').val() )
		}
	})
}

function setSelect2ValuesAutomaticallyByZipCode(obj) {
	var regionSelect = select2SearchAutomatically(regionSelect2, obj.estado_info.nome)
	
	regionSelect.then((r) => {
		select2SearchAutomatically(citySelect2, obj.cidade)
		setAdressByCep(obj)
	})
}

function setAdressByCep(obj) {
	let addressDistrict = $('#addressDistrict')
	if (obj.bairro !== '') {
		addressDistrict.val(obj.bairro)
	}
}

function getByCep(zipCode) {
	var cep = new Cep();
	cep.getCepData( zipCode ).then(r => {
		setAddressesFields(r)
		setSelect2ValuesAutomaticallyByZipCode(r)
	})
}

function setAddressesFields(r) {
	$('#addressDistrictr').val( r.bairro )
	$('#address').val( r.logradouro )
}

function select2SearchAutomatically($el, term) {
	return new Promise((res, reg) => {
		$el.select2('open');
		var $search = $el.data('select2').dropdown.$search || $el.data('select2').selection.$search;
		$search.val(term);
		$search.trigger('input');
		
		setTimeout(function() { 
			$('.select2-results__option').trigger("mouseup"); 
			res(true)
		}, 10);
	});
}

//percentage table begin////////////////////////
function tableItself(obj) {
    console.log(obj)
    table = $(tableId)
        .DataTable({
            data: obj,
            language: getLanguage(),
            columns: getColumns(),
            columnDefs: getColumnDefs(),
            initComplete: function(settings, json) {
                selectTableConfig(this.DataTable());
            },
            dom: 'Bfrtip',
            paging	: false,
            searching: false,
            select: true,
            order: [
                [1, 'asc']
            ]
        });
}

function selectTableConfig(table) {
	$('#' +table.tables().nodes().to$().attr('id')+ ' tbody').on('dblclick', 'tr', function () {
		table.rows(this).select()
		rowIndex = table.row( this ).index();
		
		var obj = table.row({
			selected : true
		}).data();
		
		$(clearPccashbackForm).removeClass("hidden")
		$(removePccashback).removeClass("hidden")
		$(addPccashback).html("Editar");
		
		tableClick(obj) 
	});
}

function tableClick(data) {
	$(pccashbackId).val(data.id)
	$("#description").val(data.description)
	$("#currency").val(data.currency).trigger('change');
	$("#pcCashback").val(data.pcCashback)
	return 0;
}

function getColumnDefs() {
	return [{
        targets: [0],
        visible: false
    }, {
        className: "dt-center",
        "targets": []
    }];
}

function getColumns() {
	 return [ { 
		 		data: "id" 
		 	},{ 
		 		title: "Descrição",
		 		data: "description" 
		 	},{ 
		 		title: "Moeda",
		 		data: "currency" 
		 	}, { 
		 		title: "Percentual %",
		 		data: "pcCashback" 
		 	}
		  ];
}
//percentage table end////////////////////////

function setSponsorAccountNo() {
	try {
		$(sponsorAccountNo).val(param.sponsorAccountNo);
	} catch (e) {
		console.log(e)
	}
}

function save() {
	if($("#addressCityCode").val() === '') {
		$("#addressRegionCode").val('')
	}
	$('#countryIsoCode').val( $('#addressCountryIsoCode').val() )
	
	var obj = $(formId).serializeObject()
	var obj2 = getPercentages();
	var object = $.extend(obj, {rules: obj2});
	var data = JSON.stringify(object);
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
					updateToken(obj.token)
					if (!obj.hasError) {
						successAlert(obj, title, text, resolve, confirmButton, cancelButton)
					} else {
						errorSw(obj.error.error)
					}
				} 
			})
			
		}).then(function (r) {
			if (r) {
				window.location.href = contextPath + "accredited/register";
			} else {
				window.location.href = contextPath + "accredited/list";
			}
		})
}

function updateToken(token) {
	$("#token").val(token)
}

function select2Initialize() {
	countrySelect2 = $('.countries').select2();
	regionSelect2 = $('.state').select2();
	citySelect2 = $('.city').select2();
	
	$('.codeCategory').select2();
	$('#currency').select2();
}

//select countries begin ////////////////////////
function getLocationsToFillUpSelect2Inputs() {
	let getCountriesPromise = getCountries();
	getCountriesPromise.then(c => {
		if (c) {
			let countries = c;
			setCountriesSelect2(countries)
			setOnChangeCountriesEvent(countries)
		} else {
			getLocationsToFillUpSelect2Inputs()
		}
	})
}

function getCountries() {
	return new Promise((resolve, reject) => {
		$.ajax({
			url : contextPath + "freely/locations",
			type: 'POST',
			beforeSend: function() {
				block('.blockit')
		    },
		}).done(function(data) {
			if (data != undefined && data != '') {
				unblock('.blockit')
				resolve(data);
			}
			setTimeout(function() {
				resolve(false);
			}, 5000);
		});
	});
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
		if (selectedCountry == 'Brazil') {
			isBrazil = true;
		} else {
			isBrazil = false;
		}
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

function setRegionsSelect2(regions){
	$('.state').select2({
		data: rMapped(regions)
	})
}
//select countries end ////////////////////////

function sorop(regionName) {
	$('.sorop').html(regionName)
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

function validate() {
	$(formId).validate({
		submitHandler : function(form) {
			save();
		},
		ignore: [],
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
             rows: {
            	 percentages: true
             },
             login: {
            	 remote : {
 					url : contextPath + "freely/islogin",
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
  					url : contextPath + "freely/isemail",
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
             },
             codeCategory : {
 				valueNotEquals: true
 			 },
 			 countryIsoCode : {
  				valueNotEquals: true
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
		    if ( element.prop('id') === 'countryIsoCode' || element.prop('id') === 'codeCategory' ) {
                error.appendTo(element.parent());
            } else {
            	error.insertAfter(element);
            }
		}
	});
}
