<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: phamh
  Date: 10/9/2023
  Time: 11:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>
    <title>Update</title>
    <link rel="stylesheet" type="text/css" href="../FileCss/update.css">

</head>
<style>
    .update tr input {
        width: 600px;
        height: 60px;
        background-color: rgba(255, 255, 255, 0.8);
    }
    .submit {
        width: 50px;
        height: 30px;
    }
</style>
<body>
<center>
    <h1>Update anime</h1>
</center>
<div align="center">
    <form method="post" class="update">
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    Edit Anime
                </h2>
            </caption>
            <c:if test="${anime != null}">
                <input type="hidden" name="id" value="<c:out value='${anime.id}' />"/>
            </c:if>
            <tr>
                <th>Name:</th>
                <td>
                    <input type="text" name="name" size="45"
                           value="<c:out value='${anime.name}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Status</th>
                <td>
                    <input type="text" name="status" size="45"
                           value="<c:out value='${anime.status}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Link:</th>
                <td>
                    <input type="text" name="link" size="45"
                           value="<c:out value='${anime.link}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Picture:</th>
                <td>
                    <input type="text" name="picture" size="45"
                           value="<c:out value='${anime.picture}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Year:</th>
                <td>
                    <input type="text" name="year" size="45"
                           value="<c:out value='${anime.year}' />"
                    />
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <button class="submit" type="submit" value="Save">Update</button>
                </td>
            </tr>

        </table>
    </form>
</div>
</body>
</html>