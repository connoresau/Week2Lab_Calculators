<%-- 
    Document   : agecalculator
    Created on : Sep 12, 2019, 4:24:01 PM
    Author     : 745507
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Age Calculator</title>
        <meta aut  
    </head>
    <body>
        <h1>Age Calculator</h1>
        <form action="age" method="post">
            Enter your age: <input type="text" name="enteredAge" value = ${ageEnteredInTextBox}><br>
            <input type="submit" value="Age next birthday"><br>
            ${output}
            <a href="arithmetic">Arithmetic Calculator</a>
        </form>
    </body>
</html>
