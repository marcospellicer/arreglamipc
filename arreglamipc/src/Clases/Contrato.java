/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author alumno
 */
public class Contrato {
    private int codigo;
    private Cliente cliente;
    private TipoContrato tipo;
    private String fecha_i;
    private String fecha_f;
    private  double importe;

    public Contrato(int codigo, Cliente cliente, TipoContrato tipo, String fecha_i, String fecha_f, double importe) {
        this.codigo = codigo;
        this.cliente = cliente;
        this.tipo = tipo;
        this.fecha_i = fecha_i;
        this.fecha_f = fecha_f;
        this.importe = importe;
    }

    @Override
    public String toString() {
        return codigo + "." + tipo.toString();
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
     * @return the tipo
     */
    public TipoContrato getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(TipoContrato tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the fecha_i
     */
    public String getFecha_i() {
        return fecha_i;
    }

    /**
     * @param fecha_i the fecha_i to set
     */
    public void setFecha_i(String fecha_i) {
        this.fecha_i = fecha_i;
    }

    /**
     * @return the fecha_f
     */
    public String getFecha_f() {
        return fecha_f;
    }

    /**
     * @param fecha_f the fecha_f to set
     */
    public void setFecha_f(String fecha_f) {
        this.fecha_f = fecha_f;
    }

    /**
     * @return the importe
     */
    public double getImporte() {
        return importe;
    }

    /**
     * @param importe the importe to set
     */
    public void setImporte(double importe) {
        this.importe = importe;
    }
    
    
}
