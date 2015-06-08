<%--
  Created by IntelliJ IDEA.
  User: 1
  Date: 30.05.2015
  Time: 17:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<head>

  <title></title>

</head>

<body>
<p>${size} - varible "size"</p>
<p>${User}</p>
<p>${hui}</p>

<div>

  <p>


  <table>

    <tr>

      <td><font size="<%=request.getAttribute("size")%>">посещений </font></td>

      <td><font size="<%=request.getAttribute("size")%>"><%=request.getAttribute("current_count")%></font></td>

    </tr>

    <tr>

      <td><font size="<%=request.getAttribute("size")%>">Дата</font></td>

      <td><font size="<%=request.getAttribute("size")%>"><%=request.getAttribute("date")%></font></td>

    </tr>

  </table>


  </p>

</div>

</body>

</html>
