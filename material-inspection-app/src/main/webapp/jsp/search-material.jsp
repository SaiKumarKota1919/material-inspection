<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Search Material</title>
    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<jsp:include page="navbar.jsp"></jsp:include>
    <div class="container mt-5">
        <h2 class="mb-4">Search Material</h2>

        <form class="border p-4 rounded shadow-sm" action="/material/search">
            <div class="form-row">
                <div class="form-group col-md-4">
                    <label for="materialId">Material ID:</label>
                    <input type="text" class="form-control" id="materialId" name="materialId">
                </div>
                <div class="form-group col-md-4">
                    <label for="materialDesc">Material Description:</label>
                    <input type="text" class="form-control" id="materialDesc" name="materialDesc">
                </div>
                <div class="form-group col-md-4">
                    <label for="materialType">Material Type:</label>
                    <input type="text" class="form-control" id="materialType" name="materialType">
                </div>
            </div>
           <div class="text-center">
                <button type="submit" class="btn btn-primary mr-2">Submit</button>
                <button type="button" class="btn btn-secondary" onclick="window.history.back();">Cancel</button>
              </div>
        </form>
    </div>

    <!-- Bootstrap JS (optional) -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
