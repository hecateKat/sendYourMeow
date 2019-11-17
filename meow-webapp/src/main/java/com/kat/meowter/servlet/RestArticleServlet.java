package com.kat.meowter.servlet;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.kat.meowter.service.ArticleService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = {"/rest/articles"})
public class RestArticleServlet extends HttpServlet {

    private ArticleService articleService = new ArticleService();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List articles = articleService.getArticles();
        sendAsJson(articles, response);
    }

    private void sendAsJson(List models, HttpServletResponse response) throws IOException {
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        String jSonString = gson.toJson(models);
        response.setContentType("application/json");
        PrintWriter writer = response.getWriter();
        writer.print(jSonString);
        writer.flush();
    }

}
