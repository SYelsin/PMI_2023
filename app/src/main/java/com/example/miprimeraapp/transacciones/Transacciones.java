package com.example.miprimeraapp.transacciones;

public class Transacciones {
    //Nombre de las base de datos

    public static final String NameDatabase = "PM01DB";

    //tablas de las db

    public static final  String tablapersonas = "personas";

    /* Transacciones de la base de datos PM01DB*/

    public static final String CreateTBPersonas =
            "CREATE TABLE personas (id INTEGER PRIMARY KEY AUTOINCREMENT, nombres TEXT,"+
        "apellidos TEXT, edad INTEGER, correo TEXT)";

    public static final String DropTablePersonas = "DROP TABLE IF EXISTS personas";

    //helpers
    public  static final String Empty = "";
}
