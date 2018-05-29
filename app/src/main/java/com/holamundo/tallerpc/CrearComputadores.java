package com.holamundo.tallerpc;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
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

        cmbMarca = findViewById(R.id.cmbMarca);
        opcMarca = this.getResources().getStringArray(R.array.marcas);
        adapterM = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,opcMarca);
        cmbMarca.setAdapter(adapterM);

        cmbRam = findViewById(R.id.cmbRam);
        opcRam = this.getResources().getStringArray(R.array.rams);
        adapterR = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,opcRam);
        cmbRam.setAdapter(adapterR);

        cmbColor = findViewById(R.id.cmbColor);
        opcColor = this.getResources().getStringArray(R.array.colors);
        adapterC = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,opcColor);
        cmbColor.setAdapter(adapterC);

        cmbTipo = findViewById(R.id.cmbTipo);
        opcTipo = this.getResources().getStringArray(R.array.tipos);
        adapterT = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,opcTipo);
        cmbTipo.setAdapter(adapterT);

        cmbSisOp = findViewById(R.id.cmbSisOp);
        opcSisOp = this.getResources().getStringArray(R.array.sos);
        adapterS = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,opcSisOp);
        cmbSisOp.setAdapter(adapterS);

        fotos = new ArrayList<Integer>();
        fotos.add(R.drawable.images);
        fotos.add(R.drawable.images2);
        fotos.add(R.drawable.images3);

    }

    public void guardar(View v){
        String id;
        int marca,ram,color,tipo,so,foto;

        id = Datos.getId();
        marca = cmbMarca.getSelectedItemPosition();
        ram = cmbRam.getSelectedItemPosition();
        color = cmbColor.getSelectedItemPosition();
        tipo = cmbTipo.getSelectedItemPosition();
        so = cmbSisOp.getSelectedItemPosition();
        foto = Datos.fotoAleatoria(fotos);

        Computador p = new Computador(id,marca,ram,color,tipo,so,foto);
        p.guardar();
        Snackbar.make(v, getResources().getString(R.string.mensaje_guardado_exitoso), Snackbar.LENGTH_SHORT)
                .setAction("Action", null).show();
        limpiar();

    }

    public void limpiar(View v){
        limpiar();
    }

    public void limpiar(){
        cmbMarca.setSelection(0);
        cmbRam.setSelection(0);
        cmbColor.setSelection(0);
        cmbTipo.setSelection(0);
        cmbSisOp.setSelection(0);
        cmbMarca.requestFocus();
    }

    public void onBackPressed(){
        finish();
        Intent i = new Intent(CrearComputadores.
                this,principal.class);
        startActivity(i);
    }
}
