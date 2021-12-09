<%--
  Created by IntelliJ IDEA.
  User: cjjc2
  Date: 2021-05-23
  Time: 10:58 p.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Category Page</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

    <style>
        h1 {
            text-align:center;
            background-color: cyan;
        }
        .btn {
            width: 100%;
        }

    </style>
</head>
<body>
<h1>Item Category</h1>
<script>
    document.getElementById("mes").innerHTML = "";
</script>


<div class="container">

    <form method="GET">
        <div class="form-group">
            <label for="ccode">Category Code:</label>
            <input type="text" name="catCode" class="form-control" id="ccode" value="${id}">
        </div>
        <div class="form-group">
            <label for="cdesc">Description:</label>
            <input type="text" name="catDesc" class="form-control" id="cdesc" value="${desc}">
        </div>
        <a class="btn btn-success" href="add-todo">Add</a>

    </form>
    <h1 id="mes">${errorMessage}</h1>
    <div class="container2">
        <h2>Categories</h2>
        <table class="table table-striped">
            <thead>
            <tr>
                <th>Category Code</th>
                <th>Category Description</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${todos}" var="todo">

                <tr>
                    <td>${todo.catCode}</td>
                    <td>${todo.catDesc}</td>
                    <td>    <a type="button" class="btn btn-primary"
                               href="update-todo?id=${todo.catCode}" >Edit</a> </td>
                    <td>    <a type="button" class="btn btn-primary"
                               href="delete-todo?id=${todo.catCode}" >Delete</a> </td>
                    <td>    <a type="button" class="btn btn-primary" onmouseout="myFunction()"
                               href="see-todo?id=${todo.catCode}" >Items</a> </td>
                </tr>

            </c:forEach>
            </tbody>
        </table>
    </div>
</div>

<script>
    function myFunction() {
        document.getElementById("mes").innerHTML = "";
    }
</script>

</body>
</html>