package com.example.roomdbandretrofit;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = dataModel.class, exportSchema = false , version = 1)
public abstract class DataBaseHelper extends RoomDatabase {
    private static final String DB_Name = "postsDB";
    private static volatile DataBaseHelper Instance;

    public static synchronized DataBaseHelper getDB(Context context){
        if(Instance == null){
            Instance = Room.databaseBuilder(context, DataBaseHelper.class, DB_Name)
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build();
        }
        return Instance;
    }

    public abstract DataDao dataDao();
}
