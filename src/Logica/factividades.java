/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Datos.vactividades;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class factividades {
    
    private conexion mysql=new conexion();
    private Connection cn=mysql.conectar();
    private String sSQL="";
    public Integer totalregistros;
    
    public DefaultTableModel mostrar(String buscar){
    DefaultTableModel modelo;
    
    String [] titulos = {"Idactividades","Nombre","Tipo","Duracion","Lugar"};
    
    String [] registro = new String [5];
    totalregistros=0;
    modelo =new DefaultTableModel(null, titulos);
    
    sSQL="select * from actividades where nombre like '%"+ buscar + "%' order by idactividades";
    
        try {
            Statement st = cn.createStatement();
            ResultSet rs =st.executeQuery(sSQL);
            
            while(rs.next()){
                
                registro[0]=rs.getString("idactividades");
                registro[1]=rs.getString("nombre");
                registro[2]=rs.getString("tipo");
                registro[3]=rs.getString("duracion");
                registro[4]=rs.getString("lugar");
                
                totalregistros=totalregistros+1;
                modelo.addRow(registro);
                
            }
            
            return modelo;
            
            
        } catch (Exception e) {
        JOptionPane.showConfirmDialog(null, e);
        return null;
    }    
}
    
    public boolean insertar (vactividades dts) {
        sSQL="insert into actividades (nombre, tipo, duracion, lugar)" +
                "values (?,?,?,?)";
       
        
        try {

            PreparedStatement pst=cn.prepareStatement(sSQL);
            pst.setString(1,dts.getNombre());
            pst.setString(2,dts.getTipo());
            pst.setString(3,dts.getDuracion());
            pst.setString(4,dts.getLugar());
            
    
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
    
    public boolean editar (vactividades dts) {
        sSQL="update actividades set nombre=?, tipo=?, duracion=?, lugar=?"+
             "where idactividades=?"; 
        try {
            PreparedStatement pst=cn.prepareStatement(sSQL);
            pst.setString(1,dts.getNombre());
            pst.setString(2,dts.getTipo());
            pst.setString(3,dts.getDuracion());
            pst.setString(4,dts.getLugar());
            pst.setInt(5,dts.getIdactividades());
            
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
        
    public boolean eliminar (vactividades dts) {
        sSQL="delete from actividades where idactividades=?";  
        try {
            PreparedStatement pst=cn.prepareStatement(sSQL);
            pst.setInt(1,dts.getIdactividades());
            
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
