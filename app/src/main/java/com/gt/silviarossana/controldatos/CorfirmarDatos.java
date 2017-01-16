package com.gt.silviarossana.controldatos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class CorfirmarDatos extends AppCompatActivity {

    private TextView tvNombre;
    private TextView tvFecha;
    private TextView tvTelefono;
    private TextView tvEmail;
    private TextView tvDescripcion;

    private int dia;
    private int mes;
    private int anio;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_corfirmar_datos);

        this.cargarDatosConfirmar();
    }

    /**
     * Cargar parametros enviados
     */
    private void cargarDatosConfirmar(){

        Bundle parametro = getIntent().getExtras();

        tvNombre = (TextView) findViewById(R.id.tvNombre);
        tvNombre.setText(parametro.getString(getResources().getString(R.string.hint_nombre)));

            dia = parametro.getInt(getResources().getString(R.string.fecha_dia));
            mes = parametro.getInt(getResources().getString(R.string.fecha_mes));
            anio = parametro.getInt(getResources().getString(R.string.fecha_anio));

        tvFecha = (TextView) findViewById(R.id.tvFechaNacimiento);
        tvFecha.setText(dia + "/" + (mes + 1) + "/" + anio);

        tvTelefono = (TextView) findViewById(R.id.tvTelefono);
        tvTelefono.setText(parametro.getString(getResources().getString(R.string.hint_telefono)));

        tvEmail = (TextView) findViewById(R.id.tvEmail);
        tvEmail.setText(parametro.getString(getResources().getString(R.string.hint_email)));

        tvDescripcion = (TextView) findViewById(R.id.tvDescripcion);
        tvDescripcion.setText(parametro.getString(getResources().getString(R.string.hint_descripcion)));
    }

    /**
     *
     * @param v
     */
    public void btnClickEditarDatos(View v){

        Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra(getResources().getString(R.string.hint_nombre), tvNombre.getText().toString());
            intent.putExtra(getResources().getString(R.string.hint_telefono), tvTelefono.getText().toString());
            intent.putExtra(getResources().getString(R.string.hint_email), tvEmail.getText().toString());
            intent.putExtra(getResources().getString(R.string.hint_descripcion), tvDescripcion.getText().toString());

            intent.putExtra(getResources().getString(R.string.fecha_dia), dia);
            intent.putExtra(getResources().getString(R.string.fecha_mes), mes);
            intent.putExtra(getResources().getString(R.string.fecha_anio), anio);

        startActivity(intent);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //return super.onKeyDown(keyCode, event);
        if (keyCode == KeyEvent.KEYCODE_BACK){
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }

        return super.onKeyDown(keyCode, event);
    }
}
