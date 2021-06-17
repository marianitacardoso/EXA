/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Datos.vdocente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ismael
 */
public class fdocente {
    
    private conexion mysql=new conexion();
    private Connection cn=mysql.conectar();
    private String sSQL="";
    public Integer totalregistros;
    
    public DefaultTableModel mostrar(String buscar){
    DefaultTableModel modelo;
    
    String [] titulos = {"ID","Nombre","A Paterno","A Materno","Domicilio","Telefono", "Correo","Profesion","Antiguedad"};
    
    String [] registro = new String [9];
    totalregistros=0;
    modelo =new DefaultTableModel(null, titulos);
    
    sSQL="select * from docente where nombre like '%"+ buscar + "%' order by iddocente";
    
        try {
            Statement st = cn.createStatement();
            ResultSet rs =st.executeQuery(sSQL);
            
            while(rs.next()){
                registro[0]=rs.getString("iddocente");
                registro[1]=rs.getString("nombre");
                registro[2]=rs.getString("apaterno");
                registro[3]=rs.getString("amaterno");
                registro[4]=rs.getString("domicilio");
                registro[5]=rs.getString("telefono");
                registro[6]=rs.getString("correo");
                registro[7]=rs.getString("profesion");
                registro[8]=rs.getString("antiguedad");
                
                totalregistros=totalregistros+1;
                modelo.addRow(registro);
                
            }
            
            return modelo;
            
            
        } catch (Exception e) {
        JOptionPane.showConfirmDialog(null, e);
        return null;
    }    
}
    
    public boolean insertar (vdocente dts) {
        sSQL="insert into docente (nombre, apaterno, amaterno, domicilio, telefono, correo, profesion, antiguedad)" +
                "values (?,?,?,?,?,?,?,?)";
       
        
        try {

            PreparedStatement pst=cn.prepareStatement(sSQL);
            pst.setString(1,dts.getNombre());
            pst.setString(2,dts.getApaterno());
            pst.setString(3,dts.getAmaterno());
            pst.setString(4,dts.getDomicilio());
            pst.setString(5,dts.getTelefono());
            pst.setString(6,dts.getCorreo());
            pst.setString(7,dts.getProfesion());
            pst.setString(8,dts.getAntiguedad());
    
            int n=pst.executeUpdate();
            if (n!=0){
               return true;
                
            }
            else {
                return false;
            }
        } catch (Exception e) {
        JOptionPane.showConfirmDialog(null, e);    
        return false;
        }
    }
    
    public boolean editar (vdocente dts) {
        sSQL="update usuario set nombre=?, apaterno=?, amaterno=?, domicilio=?, telefono=?, correo=?, profesion=?, antiguedad=?"+
             "where iddocente=?"; 
        try {
            PreparedStatement pst=cn.prepareStatement(sSQL);
            pst.setString(1,dts.getNombre());
            pst.setString(2,dts.getApaterno());
            pst.setString(3,dts.getAmaterno());
            pst.setString(4,dts.getDomicilio());
            pst.setString(5,dts.getTelefono());
            pst.setString(6,dts.getCorreo());
            pst.setString(7,dts.getProfesion());
            pst.setString(8,dts.getAntiguedad());
            pst.setInt(9,dts.getIddocente());
            
            
            int n=pst.executeUpdate();
            if (n!=0){
               return true;
                
            }
            else {
                return false;
            }
            
        } catch (Exception e) {
        JOptionPane.showConfirmDialog(null, e);    
        return false;
        }
    }
        
    public boolean eliminar (vdocente dts) {
        sSQL="delete from docente where iddocente=?";  
        try {
            PreparedStatement pst=cn.prepareStatement(sSQL);
            pst.setInt(1,dts.getIddocente());
            
            int n=pst.executeUpdate();
            if (n!=0){
               return true;
                
            }
            else {
                return false;
            }
            
        } catch (Exception e) {
        JOptionPane.showConfirmDialog(null, e);    
        return false;
        }
    }
}