<%--
  Created by IntelliJ IDEA.
  User: zsgd9
  Date: 2019/10/11
  Time: 14:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/icd_meta.jsp" />
    <title>User Management - Add users</title>
    <jsp:include page="/icd_link.jsp" />
</head>
<body>
<jsp:include page="/admin/top_menu.jsp"></jsp:include>

<!-- Content -->
<div class="wrapper" style="min-height: 500px;">
    <div class="panel" style="margin-top: 20px">
        <div class="panel-heading" style="font-size: 18px">
            <strong>Add users</strong>
        </div>
        <div class="panel-body row">
            <div class="col-xs-3"></div>

            <div class="col-xs-6" style="padding: 30px 60px">
                <div class="panel" style="border: none;">
                    <div class="panel-heading" style="background: none;">
                        <strong>Please enter info</strong>
                    </div>
                    <div class="panel-body">
                        <form action="${ctx}/admin/addUser" method="post">
                            <div class="form-group">
                                <input type="text" name="email" id="email"
                                       placeholder="Email" class="form-control input-lg">
                            </div>
                            <div class="form-group">
                                <input type="text" name="name" id="name"
                                       placeholder="Name" class="form-control input-lg">
                            </div>
                            <div class="form-group">
                                <input type="text" name="phone" id="phone"
                                       placeholder="Phone Number" class="form-control input-lg">
                            </div>
                            <div class="form-group">
                                <input type="password" name="password" id="password" value=""
                                       placeholder="Password" class="form-control input-lg">
                            </div>
                            <div class="form-group">
                                <input type="password" name="passwordConfirm" id="passwordConfirm" value=""
                                       placeholder="Confirm Password again" class="form-control input-lg">
                            </div>


                            <button type="submit" class="btn btn-primary btn-wider btn-lg">Confirm</button>
                            <button type="button" class="btn btn-primary btn-wider btn-lg" onclick="history.back(-1);">Back</button>
                        </form>
                    </div>
                </div>
            </div>

            <div class="col-xs-3"></div>

        </div>
    </div>
</div>
<!-- /Content -->


<script src="${ctx}/zui/lib/jquery/jquery.js"></script>
<script src="${ctx}/js/jquery.scrollUp.min.js"></script>
<script src="${ctx}/zui/js/zui.js"></script>
<script src="${ctx}/js/my.js"></script>
</body>
</html>

