<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Get Book</title>
</head>
<body>
    <h1>Get Book Details</h1>
    <form action="UserInteraction" method="GET" name="view">
        Book Name: <input type="text" name="bookn" required/>
        <p></p>
        Author Name: <input type="text" name="authorname"/>
        <p></p>
        <input type="hidden" name="action" value="view" /> <!-- Add hidden action parameter -->
        <input type="submit" value="Get Book"/>            
    </form>
</body>
</html>
