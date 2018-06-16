package com.example.administrator.appmusic.model;

public class QuangCao {
    public int id;
    public String hinhanh,noidung;
    public int idbaihat;
    public String tenbaihat;
    public String hinhbaihat;

    public QuangCao() {
    }

    public QuangCao(int id, String hinhanh, String noidung, int idbaihat, String tenbaihat, String hinhbaihat) {
        this.id = id;
        this.hinhanh = hinhanh;
        this.noidung = noidung;
        this.idbaihat = idbaihat;
        this.tenbaihat = tenbaihat;
        this.hinhbaihat = hinhbaihat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(String hinhanh) {
        this.hinhanh = hinhanh;
    }

    public String getNoidung() {
        return noidung;
    }

    public void setNoidung(String noidung) {
        this.noidung = noidung;
    }

    public int getIdbaihat() {
        return idbaihat;
    }

    public void setIdbaihat(int idbaihat) {
        this.idbaihat = idbaihat;
    }

    public String getTenbaihat() {
        return tenbaihat;
    }

    public void setTenbaihat(String tenbaihat) {
        this.tenbaihat = tenbaihat;
    }

    public String getHinhbaihat() {
        return hinhbaihat;
    }

    public void setHinhbaihat(String hinhbaihat) {
        this.hinhbaihat = hinhbaihat;
    }
}
