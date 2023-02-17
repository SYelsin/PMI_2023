package com.example.miprimeraapp;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.miprimeraapp.configuracion.SQLLiteconexion;
import com.example.miprimeraapp.transacciones.Personas;
import com.example.miprimeraapp.transacciones.Transacciones;

import java.util.ArrayList;

public class activity_combo extends AppCompatActivity {

    SQLLiteconexion conexion;
    Spinner combopersonas;
    EditText txtnombres, txtapellido, txtcodigo;

    ArrayList<Personas> listapersonas;
    ArrayList<String> Arreglopersonas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_combo);

        conexion = new SQLLiteconexion(this, Transacciones.NameDatabase,null,1);
        combopersonas = (Spinner) findViewById(R.id.combopersonas);
        txtnombres = (EditText) findViewById(R.id.txtcbnombres);
        txtapellido = (EditText) findViewById(R.id.txtcbapellido);
        txtcodigo = (EditText) findViewById(R.id.txtcbid);

        ObtenerListaPersonas();

        ArrayAdapter<CharSequence> adp = new ArrayAdapter(this, android.R.layout.simple_spinner_item, Arreglopersonas);
        combopersonas.setAdapter(adp);

        combopersonas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int indice, long id) {
                try {
                    txtnombres.setText(listapersonas.get(indice).getNombres());
                    txtcodigo.setText(listapersonas.get(indice).getId().toString());
                    txtapellido.setText(listapersonas.get(indice).getApellidos());
                }catch (Exception ex){
                    ex.toString();
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }
    private void ObtenerListaPersonas(){
        SQLiteDatabase db = conexion.getReadableDatabase();

        Personas person = null;
        listapersonas = new ArrayList<Personas>();

        //cursor
        Cursor cursor = db.rawQuery("SELECT * FROM personas", null);
        while (cursor.moveToNext()){
            person = new Personas();
            person.setId(cursor.getInt(0));
            person.setNombres(cursor.getString(1));
            person.setApellidos(cursor.getString(2));
            person.setEdad(cursor.getInt(3));
            person.setCorreo(cursor.getString(4));




            listapersonas.add(person);



        }
        cursor.close();
        FillList();
    }

    private void FillList() {
        Arreglopersonas = new ArrayList<String>();
        for (int i = 0; i<listapersonas.size(); i++){
            Arreglopersonas.add(
                    listapersonas.get(i).getId()+"|"+
                            listapersonas.get(i).getNombres()+"|"+
                            listapersonas.get(i).getApellidos()+"|");
        }
    }
}