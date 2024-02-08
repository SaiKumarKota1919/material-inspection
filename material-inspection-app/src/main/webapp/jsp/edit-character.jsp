<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Edit Characteristics</title>
<!-- Bootstrap CSS -->
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<jsp:include page="navbar.jsp"></jsp:include>
	<div class="container">
		<h2>Edit Characteristics</h2>

		<form id="characteristicsForm" action="/characteristics/update"
			method="post" name="characteristicsForm">
			<input type="text" hidden="hidden" name="materialId"
				value="${character.material.materialId}">
			<div id="characteristicsContainer">

				<!-- Default characteristic -->
				<fieldset class="characteristic" name="characteristicsForm">
					<legend>Characteristic details:</legend>
					<div class="form-row">
						<div class="form-group col-md-3">
							<input type="hidden" class="form-control" name="characterId"
								value="${character.characterId}" required> <label
								for="characterDesc">Character Description:</label> <input
								type="text" class="form-control" name="characterDesc"
								value="${character.characterDesc}" required>
						</div>
						<div class="form-group col-md-3">
							<label for="upperTolLimit">Upper Tolerance Limit:</label> <input
								type="number" class="form-control" name="upperTolLimit"
								value="${character.upperTolLimit}" required>
						</div>
						<div class="form-group col-md-3">
							<label for="lowerTolLimit">Lower Tolerance Limit:</label> <input
								type="number" class="form-control" name="lowerTolLimit"
								value="${character.lowerTolLimit}" required>
						</div>
						<div class="form-group col-md-3">
							<label for="unitsOfMsrmnt">Units of Measurement:</label> <select
								class="form-control" name="unitsOfMsrmnt" required>
								<option value="${character.unitsOfMsrmnt}">${character.unitsOfMsrmnt}</option>
								<option value="cm">cm</option>
								<option value="m">m</option>
								<option value="mm">mm</option>
								<!-- Add more options as needed -->
							</select>
						</div>
					</div>
				</fieldset>

				<!-- Characteristics fields will be added dynamically here -->
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