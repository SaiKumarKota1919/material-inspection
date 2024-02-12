<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
			
				<div class="form-group col-md-4">
				<label for="plantId" class="form-label">Lot ID:</label> <input
					type="text" class="form-control"  name="lotId"
					placeholder="Enter Lot Id"
					>
					</div>
		
			<div class="text-center">
				<button type="submit" class="btn btn-primary mr-2">Submit</button>
				<button type="button" class="btn btn-secondary"
					onclick="window.history.back();">Cancel</button>
			</div>
			
		</form>
	</div>
		

	<!-- Bootstrap JS (optional) -->
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>

