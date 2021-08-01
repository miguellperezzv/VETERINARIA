/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


import Clases.clsCat;
import Clases.clsDoctor;
import Clases.clsVeterinary;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

/**
 *
 * @author luisy
 */
public class modelVet {
    LinkedList<clsVeterinary> vetlist = new LinkedList<>();
    Conexion conexion = new Conexion();

    public LinkedList<clsVeterinary> getVetlist() {
        return vetlist;
    }

    public void setVetlist(LinkedList<clsVeterinary> vetlist) {
        this.vetlist = vetlist;
    }

    public boolean createVet(clsVeterinary vet) {
        
        try(Connection conn =  DriverManager.getConnection(conexion.getUrl(), conexion.getUser(), conexion.getPassword()) ){
            String query  = "INSERT INTO HOSPITAL (NAME , PHONE,  ADDRESS, ID_DOCTOR) VALUES (?,?,?,?)";
            PreparedStatement stPet =  conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stPet.setString(1, vet.getName());
            stPet.setString(2, vet.getPhone());
            stPet.setString(3, vet.getAddress());
            stPet.setInt(4, vet.getDoctor().getDoctorId());
            
            int rows = stPet.executeUpdate();
            return rows>0;
            
    }
       catch (SQLException e){
           System.out.println(e);
           return false;
       }
    }

    public boolean editVet(clsVeterinary vet) {
        try (Connection conn =  DriverManager.getConnection(conexion.getUrl(), conexion.getUser(), conexion.getPassword())){
           String queryDoc = "UPDATE HOSPITAL SET  NAME = ?, PHONE = ?, ADDRESS=?, ID_DOCTOR = ? WHERE ID = ?";
           PreparedStatement stPet =  conn.prepareStatement(queryDoc);
           stPet.setString(1, vet.getName());
           stPet.setString(2, vet.getPhone());
           stPet.setString(3, vet.getAddress());
           stPet.setInt(4, vet.getDoctor().getDoctorId());
           stPet.setInt(5, vet.getVetId());
           
           
           
           int rows1 = stPet.executeUpdate();
           
            System.out.println("SE ACTUALIZÓ!!");
           return rows1 > 0;
        }catch(Exception e){
            System.out.println("ERROR "+ e);
            return false;
        }
    }

    public boolean deleteVet(clsVeterinary vet) {
         try{
           for(clsVeterinary v : vetlist){
            if(v.getName().equals(vet.getName())){
                
                this.vetlist.remove(v);
                break;
           }
        }
           
            return false;
        }catch(Exception e){
            return false;
        }
    }

    public clsVeterinary searchVet(int id) {
        clsVeterinary vet = null;
        modelDoctor modelDoc = new modelDoctor();
        try (Connection conn =  DriverManager.getConnection(conexion.getUrl(), conexion.getUser(), conexion.getPassword())){
            String query  = "SELECT * FROM hospital  WHERE id = ?";
            PreparedStatement stPet =  conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stPet.setInt(1, id);
            ResultSet result = stPet.executeQuery();
            while(result.next()){
                int vetId= result.getInt(1);
                String name = result.getString(2);
                String phone = result.getString(3);
                String address = result.getString(4);
                int docId = result.getInt(6);
                clsDoctor doctor = modelDoc.searchDoctor(docId);
                vet = new clsVeterinary(vetId, name, phone, address, doctor);
            }
               
        }catch(Exception e){
               System.out.println("ERROR "+ e);
            
        }
        return vet;
    }
    
}
