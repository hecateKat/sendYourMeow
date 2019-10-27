<%@ page contentType="text/html;charset=UTF-8" %>

<!doctype html>
<html lang="en">
<head>
    <jsp:include page="/include/meta.jsp"/>
    <title>Meowter: login</title>
</head>

<body>
<header>
    <jsp:include page="include/header.jsp"/>
    <link href="${pageContext.request.contextPath}/css/sign-in.css" rel="stylesheet">
</header>

<main role="main" class="text-center">
    <form class="form-signin" action="login" method="post">
        <img class="mb-4" src="https://i.imgur.com/eER53Qt.jpg" alt="" width="72" height="72">
        <h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
        <label for="inputLogin" class="sr-only">Login</label>
        <input name="login" type="text" id="inputLogin" class="form-control" placeholder="Login" required autofocus>
        <label for="inputPassword" class="sr-only">Password</label>
        <input name="password" type="password" id="inputPassword" class="form-control" placeholder="Password" required>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
    </form>
</main>

<footer class="footer-add">
    <jsp:include page="include/footer.jsp"/>
</footer>

</body>
</html>