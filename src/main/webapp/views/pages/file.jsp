<%-- <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%> --%>
<%-- <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> --%>
<%-- <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> --%>

<%-- <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> --%>

<!-- <!DOCTYPE html> -->
<!-- <html class="loading" lang="en" data-textdirection="ltr"> -->
<!-- <head> -->
<%-- <jsp:include page="../../tiles/template/head.jsp"></jsp:include> --%>
<%-- <jsp:include page="../../tiles/template/css.jsp"></jsp:include> --%>
<!-- <!-- Select2 --> -->
<%-- <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/app-assets/vendors/css/forms/select/select2.min.css"> --%>
<%-- <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/app-assets/css/plugins/forms/wizard.min.css"> --%>

<!-- </head> -->
<!-- <body class="vertical-layout vertical-menu-modern 2-columns menu-expanded fixed-navbar" data-open="click" data-menu="vertical-menu-modern" data-col="2-columns"> -->
<%-- 	<jsp:include page="../../tiles/template/header.jsp"></jsp:include> --%>
<!-- 	<!-- ////////////////////////////////////////////////////////////////////////////--> -->
<%-- 	<jsp:include page="../../tiles/template/menu.jsp"></jsp:include> --%>
<!-- 	<!-- ////////////////////////////////////////////////////////////////////////////--> -->
<!-- 	<div class="app-content content"> -->
<!-- 		<div class="content-wrapper"> -->
<!-- 			<div class="content-header row"> -->
<!-- 				<div class="content-header-left col-md-6 col-12 mb-2 breadcrumb-new"> -->
<%-- 					<h3 class="content-header-title mb-0 d-inline-block">${title}</h3> --%>
<!-- 					<div class="row breadcrumbs-top d-inline-block"> -->
<!-- 						<div class="breadcrumb-wrapper col-12"> -->
<!-- 							<ol class="breadcrumb"> -->
<%-- 								<li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/dashboard">Dashboard</a></li> --%>
<%-- 								<li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/accredited/list">Listar</a></li> --%>
<!-- 							</ol> -->
<!-- 						</div> -->
<!-- 					</div> -->
<!-- 				</div> -->
<!-- 			</div> -->
<!-- 			<div class="content-body"> -->
<!-- 				Basic form layout section start -->
<!-- 				<section id="horizontal-form-layouts"> -->
<!-- 					<div class="row"> -->
<!-- 						<div class="col-md-12"> -->
<!-- 							<div class="card"> -->
<!-- 								<div class="card-header"> -->
<%-- 									<h4 class="card-title" id="horz-layout-basic">${subTitle}</h4> --%>
<!-- 									<a class="heading-elements-toggle"><i class="la la-ellipsis-v font-medium-3"></i></a> -->
<!-- 									<div class="heading-elements"> -->
<!-- 										<ul class="list-inline mb-0"> -->
<!-- 											<li><a data-action="collapse"><i class="ft-minus"></i></a></li> -->
<!-- 											<li><a data-action="reload"><i class="ft-rotate-cw"></i></a></li> -->
<!-- 											<li><a data-action="expand"><i class="ft-maximize"></i></a></li> -->
<!-- 											<li><a data-action="close"><i class="ft-x"></i></a></li> -->
<!-- 										</ul> -->
<!-- 									</div> -->
<!-- 								</div> -->
<!-- 								<div class="card-content collpase show"> -->
<!-- 									<div class="card-body"> -->
<%-- 										<form:form id="${formId}" modelAttribute="${modelAttribute}" class="add-doctors-tabs icons-tab-steps steps-validation wizard-notification"> --%>
<%-- 											<form:hidden path="ipAddress" id="ipAddress" value="${ipAddress}" /> --%>
<!-- 											<h4 class="form-section"> -->
<!-- 												<i class="ft-percent"></i> Entidade -->
<!-- 											</h4> -->
<!-- 											<fieldset> -->
<!-- 												<div class="row"> -->
<!-- 													<input type="hidden" id="item-id" /> -->
<!-- 													<div class="col-md-6 form-group"> -->
<!-- 														<label class="label-control" for="entityCode">Entidade:</label> <select class="select2 form-control" name="entityCode" id="entityCode"> -->
<!-- 															<optgroup label="Escolha uma entidade"> -->
<!-- 																<option value="">Não Selecionado</option> -->
<%-- 																<c:forEach items="${entities}" var="entity"> --%>
<%-- 																	<option value="${entity.code}">${entity.name}</option> --%>
<%-- 																</c:forEach> --%>
<!-- 															</optgroup> -->
<!-- 														</select> -->
<!-- 													</div> -->
<!-- 													<div class="col-md-6"> -->
<!-- 														<fieldset> -->
<!-- 															<label for="pcEntity">Percentual %:<span class="danger">*</span></label> -->
<!-- 															<div class="input-group"> -->
<!-- 																<input type="number" class="form-control required" id="pcEntity" name="pcEntity" aria-describedby="button-addon2" min="0"> -->

