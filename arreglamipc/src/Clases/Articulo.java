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
public class Articulo {
    private int codigo;
    private String desc;
    private String marca;
    private String fechaUltimaCompra;
    private double precio;
    private double iva;
    private String ean;

    public Articulo(int codigo, String desc, String marca, String fechaUltimaCompra, double precio, double iva, String ean) {
        this.codigo = codigo;
        this.desc = desc;
        this.marca = marca;
        this.fechaUltimaCompra = fechaUltimaCompra;
        this.precio = precio;
        this.iva = iva;
        this.ean = ean;
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
     * @return the desc
     */
    public String getDesc() {
        return desc;
    }

    /**
     * @param desc the desc to set
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     * @return the marca
     */
    public String getMarca() {
        return marca;
    }

    /**
     * @param marca the marca to set
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * @return the fechaUltimaCompra
     */
    public String getFechaUltimaCompra() {
        return fechaUltimaCompra;
    }

    /**
     * @param fechaUltimaCompra the fechaUltimaCompra to set
     */
    public void setFechaUltimaCompra(String fechaUltimaCompra) {
        this.fechaUltimaCompra = fechaUltimaCompra;
    }

    /**
     * @return the precio
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * @return the iva
     */
    public double getIva() {
        return iva;
    }

    /**
     * @param iva the iva to set
     */
    public void setIva(double iva) {
        this.iva = iva;
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
    
    
}
