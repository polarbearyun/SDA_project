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
    <title>卓尔商城-商品详情</title>
    <jsp:include page="/icd_link.jsp" />
</head>
<body>
<jsp:include page="/icd_top.jsp"></jsp:include>



<!-- 主内容 -->
<div class="wrapper">
    <%--<!-- 面包屑导航 -->--%>
    <%--<ol class="breadcrumb">--%>
        <%--<li><span class="breadcrumb-title">当前位置：</span> <a--%>
                <%--href="${ctx}/main">首页</a></li>--%>
        <%--<li class="active">${product.name}</li>--%>
    <%--</ol>--%>
    <%--<!-- /面包屑导航 -->--%>

    <!--  -->
    <div class="row">
        <!-- /左边 -->
        <div class="col-xs-9">
            <!-- 详情 -->
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
                                <li><span class="attr-name">价格</span> <span
                                        class="attr-value">￥<del>
												<strong><fmt:formatNumber value="${product.price}"
                                                                          pattern="#,##0.00" /></strong>
											</del></span></li>
                                <li><span class="attr-name">状态</span> <span
                                        class="attr-value">${product.inventory > product.sold_number ? "有货" : "有货"}</span>
                                </li>
                                <li id="countBox"><span class="attr-name">数量</span> <span
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
										<i class="icon icon-shopping-cart"></i> 加入购物车
									</button>
								</span>
                        </div>
                    </div>
                </div>
                <h5 class="header-dividing" style="margin-top: 30px;">
                    <i class="icon-file-text-alt text-muted"></i> 详情
                </h5>
                <div class="article-content" id="product-detail">
                    ${product.detail}</div>
            </div>
            <!-- /详情 -->
        </div>
        <!-- /左边 -->

    </div>
</div>
<!-- /主内容 -->

<%--<jsp:include page="/icd_bottom.jsp"></jsp:include>--%>

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
<script src="${ctx}/js/jquery.scrollUp.min.js"></script>
<script src="${ctx}/zui/js/zui.js"></script>
<script src="${ctx}/js/my.js"></script>
<script>
    $("#cartBtn").click(function(){
        var url = "${ctx}/addToCart";
        //先获取所先商品的ID和数量
        var id= $("#prodId").val();
        var num = $("#num").val();

        //http的请求参数格式“参数名=值&参数名=值”
        var param = "id=" + id +"&num=" + num;

        //AJAX提交数据
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