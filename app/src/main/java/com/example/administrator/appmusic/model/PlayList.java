package com.example.administrator.appmusic.model;

public class PlayList {
    public int idplaylist;
    public String ten;
    public String hinhnen;
    public String hinhicon;

    public PlayList() {
    }

    public PlayList(int idplaylist, String ten, String hinhnen, String hinhicon) {
        this.idplaylist = idplaylist;
        this.ten = ten;
        this.hinhnen = hinhnen;
        this.hinhicon = hinhicon;
    }

    public int getIdplaylist() {
        return idplaylist;
    }

    public void setIdplaylist(int idplaylist) {
        this.idplaylist = idplaylist;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getHinhnen() {
        return hinhnen;
    }

    public void setHinhnen(String hinhnen) {
        this.hinhnen = hinhnen;
    }

    public String getHinhicon() {
        return hinhicon;
    }

    public void setHinhicon(String hinhicon) {
        this.hinhicon = hinhicon;
    }
}
