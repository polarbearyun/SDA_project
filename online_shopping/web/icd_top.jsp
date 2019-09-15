<%@ page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!--[if lt IE 8]>
 <div class="alert alert-danger">您正在使用 <strong>过时的</strong> 浏览器. 是时候 <a href="http://browsehappy.com/">更换一个更好的浏览器</a> 来提升用户体验.</div>
<![endif]-->
<!-- 顶部 -->
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
						href="${ctx}/user/logout">退出</a>
				</div>
			</c:if>
			<c:if test="${!flag}">
				<div class="col-xs-5">演示系统,如有雷同纯属巧合！！！</div>
				<div class="col-xs-4"></div>
				<div class="col-xs-3" style="text-align: right;">
					<a href="${ctx}/login.jsp">登录</a> <a
						href="${ctx}/register.jsp">注册</a>
				</div>
			</c:if>
		</div>
	</div>
	<!-- /工具条 -->

	<!-- LOGO栏 -->
	<div id="subject">
		<div class="wrapper row">
			<div class="col-xs-2" id="logo">
				<a href="${ctx}/main "> <img src="${ctx}/pic/logo-zx.jpg"
					style="width: 160px;" />
				</a>
			</div>
			<div class="col-xs-2"></div>

			<div class="col-xs-2"></div>
			<div class="col-xs-2" id="cart">
				<a href="${ctx}/cart.jsp" class="btn btn-primary"
					style="width: 120px; height: 40px; line-height: 30px;"> <i
					class="icon icon-shopping-cart"></i> 购物车 <!-- <span class="label label-badge" style="background-color: #eba5a3;">4</span> -->
				</a>
			</div>
		</div>
	</div>
	<!-- /LOGO栏 -->

	<!-- 导航栏 -->
	<div id="navbar" class="navbar navbar-inverse">
		<div class="wrapper row">


			<ul class="nav navbar-nav col-xs-9">
				<li ${param.tag == 'index' ? "class='active'" : ""}><a href="${ctx}/main">首页</a></li>
				<li><a href="about.jsp">关于我们</a></li>
			</ul>
		</div>
	</div>
	<!-- /导航栏 -->
</div>
<!-- /顶部 -->
