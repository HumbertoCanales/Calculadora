package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView pantalla;
    String digito, secuencia, memoria, operador;
    Double val_1, val_2, resultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pantalla = (TextView)findViewById(R.id.RES);
    }

    public void miClick(View view) {
        if(operador!=""){
            pantalla.setText(secuencia);
        }
        Button btn = (Button)view;
        digito = btn.getText().toString();
        secuencia = pantalla.getText().toString();
        secuencia +=digito;
        pantalla.setText(secuencia);
    }

    public void operador(View view) {
        memoria = secuencia;
        switch (view.getId()){
            case R.id.p:
                operador = "+";
                secuencia = "";
                break;
            case R.id.m:
                operador = "-";
                secuencia = "";

                break;
            case R.id.MP:
                operador = "*";
                secuencia = "";

                break;
            case R.id.DIV:
                operador = "/";
                secuencia = "";
                break;
        }
    }
    public void obtenerRes(View view){
        val_1 = Double.parseDouble(memoria);
        val_2 = Double.parseDouble(secuencia);
        switch (operador){
            case "+":
                resultado = val_1 + val_2;
                pantalla.setText(resultado.toString());
                break;
            case "-":
                resultado = val_1 - val_2;
                pantalla.setText(resultado.toString());

                break;
            case "*":
                resultado = val_1 * val_2;
                pantalla.setText(resultado.toString());

                break;
            case "/":
                resultado = val_1 / val_2;
                pantalla.setText(resultado.toString());

                break;
            default:
                pantalla.setText(secuencia);
                break;
        }
        operador = "";
        secuencia = pantalla.getText().toString();
    }
    public void borrar(View view) {
        pantalla.setText("");
        secuencia = "";
        memoria = "";
        operador = "";
    }
}