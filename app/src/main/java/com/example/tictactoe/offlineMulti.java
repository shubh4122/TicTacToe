package com.example.tictactoe;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class offlineMulti extends AppCompatActivity implements View.OnClickListener {

    /**
     * The variables can be declared before onCreate but have to be initialized inside onCreate or after it.
     */
    public int clicks;
    private Button b1,b2,b3,b4,b5,b6,b7,b8,b9, reset;
    private TextView turnText, turnSymbol;
    public char matrix[][];
    boolean win=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_game);

        clicks = 0;
        matrix=new char[3][3];
        b1 = (Button) findViewById(R.id.btn1);
        b2 = (Button) findViewById(R.id.btn2);
        b3 = (Button) findViewById(R.id.btn3);
        b4 = (Button) findViewById(R.id.btn4);
        b5 = (Button) findViewById(R.id.btn5);
        b6 = (Button) findViewById(R.id.btn6);
        b7 = (Button) findViewById(R.id.btn7);
        b8 = (Button) findViewById(R.id.btn8);
        b9 = (Button) findViewById(R.id.btn9);

        turnText=(TextView)findViewById(R.id.turnTxt);
        turnSymbol=(TextView)findViewById(R.id.turnSym);

//        Arrays.fill(matrix, '0');

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matrix[i][j]='0';
            }
        }
        /**
         * Note this way of doing it.!!!
         */
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
        b6.setOnClickListener(this);
        b7.setOnClickListener(this);
        b8.setOnClickListener(this);
        b9.setOnClickListener(this);

        //reset Logic
        reset = (Button)findViewById(R.id.reset);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetAll();
            }
        });
    }

    private void resetAll() {
        clicks=0;
        b1.setText("");
        b2.setText("");
        b3.setText("");
        b4.setText("");
        b5.setText("");
        b6.setText("");
        b7.setText("");
        b8.setText("");
        b9.setText("");

        turnText.setText("Player 1's Turn");
        turnSymbol.setText("X");

        Log.i("RESET", "resetAll");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matrix[i][j]='0';
            }
        }
    }

    @Override
    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.btn1:
                setallView(0,0, b1);
                break;

            case R.id.btn2:
                setallView(0,1,b2);
                break;

            case R.id.btn3:
                setallView(0,2,b3);
                break;

            case R.id.btn4:
                setallView(1,0,b4);
                break;

            case R.id.btn5:
                setallView(1,1,b5);
                break;

            case R.id.btn6:
                setallView(1,2,b6);
                break;

            case R.id.btn7:
                setallView(2,0,b7);
                break;

            case R.id.btn8:
                setallView(2,1,b8);
                break;

            case R.id.btn9:
                setallView(2,2,b9);

        }
    }

    /**
     * This is a great Idea. Here we Do all tasks at once. Note this.
     * @param i
     * @param j
     * @param b THis is again very Important way.MUST NOTE
     */
    private void setallView(int i, int j, Button b) {
        if(matrix[i][j]=='0')
        {
            clicks++;
            if (clicks % 2 == 0) {
                //b.setBackground(R.drawable.cross_prev_ui);
                b.setText("O");
                matrix[i][j]='O';
                if(win==false)
                {
                    turnText.setText("Player 1's Turn");
                    turnSymbol.setText("X");
                }
                Log.i("cliked even", "onClick: Print O, click:" + clicks+" matrix contains: "+matrix[i][j]);
            } else {
                //b.setBackground(ContextCompat.getDrawable(context, R.drawable.ofinal));
                b.setText("X");
                matrix[i][j]='X';
                if(clicks!=9 || win==false)
                {
                    turnText.setText("Player 2's Turn");
                    turnSymbol.setText("O");
                }
                Log.i("cliked odd", "onClick: Print X, click:" + clicks+" matrix contains: "+matrix[i][j]);
            }
        }
    }
}
