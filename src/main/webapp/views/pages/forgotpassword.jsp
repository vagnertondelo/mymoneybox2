<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt">
<head>
<jsp:include page="../tiles/template/head.jsp"></jsp:include>
<jsp:include page="../tiles/template/css.jsp"></jsp:include>
</head>
<body class="vertical-layout vertical-menu-modern 1-column   menu-expanded blank-page blank-page" data-open="click" data-menu="vertical-menu-modern" data-col="1-column">
	<!-- ////////////////////////////////////////////////////////////////////////////-->
	<div class="app-content content">
		<div class="content-wrapper">
			<div class="content-header row"></div>
			<div class="content-body">
				<section class="flexbox-container">
					<div class="col-12 d-flex align-items-center justify-content-center">
						<div class="col-md-4 col-10 box-shadow-2 p-0">
							<div class="card border-grey border-lighten-3 px-2 py-2 m-0">
								<div class="card-header border-0 pb-0">
									<div class="card-title text-center">
										<img src="${pageContext.request.contextPath}/resources/app-assets/images/logo/default-logo.png" style="width: 124px;" alt="branding logo">
									</div>
									<h6 class="card-subtitle line-on-side text-muted text-center font-small-3 pt-2">
										<span>Enviaremos um link para redefinir sua senha.</span>
									</h6>
								</div>
								<div class="card-content">
									<div class="card-body">
										<form class="form-horizontal" action="login-simple.html" novalidate id="${formId}">
											<fieldset class="form-group position-relative has-icon-left">
												<input type="text" class="form-control form-control-lg input-lg" name="login" id="login" placeholder="Login" required>
												<div class="form-control-position">
													<i class="ft-user"></i>
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
										<a href="login" class="card-link">Login</a>
									</p>
								</div>
							</div>
						</div>
					</div>
				</section>
			</div>
		</div>
	</div>
	<!-- ///////////////////////////////////js/////////////////////////////////////////-->
	<jsp:include page="../tiles/template/js.jsp"></jsp:include>
	<jsp:include page="../tiles/template/validate.jsp"></jsp:include>
	<jsp:include page="../tiles/template/message.jsp"></jsp:include>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/app-assets/js/scripts/pages/${js}"></script>
</body>
</html>