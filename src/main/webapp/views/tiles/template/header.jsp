<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!-- fixed-top-->
<nav class="header-navbar navbar-expand-md navbar navbar-with-menu navbar-without-dd-arrow fixed-top navbar-semi-light bg-gradient-x-grey-blue">
	<div class="navbar-wrapper">
		<div class="navbar-header">
			<ul class="nav navbar-nav flex-row position-relative">
				<li class="nav-item mobile-menu d-md-none mr-auto"><a class="nav-link nav-menu-main menu-toggle hidden-xs" href="#"><i class="ft-menu font-large-1"></i></a></li>
				<li class="nav-item mr-auto"><a class="navbar-brand" href="home"> <img class="brand-logo" alt="modern admin logo" src="${pageContext.request.contextPath}/resources/app-assets/images/logo/default-logo.png">
						<h3 class="brand-text">${projectName}</h3>
				</a></li>
				<li class="nav-item d-md-none"><a class="nav-link open-navbar-container" data-toggle="collapse" data-target="#navbar-mobile"><i class="la la-ellipsis-v"></i></a></li>
			</ul>
		</div>
		<div class="navbar-container content">
			<div class="collapse navbar-collapse" id="navbar-mobile">
				<ul class="nav navbar-nav mr-auto float-left">
					<li class="nav-item d-none d-md-block"><a class="nav-link nav-link-expand" href="#"><i class="ficon ft-maximize"></i></a></li>
				</ul>
				<ul class="nav navbar-nav float-right">
					<li class="dropdown dropdown-user nav-item"><a class="dropdown-toggle nav-link dropdown-user-link" href="#" data-toggle="dropdown"><span class="mr-1"><span class="user-name text-bold-700 text-capitalize">${user.name}</span></span><span class="avatar avatar-online"><img src="https://www.w3schools.com/howto/img_avatar.png" alt="avatar"><i></i></span></a>
						<div class="dropdown-menu dropdown-menu-right">
							<a class="dropdown-item" href="${pageContext.request.contextPath}/account/register"><i class="ft-user"></i> Editar Perfil </a>
							<div class="dropdown-divider"></div>
							<a class="dropdown-item" href="${pageContext.request.contextPath}/logout"><i class="ft-power"></i> Logout</a>
						</div></li>
				</ul>
			</div>
		</div>
	</div>
</nav>