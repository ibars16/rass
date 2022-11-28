package com.example.tasca2;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.DialogFragment;

import java.sql.Connection;
import java.util.List;

public class MenuActivity extends AppCompatActivity  implements DatePickerDialog.OnDateSetListener {

    Button saveIncidence;
    Button dateButton;
    Button dayButton;
    EditText nameEditText;
    Spinner elementSpinner;
    Spinner typeSpinner;
    Spinner ubicationSpinner;
    EditText descriptionEditText;
    String[] elements = {"Ratoli","Altaveu", "Teclat"};
    String[] types = {"Breu","Mitjana", "Alta"};
    String[] ubications = {"Clase 1DAM","Clase 2DAM", "Sala reunions"};
    public GestorBDIncidencia gbdRest = new GestorBDIncidencia(this);

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_incidencia);

        this.elementSpinner();
        this.typeSpinner();
        this.ubicationSpinner();

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, String.valueOf(0))
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("textTitle")
                .setContentText("textContent")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        saveIncidence = (Button) findViewById(R.id.button2);
        dateButton = (Button) findViewById(R.id.datee);
        dayButton = (Button) findViewById(R.id.dateday);
        nameEditText = (EditText) findViewById(R.id.nameInput);
        descriptionEditText = (EditText) findViewById(R.id.descriptionInput);
        List<Incidencia> incidencias = gbdRest.getIncidencias();

        Connection con = null;

        this.saveIncidence.setOnClickListener(
                new View.OnClickListener()
                {
                    public void onClick(View view) {
                        String name = String.valueOf(nameEditText.getText());
                        String description = String.valueOf(descriptionEditText.getText());
                        String elementName = elementSpinner.getSelectedItem().toString();
                        String typeName = typeSpinner.getSelectedItem().toString();
                        String ubicationName = ubicationSpinner.getSelectedItem().toString();
                        gbdRest.createIncidencia(name, description, elementName, typeName, ubicationName);
                        notificationManager.notify(0, builder.build());
                    }
                });
        this.dateButton.setOnClickListener(
                new View.OnClickListener()
                {
                    public void onClick(View view) {
                        DialogFragment newFragment = new SelectDateFragment();
                        newFragment.show(getSupportFragmentManager(), "timePicker");

                    }
                });
        this.dayButton.setOnClickListener(
                new View.OnClickListener()
                {
                    public void onClick(View view) {
                        DialogFragment newFragment = new DatePickerFragmentDay();
                        newFragment.show(getSupportFragmentManager(), "datePicker");


                    }
                });
    }

    private void elementSpinner(){
        this.elementSpinner = (Spinner)findViewById(R.id.elementSpinner);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, this.elements);
        this.elementSpinner.setAdapter(arrayAdapter);
    }
    private void typeSpinner(){
        this.typeSpinner = (Spinner)findViewById(R.id.typeSpinner);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, this.types);
        this.typeSpinner.setAdapter(arrayAdapter);
    }
    private void ubicationSpinner(){
        this.ubicationSpinner = (Spinner)findViewById(R.id.ubicationSpinner);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, this.ubications);
        this.ubicationSpinner.setAdapter(arrayAdapter);
    }

    @Override
    public void onDateSet(DatePicker view, int yy, int mm, int dd) {
        String a = "a";
    }
}
