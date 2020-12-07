package com.example.a2apruebafernando;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Carrito extends AppCompatActivity {

    Button pagar;
    Producto producto;
    TextView descripcion;
    TextView total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrito);

        pagar = findViewById(R.id.btnPago);

        producto = getIntent().getParcelableExtra("producto");

        descripcion = findViewById(R.id.d2Producto);
        total = findViewById(R.id.Total);

        descripcion.setText(producto.getDescripcion());
        total.setText(String.valueOf(producto.getValor() * producto.getCantidad()));

    }
}

