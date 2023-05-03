<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Registration Form</title>
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
    <h2 class="text-center mb-4">Registration Form</h2>

  <form action="UserEdit" method="get" class="form-horizontal">
      <input type="hidden" name="customerId" value="${uid}" />
      <div class="form-group">
          <label for="fullName" class="col-sm-5 control-label">Full Name:</label>
          <div class="col-sm-10">
              <input type="text" name="fullName" id="fullName" class="form-control" value="${user.fullName}" />
          </div>
      </div>
      <div class="form-group">
          <label for="address" class="col-sm-2 control-label">Address:</label>
          <div class="col-sm-10">
              <input type="text" name="address" id="address" class="form-control" value="${user.address}" />
          </div>
      </div>
      <div class="form-group">
          <label for="dob" class="col-sm-8 control-label">Date of Birth:</label>
          <div class="col-sm-10">
              <input type="date" name="dob" id="dob" class="form-control" value="${user.dob}" />
          </div>
      </div>
      <div class="form-group">
          <div class="col-sm-offset-2 col-sm-10">
              <button type="submit" class="btn btn-primary">Update User</button>
              <a href="UserDisplay" class="btn btn-primary">Back</a>
          </div>
      </div>
  </form>




  </div>
  <!-- Include Bootstrap JS -->
  <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.7/dist/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
