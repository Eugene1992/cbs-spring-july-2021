<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Log in with your account</title>

    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

    <link rel="stylesheet" type="text/css" href="${contextPath}/resources/styles/styles.css">
</head>

<body>
<%@include file="parts/header.jsp" %>
<sec:authorize access="isAuthenticated()">
    <% response.sendRedirect("/"); %>
</sec:authorize>
<div class="container login-container">
    <div class="row">
        <div class="col-sm-4 col-md-4 col-lg-4"></div>
        <div class="col-sm-4 col-md-4 col-lg-4">
            <div class="card">
                <div class="card-body">
                    <img class="profile-img"
                         src="https://upload.wikimedia.org/wikipedia/commons/thumb/2/2c/Logo_Yandex.Tracker_2018.svg/768px-Logo_Yandex.Tracker_2018.svg.png"
                         alt="">
                    <form class="form-signin" method="POST" action="/login">
                        <input name="username" type="text" class="form-control" placeholder="Email" required
                               autofocus>
                        <input name="password" type="password" class="form-control" placeholder="Password" required>

                        <a href="/registration" class="pull-right need-help">Create new account? </a><span class="clearfix"></span>
                        <button id="reg-submit-btn" class="btn btn-md btn-primary btn-block" type="submit">Sign in</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
