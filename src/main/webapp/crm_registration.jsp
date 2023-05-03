<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>CRM Registration</title>
  <!-- Include Bootstrap CSS -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <style>
    .registration-form {
      max-width: 400px;
      margin: 0 auto;
      padding: 20px;
      border: 1px solid #ddd;
      border-radius: 5px;
      background-color: #fff;
    }
  </style>
</head>
<body>
  <div class="container mt-5 registration-form">
    <h2 class="text-center mb-4">CRM Registration Form</h2>

    <form action="registerCrm" method="get">

    <div class="form-group">
      <label for="crmName">Name:</label>
      <input type="text" class="form-control" id="crmName" name="crmName" required>
    </div>

    <div class="form-group">
      <label for="crmEmail">Email:</label>
      <input type="email" class="form-control" id="crmEmail" name="crmEmail" required>
    </div>

    <div class="form-group">
      <label for="crmPass">Password:</label>
      <input type="password" class="form-control" id="crmPass" name="crmPass" required>
    </div>

    <div class="form-group">
      <label for="crmPhone">Phone:</label>
      <input type="text" class="form-control" id="crmPhone" name="crmPhone" required>
    </div>

    <div class="form-group">
      <label for="address">Address:</label>
      <input type="text" class="form-control" id="address" name="address" required>
    </div>

    <button type="submit" class="btn btn-primary">Submit</button>
    <a href="admin.jsp" class="btn btn-primary">Back</a>
    </form>
  </div>
  <!-- Include Bootstrap JS -->
  <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.7/dist/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
