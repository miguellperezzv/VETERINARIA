/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Interfaces.IAnimal;
import Interfaces.IVertebrate;

/**
 *
 * @author luisy
 */
public class clsPet  implements IAnimal,IVertebrate{
    private String code;
    private String name;
    private int born_year;
    private String color;
    private String health_status;
    private clsVeterinary veterinary;

    public clsPet(String code, String name, int born_year, String color, String health_status) {
        this.code = code;
        this.name = name;
        this.born_year = born_year;
        this.color = color;
        this.health_status = health_status;
    }

    
    
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBorn_year() {
        return born_year;
    }

    public void setBorn_year(int born_year) {
        this.born_year = born_year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getHealth_status() {
        return health_status;
    }

    public void setHealth_status(String health_status) {
        this.health_status = health_status;
    }

    public clsVeterinary getVeterinary() {
        return veterinary;
    }

    public void setVeterinary(clsVeterinary veterinary) {
        this.veterinary = veterinary;
    }
    
    public void eat(){
        System.out.println("La mascota "+ this.getName()+" está comiendo");
    }
    
    public void move(){
        System.out.println("La mascota "+ this.getName()+" se está moviendo");
    }
    
    public void sound(){
        System.out.println("La mascota "+ this.getName()+" está haciendo ");
    }

    @Override
    public String getAnimalType() {
        return "Domèstico";
    }

    @Override
    public int getNumberOfBones() {
        return 0;
    }
    
}
