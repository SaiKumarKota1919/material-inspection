<%@page import="com.zm.mi.model.UnitsOfMeasurement"%>
<%@page import="com.zm.mi.entity.MaterialCharacteristics"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Material Characteristics</title>
    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<jsp:include page="navbar.jsp"></jsp:include>
<div class="container">
    <h2>Material Characteristics</h2>

    <form id="characteristicsForm" action="/characteristics/add" method="post" name="characteristicsForm">
    <input type="text" hidden="hidden" name="materialId" value="${mat.materialId}">
        <div id="characteristicsContainer">
        
            <!-- Default characteristic -->
            <fieldset class="characteristic" name="characteristicsForm">
                <legend>Characteristic 1</legend>
                <div class="form-row">
                    <div class="form-group col-md-3">
                        <label for="characterDesc">Character Description:</label>
                        <input type="text" class="form-control" name="characteristicsList[0].characterDesc"  required>
                    </div>
                    <div class="form-group col-md-3">
                        <label for="upperTolLimit">Upper Tolerance Limit:</label>
                        <input type="text" class="form-control" name="characteristicsList[0].upperTolLimit" 
                        pattern="[0-9]*[.,]?[0-9]*" required>
                    </div>
                    <div class="form-group col-md-3">
                        <label for="lowerTolLimit">Lower Tolerance Limit:</label>
                        <input type="text" class="form-control" name="characteristicsList[0].lowerTolLimit" 
                       pattern="[0-9]*[.,]?[0-9]*" required>
                    </div>
                    <div class="form-group col-md-3">
                    <label for="unitsOfMsrmnt">Units of Measurement:</label>
                   <select class="form-control" name="characteristicsList[0].unitsOfMsrmnt" required >
                   <option value="">Select Unit</option>
                        <%for(UnitsOfMeasurement unitsOfMeasurement : UnitsOfMeasurement.values())
                        { %>
                        	
                        	 
                       <option value="<%=unitsOfMeasurement.getIsoCode()%>"><%=unitsOfMeasurement.getIsoCode()%></option>
                       
                        	
                     <%  }%>
                        
                        
                        
                       
                        <!-- Add more options as needed -->
                    </select>
                </div>
                </div>
            </fieldset>

            <!-- Characteristics fields will be added dynamically here -->
        </div>
        <button type="button" class="btn btn-primary" onclick="addCharacteristic()">Add Characteristic</button>
        <button type="submit" class="btn btn-success">Submit Characteristics</button>
    </form>
</div>

<!-- Bootstrap JS (optional) -->
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

<script>
    var characteristicCount = 0;
    var count = 1;

    function addCharacteristic() {
        characteristicCount++;
        count++;

        var container = document.getElementById("characteristicsContainer");
        var fieldset = document.createElement("fieldset");
        fieldset.classList.add("characteristic");

        fieldset.innerHTML = "<legend>Characteristic " + count + "</legend>" +
            '<div class="form-row">' +
           '    <div class="form-group col-md-3">' +
            '        <label for="characterDesc">Character Description:</label>' +
            '        <input type="text" class="form-control" name="characteristicsList[' + characteristicCount + '].characterDesc" required>' +
            '    </div>' +
            '    <div class="form-group col-md-3">' +
            '        <label for="upperTolLimit">Upper Tolerance Limit:</label>' +
            '        <input type="text" class="form-control" name="characteristicsList[' + characteristicCount + '].upperTolLimit" pattern="[0-9]*[.,]?[0-9]*" required>' +
            '    </div>' +
            '    <div class="form-group col-md-3">' +
            '        <label for="lowerTolLimit">Lower Tolerance Limit:</label>' +
            '        <input type="text" class="form-control" name="characteristicsList[' + characteristicCount + '].lowerTolLimit" pattern="[0-9]*[.,]?[0-9]*" required>' +
            '    </div>' +
            '    <div class="form-group col-md-3">' +
            '        <label for="unitsOfMsrmnt">Units of Measurement:</label>' +
            '        <select class="form-control" name="characteristicsList[' + characteristicCount + '].unitsOfMsrmnt" required>' +
            '            <option value="">Select Unit</option>' +
            '            <%for(UnitsOfMeasurement unitsOfMeasurement : UnitsOfMeasurement.values()) 
                    { %>                                                                         '+
                        	
                        	 
              '         <option value="<%=unitsOfMeasurement.getIsoCode()%>"><%=unitsOfMeasurement.getIsoCode()%></option>'+
                       
                        	
             '        <%  }%>' +
            '            <!-- Add more options as needed -->' +
            '        </select>' +
            '    </div>' +
            '</div>';

        // Add a remove button
        var removeButton = document.createElement("button");
        removeButton.type = "button";
        removeButton.classList.add("btn", "btn-danger");
        removeButton.innerHTML = "Remove Characteristic";
        removeButton.onclick = function () {
            container.removeChild(fieldset);
            characteristicCount--;
        };

        fieldset.appendChild(removeButton);

        container.appendChild(fieldset);

        // Focus on the characterDesc input field of the newly added characteristic
        fieldset.querySelector('input[name="characteristicsList[' + characteristicCount + '].characterDesc"]').focus();
    }
</script>

</body>
</html>
