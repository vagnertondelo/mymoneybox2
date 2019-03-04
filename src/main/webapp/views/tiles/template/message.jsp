<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!-- ERRO -->
<c:if test="${messageType == 0}">
	<script type="text/javascript">
		toastr.options = {
			positionClass : "toast-top-center",
		}
		toastr.error('${messageDetail}', '${messageTitle}')
	</script>
</c:if>

<!-- ALERTA -->
<c:if test="${messageType == 1}">
	<script type="text/javascript">
		toastr.options = {
			positionClass : "toast-top-center",
		}
		toastr.warning('${messageDetail}', '${messageTitle}')
	</script>
</c:if>

<!-- INFORMA��O -->
<c:if test="${messageType == 2}">
	<script type="text/javascript">
		toastr.options = {
			positionClass : "toast-top-center",
		}
		toastr.info('${messageDetail}', '${messageTitle}')
	</script>
</c:if>

<!-- SUCESSO -->
<c:if test="${messageType == 3}">
	<script type="text/javascript">
		toastr.options = {
			positionClass : "toast-top-center",
		}
		toastr.success('${messageDetail}', '${messageTitle}')
	</script>
</c:if>