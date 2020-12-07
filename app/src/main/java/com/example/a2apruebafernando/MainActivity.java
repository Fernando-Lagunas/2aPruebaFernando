package com.example.a2apruebafernando;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button agrCarrito;
    Button comprar;
    EditText cantidad;
    TextView descripcion;
    TextView valor;
    Producto producto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        valor = (TextView) findViewById(R.id.pMemoria);
        descripcion = (TextView) findViewById(R.id.dProducto);
        agrCarrito = (Button) findViewById(R.id.btnAgregar);
        comprar = (Button) findViewById(R.id.btnComprar);
        cantidad = (EditText) findViewById(R.id.etCantidad);
        producto = new Producto(descripcion.getText().toString(), Integer.parseInt(valor.getText().toString()));

        agrCarrito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    producto.setCantidad(producto.getCantidad()+Integer.parseInt(cantidad.getText().toString()));
                    longToast("Artículo agregado al carrito existosamente");
                }catch (Exception ex){
                    longToast("ingrese una cantidad valida");
                }
            }
        });

        comprar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Carrito.class);
                intent.putExtra("producto", producto);
                startActivity(intent);
                producto.setCantidad(0);//al ingresar al al carrito la cantidad total se reinicia a 0;
            }
        });
    }



    private void longToast(String mensaje){
        Toast msg = Toast.makeText(this, mensaje, Toast.LENGTH_LONG);
        msg.show();
    }
}

