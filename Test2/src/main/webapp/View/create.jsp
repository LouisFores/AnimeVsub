<%--
  Created by IntelliJ IDEA.
  User: phamh
  Date: 10/9/2023
  Time: 3:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<html>
<head>
    <title>Create</title>
    <link rel="stylesheet" type="text/css" href="../FileCss/create.css">
</head>
<body>
<center>
    <h1>Create Anime</h1>
    <h2><a href="anime?action=anime">List All Anime</a></h2>
</center>
<div align="center">
    <form method="post">
      <table border="1" cellpadding="5">
          <caption>
              <h2>Add New Anime</h2>
          </caption>
              <tr>
                  <th>Name: </th>
                  <td><input type="text" name="name" id="name" size="45"/></td>
              </tr>
              <tr>
                  <th>Status: </th>
                  <td><input type="text" name="status" id="status" size="45"/></td>
              </tr>
              <tr>
                  <th>Link: </th>
                  <td><input type="text" name="link" id="link" size="45"/></td>
              </tr>
              <tr>
                  <th>Picture: </th>
                  <td><input type="text" name="picture" id="picture" size="45"/></td>
              </tr>
              <tr>
                  <th>Year: </th>
                  <td><input type="text" name="year" id="year" size="45"/></td>
              </tr>
              <tr>
                  <td colspan="2" align="center">
                      <input type="submit" value="Save"/></td>
              </tr>
      </table>
    </form>
</div>
</body>
</html>
