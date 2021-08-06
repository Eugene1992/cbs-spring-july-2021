<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<div id="header"
     class="d-flex flex-column flex-md-row align-items-center p-3 px-md-4 mb-3 bg-white border-bottom box-shadow">
    <h5 class="my-0 mr-md-auto font-weight-normal">CBS Crud</h5>
    <nav class="my-2 my-md-0 mr-md-3">
        <a class="p-2 text-dark" href="#">Features</a>
        <a class="p-2 text-dark" href="/news">News</a>
        <a class="p-2 text-dark" href="/admin">Admin</a>
        <a class="p-2 text-dark" href="#">Pricing</a>
    </nav>
    <sec:authorize access="!isAuthenticated()">
        <a class="btn btn-outline-primary" href="/login">Sign in</a>
        <a class="btn btn-primary" href="/registration" style="margin-left: 10px">Sign up</a>
    </sec:authorize>
    <sec:authorize access="isAuthenticated()">
        <a href="#" style="margin-left: 50px">Welcome, ${pageContext.request.userPrincipal.name}</a>
        <a class="btn btn-primary" href="/logout" style="margin-left: 20px">Logout</a>
    </sec:authorize>
</div>
