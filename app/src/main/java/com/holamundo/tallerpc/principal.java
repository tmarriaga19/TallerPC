package com.holamundo.tallerpc;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class principal extends AppCompatActivity implements AdaptadorComputador.OnComputadorClickListener{
    private RecyclerView lstOpciones;
    private Intent i;
    private ArrayList<Computador> computadores;
    private AdaptadorComputador adapter;
    private LinearLayoutManager llm;
    private DatabaseReference databaseReference;
    private String bd = "computadores";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        lstOpciones = findViewById(R.id.lstOpciones);
        computadores = new ArrayList<>();

        llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        adapter = new AdaptadorComputador(computadores,this);

        lstOpciones.setLayoutManager(llm);
        lstOpciones.setAdapter(adapter);

        databaseReference = FirebaseDatabase.getInstance().getReference();
        databaseReference.child(bd).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                computadores.clear();
                if(dataSnapshot.exists()){
                    for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                        Computador p = snapshot.getValue(Computador.class);
                        computadores.add(p);
                    }
                }
                adapter.notifyDataSetChanged();
                Datos.setComputadores(computadores);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public void crearPersonas(View v){
        i = new Intent(principal.this,CrearComputadores.class);
        startActivity(i);
    }

    @Override
    public void onComputadorClick(Computador p) {
        Intent i = new Intent(principal.this,DetalleComputador.class);
        Bundle b = new Bundle();
        b.putString("id",p.getId());
        b.putInt("marca",p.getMarca());
        b.putInt("ram",p.getRam());
        b.putInt("color",p.getColor());
        b.putInt("tipo",p.getTipo());
        b.putInt("sisOp",p.getSisOp());
        b.putInt("foto",p.getFoto());
        i.putExtra("datos",b);
        startActivity(i);
    }

}
