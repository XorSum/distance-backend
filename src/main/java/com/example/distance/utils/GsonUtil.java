package com.example.distance.utils;

import com.google.gson.Gson;

public class GsonUtil {

    private static class GsonHolder {
        private static final Gson INSTANCE = new Gson();
    }


    public static Gson getGsonInstance() {
        return GsonHolder.INSTANCE;
    }
}
