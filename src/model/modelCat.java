/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import Clases.clsCat;
import Clases.clsDog;
import Clases.clsPet;
import java.util.LinkedList;

/**
 *
 * @author luisy
 */
public class modelCat {
    
    LinkedList<clsCat> petlist = new LinkedList<>();

    public boolean createPet(clsCat pet){
        
        try{
            petlist.add(pet);
            return true;
        }catch(Exception e){
            return false;
        }
        
    }
    
    public boolean editPet(clsCat pet){
        
        try{
           for(clsCat dog : petlist){
            if(dog.getCode().equals(pet.getCode())){
               
               
                
                dog.setName(pet.getName());
                dog.setBorn_year(pet.getBorn_year());
                dog.setColor(pet.getColor());
                dog.setBreed(pet.getBreed());
                dog.setHealth_status(pet.getHealth_status());
                
                break;
           }
        }
            return true;
        }catch(Exception e){
            return false;
        }
        
    }
    
    public boolean deletePet(clsCat pet){
        
        try{
           for(clsCat dog : petlist){
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
        
        clsCat pet = null;
        try{
            for(clsCat dog : petlist){
           
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
    
    
    
    
    public LinkedList<clsCat> getPetlist() {
        return petlist;
    }

    public void setPetlist(LinkedList<clsCat> petlist) {
        this.petlist = petlist;
    }
}
