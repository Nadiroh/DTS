package com.example.finalproject;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;
import com.example.finalproject.Data;

public class Adapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<Data> items;

    public Adapter(Activity activity,List<Data> items){
        this.activity = activity;
        this.items =items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int location) {
        return items.get(location);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (inflater == null){
            inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if (convertView == null){
            convertView = inflater.inflate(R.layout.listrow,null);
        }

        TextView id = convertView.findViewById(R.id.id);
        TextView listnama = convertView.findViewById(R.id.listNama);
        TextView listalamat = convertView.findViewById(R.id.listAlamat);

        Data data = items.get(position);

        id.setText(data.getId());
        listnama.setText(data.getListnama());
        listalamat.setText(data.getListalamat());

        return convertView;
    }
}
