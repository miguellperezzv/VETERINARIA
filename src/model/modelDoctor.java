/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import Clases.clsCat;
import Clases.clsDoctor;
import java.util.LinkedList;

/**
 *
 * @author luisy
 */
public class modelDoctor {
    
    LinkedList<clsDoctor> doctorlist = new LinkedList<>();

    public LinkedList<clsDoctor> getDoctorlist() {
        return doctorlist;
    }

    public void setDoctorlist(LinkedList<clsDoctor> doctorlist) {
        this.doctorlist = doctorlist;
    }

    public boolean createDoctor(clsDoctor doctor) {
        
        try{
            doctorlist.add(doctor);
            return true;
        }catch(Exception e){
            return false;
        }
    }

    public boolean editDoctor(clsDoctor doctor) {
        try{
           for(clsDoctor doc : doctorlist){
            if(doc.getLicense().equals(doctor.getLicense())){
               
                doc.setName(doctor.getName());
                break;
           }
        }
            return true;
        }catch(Exception e){
            return false;
        }
    }

    public boolean deleteDoctor(clsDoctor doctor) {
         try{
           for(clsDoctor doc : doctorlist){
            if(doc.getLicense().equals(doctor.getLicense())){
                
                this.doctorlist.remove(doc);
                break;
           }
        }
           
            return false;
        }catch(Exception e){
            return false;
        }
    }

    public clsDoctor searchDoctor(String code) {
        clsDoctor doctor = null;
        try{
            for(clsDoctor doc : doctorlist){
           
                if(doc.getLicense().equals(code)){
                    doctor = doc;
                    return doctor;
                }
            }
        }catch(Exception e){
            return doctor;
        }
        return doctor;
    }
    
    
    
}
