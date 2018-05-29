package com.holamundo.tallerpc;

/**
 * Created by Android on 28/05/2018.
 */

public class Computador {
    private String id;
    private String marca;
    private int ram;
    private String color;
    private String tipo;
    private String sisOp;
    private int foto;

    public Computador(String id, String marca, int ram, String color, String tipo, String sisOp, int foto) {
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getSisOp() {
        return sisOp;
    }

    public void setSisOp(String sisOp) {
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


