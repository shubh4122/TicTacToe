package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Single extends AppCompatActivity implements View.OnClickListener {

    public int clicks;
    public Button b1,b2,b3,b4,b5,b6,b7,b8,b9, reset, compBtn;
    public TextView turnText, turnSymbol, xScore, oScore, draw;
    public char matrix[][];
    boolean win=false;
    short xWinCount, oWinCount, drawCount;
    offlineMulti obj;
    int idArray[][];
    Handler delay;
    boolean timerOn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_game);

        delay=new Handler();
        turnText = (TextView) findViewById(R.id.turnTxt);
        turnText.setText("Players's Turn");

        clicks = 0;
        timerOn=false;
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

        xScore=(TextView)findViewById(R.id.xScore);
        oScore=(TextView)findViewById(R.id.oScore);
        draw=(TextView)findViewById(R.id.draw);

        obj = new offlineMulti();
//        idArray= new int[3][3];
        idArray=new int[3][3];

        idArray[0][0]=R.id.btn1;
        idArray[0][1]=R.id.btn2;
        idArray[0][2]=R.id.btn3;
        idArray[1][0]=R.id.btn4;
        idArray[1][1]=R.id.btn5;
        idArray[1][2]=R.id.btn6;
        idArray[2][0]=R.id.btn7;
        idArray[2][1]=R.id.btn8;
        idArray[2][2]=R.id.btn9;

//        Toast.makeText(this, "ID BTN1: "+R.id.btn1+" "+idArray[0][0], Toast.LENGTH_LONG).show();

