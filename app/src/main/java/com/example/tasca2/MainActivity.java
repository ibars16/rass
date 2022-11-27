
package com.example.tasca2;

        import static android.provider.AlarmClock.EXTRA_MESSAGE;

        import android.annotation.SuppressLint;
        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;

        import androidx.appcompat.app.AppCompatActivity;

public class MainActivity  extends AppCompatActivity {
    private Button crearIncidencia;
    private Button llistarIncidencia;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

        crearIncidencia = (Button) findViewById(R.id.button3);
        llistarIncidencia = (Button) findViewById(R.id.button7);


        this.crearIncidencia.setOnClickListener(
                new View.OnClickListener()
                {
                    public void onClick(View view) {
                        lanzarAltaIncidencia(null);
                    }
                });

        this.llistarIncidencia.setOnClickListener(
                new View.OnClickListener()
                {
                    public void onClick(View view) {
                        lanzarListarIncidencia(null);
                    }
                });
    }

    public void lanzarAltaIncidencia(View view) {
        Intent i = new Intent(this, MenuActivity.class);
        startActivity(i);
    }

    public void lanzarListarIncidencia(View view) {
        Intent i = new Intent(this, CreateIncidencia.class);
        startActivity(i);
    }

}
