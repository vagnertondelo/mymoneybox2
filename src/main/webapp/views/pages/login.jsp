<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html class="loading" lang="en" data-textdirection="ltr">
<head>
<jsp:include page="../tiles/template/head.jsp"></jsp:include>
<jsp:include page="../tiles/template/css.jsp"></jsp:include>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/app-assets/css/plugins/forms/validation/form-validation.css">

</head>
<body class="vertical-layout vertical-menu-modern 1-column menu-expanded blank-page blank-page" data-open="click" data-menu="vertical-menu-modern" data-col="1-column">
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
											<img class="brand-logo" src="${pageContext.request.contextPath}/resources/app-assets/images/logo/default-logo.png" style="width: 124px;" alt="branding logo">
										</div>
									</div>
									<h6 class="card-subtitle line-on-side text-muted text-center font-small-3 pt-2">
										<span>Bem vindo ao ${projectName}</span>
									</h6>
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
									<div class="card-body">
										<form class="form-horizontal form-simple" action="${pageContext.request.contextPath}/login" method="post" id="${formId}">
											<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" /> <input type="hidden" id="so" name="so" />
											<fieldset class="form-group position-relative has-icon-left mb-0">
												<input type="text" class="form-control form-control-lg input-lg" id="username" name="username" placeholder="Login" required>
												<div class="form-control-position">
													<i class="ft-user"></i>
												</div>
											</fieldset>
											<fieldset class="form-group position-relative has-icon-left">
												<input type="password" class="form-control form-control-lg input-lg" name="password" id="password" maxlength="120" placeholder="Senha" required>
												<div class="form-control-position">
													<i class="la la-key"></i>
												</div>
											</fieldset>
											<div class="form-group row">
												<div class="col-md-6 col-12 text-center text-md-left">
													<fieldset></fieldset>
												</div>
												<div class="col-md-6 col-12 text-center text-md-right right">
													<a href="forgotpassword" class="card-link">Esqueci minha senha ?</a>
												</div>
											</div>
											<button type="submit" class="btn btn-info btn-lg btn-block">
												<i class="ft-unlock"></i> Entrar
											</button>
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
	<!-- ////////////////////////////////////////////////////////////////////////////-->
	<jsp:include page="../tiles/template/js.jsp"></jsp:include>
	<jsp:include page="../tiles/template/form.jsp"></jsp:include>
	<jsp:include page="../tiles/template/validate.jsp"></jsp:include>
	<jsp:include page="../tiles/template/alert.jsp"></jsp:include>
	<jsp:include page="../tiles/template/message.jsp"></jsp:include>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/app-assets/js/scripts/pages/${js}"></script>
</body>
</html>

