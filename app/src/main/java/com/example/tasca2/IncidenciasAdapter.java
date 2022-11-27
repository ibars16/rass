package com.example.tasca2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.R.layout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class IncidenciasAdapter extends ArrayAdapter<Incidencia> {
    String[] types = {"Breu","Mitjana", "Alta"};
    Spinner typeSpinner;
    private Context mContext;


    public IncidenciasAdapter(Context context, List<Incidencia> objects) {
        super(context, 0, objects);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Obtener inflater.
        LayoutInflater inflater = (LayoutInflater) getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // ¿Existe el view actual?
        if (null == convertView) {
            convertView = inflater.inflate(
                    R.layout.list_row,
                    parent,
                    false);
        }

        View view = convertView;

        this.typeSpinner(convertView);

        // Referencias UI.
        ImageView avatar = (ImageView) convertView.findViewById(R.id.iv_avatar);
        TextView name = (TextView) convertView.findViewById(R.id.nombreIncidencia);
        TextView title = (TextView) convertView.findViewById(R.id.id_incidencia);
        TextView company = (TextView) convertView.findViewById(R.id.tv_company);

        // Lead actual.
        Incidencia lead = getItem(position);

        // Setup.
        title.setText(lead.getId_incidencia());
        name.setText(lead.getNombre());


        return convertView;
    }
    private void typeSpinner(View convertView){
        this.typeSpinner = (Spinner)convertView.findViewById(R.id.spinner);
        ArrayAdapter arrayAdapter = new ArrayAdapter(mContext, android.R.layout.simple_spinner_item, this.types);
        this.typeSpinner.setAdapter(arrayAdapter);
    }
}

