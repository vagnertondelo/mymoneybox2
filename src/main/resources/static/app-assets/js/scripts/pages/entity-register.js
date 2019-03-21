const saveUrl = 'save';
var table;
const errorMessage = 'Ocorreu um erro ao tentar salvar o registro.';
const confirmButton = 'Fechar';

var entityName;
var rowIndex;
var code = 0;
var dataEntity;

var rowIndex;
var clearItemForm = '#clear-item-form';
var removeItem = '#remove-item';
var addItem = '#add-item';
var itemId = '#item-id';
var saveButton = $('#save-button');

$(document).ready(function() {
	select2Initialize()
	table()
	validate()
	percentageSum()
	onClickSaveButton()
});

function onClickSaveButton() {
	saveButton.click(function() {
		save();
	})
}

function select2Initialize() {
	$('.select2').select2()
}

// item begin ////////////////////////////////////////
function table() {
    table = $(tableId)
        .DataTable({
        	ajax: {
				type: "GET",
				url: contextPath + "entity/getlist",
				dataSrc:""
			},
			autoWidth: false,
			searching: false,
			dom : 'Bfrtip',
			select : 'single',
			autoWidth: false,
            language: getLanguage(),
            buttons: getButtons(),
            columns: getColumns(),
            columnDefs: getColumnDefs(),
            initComplete: function(settings, json) {
                selectTableConfig(this.DataTable());
            },
            select: true,
            order: [
                [1, 'asc']
            ]
        });
}

function selectDeselectTable(table) {
	var selectedRows = table.rows( { selected: true } ).count();
    table.buttons( [1] ).enable( selectedRows > 0 );
    table.buttons( [0] ).enable( selectedRows == 0 );
}

function selectTableConfig(table) {
	table.on( 'select', function () {
		selectDeselectTable(table)
	});
	
	table.on( 'deselect', function () {
		clearForm();
		$('#entityCode').val('').trigger('change');
		selectDeselectTable(table)
	});
	
	$(tableId + ' tbody').on( 'dblclick', 'tr', function() {
		table.rows(this).select()
		rowIndex = table.row( this ).index();
		var obj = table.row({
			selected : true
		}).data();
		tableClick(obj)
	});
	
}

function tableClick(data) {
	dataEntity = data.entity;
	
	setValueSelect2(dataEntity)
	
	data.code ? code = data.code : code = ''; 
	$("#pcEntity").val(data.pcEntity)
	$("#entityCode").val(data.entityCode)
	return 0;
}

function edition(data) {
	entityName = $(".select2 option:selected").text();
	
	if ($(formId).valid()) {
		table.row(rowIndex).data({
			"code": code,
	        "pcEntity": $("#pcEntity").val(),
	        "entityCode": $("#entityCode").val(),
	        "entity": dataEntity
	    }).draw()
	}
}

function clearForm() {
	$("#pcEntity").val("")
}

function setValueSelect2(data) {
	if ($('#entityCode').find("option[value='" + data.code + "']").length) {
	    $('#entityCode').val(data.code).trigger('change');
	} else { 
	    var newOption = new Option(data.name, data.code, true, true);
	    $('#entityCode').append(newOption).trigger('change');
	} 
}

function addPercentage() {
	entityName = $(".select2 option:selected").text();
	if ($(formId).valid()) {
		table.row.add( {
	        "code": "",
	        "entityCode": $("#entityCode").val(),
	        "pcEntity": $("#pcEntity").val(),
	    } ).draw();
		clearForm()
	}
	return 0;
}

function save() {
	var obj = getItems();
	var data = JSON.stringify(obj);
	saveFireSw('<h1>Finalizar Registro</h1>', 'Clique abaixo para continuar.', saveUrl, data);
	return 0;
}

function getItems() {
	var items = [];
	table.rows().every( function ( rowIdx, tableLoop, rowLoop ) {
		  var data = this.data();
		  items.push(data);
	} );
	var mappedItems = items.map(c => {
		return {code: c.code, pcEntity: c.pcEntity, entityCode: c.entityCode}
	});
	return { entities: mappedItems };
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
					if (!obj.hasError) {
						success(title, text, resolve, confirmButton)
					} else {
						errorSw(obj.error.error)
					}
				} 
			})
			
		}).then(function (r) {
			if (r) {
//				window.location.href = contextPath + "entity/register";
			} else {
//				window.location.href = contextPath + "entut/list";
			}
		})
}

function success(title, text, resolve, confirmButtonText) {
	debugger
	Swal.fire({
		  type: 'success',
		  html: HtmlSw(title, text),
		  showCloseButton: true,
		  showCancelButton: false,
		  focusConfirm: true,
		  confirmButtonText: '<i class="ft-thumbs-up"></i> ' +confirmButtonText+ '',
		  confirmButtonAriaLabel: 'Thumbs up, great!',
	}).then((result) => {
		if (result.dismiss === undefined) {
			resolve(true)
		} else {
			resolve(false)
		}
	})
}

function getColumnDefs() {
	return [{
        targets: [0, 3],
        visible: false
    }, {
        className: "dt-center",
        "targets": []
    }];
}

function getColumns() {
	 return [ { 
		 		data: "code"
		 	}, {
		 		title: "Entidade",
		 		data: "entity",
		 		render: function(data, type, full) {
	            	return data != undefined ? data.name : entityName; 
	            }
		 	}, { 
		 		title: "Percentual %",
		 		data: "pcEntity" 
		 	}, {
		 		title: "entityCode",
		 		data: "entityCode"
		 	}
		  ];
}

function validate() {
	$(formId).validate({
		submitHandler : function(form) {
			addPercentage();
		},
		rules : {
		},
		messages: {},
		errorClass : 'help-block',
		errorElement : 'div',
		success : function(label, element) {
			label.parent().removeClass('error')
		},
		highlight : function(element, errorClass, validClass) {
			$(element).parent().addClass('error')
		},
		errorPlacement : function(error, element) {
		    if ( element.prop('id') === 'entityCode') {
                error.appendTo(element.parent());
            } else {
            	error.insertAfter(element);
            }
		}
	});
}

function percentageSum() {
	jQuery.validator.addMethod("percentageSum", function(value, element) {
		var x = getItems();
		var b = 0;
		x.entities.forEach(y => {
			b += y.pcEntity; 
		})
	    if (b < 100) return true;
	}, "A soma de todas as porcentagens adicionadas não pode ultrapassar a 100!");
}

function foo() {
	var x = getItems();
	var b = 0;
	x.entities.forEach(y => {
		b += y.pcEntity; 
	})
    console.log(b)
}

function getButtons() {
	return  [ {
		        text: ' <i class="la la-plus font-small-2"></i> Adicionar',
		        className: 'btn btn-primary box-shadow-2 btn-min-width pull-left',
		        action: function(e, dt, node, config) {
		        	$(formId).submit()
		        },
		        enabled: true
		    }, {
		        text: '<i class="ft-edit-2 font-small-2"></i>',
		        className : 'btn btn-info box-shadow-2 btn-min-width pull-left',
		        attr:  {
		        	 'data-position':'top', 
		        	 'data-delay':'50',
		        	 'data-tooltip': 'Limpar Formulário'
		        },
		        action: function ( e, dt, node, config ) {
		        	edition()
		        },
		        enabled: false
		    }];
}

