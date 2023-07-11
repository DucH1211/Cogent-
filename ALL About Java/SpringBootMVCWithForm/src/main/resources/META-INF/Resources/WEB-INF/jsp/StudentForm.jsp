<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link ref = "stylesheet" href = "style.css">
</head>
<body>
<h1>Student FORM</h1>
    <div class = "coolForm">
    <form action="/student/addStudent" method="post">
    <h3>Enter Student Information</h3>
        <hr>
        <label for="firstName">FirstName:</label>
        <input type="text" name="firstName" id="firstName"> <br>

        <label for="lastName">LastName:</label>
        <input type="text" name="lastName" id="lastName"> <br>
        
        <label for="email">Email:</label>
        <input type="text" name="email" id="email"> <br>
        
        <label for="Gender">Gender:</label>
        <input type="text" name="Gender" id="Gender"> <br>
        
        <label for="education">Education:</label>
        <input type="text" name="education" id="education"> <br>
        
        <label for="DOB">DOB(YYYY-MM-DD):</label>
        <input type="date" name="DOB" id="DOB"> <br><br><br>
        
        <input type="submit" value="Save Student">
        
    </form>
    </div>
</body>
</html>