<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>vendor details</title>
  <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<jsp:include page="navbar.jsp"></jsp:include>
  <div class="container mt-5">
    <div class="row justify-content-center">
      <div class="col-md-6">
        <div class="card">
          <div class="card-header bg-primary text-white">
            <h2 class="text-center">Enter Vendor Details</h2>
          </div>
          <div class="card-body">
            <form action="/vendor/add" method="POST">
              <div class="form-group">
                <label for="plantName">Vendor Name:</label>
                <input type="text" class="form-control" id="vendorName" name="vendorName" placeholder="Enter Vendor Name" required>
              </div>
              <div class="form-group">
                <label for="city">City:</label>
                <input type="text" class="form-control" id="location" name="vendorLocation" placeholder="Enter Vendor city" required>
              </div>
              <div class="form-group">
                <label for="contact">Contact:</label>
                <input type="text" class="form-control" id="vendorContact" name="vendorContact" placeholder="Enter Vendor Contact Number" required>
              </div>
               <div class="form-group">
              <c:if test="${not empty vendorAlreadyExists}">
                  <span class="text-danger">${vendorAlreadyExists}</span> 
              </c:if>
              </div>
              
              <div class="text-center">
                <button type="submit" class="btn btn-primary mr-2">Submit</button>
                <button type="button" class="btn btn-secondary" onclick="window.history.back();">Cancel</button>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
</body>
</html>