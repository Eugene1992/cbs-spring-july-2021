<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employee CRUD servlet app</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>


<div class="container">
    <div class="row">
        <div class="panel panel-default">
            <div class="col-lg-8">
                <div class="panel-heading">Employee CRUD servlet app</div>
                <div class="panel-body">
                    <table class="table">
                        <tr>
                            <th>Id</th>
                            <th>Name</th>
                            <th>Age</th>
                            <th>Salary</th>
                            <th>Update</th>
                            <th>Delete</th>
                        </tr>
                        <c:forEach var="employee" items="${employees}">
                            <tr>
                                <td>${employee.id}</td>
                                <td>${employee.name}</td>
                                <td>${employee.age}</td>
                                <td>${employee.salary}</td>
                                <td>
                                    <a href="/employees?action=update&id=${employee.id}">
                                        <button class="btn btn-info">Update</button>
                                    </a>
                                </td>
                                <td>
                                    <a href="/employees?action=delete&id=${employee.id}">
                                        <button class="btn btn-danger">Delete</button>
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>
            <div class="col-lg-4">
                <br>
                <br>
                <form action="/employees" method="post">
                    <div class="form-group">
                        <label for="name">Name:</label>
                        <input type="text" class="form-control" id="name" name="name">
                    </div>
                    <div class="form-group">
                        <label for="age">Age:</label>
                        <input type="number" class="form-control" id="age" name="age">
                    </div>
                    <div class="form-group">
                        <label for="salary">Salary:</label>
                        <input type="number" class="form-control" id="salary" name="salary">
                    </div>
                    <button type="submit" class="btn btn-success">Create</button>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
