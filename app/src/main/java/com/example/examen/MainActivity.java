package com.example.examen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.CalendarView;

public class MainActivity extends AppCompatActivity implements CalendarView.OnDateChangeListener{
    private CalendarView calendarView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calendarView=(CalendarView) findViewById(R.id.calendarView);
    }

    @Override
    public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        CharSequence[]items= new CharSequence[3];
        items[0]="Agregar evento";
        items[1]="Ver Evento";
        items[2]="Cancelar";

        final int dia,mes,anio;
        dia=i;
        mes=i1+1;
        anio=i2;

        builder.setTitle("Seleccione una tarea")
                .setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (i == 0) {
                            Intent intent=new Intent(getApplication(),MainActivity.class);
                            Bundle bundle=new Bundle();
                            bundle.putInt("dia",dia);
                            bundle.putInt("mes",mes);
                            bundle.putInt("anio",anio);
                            intent.putExtras(bundle);
                            startActivity(intent);
                        } else if (i == 1) {
                            Intent intent=new Intent(getApplication(),Ventana3.class);
                            Bundle bundle=new Bundle();
                            bundle.putInt("dia",dia);
                            bundle.putInt("mes",mes);
                            bundle.putInt("anio",anio);
                            intent.putExtras(bundle);
                            startActivity(intent);

                        } else {
                            return;
                        }
                    }
                });

        AlertDialog dialog = builder.create();
        dialog.show();

    }
}