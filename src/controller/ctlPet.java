/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Clases.clsCat;
import Clases.clsDoctor;
import Clases.clsDog;
import Clases.clsPet;
import Clases.clsVeterinary;
import java.util.LinkedList;
import model.modelCat;
import model.modelDoctor;
import model.modelDog;
import model.modelVet;

/**
 *
 * @author luisy
 */
public class ctlPet {

    
    modelDog modelDog;
    modelCat modelCat;
    modelDoctor modelDoctor;
    modelVet modelVet;
    
    public ctlPet() {
        this.modelDog = new modelDog();
        this.modelCat = new modelCat();
        this.modelDoctor = new modelDoctor();
        this.modelVet = new modelVet();
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
    
    public boolean createDoctor(clsDoctor doctor){
        
        try{
            this.modelDoctor.createDoctor(doctor);
            return true;
        }catch(Exception e){
            return false;
        }
        
    }
    
    public boolean editDoctor(clsDoctor doctor){
        
        try{
            
            this.modelDoctor.editDoctor(doctor);
            
            return true;
        }catch(Exception e){
            return false;
        }
        
    }
    
    public boolean deleteDoctor(clsDoctor doctor){
        
        try{
            
                this.modelDoctor.deleteDoctor(doctor);
            
            return true;
        }catch(Exception e){
            return false;
        }
        
    }
    
    public clsDoctor searchDoc(int doctorId){
        
        clsDoctor doc = null;
        try{
            
               doc =  this.modelDoctor.searchDoctor(doctorId);
            
            return doc;
        }catch(Exception e){
            return doc;
        }
        
    }
    
    public boolean createVet(clsVeterinary vet){
        
        try{
            this.modelVet.createVet(vet);
            return true;
        }catch(Exception e){
            return false;
        }
        
    }
    
    public boolean editVet(clsVeterinary vet){
        
        try{
            
            this.modelVet.editVet(vet);
            
            return true;
        }catch(Exception e){
            return false;
        }
        
    }
    
    public boolean deleteVet(clsVeterinary vet){
        
        try{
            
                this.modelVet.deleteVet(vet);
            
            return true;
        }catch(Exception e){
            return false;
        }
        
    }
    
    public clsVeterinary searchVet(int id){
        
        clsVeterinary vet = null;
        try{
            
               vet =  this.modelVet.searchVet(id);
            
            return vet;
        }catch(Exception e){
            return vet;
        }
        
    }
    
    
    
    
    public LinkedList<clsDog> getDogList(String type){
        /*
        try{
            
               return modelDog.getPetlist();
            
            
        }catch(Exception e){
            return null;
        }
    */
        return null;
    }
    
    public LinkedList<clsCat> getCatList(String type){
        
        try{
            
               return modelCat.getPetlist();
            
            
        }catch(Exception e){
            return null;
        }
    }

    public LinkedList<clsDoctor> getDocList() {
        try{
            
               return modelDoctor.getDoctorlist();
            
            
        }catch(Exception e){
            return null;
        }
    
    }
    
    public LinkedList<clsVeterinary> getVetList() {
        try{
            
               return modelVet.getVetlist();
            
            
        }catch(Exception e){
            return null;
        }
    
    }

    
}
