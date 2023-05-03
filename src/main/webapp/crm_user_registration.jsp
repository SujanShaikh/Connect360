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

    <form action="crmUserRegistration" method="get">

    <div class="form-group">
      <label for="fullname">Full Name:</label>
      <input type="text" class="form-control" id="fullname" name="fullname" required>
    </div>

    <div class="form-group">
      <label for="email">Email:</label>
      <input type="email" class="form-control" id="email" name="email" required>
    </div>

    <div class="form-group">
      <label for="password">Password:</label>
      <input type="password" class="form-control" id="password" name="password" required>
    </div>

    <div class="form-group">
      <label for="phone">Phone Number:</label>
      <input type="text" class="form-control" id="phone" name="phone" required>
    </div>

    <div class="form-group">
      <label for="address">Address:</label>
      <input type="text" class="form-control" id="address" name="address" required>
    </div>

    <div class="form-group">
      <label for="gender">Gender:</label>
      <select class="form-control" id="gender" name="gender" required>
        <option value="male">Male</option>
        <option value="female">Female</option>
        <option value="other">Other</option>
      </select>
    </div>

    <div class="form-group">
      <label for="dob">Date of Birth:</label>
      <input type="date" class="form-control" id="dob" name="dob" required>
    </div>

    <button type="submit" class="btn btn-primary">Register</button>
 <a href="crm.jsp" class="btn btn-primary"> Back </a>
  </form>
  </div>
  <!-- Include Bootstrap JS -->
  <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.7/dist/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
