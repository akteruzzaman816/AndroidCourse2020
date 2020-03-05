package com.bdtask.databasedemo;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Database database;
    List<Student> allData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        database = new Database(MainActivity.this);
        allData  = new ArrayList<>();


        allData = database.getAllData();

         /** insert data to database*/
      //long id = database.insertData(new Student("Rahim","Dhaka"));

        //for update
       //int id = database.updateData(new Student("Karim","Savar"));

        int status = database.deleteData(1);
        Toast.makeText(this, String.valueOf(status), Toast.LENGTH_SHORT).show();

    }




}
