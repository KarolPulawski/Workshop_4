
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/books/addBook" method="POST">
    <label>
        Id:
        <input type="text" name="id">
    </label>

    <label>
        Isbn:
        <input type="text" name="isbn">
    </label>

    <label>
        Title:
        <input type="text" name="title">
    </label>

    <label>
        Author:
        <input type="text" name="author">
    </label>

    <label>
        Publisher:
        <input type="text" name="publisher">
    </label>


    <label>
        Type:
        <input type="text" name="type">
    </label>

    <input type="submit">
</form>
</body>
</html>
