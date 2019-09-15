<%@ page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<jsp:include page="/icd_meta.jsp" />
<title>Address PAGE</title>
<jsp:include page="/icd_link.jsp" />
</head>
<body>
	<jsp:include page="/icd_top.jsp"></jsp:include>

	<div class="wrapper" style="min-height: 500px">
		<div class="row" style="padding: 20px 0px;">
			<div class="col-xs-2">
				<jsp:include page="/user/icd_menu.jsp">
					<jsp:param value="address" name="tag" />
				</jsp:include>
			</div>

			<div class="col-xs-10">
				<div class="panel">
					<div class="panel-heading">
						<strong><i class="icon-map-marker"></i> Address Management(One User only have One Address)</strong>
						<div class="panel-actions">
							<button class="btn btn-primary" data-toggle="modal"
								data-target="#addAddressModal">ADD</button>
						</div>
					</div>
					<table class="table table-hover table-striped tablesorter">
						<thead>
							<tr class="text-center">
								<td>Name</td>
								<td>Address</td>
								<td>PostCode</td>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${list}" var="address">
								<tr class="text-center">
									<td>${address.state}</td>
									<td>${address.address}</td>
									<td>${address.post_code}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>


	<!-- Add address pop window -->
	<div class="modal fade" id="addAddressModal">
		<div class="modal-dialog">
			<form action="${ctx}/user/address/add" method="post"
				id="addressForm" class="form-horizontal">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">
							<span aria-hidden="true">×</span><span class="sr-only">Close</span>
						</button>
						<h4 class="modal-title">Add Address</h4>
					</div>
					<div class="modal-body">
						<div class="form-group">
							<label class="col-xs-2 control-label">Name</label>
							<div class="col-xs-4 required">
								<input type="text" name="contact_name" id="contact_name"
									placeholder="Name" class="form-control" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-xs-2 control-label">Address</label>
							<div class="col-xs-9 required">
								<input type="text" name="address" id="address" placeholder="Address"
									class="form-control" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-xs-2 control-label">PostCode</label>
							<div class="col-xs-4 required">
								<input type="text" name="post_code" id="post_code"
									placeholder="PostCode" class="form-control" />
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<button type="reset" id="resetBtn" class="btn btn-default">Reset</button>
						<button type="submit" id="submitBtn" class="btn btn-primary" style="min-width: 80px">Submit</button>
					</div>
				</div>
			</form>
		</div>
	</div>



	<script src="${ctx}/zui/lib/jquery/jquery.js"></script>
	<script src="${ctx}/js/jquery.scrollUp.min.js"></script>
	<script src="${ctx}/zui/js/zui.js"></script>
	<script src="${ctx}/js/my.js"></script>
	<script>
        /***********solve delete method*************/
        var url = null;
    	$(".deleteHref").click(function(){

    		$('#deleteModal').modal('show');

    		url = $(this).attr("href");
    		
    		return false;
    	});
    	
    	$("#doDelete").click(function(){

    		if(url){
    			location.assign(url);
    		}
    		$('#deleteModal').modal('hide');
    		
    		return false;
    	});
    </script>
</body>
</html>