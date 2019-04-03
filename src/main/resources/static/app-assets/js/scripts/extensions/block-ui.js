function block(input) {
	$(input).block({
		message : loaderHtml(),
		overlayCSS : {
			backgroundColor : '#FFF',
			opacity : 0.8,
			cursor : 'wait'
		},
		css : {
			border : 0,
			padding : 0,
			backgroundColor : 'transparent'
		}
	});
}

function block2(input) {
	$(input).block({
		message : loaderHtml2(),
		overlayCSS : {
			backgroundColor : '#FFF',
			opacity : 0.8,
			cursor : 'wait'
		},
		css : {
			border : 0,
			padding : 0,
			backgroundColor : 'transparent'
		}
	});
}

function loaderHtml() {
	return  '<div class="loader-wrapper">'+
			'		<div class="loader-container" style="left: 28%">'+
			'			<div class="ball-scale-multiple loader-purple">'+
			'				<div></div>'+
			'				<div></div>'+
			'				<div></div>'+
			'			</div>'+
			'		</div>'+
			'	</div>';
}

function loaderHtml2() {
	var myvar = '<div class="loader-wrapper">'+
	'							<div class="loader-container">'+
	'								<div class="ball-clip-rotate loader-primary">'+
	'									<div></div>'+
	'								</div>'+
	'							</div>'+
	'						</div>';
	
	return myvar;
}

function unblock(input) {
	$(input).unblock()
}