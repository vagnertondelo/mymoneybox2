function getLanguage() {
	return  {
			url: contextPath + "resources/app-assets/vendors/json/tables/datatables/languages/Portuguese-Brasil.json",
			sProcessing: customLoader()
	};
}

function customLoader() {

	var myvar = '<div class="loader-container">'+
	'				<div class="ball-scale-multiple loader-purple">'+
	'					<div></div>'+
	'					<div></div>'+
	'					<div></div>'+
	'				</div>'+
	'			</div>';
		
	return myvar;
		

}

