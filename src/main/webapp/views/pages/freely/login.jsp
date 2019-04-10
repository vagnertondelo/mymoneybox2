<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html class="loading" lang="pt-BR" data-textdirection="ltr">
<head>
<jsp:include page="../../tiles/template/head.jsp"></jsp:include>
<jsp:include page="../../tiles/template/css.jsp"></jsp:include>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/app-assets/css/plugins/forms/validation/form-validation.css">

</head>
<body class="vertical-layout vertical-menu-modern 1-column bg-full-screen-image blank-page" data-open="click" data-menu="vertical-menu-modern" data-col="1-column">
	<!-- ////////////////////////////////////////////////////////////////////////////-->
	<div class="app-content content">
		<div class="content-wrapper">
			<div class="content-header row"></div>
			<div class="content-body">
				<section class="flexbox-container">
					<div class="col-12 d-flex align-items-center justify-content-center">
						<div class="col-md-4 col-10 box-shadow-2 p-0">
							<div class="card border-grey border-lighten-3 m-0">
								<div class="card-header border-0">
									<div class="card-title text-center">
										<div class="p-1">
											<img src="${pageContext.request.contextPath}/resources/app-assets/images/logo/default-logo.png" style="width: 160px;" alt="branding logo">
										</div>
									</div>
								</div>
								<c:if test="${param.error ne null}">
									<c:remove var="messageType" scope="session" />
									<c:remove var="messageDetail" scope="session" />
									<c:remove var="messageTitle" scope="session" />
									<c:set var="messageType" scope="request" value="0" />
									<c:set var="messageDetail" scope="request" value="Erro" />
									<c:set var="messageTitle" scope="request" value="Usuário ou senha inválido!" />
								</c:if>
								<div class="card-content">
									<p class="card-subtitle line-on-side text-muted text-center font-small-3 mx-2">
										<span>Bem vindo ao ${projectName}</span>
									</p>
									<div class="card-body pt-0">
										<form class="form-horizontal" action="${pageContext.request.contextPath}/login" method="post" id="${formId}">
										<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" /> <input type="hidden" id="so" name="so" />
											<fieldset class="form-group floating-label-form-group">
												<label for="username">Usuário</label> <input type="text" class="form-control" name="username" id="username" placeholder="" autofocus required>
											</fieldset>
											<fieldset class="form-group floating-label-form-group mb-1">
												<label for="password">Senha</label> <input type="password" class="form-control" id="password" name="password" placeholder="" required>
											</fieldset>
											<div class="form-group row">
												<div class="col-md-6 col-12 text-center text-sm-left">
													<fieldset></fieldset>
												</div>
												<div class="col-md-6 col-12 float-sm-left text-center text-sm-right">
													<a href="${pageContext.request.contextPath}/freely/recoverypassword" class="card-link">Esqueci a minha senha?</a>
												</div>
											</div>
											<button type="submit" class="btn btn-outline-info btn-block">
												<i class="ft-unlock"></i> Login
											</button>
										</form>
									</div>
									<p class="card-subtitle line-on-side text-muted text-center font-small-3 mx-2 my-1">
										<span>Novo no ${projectName} ?</span>
									</p>
									<div class="card-body">
										<a href="${pageContext.request.contextPath}/freely/register" class="btn btn-outline-danger btn-block"><i class="ft-user"></i> Cadastrar-se </a>
									</div>
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

