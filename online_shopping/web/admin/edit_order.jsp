<%--
  Created by IntelliJ IDEA.
  User: wangyuncheng
  Date: 2019-10-11
  Time: 17:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <jsp:include page="/icd_meta.jsp" />
    <title>Online shopping mall - Login</title>
    <jsp:include page="/icd_link.jsp" />
</head>
<body>


<!-- main content -->
<div class="wrapper" style="min-height: 500px;">
    <div class="panel" style="margin-top: 20px">
        <div class="panel-heading" style="font-size: 18px">
            <strong>Edit Order</strong>
        </div>
        <div class="panel-body row">
            <div class="col-xs-3"></div>

            <div class="col-xs-6" style="padding: 30px 60px">
                <div class="panel" style="border: none;">
                    <div class="panel-heading" style="background: none;">
                        <strong>Order Detail</strong>
                    </div>
                    <div class="panel-body">
                        <form action="${ctx}/admin/editOrder" method="post">
                            <div class="form-group">
                                <input type="hidden" name="id" id="id" value="${order.id}"
                                       placeholder="Name" class="form-control input-lg">
                            </div>

                            <div class="form-group">
                                <a>Order Number</a>
                                <input type="text" readonly="readonly" name="number" id="number" value="${order.number}"
                                       placeholder="number" class="form-control input-lg">
                            </div>
                            <div class="form-group">
                                <a>User ID</a>
                                <input type="text" readonly="readonly" name="user_id" id="user_id" value="${order.user_id}"
                                       placeholder="Picture URL" class="form-control input-lg">
                            </div>
                            <div class="form-group">
                                <a>Total Price</a>
                                <input type="text" readonly="readonly" name="total_price" id="total_price" value="${order.total_price}"
                                       placeholder="Total Price" class="form-control input-lg">
                            </div>
                            <div class="form-group">
                                <a>Remark</a>
                                <input type="text" readonly="readonly" name="remark" id="remark" value="${order.remark}"
                                       placeholder="Remark" class="form-control input-lg">
                            </div>
                            <div class="form-group">
                                <input type="text" name="status" id="status" value="${order.status}"
                                       placeholder="status" class="form-control input-lg">
                            </div>
                            <button type="submit" class="btn btn-primary btn-wider btn-lg">Submit</button>
                            <button type="button" class="btn btn-primary btn-wider btn-lg" onclick="history.back(-1);">Back</button>
                        </form>
                    </div>
                </div>
            </div>

            <div class="col-xs-3"></div>

        </div>
    </div>
</div>
<!-- /main content -->


<script src="${ctx}/zui/lib/jquery/jquery.js"></script>
<script src="${ctx}/js/jquery.scrollUp.min.js"></script>
<script src="${ctx}/zui/js/zui.js"></script>
<script src="${ctx}/js/my.js"></script>
</body>
</html>