package com.example.listadesejo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomListAdapter extends BaseAdapter {
    private Context context; //context
    private ListaCores cores; //data source of the list adapter

    //public constructor
    public CustomListAdapter(Context context, ListaCores cores) {
        this.context = context;
        this.cores = cores;
    }

    @Override
    public int getCount() {
        return cores.count(); //returns total of items in the list
    }

    @Override
    public Object getItem(int position) {
        return cores.get(position); //returns list item at the specified position
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // inflate the layout for each list row
        if (convertView == null) {
            convertView = LayoutInflater.from(context).
                    inflate(R.layout.color_list_item, parent, false);
        }

        // get current item to be displayed
        Cor currentItem = (Cor) getItem(position);

        // get the TextView for item name and item description
        TextView textViewItemName = (TextView)
                convertView.findViewById(R.id.text_view_item_name);
        TextView textViewItemDescription = (TextView)
                convertView.findViewById(R.id.text_view_item_description);

        //sets the text for item name and item description from the current item object
        textViewItemName.setText(currentItem.getNome());
        textViewItemDescription.setText(currentItem.getCodigo());

        // returns the view for the current row
        return convertView;
    }
}