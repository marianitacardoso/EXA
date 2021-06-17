/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

/**
 *
 * @author Mariana Cardoso
 */
public class vactividades {
    private int idactividades;
    private String nombre;
    private String tipo;
    private String duracion;  
    private String lugar;

    public vactividades(int idactividades, String nombre, String tipo, String duracion, String lugar) {
        this.idactividades = idactividades;
        this.nombre = nombre;
        this.tipo = tipo;
        this.duracion = duracion;
        this.lugar = lugar;
    }

    public vactividades() {
    }

    public int getIdactividades() {
        return idactividades;
    }

    public void setIdactividades(int idactividades) {
        this.idactividades = idactividades;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    
}
