<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Delete Book</title>
</head>
<body>
    <h1>Delete Book Data</h1>
    <form action="UserInteraction" method="GET" name="delete">
        Book Name: <input type="text" name="bookn" required/>
        <p></p>
        <h1>OR</h1>
        Author Name: <input type="text" name="authname"/>
        <p></p>
        <input type="hidden" name="action" value="delete" /> <!-- Add hidden action parameter -->
        <input type="submit" value="Delete Book"/>
    </form>
</body>
</html>
