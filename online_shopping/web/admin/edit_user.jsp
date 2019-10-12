<%--
  Created by IntelliJ IDEA.
  User: zsgd9
  Date: 2019/10/11
  Time: 15:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <jsp:include page="/icd_meta.jsp" />
    <title>User Management - Edit User</title>
    <jsp:include page="/icd_link.jsp" />
</head>
<body>
<jsp:include page="/admin/top_menu.jsp"></jsp:include>

<div class="wrapper" style="min-height: 500px">
    <div class="row" style="padding: 20px 0px;">
        <div class="col-xs-2"></div>

        <div class="col-xs-10">
            <div class="panel">
                <div class="panel-heading">
                    <strong><i class="icon-user"></i> Edit User Info </strong>
                </div>
                <div class="panel-body">
                    <form action="${ctx}/admin/editUser" method="post"
                          id="profileForm" role="form" class="form-horizontal">
                        <div class="form-group">
                            <label class="col-xs-2 control-label"></label>
                            <div class="col-xs-4 required">
                                <input type="hidden" name="id" id="id"
                                       value="${user.id}"
                                       class="form-control">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-xs-2 control-label">Email</label>
                            <div class="col-xs-4 required">
                                <input type="text" name="email" id="email"
                                       value="${user.email}"
                                       class="form-control">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-xs-2 control-label">Name</label>
                            <div class="col-xs-4 required">
                                <input type="text" name="name" id="name"
                                       value="${user.name}"
                                       class="form-control">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-xs-2 control-label">Phone</label>
                            <div class="col-xs-4 required">
                                <input type="text" name="phone" id="phone"
                                       value="${user.phone}"
                                       class="form-control" />
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-xs-2 control-label">Password</label>
                            <div class="col-xs-4 required">
                                <input type="password" name="password" id="password"
                                       value="${user.password}"
                                       class="form-control" />
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-xs-2 control-label">Address</label>
                            <div class="col-xs-4 required">
                                <input type="text" name="address" id="address"
                                       value="${user.address.address}"
                                       class="form-control" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-xs-2 control-label">state</label>
                            <div class="col-xs-4 required">
                                <input type="text" name="state" id="state"
                                       value="${user.address.state}"
                                       class="form-control" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-xs-2 control-label">Password</label>
                            <div class="col-xs-4 required">
                                <input type="text" name="post_code" id="post_code"
                                       value="${user.address.post_code}"
                                       class="form-control" />
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-xs-2"></div>
                            <div class="col-xs-10">
                                <button type="submit" class="btn btn-primary btn-wider btn-lg">Submit</button>
                                <button type="button" class="btn btn-primary btn-wider btn-lg" onclick="history.back(-1);">Back</button>

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
</body>
</html>
