package com.example.hexgame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class GameScreen extends AppCompatActivity implements View.OnClickListener{
    private int size;
    //private View[][] hexButtons;
    private View[][] hexButtons;
    private int moveCount=0;
    //View[] button1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setSize(getIntent().getIntExtra("SIZE",6));
        System.out.println("Size "+size);
        switch (getSize()){
            case 6:
                setContentView(R.layout.activity_size_6);
                break;
        }
        /*button1 = new View[2];
        button1[0] = new HexButton(this,0,0);
        button1[0]= (ImageView) findViewById(R.id.ImageButton1);
        button1[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button1[0].setBackground(getBaseContext().getResources().getDrawable(R.drawable.hex_green));
                button1[0].setEnabled(false);
            }
        });*/

        int count=1,i,j;
        String buttonID;
        int resourceID;
        hexButtons = new View[size][size];
        for (i = 0; i < size; i++) {
            for (j = 0; j < size; j++) {
                hexButtons[i][j] = new HexButton(this,i,j);
                buttonID = "ImageButton" + count;
                resourceID=getResources().getIdentifier(buttonID,"id",getPackageName());
                hexButtons[i][j]=findViewById(resourceID);
                hexButtons[i][j].setOnClickListener(this);
                count ++ ;
            }
        }
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    @Override
    public void onClick(View v) {
        if (moveCount%2==0)
            ((ImageButton)v).setBackground(getBaseContext().getResources().getDrawable(R.drawable.hex_green));
        else
            ((ImageButton)v).setBackground(getBaseContext().getResources().getDrawable(R.drawable.hex_blue));
        ((ImageButton)v).setEnabled(false);
        moveCount++;
    }
}