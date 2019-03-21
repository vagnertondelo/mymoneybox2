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

function errorGenericSw(title, text) {
	Swal.fire({
		  type: 'error',
		  html: HtmlSw(title, text),
		  showCloseButton: true,
		  showCancelButton: false,
		  focusConfirm: false,
		  cancelButtonText:
		    '<i class="fa fa-thumbs-down"></i> Sair',
		  cancelButtonAriaLabel: 'Thumbs down',
	}).then((result) => {
		
	})
}

function successAlert(obj, title, text, resolve, confirmButtonText, cancelButtonText) {
	Swal.fire({
		  type: 'success',
		  html: HtmlSw(title, text),
		  showCloseButton: true,
		  showCancelButton: true,
		  focusConfirm: true,
		  confirmButtonText: '<i class="ft-fast-forward"></i> ' +confirmButtonText+ '',
		  cancelButtonText: ' <i class="ft-rotate-ccw"></i> ' +cancelButtonText+ ' ',
		  confirmButtonAriaLabel: 'Thumbs up, great!',
	}).then((result) => {
		if (result.dismiss === undefined) {
			resolve(true)
		} else {
			resolve(false)
		}
	})
}
