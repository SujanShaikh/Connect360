<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Details</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
    <div class="container">
        <h1>User Details</h1>
        <table class="table">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Full Name</th>
                    <th>Address</th>
                    <th>Email</th>
                    <th>Gender</th>
                    <th>Date of Birth</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="user" items="${userList}">
                    <tr>
                        <td><c:out value= "${user.customerId}" /></td>
                        <td><c:out value= "${user.fullName}" /></td>
                        <td><c:out value= "${user.address}" /></td>
                        <td><c:out value= "${user.email}" /></td>
                        <td><c:out value= "${user.gender}" /></td>
                        <td><c:out value= "${user.dob}" /></td>
                         <td>
                                <a href="user_edit.jsp?uId=${user.customerId}" class="btn btn-primary">Edit</a>
                            </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <a href='admin.jsp' class='btn btn-primary ml-2'>Back</a>
    </div>
</body>
</html>
