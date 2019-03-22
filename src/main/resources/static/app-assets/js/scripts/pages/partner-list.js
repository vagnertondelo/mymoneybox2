var table;

$(document).ready(function() {
	table()
	
})

function table() {
    table = $(tableId)
        .DataTable({
        	ajax: {
				type: "GET",
				url: contextPath + "partner/getlist",
				dataSrc:""
			},
            language: getLanguage(),
            columns: getColumns(),
            buttons: getButtons(),
            columnDefs: getColumnDefs(),
            initComplete: function(settings, json) {
                selectTableConfig(this.DataTable());
            },
            dom: 'Bfrtip',
            select: true,
            order: [
                [1, 'asc']
            ]
        });
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

function getTableId (table) {
	return '#'+table.tables().nodes().to$().attr('id');
}

function selectDeselectTable(table) {
	var selectedRows = table.rows( { selected: true } ).count();
    table.button( 1 ).enable( selectedRows > 0 && selectedRows < 2 );
}

function promtpRemove(id) {
	swal({
	    title: "Remover",
	    text: "Tem certeza que deseja remover esse registro?",
	    icon: "warning",
	    buttons: {
            cancel: {
                text: "Não",
                value: null,
                visible: true,
                className: "",
                closeModal: true,
            },
            confirm: {
                text: "Sim",
                value: true,
                visible: true,
                className: "",
                closeModal: true
            }
	    }
	})
	.then((isConfirm) => {
	    if (isConfirm) {
	    	remove(id)
	    } else {
	    	swal("Cancelado", "Registro não removido!", "error");
	    }
	});
}

function remove(id) {
	$.ajax({
		type: "POST",
		data: {
			id : id
		},
		url : contextPath + "/admin/socio/post/remove",
		success : function(obj) {
			if (obj === true) {
				 table.row({
	                 selected : true
	               }).remove();
				 table.draw();
				swal("Removido!", "Registro removido com sucesso.", "success");
			} else {
				console.log(obj);
				swal("Erro ao Remover!", "Desculpe, mas não foi possível remover esse registro!", "error");
			}
		}
	})
}

function getButtons() {
	return  [ {
		        text: ' <i class="la la-plus font-small-2"></i> Adicionar',
		        className: 'btn-sm btn btn-info round  box-shadow-2 px-2',
		        action: function(e, dt, node, config) {
		            window.location.href = contextPath +
		                "partner/register";
		        },
		        enabled: true
		    }, {
		        text: '<i class="ft-trash-2 font-small-2"></i> Remover ',
		        className : 'btn btn-sm btn-danger box-shadow-2 round btn-min-width pull-right',
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

function getColumns() {
    return [{
            title: "doLogin",
            data: "doLogin"
        }, {
            title: "País",
            data: "countryIsoCode"
        }, {
            title: "firstname",
            data: "firstname"
        }, {
            title: "lastname",
            data: "lastname"
        }, {
            title: "Nome",
            data: "name"
        }, {
            title: "Login",
            data: "login"
        }, {
            title: "password",
            data: "password",
        }, {
            title: "email",
            data: "email",
        }, {
            title: "Telefone",
            data: "phone",
        }, {
            title: "address",
            data: "address",
        },
        {
            title: "addressCountryIsoCode",
            data: "addressCountryIsoCode",
        },
        {
            title: "Região",
            data: "addressRegionCode",
        },
        {
            title: "addressCityCode",
            data: "addressCityCode",
        },
        {
            title: "addressDistrict",
            data: "addressDistrict",
        },
        {
            title: "addressZipcode",
            data: "addressZipcode",
        },
        {
            title: "codeCategory",
            data: "codeCategory",
        }
    ];
}

function getColumnDefs() {
	return [{
        targets: [1 ,3, 4, 6, 10, 2, 0, 13, 14, 15, 12, 5],
        visible: false
    },{
        className: "text-capitalize text-truncate",
        targets: "_all"
    }];
}
