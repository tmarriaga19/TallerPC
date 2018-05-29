package com.holamundo.tallerpc;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DetalleComputador extends AppCompatActivity {

    private TextView txtMarcaDetalle;
    private TextView txtRamDetalle;
    private TextView txtColorDetalle;
    private TextView txtTipoDetalle;
    private TextView txtSODetalle;
    private String[] VMarca,VRam,VColor,VTipo,VSO;
    private ImageView fot;
    private String id;
    private int marca,ram,color,tipo,so,foto;
    private Intent i;
    private Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_computador);

        txtMarcaDetalle = findViewById(R.id.txtMarcaDetalle);
        txtRamDetalle = findViewById(R.id.txtRamDetalle);
        txtColorDetalle = findViewById(R.id.txtColorDetalle);
        txtTipoDetalle = findViewById(R.id.txtTipoDetalle);
        txtSODetalle = findViewById(R.id.txtSODetalle);
        fot = findViewById(R.id.foto);
        VMarca =getResources().getStringArray(R.array.marcas);
        VRam =getResources().getStringArray(R.array.rams);
        VColor =getResources().getStringArray(R.array.colors);
        VTipo =getResources().getStringArray(R.array.tipos);
        VSO =getResources().getStringArray(R.array.sos);

        i = getIntent();

        bundle = i.getBundleExtra("datos");
        id = bundle.getString("id");
        marca = bundle.getInt("marca");
        ram = bundle.getInt("ram");
        color = bundle.getInt("color");
        tipo = bundle.getInt("tipo");
        so = bundle.getInt("sisOp");
        foto = bundle.getInt("foto");

        txtMarcaDetalle.setText(VMarca[marca]);
        txtRamDetalle.setText(VRam[ram]);
        txtColorDetalle.setText(VColor[color]);
        txtTipoDetalle.setText(VTipo[tipo]);
        txtSODetalle.setText(VSO[so]);
        fot.setImageResource(foto);
    }

    public void eliminar(View v){
        String positivo, negativo;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getResources().getString(R.string.eliminar));
        builder.setMessage(getResources().getString(R.string.pregunta_eliminacion));
        positivo = getResources().getString(R.string.positivo);
        negativo = getResources().getString(R.string.negativo);

        builder.setPositiveButton(positivo, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Computador p = new Computador(id);
                p.eliminar();
                onBackPressed();
            }
        });

        builder.setNegativeButton(negativo, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();

    }

    public void onBackPressed() {
        finish();
        Intent i = new Intent(DetalleComputador.this,principal.class);
        startActivity(i);
    }

}
