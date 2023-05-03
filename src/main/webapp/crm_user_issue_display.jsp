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
        <h1>User Issues</h1>
        <table class="table">
            <thead>
                <tr>
                <th>Customer Id</th>
                    <th>Issue ID</th>
                    <th>Issue Name</th>
                    <th>Description</th>
                     <th>Status</th>


                </tr>
            </thead>
           <!-- <tbody>
                <c:forEach var="issue" items="${issueList}">
                    <tr>
                     <td><c:out value= "${issue.user.customerId}" /></td>
                        <td><c:out value= "${issue.issueId}" /></td>
                        <td><c:out value= "${issue.issueName}" /></td>
                        <td><c:out value= "${issue.issueDescription}" /></td>
                        <td><c:out value= "${issue.issueStatus}" /></td>
                         <td>
                         </td>
                    </tr>
                </c:forEach>
            </tbody> -->
            <tbody>
                <c:forEach var="issue" items="${issueList}">
                    <tr>
                        <td><c:out value="${issue.user.customerId}" /></td>
                        <td><c:out value="${issue.issueId}" /></td>
                        <td><c:out value="${issue.issueName}" /></td>
                        <td><c:out value="${issue.issueDescription}" /></td>
                        <td>
                            <form action="updateIssueStatus" method="get">
                                <input type="hidden" name="issueId" value="${issue.issueId}" />
                                <select name="issueStatus" onchange="this.form.submit()">
                                    <option value="In progress" ${issue.issueStatus eq 'In progress' ? 'selected' : ''}>In progress</option>
                                    <option value="Assigned" ${issue.issueStatus eq 'Assigned' ? 'selected' : ''}>Assigned</option>
                                    <option value="Declined" ${issue.issueStatus eq 'Declined' ? 'selected' : ''}>Declined</option>
                                    <option value="Finished task" ${issue.issueStatus eq 'Finished task' ? 'selected' : ''}>Finished task</option>
                                </select>
                            </form>
                        </td>
                        <td>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>

        </table>
        <a href='crm.jsp' class='btn btn-primary ml-2'>Back</a>
    </div>
</body>
</html>
