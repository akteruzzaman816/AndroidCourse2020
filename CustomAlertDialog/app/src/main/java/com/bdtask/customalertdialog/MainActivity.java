package com.bdtask.customalertdialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button clickButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        clickButton   = findViewById(R.id.click_button);

        clickButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                customAlertDialog();

            }
        });

    }




    private void customAlertDialog() {

        final AlertDialog.Builder builder   = new AlertDialog.Builder(this);
        View view  = LayoutInflater.from(this).inflate(R.layout.custom_layout,null);
        builder.setView(view);
        builder.setCancelable(false);

        final AlertDialog alertDialog = builder.create();

        Button okButton = view.findViewById(R.id.ok_button);
        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
            }
        });

       alertDialog.show();




    }




}
