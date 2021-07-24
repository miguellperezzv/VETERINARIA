/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


import Clases.clsVeterinary;
import java.util.LinkedList;

/**
 *
 * @author luisy
 */
public class modelVet {
    LinkedList<clsVeterinary> vetlist = new LinkedList<>();

    public LinkedList<clsVeterinary> getVetlist() {
        return vetlist;
    }

    public void setVetlist(LinkedList<clsVeterinary> vetlist) {
        this.vetlist = vetlist;
    }

    public boolean createVet(clsVeterinary vet) {
        
        try{
            vetlist.add(vet);
            return true;
        }catch(Exception e){
            return false;
        }
    }

    public boolean editVet(clsVeterinary vet) {
        try{
           for(clsVeterinary v : vetlist){
            if(v.getName().equals(vet.getName())){
               
                v.setName(vet.getName());
                v.setAddress(vet.getAddress());
                v.setDoctor(vet.getDoctor());
                v.setPhone(vet.getPhone());
                break;
           }
        }
            return true;
        }catch(Exception e){
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

    public clsVeterinary searchVet(String name) {
        clsVeterinary vet = null;
        try{
            for(clsVeterinary v : vetlist){
           
                if(v.getName().equals(name)){
                    vet = v;
                    return vet;
                }
            }
        }catch(Exception e){
            return vet;
        }
        return vet;
    }
    
}
