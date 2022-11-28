package com.example.tasca2;

        import android.annotation.SuppressLint;
        import android.content.Context;
        import android.content.Intent;
        import android.database.Cursor;
        import android.os.Bundle;

        import com.google.android.material.snackbar.Snackbar;

        import androidx.appcompat.app.AppCompatActivity;

        import android.view.View;

        import androidx.core.app.NotificationCompat;
        import androidx.core.app.NotificationManagerCompat;
        import androidx.navigation.NavController;
        import androidx.navigation.Navigation;
        import androidx.navigation.ui.AppBarConfiguration;
        import androidx.navigation.ui.NavigationUI;


        import android.view.Menu;
        import android.view.MenuItem;
        import android.widget.ArrayAdapter;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.ListAdapter;
        import android.widget.ListView;
        import android.widget.SimpleAdapter;
        import android.widget.Spinner;

        import java.util.ArrayList;
        import java.util.HashMap;
        import java.util.List;
        import java.util.Map;

public class CreateIncidencia extends AppCompatActivity {
    String[] types = {"Breu","Mitjana", "Alta"};
    Spinner typeSpinner;

    public GestorBDIncidencia gbdRest = new GestorBDIncidencia(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.siuu);

        List<Incidencia> incidencias = gbdRest.getIncidencias();
        ListView incidenciasMostrar =  (ListView)findViewById(R.id.list);


        IncidenciasAdapter incidenciasAdapter = new IncidenciasAdapter(CreateIncidencia.this, incidencias);
        incidenciasMostrar.setAdapter(incidenciasAdapter);

    }
        private void typeSpinner(){
        this.typeSpinner = (Spinner)findViewById(R.id.typeSpinner);
        ArrayAdapter arrayAdapter = new ArrayAdapter<String>(CreateIncidencia.this, android.R.layout.simple_spinner_item, this.types);
        this.typeSpinner.setAdapter(arrayAdapter);
    }


}
