package com.example.test2.Admin.controller;

import com.example.test2.Admin.model.Anime;
import com.example.test2.Admin.service.DataAdmin;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ProcessSystem", value = "/admin")
public class ProcessSystem extends HttpServlet {
    private DataAdmin data;

    @Override
    public void init() throws ServletException {
       data = new DataAdmin();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    showNewForm(req, resp);
                    break;
                case "update":
                    showEditForm(req, resp);
                    break;
                case "delete":
                    deleteAnime(req, resp);
                    break;
                case "search":
                    searchAnime(req, resp);
                    break;
                default:
                    listAnime(req, resp);
                    break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void showSearchForm(HttpServletRequest req, HttpServletResponse resp) {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    insertAnime(req, resp);
                    break;
                case "update":
                    updateAnime(req, resp);
                    break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void searchAnime(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException, ServletException {
        String name = req.getParameter("name");
        List<Anime> listAnime = data.searchNameAnime(name);
        req.setAttribute("listAnime", listAnime);
        RequestDispatcher dispatcher = req.getRequestDispatcher("view/search.jsp");
        dispatcher.forward(req, resp);
    }

    private void insertAnime(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException, ServletException {
        String name = req.getParameter("name");
        String status = req.getParameter("status");
        String link = req.getParameter("link");
        String picture = req.getParameter("picture");
        int year = Integer.parseInt(req.getParameter("year"));
        Anime anime = new Anime(name, status, link, picture, year);
        data.addAnimeToData(anime);

        //switch to another tab
        //resp.sendRedirect("view/list");

        //do not switch tabs
        RequestDispatcher dispatcher = req.getRequestDispatcher("view/create.jsp");
        dispatcher.forward(req, resp);
    }


    private void listAnime(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException, ServletException{
        List<Anime> listAnime = data.selectListAnime();
        req.setAttribute("listAnime", listAnime);
        RequestDispatcher dispatcher = req.getRequestDispatcher("View/list.jsp");
        dispatcher.forward(req, resp);
    }
    private void updateAnime(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String status = req.getParameter("status");
        String link = req.getParameter("link");
        String picture = req.getParameter("picture");
        int year = Integer.parseInt(req.getParameter("year"));

        Anime anime = new Anime(id, name, status, link, picture, year);
        data.updateAnimeFromData(anime);

        List<Anime> listAnime = data.selectListAnime();
        req.setAttribute("listAnime", listAnime);
        RequestDispatcher dispatcher = req.getRequestDispatcher("view/list.jsp");
        dispatcher.forward(req, resp);
    }
    private void deleteAnime(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(req.getParameter("id"));
        data.deleteAnimeFromData(id);
        List<Anime> listAnime = data.selectListAnime();
        req.setAttribute("listAnime", listAnime);
        req.getRequestDispatcher("view/list.jsp").forward(req, resp);
    }

    private void showNewForm(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException, ServletException{
        RequestDispatcher dispatcher = req.getRequestDispatcher("view/create.jsp");
        dispatcher.forward(req, resp);
    }
    private void showEditForm(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(req.getParameter("id"));
        Anime anime = data.selectAnimeFromData(id);
        req.setAttribute("anime", anime);
        RequestDispatcher dispatcher = req.getRequestDispatcher("view/update.jsp");
        dispatcher.forward(req, resp);
    }

}
