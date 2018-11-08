package com.example.luisfuentes.calculadorapersonalizada;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText campoNombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        campoNombre = (EditText) findViewById(R.id.nombreText);
    }

    public  void aceptar(View view)
    {

        if(!campoNombre.getText().toString().equals(""))
        {
            Intent aceptar = new Intent(this, OpcionesActivity.class);
            aceptar.putExtra("nombre", campoNombre.getText().toString());
            startActivity(aceptar);
        }
        else
            Toast.makeText(this, "Ingrese su nombre", Toast.LENGTH_LONG).show();
    }
}
