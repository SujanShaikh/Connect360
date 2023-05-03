<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Enter Issue Details</title>
<!-- Link to Bootstrap stylesheet -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<style>
    .issue-form {
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
   <div class="container mt-5 issue-form">
       <h2 class="text-center mb-4">Enter Issue Details</h2>
       <form method="get" action="AddIssue">
           <div class="form-group">
               <label for="issueType">Issue Type:</label>
               <select name="issueName" id="issueName" class="form-control">
                   <option value="Account Related">Account Related</option>
                   <option value="Transaction Related">Transaction Related</option>
                   <option value="Card Related">Card Related</option>
                   <option value="Online Banking Related">Online Banking Related</option>
                   <option value="Other">Other</option>
               </select>
           </div>
           <div class="form-group">
               <label for="issueDescription">Issue Description:</label>
               <textarea name="issueDescription" id="issueDescription" class="form-control"></textarea>
           </div>
           <button type="submit" class="btn btn-primary">Submit</button>
           <a href="UserDisplay" class="btn btn-primary">Back</a>
       </form>
   </div>
<!-- Include Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.7/dist/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
