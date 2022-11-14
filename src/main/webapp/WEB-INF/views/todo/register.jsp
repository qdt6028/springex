<%--
  Created by IntelliJ IDEA.
  User: DeniseLaptop
  Date: 2022-11-14
  Time: 오전 10:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Register . jsp</title>
</head>
<body>
    <form action="/todo/register" method="post">
        <div>
            Content : <input type="text" name="content">
        </div>
        <div>
            DueDate : <input type="date" name="dueDate" value="2022-11-14">
        </div>
        <div>
            Writer : <input type="text" name="writer">
        </div>
        <div>
            Finished : <input type="checkbox" name="finished">
        </div>
        <div>
            <button type="submit">Register</button>
        </div>
    </form>
</body>
</html>
