/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Clases.clsCat;
import Clases.clsDog;
import Clases.clsPet;
import java.util.LinkedList;
import model.modelCat;
import model.modelDog;

/**
 *
 * @author luisy
 */
public class ctlPet {

    
    modelDog modelDog;
    modelCat modelCat;
    public ctlPet() {
        this.modelDog = new modelDog();
        this.modelCat = new modelCat();
    }
    
    public boolean createPet(clsPet pet){
        
        try{
            if(pet.getAnimalType()=="Gato"){
                this.modelCat.createPet((clsCat) pet);
            }else{
                this.modelDog.createPet((clsDog) pet);
            }
            return true;
        }catch(Exception e){
            return false;
        }
        
    }
    
    public boolean editPet(clsPet pet){
        
        try{
            if(pet.getAnimalType()=="Gato"){
                this.modelCat.editPet((clsCat) pet);
            }else{
                this.modelDog.editPet((clsDog) pet);
            }
            return true;
        }catch(Exception e){
            return false;
        }
        
    }
    
    public boolean deletePet(clsPet pet){
        
        try{
            if(pet.getAnimalType()=="Gato"){
               this.modelCat.deletePet((clsCat) pet);
            }else{
                this.modelDog.deletePet((clsDog) pet);
            }
            return true;
        }catch(Exception e){
            return false;
        }
        
    }
    
    public clsPet searchPet(String code, String type){
        
        clsPet pet = null;
        try{
            if(type.equals("Gato")){
               pet =  this.modelCat.searchPet(code, type);
            }else{
               pet =  this.modelDog.searchPet(code, type);
            }
            return pet;
        }catch(Exception e){
            return pet;
        }
        
    }
    
    public LinkedList<clsDog> getDogList(String type){
        
        try{
            
               return modelDog.getPetlist();
            
            
        }catch(Exception e){
            return null;
        }
    }
    
    public LinkedList<clsCat> getCatList(String type){
        
        try{
            
               return modelCat.getPetlist();
            
            
        }catch(Exception e){
            return null;
        }
    }
}
