package com.example.test2.Admin.service;

import com.example.test2.Admin.model.Anime;

import java.util.List;

public interface IAdmin {
    public Anime selectAnimeFromData(int id);
    public List<Anime> searchNameAnime(String str);
    public List<Anime> selectListAnime();
    public void addAnimeToData(Anime anime);
    public boolean updateAnimeFromData(Anime anime);
    public boolean deleteAnimeFromData(int id);

//    public void addBox(Anime anime);
//    public List<Anime> selectBoxAnime();
}
