package com.holamundo.tallerpc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

public class CrearComputadores extends AppCompatActivity {

    private Spinner cmbMarca;
    private Spinner cmbRam;
    private Spinner cmbColor;
    private Spinner cmbTipo;
    private Spinner cmbSisOp;
    private ArrayList<Integer> fotos;
    private ArrayAdapter<String> adapterM;
    private String opcMarca[];
    private ArrayAdapter<String> adapterR;
    private String opcRam[];
    private ArrayAdapter<String> adapterC;
    private String opcColor[];
    private ArrayAdapter<String> adapterT;
    private String opcTipo[];
    private ArrayAdapter<String> adapterS;
    private String opcSisOp[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_computadores);
    }

    public String ObtenerCadena(Spinner spn){
        String item = "";
        item = spn.getSelectedItem().toString();
        return item;
    }




}
