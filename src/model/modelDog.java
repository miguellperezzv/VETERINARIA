/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import Clases.clsDog;
import Clases.clsPet;
import java.util.LinkedList;
import javax.swing.JOptionPane;

/**
 *
 * @author luisy
 */
public class modelDog {

    LinkedList<clsDog> petlist = new LinkedList<>();

    public LinkedList<clsDog> getPetlist() {
        return petlist;
    }

    public void setPetlist(LinkedList<clsDog> petlist) {
        this.petlist = petlist;
    }
    
    public modelDog() {
    }
    
    public boolean createPet(clsDog pet){
        
        try{
            petlist.add(pet);
            return true;
        }catch(Exception e){
            return false;
        }
        
    }
    
    public boolean editPet(clsDog pet){
        
        try{
           for(clsDog dog : petlist){
            if(dog.getCode().equals(pet.getCode())){
               
               
                
                dog.setName(pet.getName());
                dog.setBorn_year(pet.getBorn_year());
                dog.setColor(pet.getColor());
                dog.setBreed(pet.getBreed());
                dog.setHealth_status(pet.getHealth_status());
                dog.setPedigree(pet.isPedigree());
                break;
           }
        }
            return true;
        }catch(Exception e){
            return false;
        }
        
    }
    
    public boolean deletePet(clsDog pet){
        
        try{
           for(clsDog dog : petlist){
            if(dog.getCode().equals(pet.getCode())){
                
                this.petlist.remove(dog);
                break;
           }
        }
           
            return false;
        }catch(Exception e){
            return false;
        }
        
    }
    
    public clsPet searchPet(String code, String type){
        
        clsDog pet = null;
        try{
            for(clsDog dog : petlist){
            
                if(dog.getCode().equals(code)){
                    pet = dog;
                    return pet;
                }
            }
        }catch(Exception e){
            return pet;
        }
        return pet;
    }
    
    
}
