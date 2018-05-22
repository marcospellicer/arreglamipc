/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.ArrayList;

/**
 *
 * @author marcos
 * clase para crear un objeto de venta , contiene un vector de lineas de articulos implementa de ventas
 */
public class Venta implements Ventas{
    private int codigo;
    private Cliente cliente;
    private boolean finalizada;
    private boolean pagada;
    private Empleado comercial;
    private ArrayList<Linea> articulos;

    public Venta(int codigo, Cliente cliente, boolean finalizada, boolean pagada, Empleado comercial, ArrayList<Linea> articulos) {
        this.codigo = codigo;
        this.cliente = cliente;
        this.finalizada = finalizada;
        this.pagada = pagada;
        this.comercial = comercial;
        this.articulos = articulos;
    }

    @Override
    public String imprimir() {
        
      return "lo tengo que hacer";
    }

    @Override
    public void finalizar() {
        if(pagada){
            finalizada=true;
        }
    }

    @Override
    public double calcularTotal() {
        double total=0;
        for (int i = 0; i < articulos.size(); i++) {
            total+=articulos.get(i).getArticulo().getPrecio()*articulos.get(i).getUnidades();
        }
        return total;
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
     * @return the finalizada
     */
    public boolean isFinalizada() {
        return finalizada;
    }

    /**
     * @param finalizada the finalizada to set
     */
    public void setFinalizada(boolean finalizada) {
        this.finalizada = finalizada;
    }

    /**
     * @return the pagada
     */
    public boolean isPagada() {
        return pagada;
    }

    /**
     * @param pagada the pagada to set
     */
    public void setPagada(boolean pagada) {
        this.pagada = pagada;
    }

    /**
     * @return the comercial
     */
    public Empleado getComercial() {
        return comercial;
    }

    /**
     * @param comercial the comercial to set
     */
    public void setComercial(Empleado comercial) {
        this.comercial = comercial;
    }

    /**
     * @return the articulos
     */
    public ArrayList<Linea> getArticulos() {
        return articulos;
    }

    /**
     * @param articulos the articulos to set
     */
    public void setArticulos(ArrayList<Linea> articulos) {
        this.articulos = articulos;
    }
    
    
    
}
