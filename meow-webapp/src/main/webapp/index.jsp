<%@ page import="com.kat.meowter.service.ArticleService" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <jsp:include page="/include/meta.jsp"/>
    <title>Meowter: homepage</title>
</head>
<body>
<header>
    <jsp:include page="include/header.jsp"/>
</header>
<main role="main">
    <%
        ArticleService articleService = new ArticleService();
        List articles = articleService.getArticles();
        pageContext.setAttribute("articles", articles);
    %>
    <c:forEach var="article" items="${articles}">
        <div class="jumbotron">
            <div class="container">
                <h1 class="display-3">Hello. Meow!</h1>
                <p>${article.getContent()}</p>
                <p><a class="btn btn-primary btn-lg" href="#" role="button">Learn more &raquo;</a></p>
            </div>
        </div>
    </c:forEach>
</main>
<footer>
    <jsp:include page="include/footer.jsp"/>
</footer>
</body>
</html>
