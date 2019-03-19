const saveUrl = 'save';
var table;
const errorMessage = 'Ocorreu um erro ao tentar salvar o registro.';
var entityName;

var rowIndex;
var clearItemForm = '#clear-item-form';
var removeItem = '#remove-item';
var addItem = '#add-item';
var itemId = '#item-id';

$(document).ready(function() {
	select2Initialize()
	table()
	validate()
	percentageSum()
});

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
    table.buttons( [1,2] ).enable( selectedRows > 0 );
}

function selectTableConfig(table) {
	genericTableId = (table);
	table.on( 'select deselect', function () {
		 selectDeselectTable(table)
	});
	
	$(genericTableId + ' tbody').on(
			'dblclick',
			'tr',
			function() {
				table.rows(this).select()
				var obj = table.row({
					selected : true
				}).data();
				
				window.location.href = contextPath
						+ "/admin/socio/socio?id=" + obj.id;
				
			});
	
	$(genericTableId).on( 'length.dt', function ( e, settings, newlen ) {
	    len = newlen;
	    table.ajax.reload();
	} );
}

function addPercentage() {
	entityName = $(".select2 option:selected").text();
	if ($(formId).valid()) {
		table.row.add( {
	        "code": "",
	        "entityCode": $("#entityCode").val(),
	        "pcEntity": $("#pcEntity").val()
	    } ).draw();
		
//		resetAddButton()
//		clearPercentageFields()
	}
	return 0;
}

function save() {
	addPercentage()
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
			if (obj.value != undefined) {
				obj = obj.value;
				if (!obj.hasError) {
					successAlert(obj, 'Cadastrado com sucesso!', 'Parabéns você agora está cadastrado no sistema.')
				} else {
					errorSw(errorMessage, obj.error.error);
				}
			} 
		})
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
		 		data: "code"
		 	},{ 
		 		title: "Percentual %",
		 		data: "pcEntity" 
		 	}, {
		 		title: "entity",
		 		data: "entity",
		 		render: function(data, type, full) {
	            	return data != undefined ? data.name : entityName; 
	            }
		 	}, {
		 		title: "entityCode",
		 		data: "entityCode"
		 	}
		  ];
}

function validate() {
	$(formId).validate({
		submitHandler : function(form) {
			save();
		},
		rules : {
			pcEntity: {
				percentageSum: true
			}
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
		        	var obj = dt.row( { selected: true } ).data();
		        	promtpRemove(obj.id)
		        },
		        enabled: false
		    },
		    {
		        text: '<i class="ft-trash-2 font-small-2"></i>',
		        className : 'btn btn-danger box-shadow-2 btn-min-width pull-left',
		        attr:  {
		        	 'data-position':'top', 
		        	 'data-delay':'50',
		        	 'data-tooltip': 'Limpar Formulário'
		        },
		        action: function ( e, dt, node, config ) {
		        	var obj = dt.row( { selected: true } ).data();
		        	promtpRemove(obj.id)
		        },
		        enabled: false
		    }];
}

