<%@ page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<jsp:include page="/icd_meta.jsp" />
<title>会员-个人资料</title>
<jsp:include page="/icd_link.jsp" />
</head>
<body>
	<jsp:include page="/icd_top.jsp"></jsp:include>

	<!-- 主内容 -->
	<div class="wrapper" style="min-height: 500px">
		<!--  -->
		<div class="row" style="padding: 20px 0px;">
			<!-- /左边 -->
			<div class="col-xs-2">
				<jsp:include page="/user/icd_menu.jsp">
					<jsp:param value="profile" name="tag" />
				</jsp:include>
			</div>
			<!-- /左边 -->

			<!-- 右边 -->
			<div class="col-xs-10">
				<div class="panel">
					<div class="panel-heading">
						<strong><i class="icon-user"></i> 修改资料</strong>
					</div>
					<div class="panel-body">
						<form action="${ctx}/user/edit" method="post"
							id="profileForm" role="form" class="form-horizontal">
							<div class="form-group">
								<label class="col-xs-2 control-label">当前会员</label>
								<div class="col-xs-4">${sessionScope.curr_mbr.email}</div>
							</div>
							<div class="form-group">
								<label class="col-xs-2 control-label">Name</label>
								<div class="col-xs-4 required">
									<input type="text" name="name" id="name"
										value="${sessionScope.curr_mbr.name}"
										class="form-control">
								</div>
							</div>


							<div class="form-group">
								<label class="col-xs-2 control-label">Phone</label>
								<div class="col-xs-4 required">
									<input type="text" name="phone" id="phone"
										   value="${sessionScope.curr_mbr.phone}" class="form-control" />
								</div>
							</div>

							<div class="form-group">
								<label class="col-xs-2 control-label">Password</label>
								<div class="col-xs-4 required">
									<input type="password" name="password" id="password"
										   value="${sessionScope.curr_mbr.password}" class="form-control" />
								</div>
							</div>

							<div class="form-group">
								<div class="col-xs-2"></div>
								<div class="col-xs-10">
									<button type="reset" id="resetBtn" class="btn btn-default">重置</button>
									&nbsp;&nbsp;
									<button type="submit" id="submitBtn" class="btn btn-primary"
										style="min-width: 80px">保存</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
			<!-- /右边 -->
		</div>
	</div>
	<!-- /主内容 -->

	<%--<jsp:include page="/icd_bottom.jsp"></jsp:include>--%>

	<script src="${ctx}/zui/lib/jquery/jquery.js"></script>
	<script src="${ctx}/js/jquery.scrollUp.min.js"></script>
	<script src="${ctx}/zui/js/zui.js"></script>
	<script src="${ctx}/js/my.js"></script>
	<script>
    	$("#profileForm").submit(function(){

    		//==========使用jQuery来发送异步请求
    		var url = $(this).attr("action");
    		var param = $(this).serialize(); //获取表单中输入的数据
    		
    		$.post(url, param, function(txt){
    			if("ok" == txt){
    				//修改顶部的欢迎文本
    				$("#welcome").text("欢迎会员 " + $("#nick_name").val() + "！");
					    				
    				$.zui.messager.show('资料修改成功！', {type: 'success'});
    			}else{
    				$.zui.messager.show('资料修改失败！', {type: 'danger'});
    			}
    		});
    		
    		return false; //阻止表单默认的同步提交方式
    	});
    </script>
</body>
</html>