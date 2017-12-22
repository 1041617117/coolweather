package com.coolweather.android.gson;

/**
 * Created by mr.c on 2017/12/17.
 */

public class AQI {
    public AQICity city;
    public class AQICity{
        public String aqi;
        public String pm25;
    }
}
