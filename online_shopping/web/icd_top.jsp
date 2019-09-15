<%@ page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div id="top">
	<!-- 工具条 -->
	<div id="toolbar">
		<div class="wrapper row">
			<c:if test="${!empty sessionScope.curr_mbr}" var="flag">
				<div id="welcome" class="col-xs-5">欢迎会员
					${sessionScope.curr_mbr.name}！</div>
				<div class="col-xs-4"></div>
				<div class="col-xs-3" style="text-align: right;">
					<a href="${ctx}/user/orders">会员首页</a> <a
						href="${ctx}/logout">退出</a>
				</div>
			</c:if>
			<c:if test="${!flag}">
				<div class="col-xs-5">Sneaker Mall</div>
				<div class="col-xs-4"></div>
				<div class="col-xs-3" style="text-align: right;">
					<a href="${ctx}/cart.jsp" class="btn btn-primary"style="width: 120px; height: 40px; line-height: 30px;"> <i class="icon icon-shopping-cart"></i> 购物车</a>
					<a href="${ctx}/login.jsp">登录</a> <a
						href="${ctx}/register.jsp">注册</a>
				</div>
			</c:if>
		</div>
	</div>
	<!-- /工具条 -->

	<!-- 导航栏 -->
	<div id="navbar" class="navbar navbar-inverse">
		<div class="wrapper row">

			<ul class="nav navbar-nav col-xs-9">
				<li ${param.tag == 'index' ? "class='active'" : ""}><a href="${ctx}/main">Home</a></li>
			</ul>
		</div>
	</div>
	<!-- /导航栏 -->
</div>
<!-- /顶部 -->
