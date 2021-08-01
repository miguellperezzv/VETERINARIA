/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import Clases.clsCat;
import Clases.clsDoctor;
import Clases.clsDog;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.LinkedList;
import java.sql.*;
/**
 *
 * @author luisy
 */
public class modelDoctor {
    
    LinkedList<clsDoctor> doctorlist = new LinkedList<>();
    Conexion conexion = new Conexion();
    
    public LinkedList<clsDoctor> getDoctorlist() {
        
        LinkedList<clsDoctor> docList = new LinkedList<>();
      try (Connection conn =  DriverManager.getConnection(conexion.getUrl(), conexion.getUser(), conexion.getPassword())){
            String query  = "SELECT * FROM DOCTOR ";
            PreparedStatement stPet =  conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            
            ResultSet result = stPet.executeQuery();
            while(result.next()){
                int doctorid = result.getInt(1);
                String name = result.getString(2);
                
                
                clsDoctor doctor = new clsDoctor(doctorid, name, "xx","xx");
                docList.add(doctor);
            }
                
        }catch(Exception e){
            System.out.println("ERROR "+ e);
            
        }
       return docList;
    }

    public void setDoctorlist(LinkedList<clsDoctor> doctorlist) {
        this.doctorlist = doctorlist;
    }

    public boolean createDoctor(clsDoctor doctor) {
        
       try(Connection conn =  DriverManager.getConnection(conexion.getUrl(), conexion.getUser(), conexion.getPassword()) ){
            String query  = "INSERT INTO DOCTOR (NAME , PHONE,  ADDRESS) VALUES (?,?,?)";
            PreparedStatement stPet =  conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stPet.setString(1, doctor.getName());
            stPet.setString(2, doctor.getPhone());
            stPet.setString(3, doctor.getAddress());
            
            int rows = stPet.executeUpdate();
            if (rows>0){
                return true;
            }
            else{
                return false;
            }
            
    }
       catch (SQLException e){
           System.out.println(e);
           return false;
       }
    }
    public boolean editDoctor(clsDoctor doc) {
        
        try (Connection conn =  DriverManager.getConnection(conexion.getUrl(), conexion.getUser(), conexion.getPassword())){
           String queryDoc = "UPDATE DOCTOR SET  NAME = ?, PHONE = ?, ADDRESS = ? WHERE ID = ?";
           PreparedStatement stPet =  conn.prepareStatement(queryDoc);
           stPet.setString(1, doc.getName());
           stPet.setString(2, doc.getPhone());
           stPet.setString(3, doc.getAddress());
           stPet.setInt(4, doc.getDoctorId());
           
           
           
           int rows1 = stPet.executeUpdate();
           
            System.out.println("SE ACTUALIZÓ!!");
           return rows1 > 0;
        }catch(Exception e){
            System.out.println("ERROR "+ e);
            return false;
        }
    }

    public boolean deleteDoctor(clsDoctor doctor) {
         try{
           
           
            return false;
        }catch(Exception e){
            return false;
        }
    }

    public clsDoctor searchDoctor(int doctorId) {
        clsDoctor doctor = null;
        
        try (Connection conn =  DriverManager.getConnection(conexion.getUrl(), conexion.getUser(), conexion.getPassword())){
            String query  = "SELECT * FROM DOCTOR WHERE ID = ?";
            PreparedStatement stPet =  conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stPet.setInt(1, doctorId);
            ResultSet result = stPet.executeQuery();
            while(result.next()){
                int petId = result.getInt(1);
                String name = result.getString(2);
                String phone = result.getString(3);
                
                String address = result.getString(4);
                
                doctor = new clsDoctor(petId,name, phone,address);
            }
               return doctor;     
        }catch(Exception e){
            System.out.println("ERROR "+ e);
            return doctor;
        }
    }
    
    
    
}
