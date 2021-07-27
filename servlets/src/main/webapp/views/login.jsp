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

<br>
<div class="container">
    <div class="row">
        <div class="panel panel-primary">
            <div class="panel-heading">Employee CRUD servlet app</div>
            <div class="panel-body">
                <div class="col-lg-8">
                    <table class="table">
                        <tr>
                            <th>Name</th>
                            <th>Age</th>
                            <th>Salary</th>
                            <th>Update</th>
                            <th>Delete</th>
                        </tr>
                        <c:forEach var="employee" items="${employees}">
                            <tr>
                                <td>${employee.name}</td>
                                <td>${employee.age}</td>
                                <td>${employee.salary}</td>
                                <td style="width: 20px">
                                    <a href="/employees?action=update&id=${employee.id}">
                                        <button class="btn btn-info"><span class="glyphicon glyphicon-refresh"
                                                                           aria-hidden="true"></span></button>
                                    </a>
                                </td>
                                <td style="width: 20px">
                                    <a href="/employees?action=delete&id=${employee.id}">
                                        <button class="btn btn-danger"><span class="glyphicon glyphicon-trash"
                                                                             aria-hidden="true"></span></button>
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
                <div class="col-lg-4">
                    <form action="/employees" method="post">
                        <input type="hidden" class="form-control" id="id" name="id" value="${updEmployee.id}">
                        <div class="form-group">
                            <label for="name">Name:</label>
                            <input type="text" class="form-control" id="name" name="name" value="${updEmployee.name}">
                        </div>
                        <div class="form-group">
                            <label for="age">Age:</label>
                            <input type="number" class="form-control" id="age" name="age" value="${updEmployee.age}">
                        </div>
                        <div class="form-group">
                            <label for="salary">Salary:</label>
                            <input type="number" class="form-control" id="salary" name="salary"
                                   value="${updEmployee.salary}">
                        </div>
                        <c:choose>
                            <c:when test="${updEmployee.id == null}">
                                <button type="submit" class="btn btn-success center-block">Create</button>
                            </c:when>
                            <c:when test="${updEmployee.id != null}">
                                <button type="submit" class="btn btn-warning center-block">Update</button>
                            </c:when>
                        </c:choose>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
