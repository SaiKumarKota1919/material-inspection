

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>lot Details Form</title>
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<jsp:include page="navbar.jsp"></jsp:include>
	<div class="container mt-5">
		<div class="row justify-content-center">
			<div class="col-md-6">
				<div class="card">
					<div class="card-header bg-primary text-white">
						<h2 class="text-center">Enter Lot Details</h2>
					</div>
					<div class="card-body">
						<form action="/lot/add" method="post">
							<div class="form-group">
								<label for="plantName">Plant Name:</label> <select
									class="form-control" id="plant" name="plant" required>
									<option value="" disabled selected>Select Plant</option>
									<c:forEach items="${plants}" var="plant">
									<option value="${plant.plantId}">${plant.plantName}</option>
									</c:forEach>
								</select>
								<div class="invalid-feedback">Please select a plant.</div>
							</div>
							<div class="form-group">
								<label for="materialName">Material Name:</label> <select
									class="form-control" id="materialName" name="material"
									required>
									<option value="" disabled selected>Select Material</option>
									<c:forEach items="${materials}" var="material">
									<option value="${material.materialId}">${material.materialDesc}</option>
									</c:forEach>
								</select>
								<div class="invalid-feedback">Please select a material.</div>
							</div>
							<div class="form-group">
								<label for="vendorName">Vendor Name:</label> 
								<select
									class="form-control" id="vendor" name="vendor" required>
									<option value="" disabled selected>Select Vendor</option>
									<c:forEach items="${vendors}" var="vendor">
									<option value="${vendor.vendorId}">${vendor.vendorName}</option>
									</c:forEach>
								</select>
								<div class="invalid-feedback">Please select a vendor.</div>
							</div>
							<div class="form-group">
								<label for="createdDate">Created Date:</label> <input
									type="date" class="form-control" id="createdDate"
									name="createdOn" required>
								<div class="invalid-feedback">Please provide a valid date.</div>
							</div>
							<div class="text-center">
								<button type="submit" class="btn btn-primary mr-2">Submit</button>
								<button type="button" class="btn btn-secondary"
									onclick="window.history.back();">Cancel</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
