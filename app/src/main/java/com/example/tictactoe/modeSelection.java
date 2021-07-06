package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class modeSelection extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.multi_mode_option);

        Button offline=(Button)findViewById(R.id.offline);
        Button online=(Button)findViewById(R.id.online);

        offline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent modeIntent=new Intent(modeSelection.this, offlineMulti.class);
                startActivity(modeIntent);
            }
        });
    }
}