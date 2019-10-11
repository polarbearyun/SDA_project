<%--
  Created by IntelliJ IDEA.
  User: wangyuncheng
  Date: 2019-10-11
  Time: 13:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div id="top">
    <div id="toolbar">
        <div class="wrapper row">
            <c:if test="${!empty sessionScope.curr_mbr}" var="flag">
                <div id="welcome" class="col-xs-5">Welcome
                        ${sessionScope.curr_mbr.name}！</div>
                <div class="col-xs-4"></div>
                <div class="col-xs-3" style="text-align: right;">
                    <a href="${ctx}/logout">Logout</a>
                </div>
            </c:if>
            <c:if test="${!flag}">
                <div class="col-xs-5">Admin Management</div>
                <div class="col-xs-4"></div>
                <div class="col-xs-3" style="text-align: right;">
                     <a href="${ctx}/login.jsp">Login</a> <a
                        href="${ctx}/register.jsp">Register</a>
                </div>
            </c:if>
        </div>
    </div>
    <div id="navbar" class="navbar navbar-inverse">
        <div class="wrapper row">

            <ul class="nav navbar-nav col-xs-9">
                <li ${param.tag == 'index' ? "class='active'" : ""}><a href="#">Management System</a></li>
            </ul>
        </div>
    </div>

</div>

