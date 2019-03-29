<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html class="loading" lang="en" data-textdirection="ltr">
<head>
<jsp:include page="../../tiles/template/head.jsp"></jsp:include>
<jsp:include page="../../tiles/template/css.jsp"></jsp:include>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/app-assets/css/plugins/forms/validation/form-validation.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/app-assets/vendors/css/extensions/sweetalert2/sweetalert-custom-centralize.css">
</head>
<body class="vertical-layout vertical-menu-modern 1-column bg-full-screen-image blank-page" data-open="click" data-menu="vertical-menu-modern" data-col="1-column">
	<!-- BEGIN: Content-->
	<div class="app-content content">
		<div class="content-wrapper">
			<div class="content-header row mb-1"></div>
			<div class="content-body">
				<section class="flexbox-container">
					<div class="col-12 d-flex align-items-center justify-content-center">
						<div class="col-lg-4 col-md-8 col-10 box-shadow-2 p-0">
							<div class="card border-grey border-lighten-3 px-2 py-2 m-0">
								<div class="card-header border-0 pb-0">
									<div class="card-title text-center">
										<img src="${pageContext.request.contextPath}/resources/app-assets/images/logo/default-logo.png" style="width: 160px;" alt="branding logo">
									</div>
									<h6 class="card-subtitle line-on-side text-muted text-center font-small-3 pt-2">
										<span>Enviaremos um email para redefinição de sua senha.</span>
									</h6>
								</div>
								<div class="card-content">
									<div class="card-body">
										<form class="form-horizontal" action="login-simple.html" id="${formId}">
											<fieldset class="form-group position-relative has-icon-left">
												<input type="email" class="form-control required" id="user-email" name="email" placeholder="Seu endereço de email">
												<div class="form-control-position">
													<i class="ft-mail"></i>
												</div>
											</fieldset>
											<button type="submit" class="btn btn-outline-info btn-lg btn-block">
												<i class="ft-unlock"></i> Recuperar Senha
											</button>
										</form>
									</div>
								</div>
								<div class="card-footer border-0">
									<p class="float-sm-left text-center">
										<a href="${pageContext.request.contextPath}/freely/login" class="card-link">Login</a>
									</p>
									<p class="float-sm-right text-center">
										Novo no MyMoneyBox ? <a href="${pageContext.request.contextPath}/freely/register" class="card-link">Criar uma conta</a>
									</p>
								</div>
							</div>
						</div>
					</div>
				</section>
			</div>
		</div>
	</div>
	<!-- ////////////////////////////////////////////////////////////////////////////-->
	<jsp:include page="../../tiles/template/js.jsp"></jsp:include>
	<jsp:include page="../../tiles/template/form.jsp"></jsp:include>
	<jsp:include page="../../tiles/template/validate.jsp"></jsp:include>
	<jsp:include page="../../tiles/template/alert.jsp"></jsp:include>
	<jsp:include page="../../tiles/template/message.jsp"></jsp:include>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/app-assets/js/scripts/pages/${js}"></script>
</body>
</html>

