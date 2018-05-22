/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author marcos
 * clase para crear objetos de empleado hereda de Persona
 */
public final class Empleado extends Persona{
   private boolean activo;
   private String categoria; 
   private int sede;

    public Empleado(boolean activo, String categoria, int sede, int codigo, String nombre, String dni, String fecha) {
        super(codigo, nombre, dni, fecha);
        this.activo = activo;
        this.categoria = categoria;
        this.sede = sede;
    }

    @Override
    public String toString() {
        return super.toString();
    }
    

    /**
     * @return the activo
     */
    public boolean isActivo() {
        return activo;
    }

    /**
     * @param activo the activo to set
     */
    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    /**
     * @return the categoria
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * @param categoria the categoria to set
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    /**
     * @return the sede
     */
    public int getSede() {
        return sede;
    }

    /**
     * @param sede the sede to set
     */
    public void setSede(int sede) {
        this.sede = sede;
    }
   
   
  
   

}
