<%-- 
    Document   : arithmeticcalculator
    Created on : 18-Sep-2022, 8:28:21 PM
    Author     : ivorl
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Arithmetic Calculator</title>
    </head>
    <body>
        <h1>Arithmetic Calculator</h1>
        <form method="post" action="arithmetic">
            First: <input type="text" name="firstNumber"><br>
            Second: <input type="text" name="secondNumber"><br>
            <input type="submit" name="operationType" value="+">
            <input type="submit" name="operationType" value="-">
            <input type="submit" name="operationType" value="*">
            <input type="submit" name="operationType" value="%">
        </form>
        <a href="age">Age Calculator</a>
    </body>
</html>
