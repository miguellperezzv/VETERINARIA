/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import Clases.clsCat;
import Clases.clsDog;
import Clases.clsPet;
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
public class modelCat {
    
    
    Conexion conexion = new Conexion();
    
    public boolean createPet(clsCat pet){
        
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
                    query = "INSERT INTO CAT (BREED, ID_PET) VALUES (?,?)";
                    PreparedStatement stDog = conn.prepareStatement(query);
                    stDog.setString(1, pet.getBreed());
                    
                    stDog.setInt(2, idPet);
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
    
    public boolean editPet(clsCat pet){
       try (Connection conn =  DriverManager.getConnection(conexion.getUrl(), conexion.getUser(), conexion.getPassword())){
           String queryPet = "UPDATE PET SET CODE = ?, NAME = ?, BORN_YEAR = ?, COLOR = ?, HEALTH_STATUS = ? WHERE ID = ?";
           PreparedStatement stPet =  conn.prepareStatement(queryPet);
           stPet.setString(1, pet.getCode());
           stPet.setString(2, pet.getName());
           stPet.setInt(3, pet.getBorn_year());
           stPet.setString(4, pet.getColor());
           stPet.setString(5, pet.getHealth_status());
           stPet.setInt(6, pet.getCatId());
           
           String queryDog = "UPDATE CAT SET BREED = ? WHERE ID = ?";
           PreparedStatement stDog =  conn.prepareStatement(queryDog);
           stDog.setString(1, pet.getBreed());
           
           stDog.setInt(2, pet.getCatId());
           int rows1 = stPet.executeUpdate();
           int rows2 = stDog.executeUpdate();
            System.out.println("SE ACTUALIZÓ!!");
           return rows1 > 0 && rows2>0;
        }catch(Exception e){
            System.out.println("ERROR "+ e);
            return false;
        }
    }
    
    public boolean deletePet(clsCat pet){
        
        try{
            /*
           for(clsCat dog : petlist){
            if(dog.getCode().equals(pet.getCode())){
                
                this.petlist.remove(dog);
                break;
           }*/
            
        
           
            return false;
        }catch(Exception e){
            return false;
        }
        
    }
    
    public clsPet searchPet(String code, String type){
        
        clsCat pet = null;
       
           try (Connection conn =  DriverManager.getConnection(conexion.getUrl(), conexion.getUser(), conexion.getPassword())){
            String query  = "SELECT * FROM PET  AS p INNER JOIN CAT AS c ON p.id = c.id_pet WHERE p.code = ?";
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
                int catInt = result.getInt(7);
                String petBreed  = result.getString(8);
                
                pet = new clsCat(petId, petBreed, code, petName, petBornYear, petColor, petHealthStatus);
            }
               return pet;     
        }catch(Exception e){
               System.out.println("ERROR "+ e);
            return pet;
        }
        
    }
    
    
    
    
    public LinkedList<clsCat> getPetlist() {
        return null;
    }

    public void setPetlist(LinkedList<clsCat> petlist) {
        
    }
}
