package com.example.test2.Admin.service;

import com.example.test2.Admin.model.Anime;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataAdmin implements IAdmin {
    private String url = "jdbc:mysql://localhost:3306/boxanime";
    private String username = "root";
    private String password = "mySQL7122023@";
    public DataAdmin() {}
    public Connection connecting() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public Anime selectAnimeFromData(int id) {
        Anime anime = null;
        Connection connection = connecting();
        PreparedStatement statement = null;
        try {

            statement = connection.prepareStatement("SELECT * FROM anime WHERE id = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String status = resultSet.getString("status");
                String link = resultSet.getString("link");
                String picture = resultSet.getString("picture");
                int year = resultSet.getInt("year");
                anime = new Anime(id, name, status, link, picture, year);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return anime;
    }

    @Override
    public List<Anime> searchNameAnime(String str) {
        List<Anime> list = new ArrayList<>();
        Connection connection = connecting();
        PreparedStatement statement = null;
        try {

            statement = connection.prepareStatement("SELECT * FROM anime WHERE name like ?");
            statement.setString(1, "%" + str + "%");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String status = resultSet.getString("status");
                String link = resultSet.getString("link");
                String picture = resultSet.getString("picture");
                int year = resultSet.getInt("year");
                list.add(new Anime(name, status, link, picture, year));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public List<Anime> selectListAnime() {
        List<Anime> list = new ArrayList<>();
        Connection connection = connecting();
        PreparedStatement statement = null;
        try {

            statement = connection.prepareStatement("SELECT * FROM anime");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String status = resultSet.getString("status");
                String link = resultSet.getString("link");
                String picture = resultSet.getString("picture");
                int year = resultSet.getInt("year");
                list.add(new Anime(id, name, status, link, picture, year));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }


    @Override
    public void addAnimeToData(Anime anime) {
        Connection connection = connecting();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("INSERT INTO anime (name, status, link, picture, year) VALUE (?,?,?,?,?);");
            statement.setString(1, anime.getName());
            statement.setString(2, anime.getStatus());
            statement.setString(3, anime.getLink());
            statement.setString(4, anime.getPicture());
            statement.setInt(5, anime.getYear());
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean updateAnimeFromData(Anime anime) {
        boolean check = false;
        Connection connection = connecting();
        PreparedStatement statement = null;
        try {

            statement = connection.prepareStatement("UPDATE anime SET name=?, status=?, link=?, picture=?, year=? WHERE id=?");
            statement.setString(1, anime.getName());
            statement.setString(2, anime.getStatus());
            statement.setString(3, anime.getLink());
            statement.setString(4, anime.getPicture());
            statement.setInt(5, anime.getYear());
            statement.setInt(6, anime.getId());
            check = statement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check;
    }

    @Override
    public boolean deleteAnimeFromData(int id) {
        boolean check = false;
        Connection connection = connecting();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("DELETE FROM anime WHERE id=?;");
            statement.setInt(1, id);
            check = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check;
    }

//    @Override
//    public void addBox(Anime anime) {
//        Connection connection = connecting();
//        PreparedStatement statement = null;
//        try {
//            statement = connection.prepareStatement("INSERT INTO boxAnime (name, status, link, picture, year) VALUE (?,?,?,?,?,?);");
//            statement.setInt(1, anime.getId());
//            statement.setString(2, anime.getName());
//            statement.setString(3, anime.getStatus());
//            statement.setString(4, anime.getLink());
//            statement.setString(5, anime.getPicture());
//            statement.setInt(6, anime.getYear());
//            statement.executeUpdate();
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public List<Anime> selectBoxAnime() {
//        List<Anime> listBoxAnime = new ArrayList<>();
//        Connection connection = connecting();
//        PreparedStatement statement = null;
//        try {
//            statement = connection.prepareStatement("SELECT * FROM boxAnime");
//            ResultSet resultSet = statement.executeQuery();
//
//            while (resultSet.next()) {
//                int id = resultSet.getInt("id");
//                String name = resultSet.getString("name");
//                String status = resultSet.getString("status");
//                String link = resultSet.getString("link");
//                String picture = resultSet.getString("picture");
//                int year = resultSet.getInt("year");
//                listBoxAnime.add(new Anime(id, name, status, link, picture, year));
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return listBoxAnime;
//    }
}
