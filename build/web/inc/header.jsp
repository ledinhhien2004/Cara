<%-- 
    Document   : header
    Created on : Sep 30, 2024, 4:49:45 PM
    Author     : USER
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<header id="header">
    <a href="HomeServlet"><img src="./assets/img/logo.png" class="logo" alt=""></a>
    <ul id="navbar">
        <li><a class="active" href="index.html">Home</a></li>
        <li>
            <a href="ShopServlet">Shop</a>
            <ul class="sub-menu">
                <c:forEach items="${categoryList}" var="category">
                    <li class="menu-item">
                        <a href="CategoryServlet?categoryId=${category.id}">${category.name}</a>
                    </li>                
                </c:forEach>
            </ul>
        </li>

        <li><a href="blog.html">Blog</a></li>
        <li><a href="about.html">About</a></li>
        <li><a href="contact.html">Contact</a></li>
        <li><a href="cart.html"><i class="fa-solid fa-bag-shopping"></i></a></li>
        <li>
            <c:if test="${sessionScope.user == null}">
                <a href="LoginServlet">Login</a>
            </c:if>

            <c:if test="${sessionScope.user != null}">
                <a href="LogoutServlet">Logout</a>
            </c:if>
        </li>
    </ul>
</header>
