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
    <title>Product Management</title>
    <jsp:include page="/icd_link.jsp" />
</head>
<body>
<jsp:include page="/admin/top_menu.jsp"></jsp:include>

<div class="wrapper" style="min-height: 530px">

    <div class="row" style="padding: 20px 0px;">
        <div class="col-xs-2">
            <jsp:include page="/admin/left_menu.jsp">
                <jsp:param value="product_list" name="tag" />
            </jsp:include>
        </div>

        <div class="col-xs-10">
            <div class="panel">
                <div class="panel-heading">
                    <strong><i class="icon-shopping-cart"> </i>Product Manage</strong>

                    <strong> <a class="pull-right"  href="${ctx}/admin/addProduct">ADD</a></strong>

                </div>
                <table class="table table-hover table-striped tablesorter">
                    <thead>
                    <tr class="text-center">
                        <td style="width: 80px">Name</td>
                        <td style="width: 80px" class="text-right">Price</td>
                        <td style="width: 200px">Detail</td>
                        <td style="width: 80px">Inventory</td>
                        <td style="width: 80px"></td>
                        <td style="width: 80px"></td>

                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${products}" var="ord">
                        <tr>
                            <td class="text-center"> ${ord.name}</td>
                            <td class="text-right"><fmt:formatNumber
                                    value="${ord.price.price}" pattern="$#,##0.00" /></td>
                            <td class="text-center">${ord.detail}</td>
                            <td class="text-center">${ord.inventory}</td>

                            <td><a href="${ctx}/admin/editProductByAdmin?id=${entry.key.id}"
                                        class="deleter">Edit</a></td>
                            <td><a href="${ctx}/admin/deleteProductByAdmin?id=${entry.key.id}"
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
