/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author luisy
 */
public class clsVeterinary extends abstHospital {
    private String name;
    private String phone;
    private String address;
    private clsDoctor doctor;
    private int vetId;

    public int getVetId() {
        return vetId;
    }

    public void setVetId(int vetId) {
        this.vetId = vetId;
    }

    public clsVeterinary(String name, String phone, String address, clsDoctor doctor) {
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.doctor = doctor;
    }

    public clsVeterinary(int vetId, String name, String phone, String address, clsDoctor doctor) {
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.doctor = doctor;
        this.vetId = vetId;
    }

    
    
    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public clsDoctor getDoctor() {
        return doctor;
    }

    public void setDoctor(clsDoctor doctor) {
        this.doctor = doctor;
    }

    @Override
    public String getPatientType() {
        return "Animal";
    }

    @Override
    public String Surgery() {
        return "Surgery Animal data";
    }
    
    
}
