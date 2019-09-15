<%--
  Created by IntelliJ IDEA.
  User: wangyuncheng
  Date: 2019-09-14
  Time: 13:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <jsp:include page="/icd_meta.jsp" />
    <title>HomePage</title>
    <jsp:include page="/icd_link.jsp" />
</head>
<body>
<jsp:include page="/icd_top.jsp">
    <jsp:param value="index" name="tag" />
</jsp:include>


<!-- Product List -->
<div class="wrapper">

    <div class="list">

        <section class="cards cards-condensed row" style="margin: 0">
            <c:forEach items="${products}" var="h">
                <div class="col-xs-2">
                    <div class="card">
                        <a href="${ctx}/product_detail?id=${h.id}" target="_blank">
                            <img src="${h.picture}" alt="">
                        </a>
                        <div class="card-heading">
								<span class="pull-right price"><fmt:formatNumber
                                        value="${h.price.price}" pattern="￥#,##0.00" /> </span> <a
                                href="${ctx}/product_detail?id=${h.id}" target="_blank">${h.name}</a>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </section>
    </div>
</div>


<script src="${ctx}/zui/lib/jquery/jquery.js"></script>
<script src="${ctx}/js/jquery/scrollUp/min.js"></script>
<script src="${ctx}/zui/js/zui.js"></script>
<script src="${ctx}/js/my.js"></script>
</body>
</html>