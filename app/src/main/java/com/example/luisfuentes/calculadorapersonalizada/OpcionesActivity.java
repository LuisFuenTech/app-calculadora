package com.example.luisfuentes.calculadorapersonalizada;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class OpcionesActivity extends AppCompatActivity {

    private EditText numeroUno, numeroDos;
    private TextView muestraNombre;
    private RadioButton suma, resta, multiplica, divide;
    private String recibido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opciones);

        numeroUno = (EditText) findViewById(R.id.numUnoText);
        numeroDos = (EditText) findViewById(R.id.numDosText);
        muestraNombre = (TextView) findViewById(R.id.muestraNombreText);
        suma = (RadioButton) findViewById(R.id.sumaRadioButton);
        resta = (RadioButton) findViewById(R.id.restaRadioButton);
        multiplica = (RadioButton) findViewById(R.id.multiplicaRadioButton);
        divide = (RadioButton) findViewById(R.id.divideRadioButton);

        recibido = getIntent().getStringExtra("nombre");
        String valorUno = getIntent().getStringExtra("valorUno");
        String valorDos = getIntent().getStringExtra("valorDos");
        numeroUno.setText(valorUno);
        numeroDos.setText(valorDos);
        muestraNombre.setText("Bienvenid@ "+recibido);
    }

    public void calcular(View view)
    {
        if(!numeroUno.getText().toString().equals("") && !numeroDos.getText().toString().equals(""))
        {
            int valorUno = Integer.parseInt(numeroUno.getText().toString()),
                    valorDos = Integer.parseInt(numeroDos.getText().toString());
            Intent resultado = new Intent(this, ResultadoActivity.class);

            if(suma.isChecked())
            {
                resultado.putExtra("resultado", String.valueOf( valorUno+valorDos ));
                resultado.putExtra("nombre", recibido);
                resultado.putExtra("valorUno", numeroUno.getText().toString());
                resultado.putExtra("valorDos", numeroDos.getText().toString());
                startActivity(resultado);
            }
            else if(resta.isChecked())
            {
                resultado.putExtra("resultado", String.valueOf( valorUno-valorDos ));
                resultado.putExtra("nombre", recibido);
                resultado.putExtra("valorUno", numeroUno.getText().toString());
                resultado.putExtra("valorDos", numeroDos.getText().toString());
                startActivity(resultado);
            }
            else if(multiplica.isChecked())
            {
                resultado.putExtra("resultado", String.valueOf( valorUno*valorDos ));
                resultado.putExtra("nombre", recibido);
                resultado.putExtra("valorUno", numeroUno.getText().toString());
                resultado.putExtra("valorDos", numeroDos.getText().toString());
                startActivity(resultado);
            }
            else if(divide.isChecked())
            {
                if(!numeroDos.getText().toString().equals("0"))
                {
                    resultado.putExtra("resultado", String.valueOf( valorUno/valorDos ));
                    resultado.putExtra("nombre", recibido);
                    resultado.putExtra("valorUno", numeroUno.getText().toString());
                    resultado.putExtra("valorDos", numeroDos.getText().toString());
                    startActivity(resultado);
                }
                else
                    Toast.makeText(this, "No puedes dividir entre 0",
                                    Toast.LENGTH_SHORT).show();
            }
        }
        else
            Toast.makeText(this, "Llene los campos", Toast.LENGTH_SHORT).show();
    }

    public void limpiar(View view)
    {
        numeroUno.setText("");
        numeroDos.setText("");
    }
}
