function HtmlSw(title, msg) {
	return 	'<div class="alert mb-2" role="alert">'+
			'	<h4 class="alert-heading mb-2">'+title+'</h4>'+
			'	<p>'+msg+'</p>'+
			'</div>';
}

function errorSw(title, text) {
	Swal.fire({
		  type: 'error',
		  html: HtmlSw('Ocorreu um erro ao tentar salvar o registro.', text),
		  showCloseButton: true,
		  showCancelButton: true,
		  focusConfirm: false,
		  confirmButtonText:
		    '<i class="fa fa-thumbs-up"></i> Tentar Novamente!',
		  confirmButtonAriaLabel: 'Thumbs up, great!',
		  cancelButtonText:
		    '<i class="fa fa-thumbs-down"></i> Sair',
		  cancelButtonAriaLabel: 'Thumbs down',
	}).then((result) => {
		// do nothing
	})
}

function successAlert(obj, title, text) {
	Swal.fire({
		  type: 'success',
		  html: HtmlSw('Cadastrado com sucesso!', 'Parabéns você agora está cadastrado no sistema.'),
		  showCloseButton: true,
		  focusConfirm: false,
		  confirmButtonText:
		    '<i class="fa fa-thumbs-up"></i> Pronto',
		  confirmButtonAriaLabel: 'Thumbs up, great!',
	}).then((result) => {
		// redirect to login page
		
	})
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
			debugger
			if (obj.value != undefined) {
				obj = obj.value;
				updateToken(obj.token)
				return obj;
			} 
			return false;
		})
}

