<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Material Details Form</title>
  <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
  <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<jsp:include page="navbar.jsp"></jsp:include>
  <div class="container mt-5">
    <div class="row justify-content-center">
      <div class="col-md-6">
        <div class="card">
          <div class="card-header bg-primary text-white">
            <h2 class="text-center">Enter Material Details</h2>
          </div>
          <div class="card-body">
            <form action="/material/add" method="POST">
              <div class="form-group">
                <label for="materialId">Material ID:</label>
                <input type="text" class="form-control" id="materialId" name="materialId" autofocus="autofocus" required
                <c:if test="${material ne null}"> readonly value="${material.getMaterialId()}"
                </c:if>	>
              </div>
              <div class="form-group">
                <label for="materialDesc">Material Description:</label>
                <input type="text" class="form-control" id="materialDesc" name="materialDesc" required value="${material.getMaterialDesc()}">
              </div>
              <div class="form-group">
                <label for="materialType">Material Type:</label>
                <input type="text" class="form-control" id="materialType" name="materialType" required value="${material.getMaterialType()}">
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