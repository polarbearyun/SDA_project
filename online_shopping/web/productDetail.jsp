<%--
  Created by IntelliJ IDEA.
  User: wangyuncheng
  Date: 2019-09-14
  Time: 16:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <jsp:include page="/icd_meta.jsp" />
    <title>ProductDetail</title>
    <jsp:include page="/icd_link.jsp" />
</head>
<body>
<jsp:include page="/icd_top.jsp"></jsp:include>



<div class="wrapper">

    <div class="row">
        <div class="col-xs-9">
            <div class="panel panel-body">
                <div class="row">
                    <div class="col-xs-4">
                        <div class="product-image">
                            <img src="${product.picture}"
                                 title="${product.name}" alt="${product.name}"
                                 style="max-height: 290px">
                        </div>
                    </div>
                    <div class="col-xs-8">
                        <div class="product-property">
                            <h1 class="header-dividing">${product.name}</h1>
                            <input type="hidden" name="id" id="prodId" value="${product.id}" />
                            <ul class="list-unstyled">
                                <li><span class="attr-name">Price</span> <span class="attr-value">$
												<strong><fmt:formatNumber value="${product.price.price}" pattern="#,##0.00" /></strong>
											</span></li>
                                <li><span class="attr-name">Status</span> <span
                                        class="attr-value">${product.inventory > product.sold_number ? "In store" : "no"}</span>
                                </li>
                                <li id="countBox"><span class="attr-name">Amount</span> <span
                                        class="attr-value">
											<div class="input-group" style="width: 120px">
												<span class="input-group-addon"><i
                                                        class="icon icon-minus"></i></span> <input type="text" name="num"
                                                                                                   id="num" value="1" class="form-control"
                                                                                                   style="text-align: center;"> <span
                                                    class="input-group-addon"><i class="icon icon-plus"></i></span>
											</div>
									</span></li>
                            </ul>
                            <span>
									<button id="cartBtn" class="btn btn-primary">
										<i class="icon icon-shopping-cart"></i> Add To Cart
									</button>
								</span>
                        </div>
                    </div>
                </div>
                <h5 class="header-dividing" style="margin-top: 30px;">
                    <i class="icon-file-text-alt text-muted"></i> Detail
                </h5>
                <div class="article-content" id="product-detail">
                    ${product.detail}</div>
            </div>

        </div>

    </div>
</div>


<!-- pop window -->
<div class="modal fade" id="addToCartModal">
    <div class="modal-dialog modal-sm">
        <form action="./profile" method="post" class="form-horizontal">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">
                        <span aria-hidden="true">×</span><span class="sr-only">Close</span>
                    </button>
                    <h4 class="modal-title">Success</h4>
                </div>
                <div class="modal-footer">
                    <a href="${ctx}/main" class="btn btn-primary">Continue</a> <a
                        href="${ctx}/cart.jsp" class="btn btn-primary"
                        style="min-width: 80px">Pay</a>
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
    $("#cartBtn").click(function(){
        var url = "${ctx}/addToCart";

        var id= $("#prodId").val();
        var num = $("#num").val();


        var param = "id=" + id +"&num=" + num;

        $.post(url, param, function(data){
            if(data == 'ok'){
                $('#addToCartModal').modal('show');
            }
        });

        return false;
    });
</script>
</body>
</html>