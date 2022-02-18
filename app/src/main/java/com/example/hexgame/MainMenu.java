package com.example.hexgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainMenu extends AppCompatActivity {
    private ImageButton playButton;
    private ArrayList<SizeItem> sizeList;
    private SizeAdapter sizeAdapter;
    private int size;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main_menu);
        initList();
        Spinner sizeSpinners = findViewById(R.id.customSpinner);
        sizeAdapter = new SizeAdapter(this,sizeList);
        sizeSpinners.setAdapter(sizeAdapter);

        sizeSpinners.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                SizeItem clickedItem=(SizeItem) parent.getItemAtPosition(position);
                size = clickedItem.getSize();
                String str = String.valueOf(size);
                Toast.makeText(MainMenu.this,str,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        /*Spinner sizeSpinner = findViewById(R.id.sizeSpinner);
        ArrayAdapter<String> sizeAdapter =new ArrayAdapter<String>(MainMenu.this, android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.sizes));
        sizeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sizeSpinner.setAdapter(sizeAdapter);*/
        playButton=findViewById(R.id.playButton);
        Intent intent = new Intent(this,GameScreen.class);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("SIZE",size);
                startActivity(intent);
            }
        });
    }
    private void initList(){
        sizeList=new ArrayList<>();
        sizeList.add(new SizeItem(6,R.drawable._6x6));
        sizeList.add(new SizeItem(7,R.drawable._7x7));
        sizeList.add(new SizeItem(8,R.drawable._8x8));
        sizeList.add(new SizeItem(9,R.drawable._9x9));
        sizeList.add(new SizeItem(10,R.drawable._10x10));
        sizeList.add(new SizeItem(11,R.drawable._11x11));
        sizeList.add(new SizeItem(12,R.drawable._12x12));
    }
}