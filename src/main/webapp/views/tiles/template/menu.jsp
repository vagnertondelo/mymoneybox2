<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="main-menu menu-accordion menu-shadow menu-fixed expanded menu-light" data-scroll-to-active="true">
	<div class="main-menu-content">
		<ul class="navigation navigation-main" id="main-menu-navigation" data-menu="menu-navigation">
			<li class=" nav-item"><a href="${pageContext.request.contextPath}/dashboard"><i class="la la-home"></i><span class="menu-title" data-i18n="nav.dash.main">Dashboard</span></a>
			<li class=" nav-item"><a href="${pageContext.request.contextPath}/accredited/register"><i class="la la-home"></i><span class="menu-title" data-i18n="nav.dash.main">Credenciado</span></a>
			
<%-- 			<sec:authorize access="hasRole('ADMINISTRADOR')"> --%>
<!-- 				<li class="navigation-header"><span data-i18n="nav.category.admin-panels">Painel do Administrador</span><i class="la la-ellipsis-h ft-minus" data-toggle="tooltip" data-placement="right" data-original-title="Admin Panels"></i></li> -->
<!-- 				<li class="nav-item"><a href="#"><i class="la la-television"></i><span class="menu-title" data-i18n="nav.templates.main">Cadastros</span></a> -->
<!-- 					<ul class="menu-content"> -->
<%-- 						<li><a class="menu-item mi" href="${pageContext.request.contextPath}/admin/entidade/edita" id="entidadeedita" data-i18n="nav.templates.vert.main">Entidade</a> --%>
<%-- 						<li><a class="menu-item mi" href="${pageContext.request.contextPath}/admin/usuario/lista" id="usuariolista" data-i18n="nav.templates.horz.main">Usu�rio</a> --%>
<%-- 						<li><a class="menu-item mi" href="${pageContext.request.contextPath}/admin/sociocategoria/lista" id="sociocategorialista" data-i18n="nav.templates.horz.main">Categoria de S�cio</a> --%>
<%-- 						<li><a class="menu-item mi" href="${pageContext.request.contextPath}/admin/credenciadocategoria/lista" id="credenciadocategorialista" data-i18n="nav.templates.horz.main">Categoria de credenciado</a> --%>
<%-- 						<li><a class="menu-item mi" href="${pageContext.request.contextPath}/admin/socio/lista" id="sociolista" data-i18n="nav.templates.horz.main">S�cio</a> --%>
<%-- 						<li><a class="menu-item mi" href="${pageContext.request.contextPath}/admin/credenciado/lista" id="credenciadolista" data-i18n="nav.templates.horz.main">Credenciado</a> --%>
<%-- 						<li><a class="menu-item mi" href="${pageContext.request.contextPath}/admin/temporada/lista" id="temporadalista" data-i18n="nav.templates.horz.main">Temporada</a> --%>
<!-- 					</ul> -->
<!-- 				</li> -->
<%-- 				<li class="nav-item mi"><a href="${pageContext.request.contextPath}/admin/apuracao/lista" id="apuracaolista"><i class="la la-home"></i><span class="menu-title" data-i18n="nav.dash.main">Apura��es n�o recebidas</span></a> --%>
<%-- 				<li class="nav-item mi"><a href="${pageContext.request.contextPath}/admin/doacao/anulacao" id="doacaoanulacao"><i class="la la-home"></i><span class="menu-title" data-i18n="nav.dash.main">Anula��o de doa��es</span></a> --%>
<%-- 				<li class="nav-item mi"><a href="${pageContext.request.contextPath}/admin/aceite/abre" id="aceiteabre"><i class="la la-home"></i><span class="menu-title" data-i18n="nav.dash.main">Termo de contrato</span></a> --%>
<%-- 				<li class="nav-item mi"><a href="${pageContext.request.contextPath}/admin/apuracaosocio/lista" id="apuracaosociolista"><i class="la la-home"></i><span class="menu-title" data-i18n="nav.dash.main">Gerar apura��o</span></a> --%>
<!-- 				<li class="nav-item"><a href="#"><i class="la la-television"></i><span class="menu-title" data-i18n="nav.templates.main">Relat�rios</span></a> -->
<!-- 					<ul class="menu-content"> -->
<%-- 						<li><a class="menu-item" href="${pageContext.request.contextPath}/relatorio/extrato_doacoes_por_socio/abre" id="extrato_doacao_socio" data-i18n="nav.templates.vert.main">Extrato de contribui��es</a> --%>
<%-- 						<li><a class="menu-item" href="${pageContext.request.contextPath}/relatorio/ranking_doacoes_por_socio/abre" id="ranking_doacao_socio" data-i18n="nav.templates.horz.main">Ranking Doa��es por s�cio</a> --%>
<%-- 						<li><a class="menu-item" href="${pageContext.request.contextPath}/relatorio/ranking_doacoes_por_indicador/abre" id="ranking_doacao_indicador" data-i18n="nav.templates.horz.main">Ranking Doa��es por indicador</a> --%>
<%-- 						<li><a class="menu-item" href="${pageContext.request.contextPath}/relatorio/ranking_doacoes_por_credenciado/abre" id="ranking_doacao_credenciado"  data-i18n="nav.templates.horz.main">Ranking Doa��es por credenciado</a> --%>
<%-- 						<li><a class="menu-item" href="${pageContext.request.contextPath}/relatorio/extrato_apuracao_doacoes/abre" id="extrato_apuracao_doacoesabre" data-i18n="nav.templates.horz.main">Extrato de apura��o</a> --%>
<!-- 					</ul> -->
<!-- 				</li> -->
<%-- 			</sec:authorize> --%>
		</ul>
	</div>
</div>
