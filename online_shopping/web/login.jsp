
<%--
  Created by IntelliJ IDEA.
  User: yanzhe
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
                <strong>Login</strong>
            </div>
            <div class="panel-body row">
                <div class="col-xs-3"></div>

                <div class="col-xs-6" style="padding: 30px 60px">
                    <div class="panel" style="border: none;">
                        <div class="panel-heading" style="background: none;">
                            <strong>Please Login</strong>
                        </div>
                        <div class="panel-body">
                            <form action="${ctx}/login" method="post">
                                <div class="form-group">
                                    <input type="text" name="email" id="email" value=""
                                           placeholder="Email" class="form-control input-lg">
                                </div>
                                <div class="form-group">
                                    <input type="password" name="password" id="password" value=""
                                           placeholder="Password" class="form-control input-lg">
                                </div>
                                <button type="submit" class="btn btn-primary btn-wider btn-lg">Login</button>
                                &nbsp; &nbsp; <a href="${ctx}/register.jsp">Register</a>&nbsp;
                                &nbsp; <a href="${ctx}/forgetPassword.jsp">Forget Password</a>
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
