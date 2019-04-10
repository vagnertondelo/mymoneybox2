<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html class="loading" lang="en" data-textdirection="ltr">
<head>
<jsp:include page="../tiles/template/head.jsp"></jsp:include>
<jsp:include page="../tiles/template/css.jsp"></jsp:include>
</head>
<body class="vertical-layout vertical-menu-modern 2-columns   menu-expanded fixed-navbar" data-open="click" data-menu="vertical-menu-modern" data-col="2-columns">
	<jsp:include page="../tiles/template/header.jsp"></jsp:include>
	<!-- ////////////////////////////////////////////////////////////////////////////-->
	<jsp:include page="../tiles/template/menu.jsp"></jsp:include>
	<!-- ////////////////////////////////////////////////////////////////////////////-->

	<div class="app-content content">
		<div class="content-wrapper">
			<div class="content-header row mb-1"></div>
			<div class="content-body">
				<!-- Revenue, Hit Rate & Deals -->
				<div class="row">
					<c:forEach items="${stats}" var="stat">
						<div class="col-xl-3 col-lg-6 col-12">
							<div class="card pull-up">
								<div class="card-content">
									<div class="card-body">
										<div class="media d-flex">
											<div class="media-body text-left">
												<h3 class="blue darken-3">${stat.value}</h3>
												<h6>${stat.name}</h6>
											</div>
											<div>
												<i class="${stat.icon} purple darken-3 font-large-2 float-right"></i>
											</div>
										</div>
										<div class="progress progress-sm mt-1 mb-0 box-shadow-2">
											<div class="progress-bar bg-gradient-x-purple" role="progressbar" style="width: 100%" aria-valuenow="80" aria-valuemin="0" aria-valuemax="100"></div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>

				<div class="row">
					<div class="col-xl-12 col-12">
						<div class="card">
							<div class="card-header">
								<h4 class="card-title">Indicar</h4>
								<a class="heading-elements-toggle"><i class="la la-ellipsis-v font-medium-3"></i></a>
								<div class="heading-elements">
									<ul class="list-inline mb-0">
										<li><a data-action="reload"><i class="ft-rotate-cw"></i></a></li>
									</ul>
								</div>
							</div>
							<div class="card-content collapse show">
								<div class="card-body pt-0">
									<div class="row mb-1">
										<div class="col-12 col-sm-12">
											<label for="indicar">Indicar</label>
											<div class="input-group">
												<input id="indicar" type="text" readonly="readonly" class="form-control" value="${URL}${pageContext.request.contextPath}/freely/register?sponsorAccountNo=${user.accountNo}" />
												<div class="input-group-btn">
													<button type="button" class="btn btn-default" onclick="copy('indicar')" >Copiar</button>
													<a href="${URL}${pageContext.request.contextPath}/freely/register?sponsorAccountNo=${user.accountNo}" target="_blank" class="btn btn-info">Abrir</a>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- ////////////////////////////////////////////////////////////////////////////-->
	<jsp:include page="../tiles/template/footer.jsp"></jsp:include>
	<jsp:include page="../tiles/template/js.jsp"></jsp:include>
	
	<script src="https://pixinvent.com/modern-admin-clean-bootstrap-4-dashboard-html-template/app-assets/vendors/js/charts/chart.min.js"></script>
	<script src="https://pixinvent.com/modern-admin-clean-bootstrap-4-dashboard-html-template/app-assets/vendors/js/charts/raphael-min.js"></script>
	<script src="https://pixinvent.com/modern-admin-clean-bootstrap-4-dashboard-html-template/app-assets/vendors/js/charts/morris.min.js"></script>
	
	<script src="https://pixinvent.com/modern-admin-clean-bootstrap-4-dashboard-html-template/app-assets/js/scripts/pages/dashboard-sales.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/app-assets/js/scripts/pages/${js}"></script>	
</body>
</html>