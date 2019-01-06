package com.example.myfirstapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import org.json.JSONObject;

public class ShowGithubActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_github);


        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();

        String message = "Failed : Cannot read JSON. No !";
        String json = RemoteFetch.getJSON();
        if(json != null){
            message = json;
        }
        // Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.textView);
        textView.setText(message);
    }


}