<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
     a.dropdown-item:hover {
        background-color:#6FEFF9; /* Change the background color on hover */
    }
</style>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark" style="padding: 20px">
	<c:if test="${user==null}">
				<jsp:forward page="login.jsp"/>
			</c:if>
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownPlant" role="button"
                   data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Plant
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdownPlant">
                    <a class="dropdown-item" href="/jsp/add-plant.jsp">Add</a>
                    <a class="dropdown-item" href="#">Search</a>
                   <!--  <a class="dropdown-item" href="#"></a> -->
                </div>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownVendor" role="button"
                   data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Vendor
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdownVendor">
                    <a class="dropdown-item" href="/jsp/add-vendor.jsp">Add</a>
                    <a class="dropdown-item" href="#">Search</a>
                </div>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMaterial" role="button"
                   data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Material
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdownMaterial">
                    <a class="dropdown-item" href="/jsp/add-material.jsp">Add</a>
                    <a class="dropdown-item" href="/jsp/search-material.jsp">Search</a>
                </div>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownLot" role="button"
                   data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Lot
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdownLot">
                    <a class="dropdown-item" href="/lot/form">Add</a>
                     <a class="dropdown-item" href="/jsp/search-lot-range.jsp">search by date range</a>
                      <a class="dropdown-item" href="/jsp/search-lot-id.jsp">search by lot id</a>
                    
                  	
                </div>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownInspection" role="button"
                   data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Inspection
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdownInspection">
                   <a class="dropdown-item" href="#">Add</a>
                    <a class="dropdown-item" href="#">Search</a>
                </div>
            </li>
        </ul>
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" href="/jsp/home.jsp">Home</a>
            </li>
            <li class="nav-item"> 
            	<c:if test="${user!=null}">
                <a class="nav-link" href="/user/logout">${user.userName} Logout</a>
               
                </c:if>
            </li>
        </ul>
        
			
    </div>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    
</nav>
    