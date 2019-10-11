<%--
  Created by IntelliJ IDEA.
  User: wangyuncheng
  Date: 2019-10-10
  Time: 16:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <jsp:include page="/icd_meta.jsp" />
    <title>User Management</title>
    <jsp:include page="/icd_link.jsp" />
</head>
<body>
<jsp:include page="/icd_top.jsp"></jsp:include>

<div class="wrapper" style="min-height: 530px">

    <div class="row" style="padding: 20px 0px;">
        <div class="col-xs-2">
            <jsp:include page="/admin/left_menu.jsp">
                <jsp:param value="user_list" name="tag" />
            </jsp:include>
        </div>

        <div class="col-xs-10">
            <div class="panel">
                <div class="panel-heading">
                    <strong><i class="icon-shopping-cart"> </i>Order Manage</strong>
                </div>
                <table class="table table-hover table-striped tablesorter">
                    <thead>
                    <tr class="text-center">
                        <td style="width: 100px">Email</td>
                        <td style="width: 80px">Name</td>
                        <td style="width: 80px">Phone</td>
                        <td style="width: 280px" class="text-center">Address</td>
                        <td style="width: 80px">State</td>
                        <td style="width: 80px">Post_Code</td>
                        <td style="width: 80px"></td>
                        <td style="width: 80px"></td>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${users}" var="ord">
                        <tr>
                            <td class="text-center"> ${ord.email}</td>
                            <td class="text-center"> ${ord.name}</td>
                            <td class="text-center"> ${ord.phone}</td>
                            <c:forEach items="${ord.address}" var="item" varStatus="vs">
                                <c:if test="${vs.index >0}">
                                    <td class="text-center">${ord.address.address}</td>
                                    <td class="text-center">${ord.address.state}</td>
                                    <td class="text-center">${ord.address.post_code}</td>
                                </c:if>
                            </c:forEach>

                            <td><a href="${ctx}/admin/editUserByAdmin?id=${entry.key.id}"
                                   class="deleter">Edit</a></td>
                            <td><a href="${ctx}/admin/deleteUserByAdmin?id=${entry.key.id}"
                                   class="deleter">Delete</a></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                    <tfoot>
                    <tr>
                    </tr>
                    </tfoot>
                </table>
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
