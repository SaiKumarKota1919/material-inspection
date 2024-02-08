
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>inspection actuals</title>
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
						<h2 class="text-center">Enter Inspection Actuals</h2>
					</div>
					<div class="card-body">
						<form action="/inspection/add" method="post">
							<div class="form-group">
							<input type="hidden" value="${lotId}" name="inspectionLot">
								<label for="materialName">Material Character:</label> <select
									class="form-control" id="materialName" name="materialCharacteristics"
									required>
									<option value="" disabled selected>Select Character</option>
									<c:forEach items="${materialCharacters}" var="character">
									<option value="${character.characterId}">${character.characterDesc}</option>
									</c:forEach>
								</select>
								<div class="invalid-feedback">Please select a material.</div>
							</div>
							<div class="form-group">
								<label for="vendorName">Max mes :</label> 
								<input type="text" name="maxMeasurement" placeholder="Enter maximum reading"> 
							</div>
							<div class="form-group">
								<label for="vendorName">Min mes :</label> 
								<input type="text" name="minMeasurement" placeholder="Enter minimum reading"> 
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
