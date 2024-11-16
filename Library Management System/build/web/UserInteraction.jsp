<%-- 
    Document   : UserInteraction
    Created on : Oct 31, 2024, 7:06:43 PM
    Author     : bajra
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Library Management System</title>
    </head>
    <body>
        <h1>Library Management System</h1>
        <form action="UserInteraction" method="POST">
            Book_ID : <input type="text" placeholder="Enter Book ID" name="bookid"/>
            <p></p>
            Book_Name : <input type="text" placeholder="Enter Book Name" name="bookname"/>
            <p></p>
            Author_Name : <input type="text" placeholder="Enter Author Name" name="author"/>
            <p></p>
            Category : <input type="text" placeholder="Enter Category" name="category"/>
            <p></p>
            <input type="submit" value="submit" name="addbookdetails"/>
            
        </form>
    </body>
</html>
