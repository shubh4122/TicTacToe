package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button singleP=(Button)findViewById(R.id.singlePlayer);
        Button multi=(Button)findViewById(R.id.multiPlayer);

        multi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent multiIntent=new Intent(MainActivity.this, offlineMulti.class);
                startActivity(multiIntent);
            }
        });
    }
}