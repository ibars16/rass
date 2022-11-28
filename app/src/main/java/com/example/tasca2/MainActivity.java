
package com.example.tasca2;

        import static android.provider.AlarmClock.EXTRA_MESSAGE;

        import android.annotation.SuppressLint;
        import android.app.NotificationChannel;
        import android.app.NotificationManager;
        import android.content.Intent;
        import android.os.Build;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;

        import androidx.appcompat.app.AppCompatActivity;
        import androidx.core.app.NotificationCompat;
        import androidx.core.app.NotificationManagerCompat;

public class MainActivity  extends AppCompatActivity {
    private static final String CHANNEL_ID = "0";
    private Button crearIncidencia;
    private Button llistarIncidencia;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

        crearIncidencia = (Button) findViewById(R.id.button3);
        llistarIncidencia = (Button) findViewById(R.id.button7);


        createNotificationChannel();



        this.crearIncidencia.setOnClickListener(
                new View.OnClickListener()
                {
                    public void onClick(View view) {
                        lanzarAltaIncidencia(null);
                    }
                });

//        this.llistarIncidencia.setOnClickListener(
//                new View.OnClickListener()
//                {
//                    public void onClick(View view) {
//                        lanzarListarIncidencia(null);
//                    }
//                });
    }

    public void lanzarAltaIncidencia(View view) {
        Intent i = new Intent(this, MenuActivity.class);
        startActivity(i);
    }

    public void lanzarListarIncidencia(View view) {
        Intent i = new Intent(this, CreateIncidencia.class);
        startActivity(i);
    }

    private void createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = getString(R.string.channel_name);
            String description = getString(R.string.channel_description);
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }

}
