package com.holamundo.tallerpc;

/**
 * Created by Android on 28/05/2018.
 */

public class Computador {
    private String id;
    private int marca;
    private int ram;
    private int color;
    private int tipo;
    private int sisOp;
    private int foto;

    public Computador(String id, int marca, int ram, int color, int tipo, int sisOp, int foto) {
        this.id = id;
        this.marca = marca;
        this.ram = ram;
        this.color = color;
        this.tipo = tipo;
        this.sisOp = sisOp;
        this.foto = foto;
    }

    public Computador() {
    }

    public Computador(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getMarca() {
        return marca;
    }

    public void setMarca(int marca) {
        this.marca = marca;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getSisOp() {
        return sisOp;
    }

    public void setSisOp(int sisOp) {
        this.sisOp = sisOp;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public void guardar(){
        Datos.guardar(this);
    }

    public void eliminar(){
        Datos.eliminarComputador(this);
    }

}


