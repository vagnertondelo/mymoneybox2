
<!DOCTYPE html>
<html class="loading" lang="en" data-textdirection="ltr">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
<meta name="description" content="Modern admin is super flexible, powerful, clean &amp; modern responsive bootstrap 4 admin template with unlimited possibilities with bitcoin dashboard.">
<meta name="keywords" content="admin template, modern admin template, dashboard template, flat admin template, responsive admin template, web app, crypto dashboard, bitcoin dashboard">
<meta name="author" content="PIXINVENT">
<title>Basic Forms - Modern Admin - Clean Bootstrap 4 Dashboard HTML Template + Bitcoin Dashboard</title>
<link rel="apple-touch-icon" href="../../../app-assets/images/ico/apple-icon-120.png">
<link rel="shortcut icon" type="image/x-icon" href="../../../app-assets/images/ico/favicon.ico">
<link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i%7CQuicksand:300,400,500,700" rel="stylesheet">
<!-- BEGIN VENDOR CSS-->
<link rel="stylesheet" type="text/css" href="../../../app-assets/css/vendors.min.css">
<!-- END VENDOR CSS-->
<!-- BEGIN MODERN CSS-->
<link rel="stylesheet" type="text/css" href="../../../app-assets/css/app.min.css">
<!-- END MODERN CSS-->
<!-- BEGIN Page Level CSS-->
<link rel="stylesheet" type="text/css" href="../../../app-assets/css/core/menu/menu-types/vertical-menu-modern.css">
<link rel="stylesheet" type="text/css" href="../../../app-assets/css/core/colors/palette-gradient.min.css">
<!-- END Page Level CSS-->
<!-- BEGIN Custom CSS-->
<link rel="stylesheet" type="text/css" href="../../../assets/css/style.css">
<!-- END Custom CSS-->
</head>
<body class="vertical-layout vertical-menu-modern 2-columns   menu-expanded fixed-navbar" data-open="click" data-menu="vertical-menu-modern" data-col="2-columns">
	<div class="app-content content">
		<div class="content-wrapper">
			<div class="content-header row">
				<div class="content-header-left col-md-6 col-12 mb-2 breadcrumb-new">
					<h3 class="content-header-title mb-0 d-inline-block">Basic Forms</h3>
					<div class="row breadcrumbs-top d-inline-block">
						<div class="breadcrumb-wrapper col-12">
							<ol class="breadcrumb">
								<li class="breadcrumb-item"><a href="index.html">Home</a></li>
								<li class="breadcrumb-item"><a href="#">Form Layouts</a></li>
								<li class="breadcrumb-item active"><a href="#">Basic Forms</a></li>
							</ol>
						</div>
					</div>
				</div>
				<div class="content-header-right col-md-6 col-12">
					<div class="btn-group float-md-right">
						<button class="btn btn-info dropdown-toggle" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Action</button>
						<div class="dropdown-menu arrow">
							<a class="dropdown-item" href="#"><i class="fa fa-calendar-check mr-1"></i> Calender</a><a class="dropdown-item" href="#"><i class="fa fa-cart-plus mr-1"></i> Cart</a><a class="dropdown-item" href="#"><i class="fa fa-life-ring mr-1"></i> Support</a>
							<div class="dropdown-divider"></div>
							<a class="dropdown-item" href="#"><i class="fa fa-cog mr-1"></i> Settings</a>
						</div>
					</div>
				</div>
			</div>
			<div class="content-body">
				<section id="basic-form-layouts">
					<div class="row justify-content-md-center">
						<div class="col-md-6">
							<div class="card">
								<div class="card-header">
									<h4 class="card-title" id="basic-layout-card-center">Event Registration</h4>
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
								<div class="card-content collapse show">
									<div class="card-body">
										<div class="card-text">
											<p>
												This example shows a ways to center your card with form. Here we have used
												<code>col-md-6 ml-auto</code>
												classes to center the card as its not full width. User can always change those classes according to width and offset requirements. This example also uses form action buttons in the center bottom position of the card.
											</p>
										</div>
										<form class="form">
											<div class="form-body">

												<div class="form-group">
													<label for="eventRegInput1">Full Name</label> <input type="text" id="eventRegInput1" class="form-control" placeholder="name" name="fullname">
												</div>

												<div class="form-group">
													<label for="eventRegInput2">Title</label> <input type="text" id="eventRegInput2" class="form-control" placeholder="title" name="title">
												</div>

												<div class="form-group">
													<label for="eventRegInput3">Company</label> <input type="text" id="eventRegInput3" class="form-control" placeholder="company" name="company">
												</div>

												<div class="form-group">
													<label for="eventRegInput4">Email</label> <input type="email" id="eventRegInput4" class="form-control" placeholder="email" name="email">
												</div>

												<div class="form-group">
													<label for="eventRegInput5">Contact Number</label> <input type="tel" id="eventRegInput5" class="form-control" name="contact" placeholder="contact number">
												</div>

												<div class="form-group">
													<label>Existing Customer</label>
													<div class="input-group">
														<div class="d-inline-block custom-control custom-radio mr-1">
															<input type="radio" name="customer2" class="custom-control-input" id="yes1"> <label class="custom-control-label" for="yes1">Yes</label>
														</div>
														<div class="d-inline-block custom-control custom-radio">
															<input type="radio" name="customer2" class="custom-control-input" id="no1"> <label class="custom-control-label" for="no1">No</label>
														</div>
													</div>
												</div>
											</div>

											<div class="form-actions center">
												<button type="button" class="btn btn-warning mr-1">
													<i class="ft-x"></i> Cancel
												</button>
												<button type="submit" class="btn btn-primary">
													<i class="la la-check-square-o"></i> Save
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
	<!-- BEGIN VENDOR JS-->
	<script src="../../../app-assets/vendors/js/vendors.min.js"></script>
	<!-- BEGIN VENDOR JS-->
	<!-- BEGIN PAGE VENDOR JS-->
	<!-- END PAGE VENDOR JS-->
	<!-- BEGIN MODERN JS-->
	<script src="../../../app-assets/js/core/app-menu.min.js"></script>
	<script src="../../../app-assets/js/core/app.min.js"></script>
	<script src="../../../app-assets/js/scripts/customizer.min.js"></script>
	<!-- END MODERN JS-->
	<!-- BEGIN PAGE LEVEL JS-->
	<!-- END PAGE LEVEL JS-->
</body>
</html>