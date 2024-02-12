<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Search lot</title>
<!-- Bootstrap CSS -->
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<jsp:include page="navbar.jsp"></jsp:include>
	<div class="container mt-5">
		<h2 class="mb-4">Search Lot</h2>

		<form class="border p-4 rounded shadow-sm" action="/lot/search">
			<div class="form-row">
				<div class="form-group col-md-4">
					<label for="fromDate" class="form-label">From Date:</label> <input
						type="date" class="form-control" id="fromDate" name="fromDate"
						required="required">
				</div>
				<div class="form-group col-md-4">
					<label for="toDate" class="form-label">To Date:</label> <input
						type="date" class="form-control" id="toDate" name="toDate"
						required="required">
				</div>
				<div class="form-group col-md-4">
				<label for="plantId" class="form-label">Plant ID:</label> <input
					type="text" class="form-control" id="plantId" name="plantId"
					>
					</div>
		
			<div class="form-group col-md-4">
				<label for="materialId" class="form-label">Material ID:</label> <input
					type="text" class="form-control" id="materialId" name="materialId"
					>
			</div>

			<div class="form-group col-md-4">
		
					<label for="vendorId" class="form-label">Vendor ID:</label> <input
						type="text" class="form-control" id="vendorId" name="vendorId">
			</div>
			
			<div class="form-group col-md-4">
			<label for="status" class="form-label">Status:</label> <select
					class="form-select" id="status" name="status">
					<option value="">select an option</option>
					<option value="PASS">Pass</option>
					<option value="FAIL">Fail</option>
					<option value="ON HOLD">On Hold</option>
					<option value="UNDER PROCESS">Pending</option>
				</select>
			</div>
			
			 <div class="form-group col-md-4">
              <c:if test="${not empty InvalidDateRange}">
                  <span class="text-danger">${InvalidDateRange}</span> 
              </c:if>

              </div>
			<br>
			<br>
			<div class="form-group col-md-4 text-center">
				<button type="submit" class="btn btn-primary mr-2">Submit</button>
				<button type="button" class="btn btn-secondary"
					onclick="window.history.back();">Cancel</button>
			</div>
			</div>
		</form>
	</div>
		

	<!-- Bootstrap JS (optional) -->
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>

