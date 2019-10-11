<%--
  Created by IntelliJ IDEA.
  User: wangyuncheng
  Date: 2019-10-11
  Time: 14:33
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
            <strong>Add Product</strong>
        </div>
        <div class="panel-body row">
            <div class="col-xs-3"></div>

            <div class="col-xs-6" style="padding: 30px 60px">
                <div class="panel" style="border: none;">
                    <div class="panel-heading" style="background: none;">
                        <strong>Product Detail</strong>
                    </div>
                    <div class="panel-body">
                        <form action="${ctx}/admin/addProduct" method="post">

                            <div class="form-group">
                                <input type="text" name="name" id="name" value=""
                                       placeholder="Name" class="form-control input-lg">
                            </div>
                            <div class="form-group">
                                <input type="text" readonly="readonly" name="picture" id="picture" value="https://assets.adidas.com/images/w_385,h_385,f_auto,q_auto:sensitive,fl_lossy/025f2a9492e14bc9a07baaaf0098f4e1_9366/pharrell-wil"
                                       placeholder="Picture URL" class="form-control input-lg">
                            </div>
                            <div class="form-group">
                                <input type="text" name="inventory" id="inventory" value=""
                                       placeholder="Inventory(cannot input 0)" class="form-control input-lg">
                            </div>
                            <div class="form-group">
                                <input type="text" name="price" id="price" value=""
                                       placeholder="Price" class="form-control input-lg">
                            </div>
                            <div class="form-group">
                                <input type="text" name="detail" id="detail" value=""
                                       placeholder="Detail" class="form-control input-lg">
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