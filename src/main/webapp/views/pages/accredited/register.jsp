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
								<li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/dashboard">Dashboard</a></li>
								<li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/accredited/list">Listar</a></li>
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
											<form:hidden path="doLogin" id="doLogin" value="true" />
											<form:hidden path="ipAddress" id="ipAddress" value="${ipAddress}" />
											<input name="countryIsoCode" id="countryIsoCode" type="hidden">
											<h4 class="form-section">
												<i class="la la-user"></i> Informações Gerais
											</h4>
											<fieldset class="blockit">
												<div class="row">
													<div class="col-md-6 form-group">
														<label class="label-control" for="addressCountryIsoCode">País:<span class="danger">*</span></label><select class="form-control countries required" name="addressCountryIsoCode" id="addressCountryIsoCode">
															<option value="">Selecione um País</option>
														</select>
													</div>
													<div class="col-md-6 form-group">
														<label class="label-control" for="codeCategory">Categoria:<span class="danger">*</span></label> <select class="codeCategory form-control required" name="codeCategory" id="codeCategory">
															<optgroup label="Escolha uma categoria">
																<option value="">Não Selecionado</option>
																<%-- 																<c:forEach items="${categories}" var="category"> --%>
																<%-- 																	<option value="${category.code}">${category.name}</option> --%>
																<%-- 																</c:forEach> --%>
															</optgroup>
														</select>
													</div>
												</div>
												<div class="row">
													<div class="col-md-3">
														<div class="form-group">
															<label for="name">Nome Completo:<span class="danger">*</span></label>
															<form:input path="name" maxlength="120" type="text" class="form-control text-capitalize required" id="name" name="name" />
														</div>
													</div>
													<div class="col-md-3">
														<div class="form-group">
															<label for="phone">Telefone:</label>
															<form:input path="phone" type="text" maxlength="120" class="form-control phonebrpr" id="phone" name="phone" />
														</div>
													</div>
													<div class="col-md-6">
														<div class="form-group">
															<label for="email">Email:<span class="danger">*</span></label>
															<form:input path="email" maxlength="120" type="email" class="form-control required" id="email" name="email" />
														</div>
													</div>
												</div>
											</fieldset>
											<h4 class="form-section">
												<i class="la la-location-arrow"></i> Endereço
											</h4>
											<fieldset>

												<div class="row">
													<div class="col-md-6">
														<div class="form-group">
															<label for="addressZipcode">CEP:</label> <input type="text" class="form-control" id="addressZipcode" name="addressZipcode" placeholder="Código de Área">
														</div>
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
															<label for="addressDistrict">Bairro:</label> <input type="text" class="form-control text-capitalize" id="addressDistrict" name="addressDistrict" placeholder="Bairro">
														</div>
													</div>
												</div>

												<div class="row">
													<div class="col-md-12">
														<div class="form-group">
															<label for="address">Rua:</label> <input type="text" class="form-control text-capitalize" id="address" name="address" placeholder="Rua">
														</div>
													</div>
												</div>

											</fieldset>
											<h4 class="form-section">
												<i class="ft-user-plus"></i> Conta
											</h4>
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

											<h4 class="form-section">
												<i class="ft-percent"></i> Regras
											</h4>
											<fieldset>
												<div class="row">
													<input type="hidden" id="pccashback-id" />
													<div class="col-md-3">
														<div class="form-group">
															<label for="description">Descrição:<span class="danger">*</span></label> <input type="text" class="form-control text-capitalize" id="description" name="description" />
															<div id="description-error" class="help-block hidden">Este campo é obrigatório.</div>
														</div>
													</div>
													<div class="col-md-3 form-group">
														<label class="label-control" for="categoria">Moeda:</label> <select class="select2 form-control currency" name="currency" id="currency">
															<optgroup label="Escolha uma categoria">
																<option value="">Não Selecionado</option>
															</optgroup>
														</select>
														<div id="currency-error" class="help-block hidden">Este campo é obrigatório.</div>
													</div>
													<div class="col-md-6">
														<fieldset>
															<label for="pcCashback">Percentual %:<span class="danger">*</span></label>
															<div class="input-group">
																<input type="number" class="form-control" id="pcCashback" name="pcCashback" aria-describedby="button-addon2" min="0">
																<div class="input-group-append">
																	<button class="btn btn-primary btn-glow" type="button" id="add-pccashback">
																		<i class="step-icon ft-plus"></i>Adicionar
																	</button>
																	<button class="btn btn-dark btn-glow hidden" data-toggle="tooltip" data-placement="top" title="" data-original-title="Clique para limpar o Formulário" type="button" id="clear-pccashback-form">
																		<i class="ft-refresh-cw"></i>
																	</button>
																	<button class="btn btn-danger btn-glow hidden" data-toggle="tooltip" data-placement="top" title="" data-original-title="Clique para remover esse registro" type="button" id="remove-pccashback">
																		<i class="ft-x"></i>
																	</button>
																</div>
															</div>
															<div class="help-block hidden" id="pcCashback-error">Campo não preenchido ou maior que 99</div>
														</fieldset>
													</div>
												</div>
											</fieldset>
											<h4 class="form-section">
												<i class="ft-percent"></i> Tabela de Regras
											</h4>
											<fieldset>
												<div class="row">
													<div class="col-md-12 table-responsive">
														<table class="table table-striped table-bordered" id="${tableId}">
														</table>
													</div>
												</div>
											</fieldset>
											<div class="col-md-12 text-center">
												<input name="rows" type="hidden">
											</div>
											<div class="form-actions center">
												<a href="${pageContext.request.contextPath}/accredited/list" class="btn btn-outline-primary btn-min-width btn-glow mr-1 mb-1"> <i class="ft-arrow-left"></i> Voltar a página anterior
												</a>
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
	<jsp:include page="../../tiles/template/footer.jsp"></jsp:include>
	<!-- ///////////////////////////////////js/////////////////////////////////////////-->
	<jsp:include page="../../tiles/template/js.jsp"></jsp:include>
	<script src="${pageContext.request.contextPath}/resources/app-assets/vendors/js/forms/select/select2.full.min.js"></script>
	<jsp:include page="../../tiles/template/form.jsp"></jsp:include>
	<jsp:include page="../../tiles/template/alert.jsp"></jsp:include>
	<jsp:include page="../../tiles/template/validate.jsp"></jsp:include>
	<jsp:include page="../../tiles/template/datatable.jsp"></jsp:include>
	<script src="${pageContext.request.contextPath}/resources/app-assets/vendors/js/tables/datatable/dataTables.select.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/app-assets/js/scripts/helpers/data-table-helper.js"></script>
	<script src="${pageContext.request.contextPath}/resources/app-assets/js/scripts/helpers/cep.js"></script>

	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/app-assets/js/scripts/extensions/block-ui.js"></script>
	<script src="${pageContext.request.contextPath}/resources/app-assets/js/scripts/pages/${js}"></script>
</body>
</html>