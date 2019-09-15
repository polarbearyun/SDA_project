<%--
  Created by IntelliJ IDEA.
  User: yanzhe
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Online shopping mall - Register</title>
</head>
<body>

    <!-- Content -->
    <div class="wrapper" style="min-height: 500px;">
            <div class="panel" style="margin-top: 20px">
            <div class="panel-heading" style="font-size: 18px">
                <strong>Register</strong>
            </div>
            <div class="panel-body row">
                <div class="col-xs-3"></div>

                <div class="col-xs-6" style="padding: 30px 60px">
                    <div class="panel" style="border: none;">
                        <div class="panel-heading" style="background: none;">
                            <strong>Welcome to register</strong>
                        </div>
                        <div class="panel-body">
                            <form action="${ctx}/register" method="post">
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


                                <button type="submit" class="btn btn-primary btn-wider btn-lg">Register</button>
                                &nbsp; &nbsp;
                                <button type="reset" class="btn btn-wider btn-lg">Cancel</button>
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