//        {{R.id.btn1, R.id.btn2, R.id.btn3}, {R.id.btn4, R.id.btn5, R.id.btn6}, {R.id.btn7, R.id.btn8, R.id.btn9}};

        xWinCount=0;
        oWinCount=0;
        drawCount=0;
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

    public void resetAll() {
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

        idArray[0][0]=R.id.btn1;
        idArray[0][1]=R.id.btn2;
        idArray[0][2]=R.id.btn3;
        idArray[1][0]=R.id.btn4;
        idArray[1][1]=R.id.btn5;
        idArray[1][2]=R.id.btn6;
        idArray[2][0]=R.id.btn7;
        idArray[2][1]=R.id.btn8;
        idArray[2][2]=R.id.btn9;


        /**
         * This detects theme and changes accordingly
         */
        switch (getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK) {
            case Configuration.UI_MODE_NIGHT_YES:
                b1.setBackgroundColor(Color.BLACK);
                b2.setBackgroundColor(Color.BLACK);
                b3.setBackgroundColor(Color.BLACK);
                b4.setBackgroundColor(Color.BLACK);
                b5.setBackgroundColor(Color.BLACK);
                b6.setBackgroundColor(Color.BLACK);
                b7.setBackgroundColor(Color.BLACK);
                b8.setBackgroundColor(Color.BLACK);
                b9.setBackgroundColor(Color.BLACK);
        
                break;
            case Configuration.UI_MODE_NIGHT_NO:
                b1.setBackgroundColor(Color.WHITE);
                b2.setBackgroundColor(Color.WHITE);
                b3.setBackgroundColor(Color.WHITE);
                b4.setBackgroundColor(Color.WHITE);
                b5.setBackgroundColor(Color.WHITE);
                b6.setBackgroundColor(Color.WHITE);
                b7.setBackgroundColor(Color.WHITE);
                b8.setBackgroundColor(Color.WHITE);
                b9.setBackgroundColor(Color.WHITE);
        
                break;
        }

//        setContentView(R.layout.main_game);
//        xScore.setText("X: "+xWinCount);
//        oScore.setText("O: "+oWinCount);
//        draw.setText("Draw: "+drawCount);

        turnText.setText("Player's Turn");
        turnSymbol.setText("X");
        win=false;
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
                if(idArray[0][0]!=0 && timerOn==false) {
                    idArray[0][0] = 0;
                    setallView(0, 0, b1);
                }
                else {
                    Toast.makeText(this, "Let Computer take its turn !!", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.btn2:
                if(idArray[0][1]!=0 && timerOn==false) {
                    idArray[0][1] = 0;
                    setallView(0, 1, b2);
                }
                else {
                    Toast.makeText(this, "Let Computer take its turn !!", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.btn3:
                if(idArray[0][2]!=0 && timerOn==false) {
                    idArray[0][2] = 0;
                    setallView(0, 2, b3);
                }
                else {
                    Toast.makeText(this, "Let Computer take its turn !!", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.btn4:
                if(idArray[1][0]!=0 && timerOn==false) {
                    idArray[1][0] = 0;
                    setallView(1, 0, b4);
                }
                else {
                    Toast.makeText(this, "Let Computer take its turn !!", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.btn5:
                if(idArray[1][1]!=0 && timerOn==false) {
                    idArray[1][1] = 0;
                    setallView(1, 1, b5);
                }
                else {
                    Toast.makeText(this, "Let Computer take its turn !!", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.btn6:
                if(idArray[1][2]!=0 && timerOn==false) {
                    idArray[1][2] = 0;
                    setallView(1, 2, b6);
                }
                else {
                    Toast.makeText(this, "Let Computer take its turn !!", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.btn7:
                if(idArray[2][0]!=0 && timerOn==false) {
                    idArray[2][0] = 0;
                    setallView(2, 0, b7);
                }
                else {
                    Toast.makeText(this, "Let Computer take its turn !!", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.btn8:
                if(idArray[2][1]!=0 && timerOn==false) {
                    idArray[2][1] = 0;
                    setallView(2, 1, b8);
                }
                else {
                    Toast.makeText(this, "Let Computer take its turn !!", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.btn9:
                if(idArray[2][2]!=0 && timerOn==false) {
                    idArray[2][2] = 0;
                    setallView(2, 2, b9);
                }
                else {
                    Toast.makeText(this, "Let Computer take its turn !!", Toast.LENGTH_SHORT).show();
                }

        }
    }

    /**
     * This is a great Idea. Here we Do all tasks at once. Note this.
     * @param i
     * @param j
     * @param b THis is again very Important way.MUST NOTE
     */
    public void setallView(int i, int j, Button b) {
        if(matrix[i][j]=='0' && win==false)
        {
            clicks+=2;
            matrix[i][j]='X';
            checkWin(i,j);
            b.setText("X");
//            Log.i("cliked a btn", "----------------------------------------------------\n"+"click:" + clicks+"i j: "+i+" "+j+" matrix contains: "+matrix[i][j]+" Win: "+win);
//            Log.i("clicks record", "setallView: MATRIX On Players turn:\n"+matrix[0][0]+matrix[0][1]+matrix[0][2]+"\n"+matrix[1][0]+matrix[1][1]+matrix[1][2]+"\n"+matrix[2][0]+matrix[2][1]+matrix[2][2]);
            if(win==false)
            {
                if(clicks!=10) {
                    turnText.setText("Computer's Turn -- Waiting for Comp...");
                    turnSymbol.setText("O");

//                checkWin(i,j);
//                if(win==false)
//                {

                    /**
                     * NOTE THIS and Learn!!!
                     */
                    timerOn=true;
                    delay.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Random rand = new Random();
                            while (true) {
                                int randI = rand.nextInt(3);
                                int randJ = rand.nextInt(3);
//                                Log.i("COMP PLAY", "randi and randj" + randI + " " + randJ + " Btn ID: " + idArray[randI][randJ] + " click:" + clicks + " matrix contains: " + matrix[i][j]);

                                if (idArray[randI][randJ] != 0) {
//                                    Log.i("COMP PLAY", "BTN ID FINAL: " + idArray[randI][randJ] + " matrix contains: " + matrix[i][j]);

                                    compBtn = (Button) findViewById(idArray[randI][randJ]);
                                    matrix[randI][randJ] = 'O';
//                                    Log.i("clicks record", "setallView: MATRIX On Computers turn:\n" + matrix[0][0] + matrix[0][1] + matrix[0][2] + "\n" + matrix[1][0] + matrix[1][1] + matrix[1][2] + "\n" + matrix[2][0] + matrix[2][1] + matrix[2][2]);
                                    checkWin(randI, randJ);
//                                    Log.i("COMP PLAY", " matrix contains: " + matrix[i][j] + " Win: " + win);
//                                    Log.i("aasd", "timerON: "+timerOn);
                                    compBtn.setText("O");
                                    idArray[randI][randJ] = 0;
                                    if (win == true) {
                                        oWinCount++;
                                        oScore.setText("O: " + oWinCount);
                                        Toast.makeText(Single.this, "!! Computer WON -- O !!", Toast.LENGTH_SHORT).show();
                                    } else {
                                        turnText.setText("Player's Turn");
                                        turnSymbol.setText("X");
                                    }

                                    timerOn=false;
//                                    Log.i("aasd", "timerON: "+timerOn);
                                    break;
                                }
                            }
                        }
                    }, 2000);
                }
//}
            }
            else
            {
                xWinCount++;
                xScore.setText("X: "+xWinCount);
                Toast.makeText(this, "!! Player WON -- X !!", Toast.LENGTH_SHORT).show();
            }
//            Log.i("cliked odd", "onClick: Print X, click:" + clicks+" matrix contains: "+matrix[i][j]);
        }
        if(clicks==10 && win==false) {
            drawCount++;
            draw.setText("Draw: "+drawCount);
            Toast.makeText(this, "!! Match DRAW !!", Toast.LENGTH_SHORT).show();
        }
    }

    public void checkWin(int i, int j) {
        if(i==0)
        {
            if(j==0)
            {
                if(left(i,j) || up(i,j) || diagBack(i,j))
                {
                    win=true;

                    if(left(i, j))
                    {
                        b1.setBackgroundColor(Color.GREEN);
                        b4.setBackgroundColor(Color.GREEN);
                        b7.setBackgroundColor(Color.GREEN);
                    }
                    if(up(i, j))
                    {
                        b1.setBackgroundColor(Color.GREEN);
                        b2.setBackgroundColor(Color.GREEN);
                        b3.setBackgroundColor(Color.GREEN);
                    }
                    if(diagBack(i, j))
                    {
                        b1.setBackgroundColor(Color.GREEN);
                        b5.setBackgroundColor(Color.GREEN);
                        b9.setBackgroundColor(Color.GREEN);
                    }
                }

            }

            else if(j==1)
            {
                if(up(i,j) || middleVertical(i,j))
                {
                    win=true;

                    if(middleVertical(i, j))
                    {
                        b2.setBackgroundColor(Color.GREEN);
                        b5.setBackgroundColor(Color.GREEN);
                        b8.setBackgroundColor(Color.GREEN);
                    }
                    if(up(i, j))
                    {
                        b1.setBackgroundColor(Color.GREEN);
                        b2.setBackgroundColor(Color.GREEN);
                        b3.setBackgroundColor(Color.GREEN);
                    }
                }
            }

            else
            {
                if(up(i,j) || diagFront(i,j) || right(i,j))
                {
                    win=true;

                    if(up(i, j))
                    {
                        b1.setBackgroundColor(Color.GREEN);
                        b2.setBackgroundColor(Color.GREEN);
                        b3.setBackgroundColor(Color.GREEN);
                    }
                    if(diagFront(i, j))
                    {
                        b3.setBackgroundColor(Color.GREEN);
                        b5.setBackgroundColor(Color.GREEN);
                        b7.setBackgroundColor(Color.GREEN);
                    }
                    if(right(i, j))
                    {
                        b3.setBackgroundColor(Color.GREEN);
                        b6.setBackgroundColor(Color.GREEN);
                        b9.setBackgroundColor(Color.GREEN);
                    }
                }
            }
        }

        else if(i==1)
        {
            if(j==0)
            {
                if(left(i,j) || middleHorizontal(i,j))
                {
                    win=true;

                    if(left(i, j))
                    {
                        b1.setBackgroundColor(Color.GREEN);
                        b4.setBackgroundColor(Color.GREEN);
                        b7.setBackgroundColor(Color.GREEN);
                    }
                    if(middleHorizontal(i, j))
                    {
                        b5.setBackgroundColor(Color.GREEN);
                        b4.setBackgroundColor(Color.GREEN);
                        b6.setBackgroundColor(Color.GREEN);
                    }
                }
            }

            else if(j==1)
            {
                if(diagBack(i,j) || diagFront(i,j) || middleHorizontal(i,j) || middleVertical(i,j))
                {
                    win=true;
                    if(diagBack(i, j))
                    {
                        b1.setBackgroundColor(Color.GREEN);
                        b5.setBackgroundColor(Color.GREEN);
                        b9.setBackgroundColor(Color.GREEN);
                    }
                    if(diagFront(i, j))
                    {
                        b3.setBackgroundColor(Color.GREEN);
                        b5.setBackgroundColor(Color.GREEN);
                        b7.setBackgroundColor(Color.GREEN);
                    }
                    if(middleHorizontal(i, j))
                    {
                        b5.setBackgroundColor(Color.GREEN);
                        b4.setBackgroundColor(Color.GREEN);
                        b6.setBackgroundColor(Color.GREEN);
                    }
                    if(middleVertical(i, j))
                    {
                        b2.setBackgroundColor(Color.GREEN);
                        b5.setBackgroundColor(Color.GREEN);
                        b8.setBackgroundColor(Color.GREEN);
                    }
                }
            }

            else
            {
                if(right(i,j) || middleHorizontal(i, j))
                {
                    win=true;

                    if(right(i, j))
                    {
                        b3.setBackgroundColor(Color.GREEN);
                        b6.setBackgroundColor(Color.GREEN);
                        b9.setBackgroundColor(Color.GREEN);
                    }
                    if(middleHorizontal(i, j))
                    {
                        b5.setBackgroundColor(Color.GREEN);
                        b4.setBackgroundColor(Color.GREEN);
                        b6.setBackgroundColor(Color.GREEN);
                    }
                }
            }
        }

        else
        {
            if(j==0)
            {
                if(left(i,j) || down(i,j) || diagFront(i,j))
                {
                    win=true;

                    if(left(i, j))
                    {
                        b1.setBackgroundColor(Color.GREEN);
                        b4.setBackgroundColor(Color.GREEN);
                        b7.setBackgroundColor(Color.GREEN);
                    }
                    if(down(i, j))
                    {
                        b8.setBackgroundColor(Color.GREEN);
                        b9.setBackgroundColor(Color.GREEN);
                        b7.setBackgroundColor(Color.GREEN);
                    }
                    if(diagFront(i, j))
                    {
                        b3.setBackgroundColor(Color.GREEN);
                        b5.setBackgroundColor(Color.GREEN);
                        b7.setBackgroundColor(Color.GREEN);
                    }
                }
            }

            else if(j==1)
            {
                if(down(i, j) || middleVertical(i, j))
                {
                    win=true;

                    if(down(i, j))
                    {
                        b8.setBackgroundColor(Color.GREEN);
                        b9.setBackgroundColor(Color.GREEN);
                        b7.setBackgroundColor(Color.GREEN);
                    }
                    if(middleVertical(i, j))
                    {
                        b2.setBackgroundColor(Color.GREEN);
                        b5.setBackgroundColor(Color.GREEN);
                        b8.setBackgroundColor(Color.GREEN);
                    }
                }
            }

            else
            {
                if(right(i,j) || down(i,j) || diagBack(i,j))
                {
                    win=true;

                    if(down(i, j))
                    {
                        b8.setBackgroundColor(Color.GREEN);
                        b9.setBackgroundColor(Color.GREEN);
                        b7.setBackgroundColor(Color.GREEN);
                    }
                    if(right(i, j))
                    {
                        b3.setBackgroundColor(Color.GREEN);
                        b9.setBackgroundColor(Color.GREEN);
                        b6.setBackgroundColor(Color.GREEN);
                    }
                    if(diagBack(i, j))
                    {
                        b1.setBackgroundColor(Color.GREEN);
                        b9.setBackgroundColor(Color.GREEN);
                        b5.setBackgroundColor(Color.GREEN);
                    }
                }
            }
        }
    }

    public boolean up(int i, int j) {
        return matrix[0][0] == matrix[0][1] && matrix[0][1] == matrix[0][2]; //Cool way!! :)
    }

    public boolean left(int i, int j) {
        return matrix[0][0] == matrix[1][0] && matrix[1][0] == matrix[2][0];
    }

    public boolean down(int i, int j) {
        return matrix[2][0] == matrix[2][1] && matrix[2][1] == matrix[2][2];
    }

    public boolean right(int i, int j) {
        return matrix[2][2] == matrix[1][2] && matrix[1][2] == matrix[0][2];
    }

    public boolean middleVertical(int i, int j) {
        return matrix[1][1] == matrix[0][1] && matrix[0][1] == matrix[2][1];
    }

    public boolean middleHorizontal(int i, int j) {
        return matrix[1][0] == matrix[1][1] && matrix[1][1] == matrix[1][2];
    }

    public boolean diagFront(int i, int j) {
        return matrix[2][0] == matrix[1][1] && matrix[1][1] == matrix[0][2];
    }

    public boolean diagBack(int i, int j) {
        return matrix[0][0] == matrix[1][1] && matrix[1][1] == matrix[2][2];
    }




}