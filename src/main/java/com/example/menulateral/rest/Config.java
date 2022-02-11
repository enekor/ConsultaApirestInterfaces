package com.example.menulateral.rest;

public class Config {
    private static String url = "https://randomuser.me";
    private Config(){}

    public static CrudRest getService(){
        return Client.getClient(url).create(CrudRest.class);
    }
}
