package com.bdtask.popupmenu;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button clickButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        clickButton  = findViewById(R.id.click_button);

        clickButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                PopupMenu popupMenu = new PopupMenu(MainActivity.this,clickButton);
                popupMenu.getMenuInflater().inflate(R.menu.main_menu,popupMenu.getMenu());


                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {

                        int id = menuItem.getItemId();

                        switch (id){
                            case R.id.first_item:
                        Toast.makeText(MainActivity.this, "First item", Toast.LENGTH_SHORT).show();
                        break;

                            case R.id.second_item:
                                Toast.makeText(MainActivity.this, "Second item", Toast.LENGTH_SHORT).show();
                                break;

                            case R.id.third_item:
                                Toast.makeText(MainActivity.this, "Third item", Toast.LENGTH_SHORT).show();
                                break;


                                default:
                                    Toast.makeText(MainActivity.this, "Default", Toast.LENGTH_SHORT).show();
                                    break;
                        }



                        return true;
                    }
                });



                popupMenu.show();





            }
        });




    }
}
