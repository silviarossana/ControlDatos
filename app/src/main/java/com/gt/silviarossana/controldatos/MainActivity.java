package com.gt.silviarossana.controldatos;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private EditText etNombre;
    private EditText etTelefono;
    private EditText etEmail;
    private EditText etDescripcion;
    private DatePicker dpFechaNacimiento;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Si es la edición de datos.
        Bundle parametro = getIntent().getExtras();
        if(parametro != null){
            this.editarDatos(parametro);
        }
    }

    private void editarDatos(Bundle parametro){

        etNombre = (EditText) findViewById(R.id.etNombre);
        etNombre.setText(parametro.getString(getResources().getString(R.string.hint_nombre)));

        etTelefono = (EditText) findViewById(R.id.etTelefono);
        etTelefono.setText(parametro.getString(getResources().getString(R.string.hint_telefono)));

        etEmail = (EditText) findViewById(R.id.etMail);
        etEmail.setText(parametro.getString(getResources().getString(R.string.hint_email)));

        etDescripcion = (EditText) findViewById(R.id.etDescripcion);
        etDescripcion.setText(parametro.getString(getResources().getString(R.string.hint_descripcion)));

        dpFechaNacimiento = (DatePicker)  findViewById(R.id.dpFechaNacimiento);
        dpFechaNacimiento.updateDate(parametro.getInt(getResources().getString(R.string.fecha_anio)),
                                    parametro.getInt(getResources().getString(R.string.fecha_mes)),
                                    parametro.getInt(getResources().getString(R.string.fecha_dia)));
    }

    public void btnClickEnviarDatos(View v){

        etNombre = (EditText) findViewById(R.id.etNombre);
        etTelefono = (EditText) findViewById(R.id.etTelefono);
        etEmail = (EditText) findViewById(R.id.etMail);
        etDescripcion = (EditText) findViewById(R.id.etDescripcion);
        dpFechaNacimiento = (DatePicker) findViewById(R.id.dpFechaNacimiento);

        Intent intent = new Intent(MainActivity.this, CorfirmarDatos.class);
            intent.putExtra(getResources().getString(R.string.hint_nombre), etNombre.getText().toString());
            intent.putExtra(getResources().getString(R.string.hint_telefono), etTelefono.getText().toString());
            intent.putExtra(getResources().getString(R.string.hint_email), etEmail.getText().toString());
            intent.putExtra(getResources().getString(R.string.hint_descripcion), etDescripcion.getText().toString());
            intent.putExtra(getResources().getString(R.string.hint_fecha),
                    dpFechaNacimiento.getDayOfMonth() + "/" + (dpFechaNacimiento.getMonth() + 1) + "/" + dpFechaNacimiento.getYear());

            intent.putExtra(getResources().getString(R.string.fecha_dia), dpFechaNacimiento.getDayOfMonth());
            intent.putExtra(getResources().getString(R.string.fecha_mes), dpFechaNacimiento.getMonth());
            intent.putExtra(getResources().getString(R.string.fecha_anio), dpFechaNacimiento.getYear());

        startActivity(intent);
    }



}


