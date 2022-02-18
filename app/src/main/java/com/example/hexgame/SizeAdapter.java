package com.example.hexgame;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class SizeAdapter extends ArrayAdapter<SizeItem> {
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position,convertView,parent);
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position,convertView,parent);
    }

    public SizeAdapter(Context context, ArrayList<SizeItem> sizeList){
        super(context,0,sizeList);

    }
    private View initView(int position, View convertView,ViewGroup parent){
        if (convertView==null){
            convertView= LayoutInflater.from(getContext()).inflate(R.layout.size_spinner,parent,false);
        }
        ImageView imageViewFlag=convertView.findViewById(R.id.imageViewFlag);
        SizeItem curItem = getItem(position);
        if (curItem!=null) {
            imageViewFlag.setImageResource(curItem.getFlagImage());
        }
        return convertView;
    }
}
