<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: phamh
  Date: 10/9/2023
  Time: 2:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<meta charset="UTF-8">



<html>
<head>
    <title>AnimeVsub</title>
    <link rel="stylesheet" type="text/css" href="../Css/list.css">
</head>
<body>
<header class="header">
    <div class="logo">
        <img src="\Picture\logoz.webp" alt="Logo">
    </div>

    <nav class="navbar">
        <a href="admin?action=anime">HOME</a>
        <a href="#">HORROR</a>
        <a href="#">ACTION</a>
        <a href="#">DRAMA</a>
        <a href="#">COMEDY</a>
        <a href="admin?action=create">ADD</a>

    </nav>

    <div class="search-bar">
        <form id="search-form" method="get">
            <input type="hidden" value="search" name="action">
            <input type="text" id="search-input" name="name" placeholder="Search">
            <button type="submit" id="search-submit" ><img src="\Picture\search.png"></button>
        </form>
    </div>
</header>

<main>
    <div class="box">
        <a href="#"><h2>Danh sách phim</h2></a>
        <a href="#"><h2>| Hộp phim</h2></a>
    </div>
    <div class="product-list">
       <c:forEach var="list" items="${listAnime}">
           <div class="product product1">
               <img src="<c:out value="${list.picture}"/>">
               <h3><c:out value="${list.name}"/></h3>
               <p><c:out value="${list.status}"/></p>
               <button type="submit" class="button1"><a target="_blank" href="${list.link}">View</a></button>
               <button type="submit" class="button2"><a target="_blank" href="/admin?action=addBox&id=${list.id}">Box</a></button>
               <button type="submit" class="button3"><a target="_blank" href="/admin?action=update&id=${list.id}">Update</a></button>
               <button type="submit" class="button4"><a target="_blank" href="/admin?action=delete&id=${list.id}">Delete</a></button>
           </div>
       </c:forEach>
    </div>
</main>
<footer>
    <p>© Trang web xem phim</p>
</footer>
</body>
</html>
