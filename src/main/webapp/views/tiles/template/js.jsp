
<script>
	var contextPath = '${pageContext.request.contextPath}/'
	var tableId = '#${tableId}'
	var formId = '#${formId}'
	var mi = '#${mi}'
	var role = '${user.role}' 

	
	
	
	
	
	if ('serviceWorker' in navigator) {
		  // Registra um service worker hospeadado na raiz do
		  // site usando o escopo padrão
		  navigator.serviceWorker.register('${pageContext.request.contextPath}/resources/app-assets/js/core/sw.js').then(function(registration) {
		    console.log('Service worker  registrado com sucesso:', registration);
		  }).catch(function(error) {
		    console.log('Falha ao Registrar o Service Worker:', error);
		  });
		  
		} else {
		  console.log('Service workers não suportado!');
		}
	
	
	
	
</script>

<!-- BEGIN VENDOR JS-->
<script src="${pageContext.request.contextPath}/resources/app-assets/vendors/js/vendors.min.js"></script>
<!-- BEGIN VENDOR JS-->

<script src="${pageContext.request.contextPath}/resources/app-assets/js/core/app-menu.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/app-assets/js/core/app.min.js"></script>
<%-- <script src="${pageContext.request.contextPath}/resources/app-assets/js/scripts/customizer.min.js"></script> --%>
<script src="${pageContext.request.contextPath}/resources/app-assets/js/scripts/pages/menu.js"></script>



