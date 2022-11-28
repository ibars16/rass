package com.example.tasca2;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GestorBDIncidencia extends SQLiteOpenHelper {
    private static final String KEY_ID = "id_incidencia";
    private static final String KEY_NOMBRE = "nombre";

    public GestorBDIncidencia(Context context) {
        super(context, "incidencias", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE incidencia ("
                + "id_incidencia INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "nombre TEXT," +
                "descripcio TEXT," +
                "element TEXT," +
                "tipus TEXT," +
                "ubicacio TEXT," +
                "date DATETIME)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void cargarIncidencias() {
        guardarIncidencia("primera");
    }

    private void guardarIncidencia(String nombre) {
        SQLiteDatabase db = getWritableDatabase();
        guardarIncidencias(db, nombre);
    }

    private void guardarIncidencias(SQLiteDatabase db, String nombre) {
        ContentValues cv = new ContentValues();
        cv.put("nombre", nombre);
        db.insertOrThrow("incidencia", null, cv);
    }

    @SuppressLint("Range")
    public List<Incidencia> getIncidencias(){
        SQLiteDatabase db = getWritableDatabase();
        HashMap<String, Incidencia>  incidenciaList = new HashMap<>();
        Cursor cursor = db.rawQuery("SELECT * FROM incidencia ORDER BY id_incidencia" ,null);

        while (cursor.moveToNext()){
            Incidencia incidencia = new Incidencia(cursor.getString(cursor.getColumnIndex(KEY_ID)), cursor.getString(cursor.getColumnIndex(KEY_NOMBRE)));
            incidenciaList.put(incidencia.getId_incidencia(),incidencia);
        }

        return new ArrayList<>(incidenciaList.values());
    }

    public void createIncidencia(String nombre, String descripcion, String element, String tipus, String ubicacio){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("nombre", nombre);
        cv.put("descripcio", descripcion);
        cv.put("element", element);
        cv.put("tipus", tipus);
        cv.put("ubicacio", ubicacio);
        db.insertOrThrow("incidencia", null, cv);
    }
}
