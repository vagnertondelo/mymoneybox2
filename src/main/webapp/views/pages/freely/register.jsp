<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
<link rel="stylesheet" type="text/css" href="https://pixinvent.com/modern-admin-clean-bootstrap-4-dashboard-html-template/app-assets/css/plugins/loaders/loaders.min.css">
<link rel="stylesheet" type="text/css" href="https://pixinvent.com/modern-admin-clean-bootstrap-4-dashboard-html-template/app-assets/css/core/colors/palette-loader.min.css">


</head>
<body class="vertical-layout vertical-menu-modern 2-columns menu-expanded fixed-navbar bg-full-screen-image" data-open="click" data-menu="vertical-menu-modern" data-col="2-columns">
	<div class="app-content">
		<div class="content-wrapper">
			<div class="content-header row"></div>
			<div class="content-body">
				<section id="number-tabs">
					<div class="row justify-content-md-center">
						<div class="col-lg-6 col-md-6 col-sm-12 blockit"> 
							<div class="card">
								<div class="card-header border-0">
									<div class="card-title text-center">
										<div class="p-1">
											<img src="${pageContext.request.contextPath}/resources/app-assets/images/logo/default-logo.png" style="width: 124px;" alt="branding logo">
										</div>
									</div>
								</div>
								<div class="card-content collapse show">
									<div class="card-body">
										<form class="number-tab-steps wizard-notification steps-validation" id="${formId}">
											<input type="text" maxlength="13" class="form-control hidden" id="accountNo" name="accountNo" placeholder="accountNo"> <input type="number" class="form-control hidden" id="sponsorAccountNo" name="sponsorAccountNo" placeholder="sponsorAccountNo"> <input type="hidden" class="form-control" id="ipAddress" name="ipAddress" placeholder="ipAddress" value="${ipAddress}">
											<input type="hidden" class="form-control" id="doLogin" name="doLogin" placeholder="doLogin"> <input type="hidden" class="form-control" id="token" name="token" placeholder="token" value="${token}">
											<h6>Informações Pessoais</h6>

											<fieldset>
												<div class="row">
													<div class="col-md-12">
														<div class="form-group">
															<label for="name">Nome Completo:<span class="danger">*</span></label> <input type="text" class="form-control required text-capitalize" id="name" name="name" placeholder="Nome Completo">
														</div>
													</div>
												</div>
												<div class="row">
													<div class="col-md-6">
														<div class="form-group">
															<label for="taxid">Número do Documento:</label> <input type="number" class="form-control" id="taxid" name="taxid" placeholder="Número do Documento">
														</div>
													</div>

													<div class="col-md-6 form-group" >
														<label class="label-control" for="countryIsoCode">País:<span class="danger">*</span>
														</label> 
														<select class="form-control country required" name="countryIsoCode" id="countryIsoCode">
															<option value="">Selecione um País</option>
														</select>
													</div>

												</div>
												<div class="row">
													<div class="col-md-6">
														<div class="form-group">
															<label for="email">Email:<span class="danger">*</span></label> <input type="email" class="form-control required" id="email" name="email" placeholder="Email">
														</div>
													</div>

													<div class="col-md-6">
														<div class="form-group">
															<label for="phone">Telefone:</label> <input type="text" class="form-control phonebrpr" id="phone" name="phone" placeholder="Telefone">
														</div>
													</div>
												</div>
											</fieldset>

											<h6>Endereço</h6>
											<fieldset>
												<div class="row">
													<div class="col-md-6">
														<div class="form-group">
															<label for="address">Rua:</label> <input type="text" class="form-control" id="address" name="address" placeholder="Rua">
														</div>
													</div>
													<div class="col-md-6">
														<div class="form-group">
															<label for="addressDistrict">Bairro:</label> <input type="text" class="form-control" id="addressDistrict" name="addressDistrict" placeholder="Bairro">
														</div>
													</div>
												</div>

												<div class="row">
													<div class="col-md-6 form-group">
														<label class="label-control" for="addressCountryIsoCode">País:</label> <select class="form-control countries" name="addressCountryIsoCode" id="addressCountryIsoCode">
															<option value="">Selecione um País</option>
														</select>
													</div>
													<div class="col-md-6 form-group">
														<label class="label-control" for="addressRegionCode"><span class="sorop">Estado</span>:</label> <select class="form-control state" name="addressRegionCode" id="addressRegionCode">
														</select>
													</div>
												</div>

												<div class="row">
													<div class="col-md-6 form-group">
														<label class="label-control" for="addressCityCode">Cidade:</label> <select class="form-control city" name="addressCityCode" id="addressCityCode">
														</select>
													</div>
													<div class="col-md-6">
														<div class="form-group">
															<label for="addressZipcode">Código de Área:</label> <input type="text" class="form-control" id="addressZipcode" name="addressZipcode" placeholder="Código de Área">
														</div>
													</div>
												</div>
											</fieldset>

											<h6>Conta</h6>
											<fieldset>
												<div class="row">
													<div class="col-md-12">
														<div class="form-group">
															<label for="login">Login:</label> <input type="text" class="form-control" id="login" name="login" placeholder="Login">
														</div>
													</div>
												</div>
												<div class="row">
													<div class="col-md-6">
														<div class="form-group">
															<label for="password">Senha:</label> <input type="password" class="form-control" id="password" name="password" placeholder="Senha">
														</div>
													</div>

													<div class="col-md-6">
														<div class="form-group">
															<label for="passwordConfirm">Confirme sua Senha:</label> <input type="password" class="form-control" id="passwordConfirm" name="passwordConfirm" placeholder="Confirme sua Senha">
														</div>
													</div>
												</div>
											</fieldset>
										</form>
									</div>
								</div>
							</div>
						</div>
					</div>
				</section>
			</div>
		</div>
	</div>
	<jsp:include page="../../tiles/template/js.jsp"></jsp:include>
	<jsp:include page="../../tiles/template/message.jsp"></jsp:include>
	<jsp:include page="../../tiles/template/form.jsp"></jsp:include>
	<jsp:include page="../../tiles/template/alert.jsp"></jsp:include>
	<jsp:include page="../../tiles/template/validate.jsp"></jsp:include>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/app-assets/js/scripts/extensions/block-ui.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/app-assets/vendors/js/forms/intlTelInput/intlTelInput.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/app-assets/js/scripts/pages/${js}"></script>
</body>
</html>