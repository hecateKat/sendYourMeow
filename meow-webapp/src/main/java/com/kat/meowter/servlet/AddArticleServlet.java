package com.kat.meowter.servlet;

import com.kat.meowter.service.ArticleService;
import com.kat.persistance.entities.TbUser;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = {"/addArticle"})
public class AddArticleServlet extends HttpServlet {

    private ArticleService articleService = new ArticleService();


    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String content = request.getParameter("content");
        HttpSession session = request.getSession();
        TbUser user = (TbUser) session.getAttribute("user");
        articleService.addArticle(user, content);
        response.setCharacterEncoding("UTF-8");
        response.sendRedirect("index.jsp");
    }

}
