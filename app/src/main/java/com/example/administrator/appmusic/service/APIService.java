package com.example.administrator.appmusic.service;

public class APIService {
    public static String base_url="https://ducnguyenptit1909.000webhostapp.com/Server/";
    public static DataService getService(){
        return APIRetrofitClient.getClient(base_url).create(DataService.class);
    }
}
