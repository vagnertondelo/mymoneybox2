<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"   prefix="sec" %>


<div class="main-menu menu-accordion menu-shadow menu-fixed expanded menu-light" data-scroll-to-active="true">
	<div class="main-menu-content">
		<ul class="navigation navigation-main" id="main-menu-navigation" data-menu="menu-navigation">
			<li class="nav-item"><a id="dashboard" href="${pageContext.request.contextPath}/dashboard"><i class="la la-home"></i><span class="menu-title" data-i18n="nav.dash.main">Dashboard</span></a> 
			
			 <c:if test = "${user.role == 'CUSTOMER'}">
				<li class="nav-item"><a id="accredited" href="${pageContext.request.contextPath}/accredited/list"><i class="ft-user-plus"></i><span class="menu-title" data-i18n="nav.dash.main">Lista de Credenciados</span></a>
				<li class="nav-item"><a id="cashback" href="${pageContext.request.contextPath}/cashback/list"><i class="ft-clipboard"></i><span class="menu-title" data-i18n="nav.dash.main">Extrato Cashback</span></a> 
			</c:if>
			
			<c:if test = "${user.role == 'SELLER'}">
				<li class="nav-item"><a id="sale" href="${pageContext.request.contextPath}/sale/list"><i class="la la-cart-plus"></i><span class="menu-title" data-i18n="nav.dash.main">Registrar Compra</span></a>
			</c:if>
			
<%-- 			<li class="nav-item"><a id="partner" href="${pageContext.request.contextPath}/partner/register"><i class="ft-users"></i><span class="menu-title" data-i18n="nav.dash.main">Registrar Parceiro</span></a> --%>
<%-- 			<li class="nav-item"><a id="entity" href="${pageContext.request.contextPath}/entity/register"><i class="la la-institution"></i><span class="menu-title" data-i18n="nav.dash.main">Entidade</span></a> --%>
		
		</ul>
	</div>
</div>
