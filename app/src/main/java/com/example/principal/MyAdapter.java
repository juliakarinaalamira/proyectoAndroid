package com.example.principal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<DataInfo> list;
    public MyAdapter(Context context, ArrayList<DataInfo> list){
        this.context = context;
        this.list = list;

     }
    @Override
    public int getCount() {
        return this.list.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null){
            LayoutInflater inflate = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView =inflate.inflate(R.layout.item, null);
        }
        ImageView img =  convertView.findViewById(R.id.img);
        TextView des =   convertView.findViewById(R.id.descripcion);
        TextView title = convertView.findViewById(R.id.title);
        img.setImageResource(this.list.get(position).getImg());
        des.setText(this.list.get(position).getDescripcion());
        title.setText(this.list.get(position).getTitle());
        return convertView;
    }

}
