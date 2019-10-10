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
    <title>Member PAGE</title>
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
                        <td style="width: 60px">ID</td>
                        <td style="width: 80px">Amount</td>
                        <td style="width: 80px" class="text-right">Price</td>
                        <td style="width: 200px">Status</td>
                        <td style="width: 280px">Remark</td>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${page}" var="ord">
                        <tr>
                            <td class="text-center">${ord.number}</td>
                            <td class="text-center">
                                <c:forEach items="${ord.item}" var="item" varStatus="vs">
                                    <c:if test="${vs.index >0}">
                                        <br />
                                    </c:if>
                                    <a href="${ctx}/product_detail?id=${item.product_id}">ProductID:${item.order_id}</a>
                                    x${item.amount}
                                </c:forEach></td>
                            <td class="text-right"><fmt:formatNumber
                                    value="${ord.total_price}" pattern="$#,##0.00" /></td>
                            <td class="text-center">
                                <c:choose>
                                    <c:when test="${ord.status==2}">Paid</c:when>
                                </c:choose>
                            </td>
                            <td class="text-center">${ord.remark}</td>
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
