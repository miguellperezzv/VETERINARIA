/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import Clases.clsDoctor;
import Clases.clsDog;
import Clases.clsPet;
import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;   
import java.sql.SQLException;
import java.sql.*;

import java.util.LinkedList;
import javax.swing.JOptionPane;

/**
 *
 * @author luisy
 */
public class modelDog {

    Conexion conexion = new Conexion();
    //LinkedList<clsDog> petlist = new LinkedList<>();

    /*
    public LinkedList<clsDog> getPetlist() {
        return petlist;
    }

    public void setPetlist(LinkedList<clsDog> petlist) {
        this.petlist = petlist;
    }*/
    
    public modelDog() {
    }
    
    public boolean createPet(clsDog pet){
        
        try(Connection conn =  DriverManager.getConnection(conexion.getUrl(), conexion.getUser(), conexion.getPassword()) ){
            String query  = "INSERT INTO PET (CODE, NAME , BORN_YEAR, COLOR, HEALTH_STATUS) VALUES (?,?,?,?,?)";
            PreparedStatement stPet =  conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stPet.setString(1, pet.getCode());
            stPet.setString(2, pet.getName());
            stPet.setInt(3, pet.getBorn_year());
            stPet.setString(4, pet.getColor());
            stPet.setString(5, pet.getHealth_status());
            int rows = stPet.executeUpdate();
            if(rows > 0){
                ResultSet generatedKeys  = stPet.getGeneratedKeys();
                if(generatedKeys.next()){
                    int idPet = generatedKeys.getInt(1);
                    query = "INSERT INTO DOG (BREED, PEDIGREE, ID_PET) VALUES (?,?,?)";
                    PreparedStatement stDog = conn.prepareStatement(query);
                    stDog.setString(1, pet.getBreed());
                    stDog.setBoolean(2, pet.isPedigree());
                    stDog.setInt(3, idPet);
                    rows = stDog.executeUpdate();
                    if (rows > 0){
                        return true;
                    }
                }
            }
            
            return true;
        }catch(SQLException e){
            System.out.println("ERROR: "+ e);
            return false;
        }
        
    }
    
    public boolean editPet(clsDog pet){
        
        try (Connection conn =  DriverManager.getConnection(conexion.getUrl(), conexion.getUser(), conexion.getPassword())){
           String queryPet = "UPDATE PET SET CODE = ?, NAME = ?, BORN_YEAR = ?, COLOR = ?, HEALTH_STATUS = ? WHERE ID = ?";
           PreparedStatement stPet =  conn.prepareStatement(queryPet);
           stPet.setString(1, pet.getCode());
           stPet.setString(2, pet.getName());
           stPet.setInt(3, pet.getBorn_year());
           stPet.setString(4, pet.getColor());
           stPet.setString(5, pet.getHealth_status());
           stPet.setInt(6, pet.getDogId());
           
           String queryDog = "UPDATE DOG SET BREED = ?, PEDIGREE = ? WHERE ID = ?";
           PreparedStatement stDog =  conn.prepareStatement(queryDog);
           stDog.setString(1, pet.getBreed());
           stDog.setBoolean(2, pet.isPedigree());
           stDog.setInt(3, pet.getDogId());
           int rows1 = stPet.executeUpdate();
           int rows2 = stDog.executeUpdate();
            System.out.println("SE ACTUALIZÓ!!");
           return rows1 > 0 && rows2>0;
        }catch(Exception e){
            System.out.println("ERROR "+ e);
            return false;
        }
        
    }
    
    public boolean deletePet(clsDog pet){
        
        try{
            /*
           for(clsDog dog : petlist){
            if(dog.getCode().equals(pet.getCode())){
                
                this.petlist.remove(dog);
                break;
           }
        }
           */
            return false;
            
        }catch(Exception e){
            return false;
        }
        
    }
    
    public clsPet searchPet(String code, String type){
        
        clsDog pet = null;
        try (Connection conn =  DriverManager.getConnection(conexion.getUrl(), conexion.getUser(), conexion.getPassword())){
            String query  = "SELECT * FROM PET  AS p INNER JOIN DOG AS d ON p.id = d.id WHERE p.code = ?";
            PreparedStatement stPet =  conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stPet.setString(1, code);
            ResultSet result = stPet.executeQuery();
            while(result.next()){
                int petId = result.getInt(1);
                String petCode = result.getString(2);
                String petName = result.getString(3);
                int petBornYear = result.getInt(4);
                String petColor = result.getString(5);
                String petHealthStatus = result.getString(6);
                int dogInt = result.getInt(7);
                String petBreed  = result.getString(8);
                Boolean petPedigree = result.getBoolean(9);
                pet = new clsDog(petId,petBreed, petPedigree, petCode, petName, petBornYear, petColor, petHealthStatus);
            }
               return pet;     
        }catch(Exception e){
            System.out.println("ERROR "+ e);
            return pet;
        }
        
    }

    
    
    
}
