package com.example.hexgame;

public class SizeItem {
    private int mSize;
    private int mFlagImage;

    public SizeItem(int size,int flagImage){
        mSize=size;
        mFlagImage=flagImage;
    }

    public int getSize() {
        return mSize;
    }
    public int getFlagImage(){
        return mFlagImage;
    }
}
