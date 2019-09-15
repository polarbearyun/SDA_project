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
    <title>电器城-首页</title>
    <jsp:include page="/icd_link.jsp" />
</head>
<body>
<jsp:include page="/icd_top.jsp">
    <jsp:param value="index" name="tag" />
</jsp:include>


<!-- 商品列表 -->
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
                                        value="${h.price}" pattern="￥#,##0.00" /> </span> <a
                                href="${ctx}/product_detail?id=${h.id}" target="_blank">${h.name}</a>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </section>
    </div>
</div>

<!-- /商品列表 -->

<!-- 添加到购物车的对话框 -->
<div class="modal fade" id="addToCartModal">
    <div class="modal-dialog modal-sm">
        <form action="./profile" method="post" class="form-horizontal">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">
                        <span aria-hidden="true">×</span><span class="sr-only">关闭</span>
                    </button>
                    <h4 class="modal-title">商品成功加入购物车</h4>
                </div>
                <div class="modal-footer">
                    <a href="${ctx}/main" class="btn btn-primary">继续购物</a> <a
                        href="${ctx}/cart.jsp" class="btn btn-primary"
                        style="min-width: 80px">立即结算</a>
                </div>
            </div>
        </form>
    </div>
</div>
<!-- /添加到购物车 -->

<script src="${ctx}/zui/lib/jquery/jquery.js"></script>
<script src="${ctx}/js/jquery/scrollUp/min.js"></script>
<script src="${ctx}/zui/js/zui.js"></script>
<script src="${ctx}/js/my.js"></script>
</body>
</html>