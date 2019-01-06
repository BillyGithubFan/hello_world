package com.example.myfirstapp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.lang.Runnable;

import org.json.JSONObject;

import android.content.Context;


public class RemoteFetch {

    private static final String OPEN_WEATHER_MAP_API =
            "http://192.168.1.10:8080/sample/index.html";

    public static String getJSON(){
        try {
            //String message = connection.getResponseMessage();
            //BufferedReader reader = new BufferedReader(
            //        new InputStreamReader(connection.getInputStream()));

            //StringBuffer json = new StringBuffer(1024);
            //String tmp="";
            //while((tmp=reader.readLine())!=null)
            //    json.append(tmp).append("\n");
            //reader.close();
            MyThread t1 = new MyThread();

            t1.start();
            //String data = json.toString();

            String data = "This is a new ok make up data";

            //String data = message;

            // This value will be 404 if the request was not
            // successful


            return data;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

}
