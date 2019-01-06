package com.example.myfirstapp;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import android.util.Log;
import org.json.JSONObject;

public class MyThread extends Thread {

    String OPEN_WEATHER_MAP_API =
            "http://192.168.1.10:8080/sample/index.html";

    public MyThread() {

    };

    @Override
    public void run() {
        try  {
            // URL url = new URL("http://192.168.1.10:8080/sample/index.html");
            URL url = new URL("https://api.github.com/");

            Log.w("myApp0", "Good0 http go through network fine.");
            Log.w("myApp0", "Good0 http go through network fine.");

            HttpURLConnection connection =
                    (HttpURLConnection)url.openConnection();
            Log.w("myApp1", "Good1 http go through network fine.");
            Log.w("myApp1", "Good1 http go through network fine.");

            connection.getResponseCode();

            Log.w("myApp2", "Good2 http go through network fine.");
            Log.w("myApp2", "Good2 http go through network fine.");

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));

            Log.w("myApp3", "reader getInputStream fine.");
            Log.w("myApp3", "reader getInputStream fine.");

            StringBuffer json = new StringBuffer(4096);
            String tmp = json.append(reader.readLine()).append("\n").toString();

            //while((tmp=reader.readLine())!=null)
             //   json.append(tmp).append("\n");


            reader.close();

            Log.w("myApp4", tmp);

            Log.w("myApp5", "works in toString.");
            Log.w("myApp5", "works in toString.");

            connection.disconnect();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
