<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html class="loading" lang="en" data-textdirection="ltr">
<head>
<jsp:include page="../../tiles/template/head.jsp"></jsp:include>
<jsp:include page="../../tiles/template/css.jsp"></jsp:include>
<!-- Select2 -->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/app-assets/vendors/css/forms/select/select2.min.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/app-assets/css/plugins/forms/wizard.min.css">

<!-- Loaders -->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/app-assets/css/plugins/loaders/loaders.min.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/app-assets/css/core/colors/palette-loader.min.css">
</head>
<body class="vertical-layout vertical-menu-modern 2-columns menu-expanded fixed-navbar" data-open="click" data-menu="vertical-menu-modern" data-col="2-columns">
	<jsp:include page="../../tiles/template/header.jsp"></jsp:include>
	<!-- ////////////////////////////////////////////////////////////////////////////-->
	<jsp:include page="../../tiles/template/menu.jsp"></jsp:include>
	<!-- ////////////////////////////////////////////////////////////////////////////-->
	<div class="app-content content">
		<div class="content-wrapper">
			<div class="content-header row">
				<div class="content-header-left col-md-6 col-12 mb-2 breadcrumb-new">
					<h3 class="content-header-title mb-0 d-inline-block">${title}</h3>
					<div class="row breadcrumbs-top d-inline-block">
						<div class="breadcrumb-wrapper col-12">
							<ol class="breadcrumb">
								<li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/dashboard">Home</a></li>
								<li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/sale/list">Listar</a></li>
							</ol>
						</div>
					</div>
				</div>
			</div>
			<div class="content-body blockit">
				<!-- Basic form layout section start -->
				<section id="horizontal-form-layouts">
					<div class="row">
						<div class="col-md-12">
							<div class="card">
								<div class="card-header">
									<h4 class="card-title" id="horz-layout-basic">${subTitle}</h4>
									<a class="heading-elements-toggle"><i class="la la-ellipsis-v font-medium-3"></i></a>
									<div class="heading-elements">
										<ul class="list-inline mb-0">
											<li><a data-action="collapse"><i class="ft-minus"></i></a></li>
											<li><a data-action="reload"><i class="ft-rotate-cw"></i></a></li>
											<li><a data-action="expand"><i class="ft-maximize"></i></a></li>
											<li><a data-action="close"><i class="ft-x"></i></a></li>
										</ul>
									</div>
								</div>
								<div class="card-content collpase show">
									<div class="card-body">
										<form:form id="${formId}" modelAttribute="${modelAttribute}" class="add-doctors-tabs icons-tab-steps steps-validation wizard-notification">
											<form:hidden path="ipAddress" id="ipAddress" value="${ipAddress}" />
											<h4 class="form-section">
												<i class="ft-shopping-cart"></i> Informações da Compra
											</h4>
											<div class="row">
												<div class="col-md-6">
													<div class="form-group">
														<input type="text" class="form-control typeahead-basic" id="accountNo" name="accountNo" placeholder="Informe CPF/Telfone/Número da Conta/Código da conta" />
													</div>
												</div>
											</div>
											<div class="row">
												<div class="col-md-6 form-group">
													<label class="label-control" for="codeRule">Percentual:<span class="danger">*</span></label> <select class="select2 form-control required codeRule" name="codeRule" id="codeRule">
													</select>
												</div>
												<div class="col-md-3">
													<div class="form-group">
														<label for="saleAmount">Valor da Compra:</label>
														<form:input path="saleAmount" type="text" maxlength="120" class="form-control brlmask required" id="saleAmount" name="saleAmount" />
													</div>
												</div>
												<div class="col-md-3">
													<div class="form-group">
														<label for="name">Número da Compra:</label>
														<form:input path="documentNo" maxlength="120" type="text" class="form-control" id="documentno" name="documentno" />
													</div>
												</div>
											</div>

											<div class="form-actions center">
												<button type="submit" class="btn btn-outline-success btn-min-width btn-glow mr-1 mb-1">
													<i class="la la-check-square-o"></i> Enviar
												</button>
											</div>
										</form:form>
									</div>
								</div>
							</div>
						</div>
					</div>
				</section>
				<!-- // Basic form layout section end -->
			</div>
		</div>
	</div>
	<!-- ////////////////////////////////////////////////////////////////////////////-->
	<jsp:include page="../../tiles/template/footer.jsp"></jsp:include>
	<!-- ///////////////////////////////////js/////////////////////////////////////////-->
	<jsp:include page="../../tiles/template/js.jsp"></jsp:include>
	<script src="${pageContext.request.contextPath}/resources/app-assets/vendors/js/forms/select/select2.full.min.js"></script>
	<jsp:include page="../../tiles/template/form.jsp"></jsp:include>
	<jsp:include page="../../tiles/template/alert.jsp"></jsp:include>
	<jsp:include page="../../tiles/template/validate.jsp"></jsp:include>
	<script src="${pageContext.request.contextPath}/resources/app-assets/vendors/js/forms/extended/typeahead/typeahead.bundle.js"></script>
	<script src="${pageContext.request.contextPath}/resources/app-assets/vendors/js/forms/extended/typeahead/bloodhound.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/app-assets/vendors/js/forms/extended/typeahead/handlebars.js"></script>
	<script src="${pageContext.request.contextPath}/resources/app-assets/js/scripts/extensions/block-ui.js"></script>
	<script src="${pageContext.request.contextPath}/resources/app-assets/js/scripts/helpers/money-helper.js"></script>
	<script src="${pageContext.request.contextPath}/resources/app-assets/js/scripts/pages/${js}"></script>
</body>
</html>