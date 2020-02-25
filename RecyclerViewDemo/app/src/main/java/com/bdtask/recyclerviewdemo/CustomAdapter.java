package com.bdtask.recyclerviewdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    Context context;
    List<Student> dataList;

    public CustomAdapter(Context context, List<Student> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.custom_layout,viewGroup,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.name.setText(dataList.get(position).getName());
        holder.phoneNumber.setText(String.valueOf(dataList.get(position).getPhone()));



    }

   @Override
    public int getItemCount() {
        return dataList.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView name,phoneNumber;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name);
            phoneNumber = itemView.findViewById(R.id.phone);



        }
    }

}
