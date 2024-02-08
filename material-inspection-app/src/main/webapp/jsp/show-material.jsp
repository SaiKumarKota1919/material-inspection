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
  <div class="sort-by">
    <label for="sort-options">Sort By:</label>
    <select id="sort-options" onchange="sortResults(this.value)" class="form-control">
      <option value="" selected disabled>Select sort option</option>
      <option value="name">Name</option>
      <option value="city">City</option>
      <option value="state">State</option>
    </select>
  </div>
  
  <table class="table table-bordered">
    <thead class="thead-dark">
      <tr>
        <th>Material Id</th>
        <th>Description</th>
        <th>Type</th>
        <th>Action</th>
      </tr>
    </thead>
    <tbody id="resultsBody">
      <% session = request.getSession();
         List<Material> materials = (List<Material>)session.getAttribute("materials");
         for(Material material: materials) {
       
        	 %>
          <tr>
        
            <td><%= material.getMaterialId() %></td>
            <td><%= material.getMaterialDesc() %></td>
            <td><%= material.getMaterialType() %></td>
            <td class="action-links">
            <c:if test="<%= material.getMaterialCharacteristics().size()!=0%>">
            <a href="/material/view/<%= material.getMaterialId() %>" class="btn btn-sm btn-info"><i class="bi bi-eye"></i> View Characters</a>
            </c:if> 
              <a href="/material/edit/<%= material.getMaterialId() %>" class="btn btn-sm btn-primary"><i class="bi bi-pencil"></i> Edit</a>
              <a href="/material/delete/<%= material.getMaterialId() %>" class="btn btn-sm btn-danger"><i class="bi bi-trash"></i> Delete</a>
              <%System.out.println("****"+material); %>
             
              <a href="/characteristics/form/<%= material.getMaterialId() %>" class="btn btn-sm btn-success"><i class="bi bi-plus"></i> Add Characters</a>               
              
            </td>
          </tr>
      <% } %>
    </tbody>
  </table>
</div>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>