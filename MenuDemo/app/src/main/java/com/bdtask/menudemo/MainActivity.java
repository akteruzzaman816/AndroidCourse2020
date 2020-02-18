package com.bdtask.menudemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.options_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.first_item){

            Toast.makeText(this, "First item Clicked", Toast.LENGTH_SHORT).show();

        }else if (id == R.id.second_item){

            Toast.makeText(this, "Second item Clicked", Toast.LENGTH_SHORT).show();

        }else if (id == R.id.third_item){

            Toast.makeText(this, "Third item Clicked", Toast.LENGTH_SHORT).show();
            
        }



        return super.onOptionsItemSelected(item);

    }
}