<!-- 																																<div class="input-group-append"> -->
<!-- 																																	<button class="btn btn-primary btn-glow" type="button" id="add-item"> -->
<!-- 																																		<i class="step-icon ft-plus"></i>Adicionar -->
<!-- 																																	</button> -->
<!-- 																																	<button class="btn btn-dark btn-glow hidden" data-toggle="tooltip" data-placement="top" title="" data-original-title="Clique para limpar o Formulário" type="button" id="clear-item-form"> -->
<!-- 																																		<i class="ft-refresh-cw"></i> -->
<!-- 																																	</button> -->
<!-- 																																	<button class="btn btn-danger btn-glow hidden" data-toggle="tooltip" data-placement="top" title="" data-original-title="Clique para remover esse registro" type="button" id="remove-item"> -->
<!-- 																																		<i class="ft-x"></i> -->
<!-- 																																	</button> -->
<!-- 																																</div> -->
<!-- 															</div> -->
<!-- 															<div class="danger hidden" id="pcEntity-error">Campo não preenchido ou maior que 99</div> -->
<!-- 														</fieldset> -->
<!-- 													</div> -->
<!-- 												</div> -->
<!-- 											</fieldset> -->
<!-- 											<div class="col-md-12 text-center"> -->
<!-- 												<input name="rows" type="hidden"> -->
<!-- 											</div> -->
<!-- 											<div class="form-actions center"> -->
<!-- 												<button type="submit" class="btn btn-outline-success btn-min-width btn-glow mr-1 mb-1"> -->
<!-- 													<i class="la la-check-square-o"></i> Salvar -->
<!-- 												</button> -->
<!-- 											</div> -->
<!-- 											<div class="table-responsive"> -->
<%-- 												<table class="table table-striped table-bordered" id="${tableId}"> --%>
<!-- 												</table> -->
<!-- 											</div> -->
<%-- 										</form:form> --%>
<!-- 									</div> -->
<!-- 								</div> -->
<!-- 							</div> -->
<!-- 						</div> -->
<!-- 					</div> -->
<!-- 				</section> -->
<!-- 				// Basic form layout section end -->
<!-- 			</div> -->
<!-- 		</div> -->
<!-- 	</div> -->
<!-- 	<!-- ////////////////////////////////////////////////////////////////////////////--> -->
<%-- 	<jsp:include page="../../tiles/template/footer.jsp"></jsp:include> --%>
<!-- 	<!-- ///////////////////////////////////js/////////////////////////////////////////--> -->
<%-- 	<jsp:include page="../../tiles/template/js.jsp"></jsp:include> --%>
<%-- 	<script src="${pageContext.request.contextPath}/resources/app-assets/vendors/js/forms/select/select2.full.min.js"></script> --%>
<%-- 	<jsp:include page="../../tiles/template/form.jsp"></jsp:include> --%>
<%-- 	<jsp:include page="../../tiles/template/alert.jsp"></jsp:include> --%>
<%-- 	<jsp:include page="../../tiles/template/validate.jsp"></jsp:include> --%>
<%-- 	<jsp:include page="../../tiles/template/datatable.jsp"></jsp:include> --%>
<%-- 	<script src="${pageContext.request.contextPath}/resources/app-assets/vendors/js/tables/datatable/dataTables.select.min.js"></script> --%>
<%-- 	<script src="${pageContext.request.contextPath}/resources/app-assets/js/scripts/helpers/data-table-helper.js"></script> --%>
<%-- 	<script src="${pageContext.request.contextPath}/resources/app-assets/js/scripts/pages/${js}"></script> --%>
<!-- </body> -->
<!-- </html> -->