<%@page import="com.zm.mi.service.impl.InspectionActualsServiceImpl"%>
<%@page import="org.springframework.beans.factory.annotation.Autowired"%>
<%@page import="com.zm.mi.service.InspectionActualsService"%>
<%@page import="com.zm.mi.entity.InspectionLot"%>
<%@page import="com.zm.mi.entity.Material"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Materials</title>
  <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
  <script src="sort.js"></script>
  <style>
    body {
      font-size: 14px;
      font-family: sans-serif;
    }
    .sort-by {
      margin-bottom: 20px;
    }
    .action-links a {
      margin-right: 5px;
    }
  </style>
</head>
<body>
<jsp:include page="navbar.jsp"></jsp:include>
<div class="container mt-4">
  
  <table class="table table-bordered">
    <thead class="thead-dark">
      <tr>
        <th>Lot Id</th>
        <th>Plant</th>
        <th>Vendor</th>
        <th>Material Desc</th>
        <th>Actions</th>
      </tr>
    </thead>
    <tbody id="resultsBody">
    
      <% session = request.getSession();
         List<InspectionLot> lots = (List<InspectionLot>)session.getAttribute("lots");
         for(InspectionLot lot: lots) {
       
        	 %>
          <tr>
        
            <td><%= lot.getLotId() %></td>
            <td><%= lot.getPlant().getPlantName() %></td>
            <td><%= lot.getVendor().getVendorName()%></td>
            <td><%= lot.getMaterial().getMaterialDesc()%></td>
            <td class="action-links">
            <c:if test="<%=lot.getInspectionActuals().size()!=0%>">
    	<a href="/inspection/actuals/<%=lot.getMaterial().getMaterialId()%>" class="btn btn-sm btn-info"><i class="bi bi-eye"></i>View Actuals</a>
			</c:if>
 				<c:if test="<%=lot.getInspectionActuals().size()<lot.getMaterial().getMaterialCharacteristics().size()%>">
               <a href="/inspection/add/form/<%=lot.getLotId()%>" class="btn btn-sm btn-success"><i class="bi bi-plus"></i>Add Actuals</a> 
               </c:if>
               <c:if test="<%=((lot.getInspectionActuals().size()==lot.getMaterial().getMaterialCharacteristics().size())&&lot.getMaterial().getMaterialCharacteristics().size()!=0) %>">              
             <a href="/inspection/add/form/<%=lot.getLotId()%>" class="btn btn-sm btn-warning"><i class="bi bi-eye-fill"></i>View Results</a>
             </c:if>
           <a href="/material/edit/" class="btn btn-sm btn-primary"><i class="bi bi-pencil"></i>Edit</a>
              <a href="/material/delete/" class="btn btn-sm btn-danger"><i class="bi bi-trash"></i>Delete</a>
              
           
            </td>
          </tr>
      <% } %>
    </tbody>
  </table>
</div>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
