package com.example.roomdbandretrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import java.util.ArrayList;

public class ViewResultActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    Adapter adapter;
    DataBaseHelper databaseHelper = DataBaseHelper.getDB(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_result);
        recyclerView = findViewById(R.id.recyclerViewXml);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<dataModel> arrayList = new ArrayList();
        arrayList.addAll( databaseHelper.dataDao().getAllData());
        adapter = new Adapter(this, arrayList);

        recyclerView.setAdapter(new Adapter(ViewResultActivity.this, arrayList));
    }
}