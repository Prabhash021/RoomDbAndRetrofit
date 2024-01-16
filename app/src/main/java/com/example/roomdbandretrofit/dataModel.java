package com.example.roomdbandretrofit;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import javax.annotation.processing.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
@Entity(tableName = "postsDB")
public class dataModel {
    @SerializedName("userId")
    @ColumnInfo(name = "UserId")
    private String userId;

    @SerializedName("id")
    @PrimaryKey(autoGenerate = false)
    @NonNull
    private String id;

    @SerializedName("title")
    @ColumnInfo(name = "Title")
    private String title;

    @SerializedName("body")
    @ColumnInfo(name = "Body")
    private String body;

    public dataModel(String userId, String id, String title, String body) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
