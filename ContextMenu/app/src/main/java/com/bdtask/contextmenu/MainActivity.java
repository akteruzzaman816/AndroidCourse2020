package com.bdtask.contextmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String name[] = {"Abdullah","Noman","Tushar","nirob","karim","Rahim","akterVai"};
    ArrayAdapter<String> adapter;

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView  = findViewById(R.id.list_view);
        adapter   = new ArrayAdapter<>(MainActivity.this,android.R.layout.simple_dropdown_item_1line,name);

        listView.setAdapter(adapter);

        registerForContextMenu(listView);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        getMenuInflater().inflate(R.menu.main_menu,menu);
        menu.setHeaderTitle("Select Option");

    }


    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.call){
            Toast.makeText(this, "Calling", Toast.LENGTH_SHORT).show();
        }else if (id == R.id.message){
            Toast.makeText(this, "Message", Toast.LENGTH_SHORT).show();
        }


        return true;
    }
}
