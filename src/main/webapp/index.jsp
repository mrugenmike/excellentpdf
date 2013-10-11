<%@ page import="com.ee.excellentpdf.domain.SalarySlip" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="css/ass8.css"/>
</head>
<body>
<div class="header">
    <div class="logoText"></div>
    <div class="logo"></div>
</div>
<div class="wrapper">
    <form method="POST" action="upload" enctype="multipart/form-data">
        <h4>Upload Your Excel file To Genrate PDF as per sheet</h4>
        <input type="file" class="browse" name="file"/>
        <input type="submit" class="btn" value="Generate Salary Slips"/>
    </form>
    <ul>
        <c:forEach items="${slips}" var="slip">

                <li> <c:out value="${slip.name}"/>  </li>


        </c:forEach>
    </ul>

    <input type="button" class="btn" value="SEND MAIL TO ALL"/>

</div>
</body>
</html>
