<script>
	var contextPath = '${pageContext.request.contextPath}/resources'
	var tableId = '#${tableId}'
	var formId = '#${formId}'
	var mi = '#${mi}'
</script>

<!-- BEGIN VENDOR JS-->
<script src="${pageContext.request.contextPath}/resources/app-assets/vendors/js/vendors.min.js"></script>
<!-- BEGIN VENDOR JS-->

<script src="${pageContext.request.contextPath}/resources/app-assets/js/core/app-menu.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/app-assets/js/core/app.min.js"></script>
<%-- <script src="${pageContext.request.contextPath}/resources/app-assets/js/scripts/customizer.min.js"></script> --%>
<%-- <script src="${pageContext.request.contextPath}/resources/app-assets/js/scripts/pages/menu.js"></script> --%>

<script type="text/javascript">
	function mask() {
		$('.phonebr').mask('(00) 00000-0000');
		$('.phonepr').mask('(00) 000-000');
		$(".cep").mask("99.999-999");
		$('.date').mask('00/00/0000');
		$('.cnpj').mask('00.000.000/0000-00', {
			reverse : true
		});
		
		$('.cpf').mask('000.000.000-00', {
			reverse : true
		});
	}
</script>
