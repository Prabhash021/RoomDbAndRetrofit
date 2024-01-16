package com.example.roomdbandretrofit;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface DataDao {

    @Insert
    void addData(dataModel dataModel);

    @Query("Select * from postsDB")
    List<dataModel> getAllData();
}
