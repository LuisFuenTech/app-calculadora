package com.example.luisfuentes.calculadorapersonalizada;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ResultadoActivity extends AppCompatActivity {

    private TextView verResultado;
    private String nombre, valorUno, valorDos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        verResultado = (TextView) findViewById(R.id.resultadoText);
        String recibido = getIntent().getStringExtra("resultado");
        nombre = getIntent().getStringExtra("nombre");
        valorUno = getIntent().getStringExtra("valorUno");
        valorDos = getIntent().getStringExtra("valorDos");
        verResultado.setText("Resultado: "+recibido);
    }

    public void regresar(View view)
    {
        Intent regresar = new Intent(this, OpcionesActivity.class);
        regresar.putExtra("nombre", nombre);
        regresar.putExtra("valorUno", valorUno);
        regresar.putExtra("valorDos", valorDos);
        startActivity(regresar);
    }
}
