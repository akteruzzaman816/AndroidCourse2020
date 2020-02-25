package com.bdtask.recyclerviewdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Student> data;
    CustomAdapter customAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView  = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        data = new ArrayList<>();
        data.add(new Student("Rahim",016565455555));
        data.add(new Student("Karim",016565455555));
        data.add(new Student("Mobin",016565455555));
        data.add(new Student("Noman",016565455555));
        data.add(new Student("Abdullah",016565455555));
        data.add(new Student("Rahim",016565455555));
        data.add(new Student("Rahim",016565455555));


        customAdapter = new CustomAdapter(MainActivity.this,data);

        recyclerView.setAdapter(customAdapter);


    }
}
