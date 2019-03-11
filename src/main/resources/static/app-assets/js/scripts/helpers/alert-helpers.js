function HtmlSw(title, msg) {
	return 	'<div class="alert mb-2" role="alert">'+
			'	<h4 class="alert-heading mb-2">'+title+'</h4>'+
			'	<p>'+msg+'</p>'+
			'</div>';
}

function errorSw(title, text) {
	Swal.fire({
		  type: 'error',
		  html: HtmlSw(title, text),
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

