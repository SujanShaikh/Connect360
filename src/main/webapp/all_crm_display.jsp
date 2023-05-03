<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>CRM Details</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
    <div class="container">

        <h1>CRM Details</h1>
        <table class="table">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Phone</th>
                    <th>Address</th>
                </tr>
            </thead>
            <tbody>
                   <!--   for (Crm crm: crmList) {  -->

                <c:forEach var="crm" items="${crmList}">
                    <tr>
                        <td><c:out value="${crm.crmId}" /></td>
                        <td><c:out value="${crm.crmName}" /></td>
                        <td><c:out value="${crm.crmEmail}" /></td>
                        <td><c:out value="${crm.crmPhone}" /></td>
                        <td><c:out value="${crm.address}" /></td>
                        <td>
                       <a href="crm_edit.jsp?id=${user.customerId}" class="btn btn-primary">Edit</a>
                       <a href="CrmDelete?id=${user.customerId}" class="btn btn-danger">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <a href='admin.jsp' class='btn btn-primary ml-2'>Back</a>
    </div>
</body>
</html>
