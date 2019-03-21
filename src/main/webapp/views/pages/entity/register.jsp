<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html class="loading" lang="en" data-textdirection="ltr">
<head>
<jsp:include page="../../tiles/template/head.jsp"></jsp:include>
<jsp:include page="../../tiles/template/css.jsp"></jsp:include>
<!-- Select2 -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/app-assets/vendors/css/forms/select/select2.min.css">
<!-- DataTable -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/app-assets/vendors/css/tables/datatable/datatables.min.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/app-assets/vendors/css/tables/extensions/buttons.dataTables.min.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/app-assets/vendors/css/tables/datatable/dataTables.bootstrap4.min.css">

<style>
.dataTables_wrapper .dt-buttons {
	float: right;
	margin-bottom: 20px;
}
</style>

</head>
<body
	class="vertical-layout vertical-menu-modern 2-columns menu-expanded fixed-navbar"
	data-open="click" data-menu="vertical-menu-modern" data-col="2-columns">
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
								<li class="breadcrumb-item"><a
									href="${pageContext.request.contextPath}/dashboard">Dashboard</a></li>
								<li class="breadcrumb-item"><a
									href="${pageContext.request.contextPath}/accredited/list">Listar</a></li>
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
									<h4 class="card-title">${title}</h4>
									<a class="heading-elements-toggle"><i
										class="la la-ellipsis-v font-medium-3"></i></a>
									<div class="heading-elements">
										<ul class="list-inline mb-0">
											<li><a data-action="collapse"><i class="ft-minus"></i></a></li>
											<li><a data-action="reload"><i class="ft-rotate-cw"></i></a></li>
											<li><a data-action="expand"><i class="ft-maximize"></i></a></li>
											<li><a data-action="close"><i class="ft-x"></i></a></li>
										</ul>
									</div>
								</div>
								<div class="card-content collapse show">
									<div class="card-body">
										<div class="card-text">
											<p></p>
										</div>
										<form class="form" id="${formId}">
											<div class="form-body">
												<div class="row">
													<input type="hidden" id="item-id" /> <input type="hidden"
														name="ipAddress" id="ipAddress" value="${ipAddress}" />
													<div class="col-md-6 form-group">
														<label class="label-control" for="entityCode">Entidade:</label>
														<select class="select2 form-control required"
															name="entityCode" id="entityCode">
															<optgroup label="Escolha uma entidade">
																<option value="">Não Selecionado</option>
																<c:forEach items="${entities}" var="entity">
																	<option value="${entity.code}">${entity.name}</option>
																</c:forEach>
															</optgroup>
														</select>
													</div>
													<div class="col-md-6">
														<div class="form-group">
															<label class="label-control" for="pcEntity">Percentual:</label>
															<input type="text" id="pcEntity" max="100"
																class="form-control required" name="pcEntity"
																placeholder="%">
														</div>
													</div>
												</div>
											</div>
											<div class="table-responsive">
												<table class="table table-striped table-bordered"
													id="${tableId}" style="width: 100%">
												</table>
											</div>
											<div class="form-actions center">
												<button type="button" id="save-button"
													class="btn btn-outline-success btn-min-width btn-glow mr-1 mb-1">
													<i class="la la-check-square-o"></i> Salvar
												</button>
											</div>
										</form>
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
	<script
		src="${pageContext.request.contextPath}/resources/app-assets/vendors/js/forms/select/select2.full.min.js"></script>
	<jsp:include page="../../tiles/template/form.jsp"></jsp:include>
	<jsp:include page="../../tiles/template/alert.jsp"></jsp:include>
	<jsp:include page="../../tiles/template/validate.jsp"></jsp:include>
	<jsp:include page="../../tiles/template/datatable.jsp"></jsp:include>
	<script
		src="${pageContext.request.contextPath}/resources/app-assets/vendors/js/tables/datatable/dataTables.select.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/app-assets/js/scripts/helpers/data-table-helper.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/app-assets/vendors/js/tables/datatable/dataTables.buttons.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/app-assets/vendors/js/tables/datatable/buttons.bootstrap4.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/app-assets/js/scripts/pages/${js}"></script>
</body>
</html>