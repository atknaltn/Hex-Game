package com.example.hexgame;

import android.content.Context;
import android.widget.ImageButton;
import android.widget.ImageView;

public class HexButton extends androidx.appcompat.widget.AppCompatImageButton {
    private int row;
    private int column;
    public HexButton(Context context){
        super(context);
    }
    public HexButton(Context context,int row,int column){
        super(context);
        this.row=row;
        this.column=column;
    }

    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public void setRow(int row) {
        this.row = row;
    }
}
