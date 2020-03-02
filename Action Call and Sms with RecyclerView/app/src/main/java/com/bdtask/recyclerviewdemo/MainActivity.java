package com.bdtask.recyclerviewdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
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
        data.add(new Student("Rahim",016565455555,"Dhaka"));
        data.add(new Student("Karim",016565455555,"Mirpur"));
        data.add(new Student("Mobin",016565455555,"Jamalpur"));
        data.add(new Student("Noman",016565455555,"Rajshahi"));
        data.add(new Student("Abdullah",016565455555,"Khilkhet"));
        data.add(new Student("Salam",016565455555,"Uttara"));
        data.add(new Student("Robiul",016565455555,"Mymensingh"));


        customAdapter = new CustomAdapter(MainActivity.this,data);

        recyclerView.setAdapter(customAdapter);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu,menu);

        MenuItem menuItem = menu.findItem(R.id.search);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setQueryHint("Search Here");


        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {

                customAdapter.getFilter().filter(s);

                return true;
            }
        });

        return true;
    }
}
