<%@ page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div id="top">
	<!-- 工具条 -->
	<div id="toolbar">
		<div class="wrapper row">
			<c:if test="${!empty sessionScope.curr_mbr}" var="flag">
				<div id="welcome" class="col-xs-5">Welcome
					${sessionScope.curr_mbr.name}！</div>
				<div class="col-xs-4"></div>
				<div class="col-xs-3" style="text-align: right;">
					<a href="${ctx}/user/orders">Member</a> <a
						href="${ctx}/logout">Logout</a>
				</div>
			</c:if>
			<c:if test="${!flag}">
				<div class="col-xs-5">Sneaker Mall</div>
				<div class="col-xs-4"></div>
				<div class="col-xs-3" style="text-align: right;">
					<a href="${ctx}/cart.jsp" class="btn btn-primary"style="width: 120px; height: 40px; line-height: 30px;"> <i class="icon icon-shopping-cart"></i> Cart</a>
					<a href="${ctx}/login.jsp">Login</a> <a
						href="${ctx}/register.jsp">Register</a>
				</div>
			</c:if>
		</div>
	</div>
	<div id="navbar" class="navbar navbar-inverse">
		<div class="wrapper row">

			<ul class="nav navbar-nav col-xs-9">
				<li ${param.tag == 'index' ? "class='active'" : ""}><a href="${ctx}/main">Home</a></li>
			</ul>
		</div>
	</div>

</div>
