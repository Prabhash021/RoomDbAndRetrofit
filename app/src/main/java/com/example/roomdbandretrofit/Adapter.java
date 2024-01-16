package com.example.roomdbandretrofit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    Context context;
    ArrayList<dataModel> arrData;

    Adapter(Context context, ArrayList<dataModel> arrData){
        this.context = context;
        this.arrData = arrData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.signle_row_view, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {
        holder.txtTittle.setText(arrData.get(position).getTitle());
        holder.txtBody.setText(arrData.get(position).getBody());
        holder.txtID.setText(arrData.get(position).getId());
        holder.txtUserId.setText(arrData.get(position).getUserId());

        Log.e("AdapterTitle", arrData.get(position).getTitle());
        Log.e("AdapterBody", arrData.get(position).getBody());
    }

    @Override
    public int getItemCount() {
        return arrData.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtTittle, txtID, txtBody, txtUserId;
        public ViewHolder(View view) {
            super(view);

            txtUserId = view.findViewById(R.id.userId);
            txtID = view.findViewById(R.id.id);
            txtTittle = view.findViewById(R.id.title);
            txtBody = view.findViewById(R.id.body);
        }
    }
}
