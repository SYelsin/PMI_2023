package com.example.miprimeraapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.miprimeraapp.configuracion.SQLLiteconexion;
import com.example.miprimeraapp.transacciones.Transacciones;

public class MainActivity extends AppCompatActivity {

    //Global
    EditText nombres, apellidos,correo,edad;
    Button btnagregar;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombres = (EditText) findViewById(R.id.nombre);
        apellidos = (EditText) findViewById(R.id.apellido);
        correo = (EditText) findViewById(R.id.correo);
        edad = (EditText) findViewById(R.id.edad);
        btnagregar = (Button)  findViewById(R.id.btnagregar);

        btnagregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AgregarPersona();
            }
        });

    }

    private void AgregarPersona(){
        try {
            SQLLiteconexion conexion = new SQLLiteconexion(this, Transacciones.NameDatabase, null,1);
            SQLiteDatabase db = conexion.getWritableDatabase();

            ContentValues valores = new ContentValues();
            valores.put("nombres",nombres.getText().toString());
            valores.put("apellidos",apellidos.getText().toString());
            valores.put("correo",correo.getText().toString());
            valores.put("edad",edad.getText().toString());

            Long Resultado = db.insert(Transacciones.tablapersonas, "id",valores);
            Toast.makeText(this,Resultado.toString(),Toast.LENGTH_SHORT).show();

            ClearScreen();
        }
        catch (Exception ex){
            Toast.makeText(this,"No s puede ingresar el dato",Toast.LENGTH_SHORT).show();
        }


    }

    private void ClearScreen(){
        nombres.setText(Transacciones.Empty);
        apellidos.setText(Transacciones.Empty);
        correo.setText(Transacciones.Empty);
        edad.setText(Transacciones.Empty);

    }

    private void MostrarCliente() {
        String mensaje = nombres.getText().toString()+
                "|" +    apellidos.getText().toString()+
                "|" + correo.getText().toString();

        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
    }
}