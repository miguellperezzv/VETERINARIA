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
public class clsDog extends clsPet{
    
    private String breed;
    private boolean pedigree;

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public boolean isPedigree() {
        return pedigree;
    }

    public void setPedigree(boolean pedigree) {
        this.pedigree = pedigree;
    }

    public clsDog(String breed, boolean pedigree, String code, String name, int born_year, String color, String health_status) {
        super(code, name, born_year, color, health_status);
        this.breed = breed;
        this.pedigree = pedigree;
    }
    
    public void WalkAround(){
        System.out.println("El perro "+ super.getName()+" está caminando");
    }
    
    public void WalkAround(boolean collar){
        if (collar){
            System.out.println("El perro "+ super.getName()+" está caminando con collar");
        }else{
            System.out.println("El perro "+ super.getName()+" está caminando sin collar");
        }
            
    }
    
    public void sound(){
        System.out.println("El perro "+ this.getName()+" está haciendo WOOF");
    }
    
    @Override
    public int getNumberOfBones(){
        return 320;
    }
    
    @Override
    public String getAnimalType(){
        return "Perro";
    }
}
