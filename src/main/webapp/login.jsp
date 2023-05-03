<!doctype html>
<html lang="en">
<head>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

  <title>Login</title>

  <!-- Include Bootstrap CSS -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <style>
    /* Custom CSS for input field width and border */
    .form-control-lg {
      width: 400px;
      border: 1px solid #ced4da;
    }
  </style>
</head>
<body>
<div class="container mt-5">
  <h3>Login</h3>
  <br>
  <!-- User input form -->
  <form action="loginServ" method="get">

    <div class="form-group">
      <label for="title">Email:</label>
      <input name="email" required type="email" class="form-control form-control-lg" id="email" placeholder="">
    </div>

    <div class="form-group">
      <label for="NoteContent">Password:</label>
      <input  name="password" type="password" class="form-control form-control-lg" id="password" placeholder="">
    </div>

    <div class="form-group">
      <label>User type:</label>
      <div class="form-check">
        <input class="form-check-input" type="radio" name="userType" id="user" value="user" checked>
        <label class="form-check-label" for="user">
          User
        </label>
      </div>
      <div class="form-check">
        <input class="form-check-input" type="radio" name="userType" id="crm" value="crm">
        <label class="form-check-label" for="crm">
          CRM
        </label>
      </div>
      <div class="form-check">
        <input class="form-check-input" type="radio" name="userType" id="admin" value="admin">
        <label class="form-check-label" for="admin">
          Admin
        </label>
      </div>
    </div>

    <button type="submit" class="btn btn-primary">Login</button>
    <!-- <a href="registration.jsp" class="btn btn-primary">Register</a> -->

  </form>
</div>

<!-- Include Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.7/dist/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
