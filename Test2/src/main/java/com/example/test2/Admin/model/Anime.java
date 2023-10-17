package com.example.test2.Admin.model;
public class Anime {
    private int id;
    private String name;
    private String status;
    private String link;
    private String picture;
    private int year;

    public Anime() {
    }

    public Anime(String name, String status, String link, String picture, int year) {
        this.name = name;
        this.status = status;
        this.link = link;
        this.picture = picture;
        this.year = year;
    }

    public Anime(int id, String name, String status, String link, String picture, int year) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.link = link;
        this.picture = picture;
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Anime{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", link='" + link + '\'' +
                ", picture='" + picture + '\'' +
                ", year=" + year +
                '}';
    }
}