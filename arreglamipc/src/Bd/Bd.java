/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bd;

import Clases.Articulo;
import Clases.Cliente;
import Clases.Contrato;
import Clases.Empleado;
import Clases.Linea;
import Clases.Reparacion;
import Clases.TipoContrato;
import Clases.Venta;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import sun.invoke.empty.Empty;

/**
 *
 * @author marcos
 * clase se conecsion a la base de datos y consultas
 */
public class Bd {
    private Connection con;

    public Bd() {
    }
    
    private void conectar(){
        try {
            con =(Connection) DriverManager.getConnection("jdbc:mysql://192.168.4.187:3310/proyectoprogramacion", "marcos", "marcos");
        } catch (SQLException ex) {
            Logger.getLogger(Bd.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    private void desconectar(){
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Bd.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public Empleado login(String usu){
        conectar();
        Empleado e = null;
        try {
            Statement s = (Statement) con.createStatement();
            ResultSet rs = s.executeQuery("select * from empleado where nombre='"+usu+"';");
            if(rs.first()){
              Empleado em = new Empleado(rs.getBoolean("activo"), rs.getString("tipo"), rs.getInt("cod_sede"), rs.getInt("cod_op"), rs.getString("nombre"), rs.getString("dni"), rs.getString("fecha_alta"));
              e=em;       
            }
        } catch (SQLException ex) {
            Logger.getLogger(Bd.class.getName()).log(Level.SEVERE, null, ex);
        }
        desconectar();
        return e;
    }
    public ArrayList<Cliente> clientes(){
        conectar();
        ArrayList<Cliente> e = new ArrayList<>();
        try {
            Statement s = (Statement) con.createStatement();
            ResultSet rs = s.executeQuery("select * from cliente");
            while(rs.next()){
              Cliente cli = new Cliente(rs.getString("direccion"), rs.getString("poblacion"), rs.getString("telefono"), rs.getInt("cod_cli"), rs.getString("nombre"), rs.getString("dni"), rs.getString("fecha_alta"));
              e.add(cli);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Bd.class.getName()).log(Level.SEVERE, null, ex);
        }
        desconectar();
        return e;
    }
    public ArrayList<Contrato> contratos(Cliente c){
        conectar();
        ArrayList<Contrato> e = new ArrayList<>();
        try {
            Statement s = (Statement) con.createStatement();
            ResultSet rs = s.executeQuery("select * from contrato where cod_cli='"+c.getCodigo()+"';");
            while(rs.next()){
              Contrato co = new Contrato(rs.getInt("cod_con"), c, tipoContrato(rs.getInt("cod_t_con")), rs.getString("fecha_in"), rs.getString("fecha_fin"), rs.getDouble("importe"));
              e.add(co);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Bd.class.getName()).log(Level.SEVERE, null, ex);
        }
        desconectar();
        return e;
    }
    private TipoContrato tipoContrato(int cod){
        conectar();
        TipoContrato e = null;
        try {
            Statement s = (Statement) con.createStatement();
            ResultSet rs = s.executeQuery("select * from tipo_con where cod_t_con='"+cod+"';");
            if(rs.first()){
              TipoContrato t = new TipoContrato(rs.getInt("cod_t_con"), rs.getString("nombre"), rs.getString("esp1"), rs.getString("esp2"), rs.getString("esp3"), rs.getDouble("importe"));
              e=t;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Bd.class.getName()).log(Level.SEVERE, null, ex);
        }
        desconectar();
        return e;
    }
    public void insertarLineas(Linea a , int cod, int linea){
        conectar();
        try {
           PreparedStatement ps = (PreparedStatement)  con.prepareStatement("insert into lista_rep values(?,?,?,?,?,?,?);");
           ps.setInt(1 ,linea);
           ps.setInt(2, a.getUnidades());
           ps.setDouble(3, a.getArticulo().getPrecio());
           ps.setInt(4, a.getArticulo().getCodigo());
           ps.setDouble(5, (a.getUnidades()*a.getArticulo().getPrecio()));
           ps.setInt(6, cod);
           ps.setInt(7, a.getArticulo().getCodigo());
           ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Bd.class.getName()).log(Level.SEVERE, null, ex);
        }
        desconectar();
    }
    public ArrayList<Articulo> articulos(){
        conectar();
        ArrayList<Articulo> e = new ArrayList<>();
        try {
            Statement s = (Statement) con.createStatement();
            ResultSet rs = s.executeQuery("select * from articulo;");
            while(rs.next()){
              Articulo co = new Articulo(rs.getInt("cod_art"),rs.getString("descri"),rs.getString("marca"),rs.getString("fecha_ult_comp"),rs.getDouble("precio_vent"),rs.getDouble("iva"),rs.getString("ean"));
              e.add(co);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Bd.class.getName()).log(Level.SEVERE, null, ex);
        }
        desconectar();
        return e;
    }
    public int ultimo(String tabla){
        conectar();
        int e = 0;
        try {
            Statement s = (Statement) con.createStatement();
            ResultSet rs = s.executeQuery("select count(*) from "+tabla+";");
            if(rs.first()){
              e=rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Bd.class.getName()).log(Level.SEVERE, null, ex);
        }
        desconectar();
        return e;
    }
    public void insertarReparacion(Reparacion r){
        conectar();
        TipoContrato e = null;
        try {
           PreparedStatement ps = (PreparedStatement)  con.prepareStatement("insert into reparacion values(0,?,?,curdate(),?,?,null,?,?,?,?);");
           ps.setInt(1, r.getTiempo());
           ps.setInt(2, r.getDesplazamiento());
           ps.setBoolean(3, r.getFinalizado());
           ps.setBoolean(4, r.getFinalizado());
           ps.setString(5, r.getEan());
           ps.setInt(6, r.getCliente().getCodigo());
           ps.setInt(7, r.getContrato().getCodigo());
           ps.setInt(8, r.getTecnico().getCodigo());
           ps.executeUpdate();
           int ult = ultimo("reparacion");
           int nLinea=0;
            for (int i = 0; i < r.getArticulso().size(); i++) {
                nLinea=i+1;
                insertarLineas(r.getArticulso().get(i), ult ,nLinea);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Bd.class.getName()).log(Level.SEVERE, null, ex);
        }
        desconectar();
    }
    public void insertarVenta(Venta r){
        conectar();
        TipoContrato e = null;
        try {
           PreparedStatement ps = (PreparedStatement)  con.prepareStatement("insert into venta values(0,?,?,curdate(),'contado',null,?,?);");
           ps.setBoolean(1, r.isFinalizada());
           ps.setBoolean(2, r.isPagada());
           ps.setInt(3, r.getCliente().getCodigo());
           ps.setInt(4, r.getComercial().getCodigo());
           ps.executeUpdate();
           int ult = ultimo("venta");
           int nLinea=0;
            for (int i = 0; i < r.getArticulos().size(); i++) {
                nLinea=i+1;
                insertarLineasVenta(r.getArticulos().get(i), ult , nLinea);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Bd.class.getName()).log(Level.SEVERE, null, ex);
        }
        desconectar();
    }
    public void insertarLineasVenta(Linea a , int cod , int lineas){
        conectar();
        try {
           PreparedStatement ps = (PreparedStatement)  con.prepareStatement("insert into lista_venta values(?,?,?,?,?,?,?);");
           ps.setInt(1, lineas);
           ps.setInt(2, a.getUnidades());
           ps.setDouble(3, a.getArticulo().getPrecio());
           ps.setInt(4, a.getArticulo().getCodigo());
           ps.setDouble(5, (a.getUnidades()*a.getArticulo().getPrecio()));
           ps.setInt(6, cod);
           ps.setInt(7, a.getArticulo().getCodigo());
           ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Bd.class.getName()).log(Level.SEVERE, null, ex);
        }
        desconectar();
    }
    public int ean(String ean){
        conectar();
        int e = 0;
        try {
            Statement s = (Statement) con.createStatement();
            ResultSet rs = s.executeQuery("select count(*) from articulo where ean="+ean+";");
            if(rs.first()){
              e=rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Bd.class.getName()).log(Level.SEVERE, null, ex);
        }
        desconectar();
        return e;
    }
    public String nombreEan(String ean){
        conectar();
        String e = "";
        try {
            Statement s = (Statement) con.createStatement();
            ResultSet rs = s.executeQuery("select descri from articulo where ean="+ean+";");
            if(rs.first()){
              e=rs.getString(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Bd.class.getName()).log(Level.SEVERE, null, ex);
        }
        desconectar();
        return e;
    }
    public DefaultTableModel rellenarTabla(int aux){
        conectar();
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("codigo");
        modelo.addColumn("fecha");
        modelo.addColumn("finalizada");
        modelo.addColumn("cliente");
        modelo.addColumn("operario");
        try {
            Statement s = (Statement) con.createStatement();
            ResultSet rs = s.executeQuery("select cod_re , fecha , finalizada , cod_cli , cod_op from reparacion where cod_cli="+aux+";");
            while(rs.next()){
              Object [] fila = new Object[5];
              for (int i=0;i<fila.length;i++)
                fila[i] = rs.getObject(i+1); 
              modelo.addRow(fila); 
              }
        } catch (SQLException ex) {
            Logger.getLogger(Bd.class.getName()).log(Level.SEVERE, null, ex);
        }
        desconectar();
        return modelo;
    }
    public DefaultTableModel rellenarTablaT(){
        conectar();
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("codigo");
        modelo.addColumn("fecha");
        modelo.addColumn("finalizada");
        modelo.addColumn("cliente");
        modelo.addColumn("operario");        
        try {
            Statement s = (Statement) con.createStatement();
            ResultSet rs = s.executeQuery("select cod_re , fecha , finalizada , cod_cli , cod_op from reparacion;");
            while(rs.next()){
              Object [] fila = new Object[5];
              for (int i=0;i<fila.length;i++)
                fila[i] = rs.getObject(i+1); 
              modelo.addRow(fila); 
              }
        } catch (SQLException ex) {
            Logger.getLogger(Bd.class.getName()).log(Level.SEVERE, null, ex);
        }
        desconectar();
        return modelo;
    }
    public DefaultTableModel rellenarTablaVentas(int aux){
        conectar();
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("codigo");
        modelo.addColumn("pagada");
        modelo.addColumn("fecha");
        modelo.addColumn("cliente");
        modelo.addColumn("operario");
        try {
            Statement s = (Statement) con.createStatement();
            ResultSet rs = s.executeQuery("select cod_venta , pagada , fecha , cod_cli , cod_op from venta where cod_cli="+aux+";");
            while(rs.next()){
              Object [] fila = new Object[5];
              for (int i=0;i<fila.length;i++)
                fila[i] = rs.getObject(i+1); 
              modelo.addRow(fila); 
              }
        } catch (SQLException ex) {
            Logger.getLogger(Bd.class.getName()).log(Level.SEVERE, null, ex);
        }
        desconectar();
        return modelo;
    }
     public DefaultTableModel rellenarTablaVentasT(){
        conectar();
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("codigo");
        modelo.addColumn("pagada");
        modelo.addColumn("fecha");
        modelo.addColumn("cliente");
        modelo.addColumn("operario");
        try {
            Statement s = (Statement) con.createStatement();
            ResultSet rs = s.executeQuery("select cod_venta , pagada , fecha , cod_cli , cod_op from venta;");
            while(rs.next()){
              Object [] fila = new Object[5];
              for (int i=0;i<fila.length;i++)
                fila[i] = rs.getObject(i+1); 
              modelo.addRow(fila); 
              }
        } catch (SQLException ex) {
            Logger.getLogger(Bd.class.getName()).log(Level.SEVERE, null, ex);
        }
        desconectar();
        return modelo;
    }
}
