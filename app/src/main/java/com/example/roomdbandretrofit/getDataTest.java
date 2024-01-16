package com.example.roomdbandretrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

public class getDataTest extends AppCompatActivity {

    //used for the testing purpose, to check data is showing or not

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_data_test);

        TextView result = findViewById(R.id.result);
        Adapter adapter;
        DataBaseHelper databaseHelper = DataBaseHelper.getDB(this);

        ArrayList<dataModel> arrayList = new ArrayList<>();
        arrayList.addAll(databaseHelper.dataDao().getAllData());
        for(int i=0;i<arrayList.size();i++){

            String content = "";
            content += "ID: "+ arrayList.get(i).getId() + "\n";
            content += "UserId: "+arrayList.get(i).getUserId()+"\n";
            content += "Title: "+arrayList.get(i).getTitle()+"\n";
            content += "Text: "+arrayList.get(i).getBody();

            result.append(content);
        }


    }
}