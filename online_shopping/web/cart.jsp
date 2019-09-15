<%--
  Created by IntelliJ IDEA.
  User: wangyuncheng
  Date: 2019-09-14
  Time: 17:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <jsp:include page="/icd_meta.jsp" />
    <title>Cart</title>
    <jsp:include page="/icd_link.jsp" />
</head>
<body>
<jsp:include page="/icd_top.jsp"></jsp:include>

<div class="wrapper" style="min-height: 500px;">
    <div class="panel" style="margin-top: 20px">
        <div class="panel-heading" style="font-size: 18px">
            <strong>My cart</strong>
        </div>
        <form action="${ctx}/submit_order" method="post">
            <div class="panel-body">
                <table class="table">
                    <thead>
                    <tr class="text-center">
                        <td colspan="2" class="text-left">Product</td>
                        <td class="text-left">Price</td>
                        <td>Amount</td>
                        <td>Price</td>
                        <td>Method</td>
                    </tr>
                    </thead>
                    <tbody id="cart-list">
                    <c:forEach items="${sessionScope.cart}" var="entry">
                        <tr>
                            <td style="width: 100px"><a
                                    href="${ctx}/product_detail?id=${entry.key.id}"><img
                                    src="${pic_base}${entry.key.picture}" title="" alt="" /></a></td>
                            <td class="text-left"><a
                                    href="${ctx}/product_detail?id=${entry.key.id}"
                                    class="media-wrapper">${entry.key.name}</a> <input
                                    type="hidden" name="id" value="${entry.key.id}" /></td>
                            <td style="width: 100px">
                                <div id="price">
                                    <fmt:formatNumber value="${entry.key.price.price}"
                                                      pattern="#0.00" />
                                </div>
                            </td>
                            <td style="width: 140px">
                                <div class="input-group">
											<span class="input-group-addon"><i
                                                    class="icon icon-minus"></i></span> <input type="text"
                                                                                               name="amount" id="amount" value="${entry.value}"
                                                                                               class="form-control" style="text-align: center;" /> <span
                                        class="input-group-addon"><i class="icon icon-plus"></i></span>
                                </div>
                            </td>
                            <td style="width: 160px" class="text-center text-middle">
                                <strong class="text-danger" id="sum"><fmt:formatNumber
                                        value="${entry.key.price.price * entry.value}"
                                        pattern="#0.00" /></strong>
                            </td>
                            <td style="width: 120px" class="text-middle text-center">
                                <a href="${ctx}/removeFromCart?id=${entry.key.id}"
                                   class="deleter">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <div class="panel-footer text-right">
                    Chosen <strong class="text-danger" id="amount-sum"></strong> Items， Total：<strong
                        id="price-sum" class="text-danger"></strong> <input type="submit"
                                                                            id="submit" class="btn btn-primary" value="Pay"
                                                                            data-loading="Wait..." />
                </div>
            </div>
        </form>
    </div>
</div>

<script src="${ctx}/zui/lib/jquery/jquery.js"></script>
<script src="${ctx}/js/jquery.scrollUp.min.js"></script>
<script src="${ctx}/zui/js/zui.js"></script>
<script src="${ctx}/js/my.js"></script>
<script>
    countSum();
</script>
</body>
</html>