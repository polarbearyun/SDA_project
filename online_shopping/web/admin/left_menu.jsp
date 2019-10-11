<%@ page pageEncoding="UTF-8"%>
<nav class="menu" id="mymenu">
    <ul class="nav nav-primary">
        <li class="nav-parent show"><a href="javascript:;"> Management</a>
            <ul class="nav">
                <li ${param.tag == 'product_list' ? "class='active'" : ""}><a
                        href="${ctx}/admin/product"><i class="icon-list-alt"></i>
                    Product List<i class="icon-chevron-right"></i></a></li>
            </ul></li>
        <li class="nav-parent show"><a href="javascript:;"> </a>
            <ul class="nav">
                <li ${param.tag == 'user_list' ? "class='active' " : ""}><a
                        href="${ctx}/admin/user_list.jsp"><i class="icon-list-alt"></i>
                    User List<i class="icon-chevron-right"></i></a></li>
            </ul></li>
        <li class="nav-parent show"><a href="javascript:;"> </a>
            <ul class="nav">
                <li ${param.tag == 'order_list' ? "class='active' " : ""}><a
                        href="${ctx}/admin/order_list.jsp"><i class="icon-list-alt"></i>
                    Order List<i class="icon-chevron-right"></i></a></li>
            </ul></li>
    </ul>
</nav>