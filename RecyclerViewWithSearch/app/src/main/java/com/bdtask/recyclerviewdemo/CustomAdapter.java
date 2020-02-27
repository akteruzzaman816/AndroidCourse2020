package com.bdtask.recyclerviewdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> implements Filterable {

    Context context;
    List<Student> dataList;
    List<Student> filterDataList;

    public CustomAdapter(Context context, List<Student> dataList) {
        this.context = context;
        this.dataList = dataList;
        filterDataList = new ArrayList<>(dataList);
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

    @Override
    public Filter getFilter() {
        return filterData;
    }

    public Filter filterData = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {

            List<Student> filterList = new ArrayList<>();

            if (charSequence == null || charSequence.length() == 0){

                filterList.addAll(filterDataList);

            }else {

                String value = charSequence.toString().toLowerCase().trim();
                for (Student student : filterDataList){
                    if (student.getName().toLowerCase().trim().contains(value)){
                        filterList.add(student);
                    }
                }

            }

            FilterResults filterResults = new FilterResults();
            filterResults.values = filterList;



            return filterResults;

        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {

            dataList.clear();
            dataList.addAll((List)filterResults.values);
            notifyDataSetChanged();



        }
    };


    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView name,phoneNumber;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name);
            phoneNumber = itemView.findViewById(R.id.phone);



        }
    }

}
