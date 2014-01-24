<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <title>Students</title>
</head>
<body>
    <table>
        <tr>
            <td>NAME</td>
            <td>GRADE</td>
        </tr>
        <c:forEach var="student" items="${students}">
            <tr>
                <td>${student.getName()}</td>
                <td>${student.getGrade()}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
