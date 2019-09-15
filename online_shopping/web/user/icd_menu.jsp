<%@ page pageEncoding="UTF-8"%>
<nav class="menu" id="mymenu">
	<ul class="nav nav-primary">
		<li class="nav-parent show"><a href="javascript:;"> 订单信息</a>
			<ul class="nav">
				<li ${param.tag == 'index' ? "class='active'" : ""}><a
					href="${ctx}/user/orders"><i class="icon-shopping-cart"></i>
						我的订单<i class="icon-chevron-right"></i></a></li>
			</ul></li>
		<li class="nav-parent show"><a href="javascript:;"> 个人信息</a>
			<ul class="nav">
				<li ${param.tag == 'profile' ? "class='active' " : ""}><a
					href="${ctx}/user/profile.jsp"><i class="icon-user"></i> 个人资料<i
						class="icon-chevron-right"></i></a></li>
			</ul></li>
	</ul>
</nav>