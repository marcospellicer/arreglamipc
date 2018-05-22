/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author marcos
 * clase para crear objetos de tipo de contrato
 */
public class TipoContrato {
  private int codigo;
  private String nombre;
  private String esp1;
  private String esp2;
  private String esp3;
  private double importeAnual;

    public TipoContrato(int codigo, String nombre, String esp1, String esp2, String esp3, double importeAnual) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.esp1 = esp1;
        this.esp2 = esp2;
        this.esp3 = esp3;
        this.importeAnual = importeAnual;
    }

    @Override
    public String toString() {
        return nombre;
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
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the esp1
     */
    public String getEsp1() {
        return esp1;
    }

    /**
     * @param esp1 the esp1 to set
     */
    public void setEsp1(String esp1) {
        this.esp1 = esp1;
    }

    /**
     * @return the esp2
     */
    public String getEsp2() {
        return esp2;
    }

    /**
     * @param esp2 the esp2 to set
     */
    public void setEsp2(String esp2) {
        this.esp2 = esp2;
    }

    /**
     * @return the esp3
     */
    public String getEsp3() {
        return esp3;
    }

    /**
     * @param esp3 the esp3 to set
     */
    public void setEsp3(String esp3) {
        this.esp3 = esp3;
    }

    /**
     * @return the importeAnual
     */
    public double getImporteAnual() {
        return importeAnual;
    }

    /**
     * @param importeAnual the importeAnual to set
     */
    public void setImporteAnual(double importeAnual) {
        this.importeAnual = importeAnual;
    }
  
  
          
}
