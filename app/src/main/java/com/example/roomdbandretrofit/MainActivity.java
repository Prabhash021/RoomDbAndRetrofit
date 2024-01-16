package com.example.roomdbandretrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    ArrayList<dataModel> arrData = new ArrayList<>();
    Button fetchBtn, showBtn;
    ProgressBar loading;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fetchBtn = findViewById(R.id.fetch);
        showBtn = findViewById(R.id.show);
        loading = findViewById(R.id.progress);

        loading.setVisibility(View.INVISIBLE);

        DataBaseHelper databaseHelper = DataBaseHelper.getDB(this);
        ArrayList<dataModel> checkData = (ArrayList<dataModel>) databaseHelper.dataDao().getAllData();

        if(!checkData.isEmpty()){
            showBtn.setEnabled(true);
        }

        fetchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loading.setVisibility(View.VISIBLE);
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("https://jsonplaceholder.typicode.com/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                Api api = retrofit.create(Api.class);
                Call<List<dataModel>> call = api.getPosts();

                call.enqueue(new Callback<List<dataModel>>() {
                    @Override
                    public void onResponse(Call<List<dataModel>> call, Response<List<dataModel>> response) {
                        if(!response.isSuccessful()){
                            Toast.makeText(MainActivity.this, "Data fetch unsuccessful. Response code:" + response.code(), Toast.LENGTH_SHORT).show();
                            return;
                        }
                        showBtn.setEnabled(true);
                        loading.setVisibility(View.INVISIBLE);

                        List<dataModel> posts = response.body();
                        for(dataModel post: posts){
                            String uid = post.getUserId();
                            String id = post.getId();
                            String title = post.getTitle();
                            String body = post.getBody();

                            databaseHelper.dataDao().addData(new dataModel(uid, id,title,body));
                        }
                    }

                    @Override
                    public void onFailure(Call<List<dataModel>> call, Throwable t) {
                        Toast.makeText(MainActivity.this, "Unable to fetch data", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        showBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ViewResultActivity.class);
                startActivity(intent);
            }
        });

    }
}