package com.geniusplaza.app.utils;

public class AppConstants {

    public static final String BASE_URL = "https://reqres.in/";
    public static boolean flagNotFromTimeLineScreen= true;



    public enum COLOR {
        ;
        public static final String MOMENT_GREEN = "MOMENT_GREEN";
        public static final String GREY_DARK = "GREY_DARK";
        public static final String GREY_LIGHT = "GREY_LIGHT";
        public static final String YELLOW = "YELLOW";
    }

    public static class DataBase {
        public static final String DATABASE_NAME = "momentStorage.db";
    }

    public static class Preference {

        public static final String PREFERENCE_NAME = "momentPrefStorage";
        public static final String FIRST_LAUNCH = "firstLaunch";
    }




}
