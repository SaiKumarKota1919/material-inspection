<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Plant Details Form</title>
  <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<jsp:include page="navbar.jsp"></jsp:include>
  <div class="container mt-5">
    <div class="row justify-content-center">
      <div class="col-md-6">
        <div class="card">
          <div class="card-header bg-primary text-white">
            <h2 class="text-center">Enter Plant Details</h2>
          </div>
          <div class="card-body">
            <form action="/plant/add" method="POST">
              <div class="form-group">
                <label for="plantId">Plant ID:</label>
                <input type="text" class="form-control" id="plantId" name="plantId" autofocus="autofocus" required>
              </div>
              <div class="form-group">
                <label for="plantName">Plant Name:</label>
                <input type="text" class="form-control" id="plantName" name="plantName" required>
              </div>
              <div class="form-group">
                <label for="state">State:</label>
                <input type="text" class="form-control" id="state" name="plantState" required>
              </div>
              <div class="form-group">
                <label for="city">City:</label>
                <input type="text" class="form-control" id="city" name="plantCity" required>
              </div>
              <div class="form-group">
                <label for="contact">Contact:</label>
                <input type="text" class="form-control" id="contact" name="contact" required>
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
