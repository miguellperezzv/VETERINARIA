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
public class clsCat extends clsPet {
    
    
    private String breed;

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public clsCat(String code, String name, int born_year, String color, String health_status, String breed) {
        
        super(code, name, born_year, color, health_status);
        this.breed = breed;
    }
    
    public void SelfCleaning(){
        System.out.println("El gato "+ super.getName() + " se está limpiando");
    }
    
    public void sound(){
        System.out.println("El gato "+ this.getName()+" está haciendo MEOW");
    }
    
    @Override
    public int getNumberOfBones(){
        return 230;
    }
    
    @Override
    public String getAnimalType(){
        return "Gato";
    }
    
}
