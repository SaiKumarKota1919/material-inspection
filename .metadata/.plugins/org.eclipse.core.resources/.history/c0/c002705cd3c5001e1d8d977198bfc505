<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Show Material Characteristics</title>
    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
  
</head>
<body>
    <jsp:include page="navbar.jsp"></jsp:include>
    <div class="container">

        <div class="row">
            <div class="col-xs-6">
                <h3>Material Details</h3>
                <table class="table table-bordered">
                    <tbody>
                        <tr>
                            <td><strong>Material ID</strong></td>
                            <td>${material.materialId}</td>
                        </tr>
                        <tr>
                            <td><strong>Material Name</strong></td>
                            <td>${material.materialDesc}</td>
                        </tr>
                         <tr>
                            <td><strong>Material Type</strong></td>
                            <td>${material.materialType}</td>
                        </tr>
                        <!-- Add other material details as needed -->
                    </tbody>
                </table>
            </div>
        </div>

        <div class="row">
            <div class="col-xs-6 ">
                <h3>Characteristics</h3>
                <table class="table table-bordered">
                    <thead class="thead-dark">
                        <tr>
                            <th>Characteristic ID</th>
                            <th>Description</th>
                            <th>Upper Tol Limit</th>
                            <th>Lower Tol Limit</th>
                            <th>UOM</th>
                            <th>Action</th>
                            <!-- Add more columns as needed -->
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="characteristic" items="${material.materialCharacteristics}">
                            <tr>
                                <td>${characteristic.characterId}</td>
                                <td>${characteristic.characterDesc}</td>
                                <td>${characteristic.upperTolLimit}</td>
                                <td>${characteristic.lowerTolLimit}</td>
                                <td>${characteristic.unitsOfMsrmnt}</td>
                                <td>
                <a href="/characteristics/edit/${characteristic.characterId}" class="btn btn-sm btn-primary"><i class="bi bi-pencil"></i> Edit</a>
              <a href="/characteristics/delete?characterId=${characteristic.characterId}&materialId=${material.materialId}" class="btn btn-sm btn-danger"><i class="bi bi-trash"></i> Delete</a>
              </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>

    <!-- Bootstrap JS (optional) -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
