package com.bdtask.recyclerviewdemo;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
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

        View view = LayoutInflater.from(context).inflate(R.layout.custom_layout, viewGroup, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        holder.name.setText(dataList.get(position).getName());
        holder.phoneNumber.setText(String.valueOf(dataList.get(position).getPhone()));

        //for calling
        holder.callButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + String.valueOf(dataList.get(position).getPhone())));
                context.startActivity(intent);

            }
        });


        //for sms sending
        holder.smsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("smsto:" + String.valueOf(dataList.get(position).getPhone())));
                intent.putExtra("sms_body", "This is a dummy text");
                context.startActivity(intent);

            }
        });



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

        TextView name,phoneNumber,address;
        ImageView  callButton, smsButton;



        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            name        = itemView.findViewById(R.id.name);
            phoneNumber = itemView.findViewById(R.id.phone);
            address     = itemView.findViewById(R.id.address);

            callButton  = itemView.findViewById(R.id.call_button);
            smsButton   = itemView.findViewById(R.id.sms_button);






        }
    }

}
