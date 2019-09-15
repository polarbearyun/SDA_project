<%--
  Created by IntelliJ IDEA.
  User: wangyuncheng
  Date: 2019-09-14
  Time: 19:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <jsp:include page="/icd_meta.jsp" />
    <title>Confirm</title>
    <jsp:include page="/icd_link.jsp" />
</head>
<body>
<jsp:include page="/icd_top.jsp"></jsp:include>

<div class="wrapper" style="min-height: 500px;">
    <div class="panel" style="margin-top: 20px">
        <div class="panel-heading" style="font-size: 18px">
            <strong>Confirm</strong>
        </div>
        <form action="${ctx}/pay" method="post">
            <div class="panel-body">
                <div id="addressBox">
                    <div id="addressTitle">
                        <strong>Address</strong> <a href="${ctx}/user/address/list">Add Address if there is no address</a>
                    </div>
                    <div id="addressList">
                        <c:forEach items="${addressList}" var="ad">
                            <div class="item">
                                <strong>${ad.state}</strong>
                                <span class="text-muted">${ad.address}</span>
                                <span class="text-muted">${ad.post_code}</span>
                            </div>
                        </c:forEach>
                    </div>
                </div>

                <br /> <br />
                <div class="form-group">
                    <label class="col-xs-1 control-label required">Remark</label>
                    <div class="col-xs-11">
                        <input type="text" name="remark" id="remark" class="form-control" />
                    </div>
                </div>
            </div>
            <div class="panel-footer text-right">
                Chosen <strong class="text-danger">${current_order.number}</strong>
                Items, Total：<strong class="text-danger"><fmt:formatNumber
                    value="${current_order.total_price}" pattern="$#,##0.00" /> </strong> <input
                    type="submit" id="submit" class="btn btn-primary" value="Pay" />
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
