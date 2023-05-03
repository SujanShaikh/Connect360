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
  <div class="container">
    <div class="row">
      <div class="col-md-6 offset-md-3">
        <h1>Edit Customer</h1>
        <form method="get" action="CrmEdit">
         <div class="form-group">
                            <label for="crmId">ID:</label>
                            <input type="text" class="form-control" id="crmId" name="crmId" value="${crm.crmId}" >
                          </div>

          <div class="form-group">
            <label for="crmPhone">Phone:</label>
            <input type="tel" class="form-control" id="crmPhone" name="crmPhone" value="${crm.crmPhone}" required>
          </div>
          <div class="form-group">
            <label for="address">Address:</label>
            <textarea class="form-control" id="address" name="address" rows="3" required>${crm.address}</textarea>
          </div>
          <input type="hidden" name="customerId" value="${crm.crmId}">
          <button type="submit" class="btn btn-primary">Update</button>
          <a href="CrmDisplay" class="btn btn-primary">Back</a>

        </form>
      </div>
    </div>
  </div>
  </div>
  <!-- Include Bootstrap JS -->
  <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.7/dist/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
