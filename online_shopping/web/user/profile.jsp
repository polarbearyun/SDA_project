<%@ page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<jsp:include page="/icd_meta.jsp" />
<title>Member PAGE</title>
<jsp:include page="/icd_link.jsp" />
</head>
<body>
	<jsp:include page="/icd_top.jsp"></jsp:include>

	<div class="wrapper" style="min-height: 500px">
		<div class="row" style="padding: 20px 0px;">
			<div class="col-xs-2">
				<jsp:include page="/user/icd_menu.jsp">
					<jsp:param value="profile" name="tag" />
				</jsp:include>
			</div>

			<div class="col-xs-10">
				<div class="panel">
					<div class="panel-heading">
						<strong><i class="icon-user"></i> Edit </strong>
					</div>
					<div class="panel-body">
						<form action="${ctx}/user/edit" method="post"
							id="profileForm" role="form" class="form-horizontal">
							<div class="form-group">
								<label class="col-xs-2 control-label">Current Member</label>
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
									<button type="reset" id="resetBtn" class="btn btn-default">Reset</button>
									&nbsp;&nbsp;
									<button type="submit" id="submitBtn" class="btn btn-primary"
										style="min-width: 80px">Submit</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>


	<script src="${ctx}/zui/lib/jquery/jquery.js"></script>
	<script src="${ctx}/js/jquery.scrollUp.min.js"></script>
	<script src="${ctx}/zui/js/zui.js"></script>
	<script src="${ctx}/js/my.js"></script>
	<script>
    	$("#profileForm").submit(function(){

    		var url = $(this).attr("action");
    		var param = $(this).serialize();
    		
    		$.post(url, param, function(txt){
    			if("ok" == txt){

    				$("#welcome").text("Welcome " + $("#nick_name").val() + "！");
					    				
    				$.zui.messager.show('Success!', {type: 'success'});
    			}else{
    				$.zui.messager.show('Failed', {type: 'danger'});
    			}
    		});
    		return false;
    	});
    </script>
</body>
</html>