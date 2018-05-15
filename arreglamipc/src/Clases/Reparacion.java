/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.ArrayList;



/**
 *
 * @author alumno
 */
public class Reparacion {
   private int codigo;
   private Cliente cliente;
   private Contrato contrato;
   private int tiempo;
   private int desplazamiento;
   private String fecha;
   private boolean finalizado;
   private Empleado tecnico;
   private String ean;
   private ArrayList<Linea> articulso;

    public Reparacion(int codigo, Cliente cliente, Contrato contrato, int tiempo, int desplazamiento, String fecha, boolean finalizado, Empleado tecnico, String ean, ArrayList<Linea> articulso) {
        this.codigo = codigo;
        this.cliente = cliente;
        this.contrato = contrato;
        this.tiempo = tiempo;
        this.desplazamiento = desplazamiento;
        this.fecha = fecha;
        this.finalizado = finalizado;
        this.tecnico = tecnico;
        this.ean = ean;
        this.articulso = articulso;
    }

    /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * @return the contrato
     */
    public Contrato getContrato() {
        return contrato;
    }

    /**
     * @param contrato the contrato to set
     */
    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
    }

    /**
     * @return the tiempo
     */
    public int getTiempo() {
        return tiempo;
    }

    /**
     * @param tiempo the tiempo to set
     */
    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    /**
     * @return the desplazamiento
     */
    public int getDesplazamiento() {
        return desplazamiento;
    }

    /**
     * @param desplazamiento the desplazamiento to set
     */
    public void setDesplazamiento(int desplazamiento) {
        this.desplazamiento = desplazamiento;
    }

    /**
     * @return the fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the finalizado
     */
    public boolean getFinalizado() {
        return finalizado;
    }

    /**
     * @param finalizado the finalizado to set
     */
    public void setFinalizado(boolean finalizado) {
        this.finalizado = finalizado;
    }

    /**
     * @return the tecnico
     */
    public Empleado getTecnico() {
        return tecnico;
    }

    /**
     * @param tecnico the tecnico to set
     */
    public void setTecnico(Empleado tecnico) {
        this.tecnico = tecnico;
    }

    /**
     * @return the ean
     */
    public String getEan() {
        return ean;
    }

    /**
     * @param ean the ean to set
     */
    public void setEan(String ean) {
        this.ean = ean;
    }

    /**
     * @return the articulso
     */
    public ArrayList<Linea> getArticulso() {
        return articulso;
    }

    /**
     * @param articulso the articulso to set
     */
    public void setArticulso(ArrayList<Linea> articulso) {
        this.articulso = articulso;
    }
   
   
}
