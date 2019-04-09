<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html class="loading" lang="en" data-textdirection="ltr">
<head>
    <jsp:include page="../../tiles/template/head.jsp"></jsp:include>
    <jsp:include page="../../tiles/template/css.jsp"></jsp:include>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/app-assets/css/plugins/forms/validation/form-validation.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/app-assets/css/plugins/forms/wizard.min.css">
    <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/flag-icon-css/0.8.2/css/flag-icon.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/app-assets/vendors/css/extensions/flag-icon.min-adjust.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/app-assets/vendors/css/forms/intlTelInput/intlTelInput.css">

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
								<li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/dashboard">Dashboard</a></li>
							</ol>
						</div>
					</div>
				</div>
			</div>
			<div class="content-body">
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
											<form:hidden path="addressCountryIsoCode" id="addressCountryIsoCode"/>
											<input name="countryIsoCode" id="countryIsoCode" type="hidden">
											<h4 class="form-section">
												<i class="la la-user"></i> Meus Dados
											</h4>
											<fieldset class="blockit">
												<div class="row">
													<div class="col-md-4">
														<div class="form-group">
															<label for="firstname">Nome:<span class="danger">*</span></label>
															<form:input path="firstname" maxlength="120" type="text" class="form-control text-capitalize required" id="firstname" name="firstname" />
														</div>
													</div>
													<div class="col-md-4">
														<div class="form-group">
															<label for="lastname">Sobrenome:<span class="danger">*</span></label>
															<form:input path="lastname" maxlength="120" type="text" class="form-control text-capitalize required" id="lastname" name="lastname" />
														</div>
													</div>
													<div class="col-md-4">
														<div class="form-group">
															<label for="name">Nome Completo:<span class="danger">*</span></label>
															<form:input path="name" maxlength="120" type="text" class="form-control text-capitalize required" id="name" name="name" />
														</div>
													</div>
													<div class="col-sm-12">
														<label for="indicar">Indicar</label>
														<div class="input-group">
															<input id="indicar" type="text" readonly="readonly" class="form-control" value="${URL}${pageContext.request.contextPath}/freely/register?sponsorAccountNo=${user.accountNo}" />
															<div class="input-group-btn">
																<button type="button" class="btn btn-default" onclick="copy('indicar')" >Copiar</button>
																<a href="${URL}${pageContext.request.contextPath}/freely/register?sponsorAccountNo=${account.accountNo}" target="_blank" class="btn btn-info">Abrir</a>
															</div>
														</div>
													</div>
												</div>
											</fieldset>
											<h4 class="form-section">
												<i class="la la-location-arrow"></i> Endereço
											</h4>
											<fieldset>
												<div class="row">
													<div class="col-md-6 form-group">
														<label class="label-control" for="addressCountryIsoCode">País:<span class="danger">*</span></label>
														<select class="form-control countries required" name="addressCountryIsoCode" id="addressCountryIsoCode">
															<option value="">Selecione um País</option>
														</select>
													</div>

													<div class="col-md-6">
														<div class="form-group">
															<label for="addressZipcode">CEP:</label>
															<form:input path="addressZipcode" type="text" class="form-control" id="addressZipcode" name="addressZipcode" placeholder="Código de Área"/>
														</div>
													</div>

													<div class="col-md-6 form-group">
														<label class="label-control" for="addressRegionCode"><span class="sorop">Estado</span>:</label> <select class="form-control state" name="addressRegionCode" id="addressRegionCode">
														</select>
													</div>

													<div class="col-md-6 form-group">
														<label class="label-control" for="addressCityCode">Cidade:</label> <select class="form-control city" name="addressCityCode" id="addressCityCode">
														</select>
													</div>

													<div class="col-md-6">
														<div class="form-group">
															<label for="addressDistrict">Bairro:</label> <input type="text" class="form-control text-capitalize" id="addressDistrict" name="addressDistrict" placeholder="Bairro">
														</div>
													</div>
													<div class="col-md-6">
														<div class="form-group">
															<label for="addressNumber">Número:</label>
                                                            <form:input path="addressNumber" type="text" class="form-control text-capitalize" id="addressNumber" name="addressNumber" placeholder="Número"/>
														</div>
													</div>
												</div>

												<div class="row">
													<div class="col-md-12">
														<div class="form-group">
															<label for="address">Rua:</label>
															<form:input path="address" type="text" class="form-control text-capitalize" id="address" name="address" placeholder="Rua"/>
														</div>
													</div>
												</div>

											</fieldset>

											<div class="col-md-12 text-center">
												<input name="rows" type="hidden">
											</div>
											<div class="form-actions center">
												<button type="submit" class="btn btn-outline-success btn-min-width btn-glow mr-1 mb-1">
													<i class="la la-check-square-o"></i> Salvar
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
	<jsp:include page="../../tiles/template/js.jsp"></jsp:include>
	<jsp:include page="../../tiles/template/message.jsp"></jsp:include>
	<jsp:include page="../../tiles/template/form.jsp"></jsp:include>
	<jsp:include page="../../tiles/template/alert.jsp"></jsp:include>
	<jsp:include page="../../tiles/template/validate.jsp"></jsp:include>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/app-assets/js/scripts/extensions/block-ui.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/app-assets/vendors/js/forms/intlTelInput/intlTelInput.js"></script>

	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/app-assets/js/scripts/helpers/steps-helpers.js"></script>
	<script src="${pageContext.request.contextPath}/resources/app-assets/js/scripts/helpers/cep.js"></script>

	<script src="${pageContext.request.contextPath}/resources/app-assets/js/scripts/pages/${js}"></script>
</body>
</html>