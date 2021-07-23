/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veterinaria;

import Clases.clsCat;
import Clases.clsDoctor;
import Clases.clsDog;
import Clases.clsVeterinary;
import View.frmPetManager;
import java.util.Date;

/**
 *
 * @author luisy
 */
public class Principal {
    
    public static void main (String args[]){
        
        frmPetManager frame = new frmPetManager();
        frame.setVisible(true);
        
        //EJERCICIO DE ABSTRACT CLASS
        System.out.println("\nEJERCICIO DE ABSTRACT CLASS.............................");
        clsDoctor doctor1 = new clsDoctor("Gerardo Galindo", "Lic1234");
        clsVeterinary veterinary  =new clsVeterinary("VETERINARIA", "12345", "CLL15#10B", doctor1);
        
        veterinary.setData(veterinary.getName() +" - " +veterinary.getAddress());
        
        String data = veterinary.getData();
        String type = veterinary.getPatientType();
        String surgery = veterinary.Surgery();
        
        System.out.println("Data: "+ data);
        System.out.println("type: " + type);
        System.out.println("surgery: "+ surgery);
        
        
        //EJERCICIO DE INTERFACE
        System.out.println("\nEJERCICIO DE INTERFACE.............................");
        clsCat cat1 = new clsCat("001","Motas José", 2013, "Negro", "Sano", "Angora" );
        clsDog dog1 = new clsDog("Criollito", true, "001","Motas David", 2013, "Negro", "Sano" );
        
        System.out.println(cat1.getName() + " ES ANIMAL DE TIPO "+ cat1.getAnimalType());
        System.out.println(cat1.getName()+ " TIENE " +cat1.getNumberOfBones()+ " HUESOS");
        
        System.out.println(dog1.getName() + "ES ANIMAL DE TIPO "+ dog1.getAnimalType());
        System.out.println(dog1.getName()+ "TIENE " +dog1.getNumberOfBones()+ " HUESOS");
        
        //EJERCIICIO DE POLIMORFISMO SOBREESCRITURA SOBRECARGA
        System.out.println("\nEJERCIICIO DE POLIMORFISMO SOBREESCRITURA SOBRECARGA.............................");
        clsDoctor doctor2 = new clsDoctor("Gerardo Galindo", "Lic1234");
        clsVeterinary veterinaria1  =new clsVeterinary("VETERINARIA", "12345", "CLL15#10B", doctor2);
        System.out.println(veterinaria1.getName()+ " ATENIDO POR "+ veterinaria1.getDoctor().getName());
        
       
        clsCat cat2 = new clsCat("001","Motas José", 2013, "Negro", "Sano", "Angora" );
        clsDog dog2 = new clsDog("Criollito", true, "001","Motas David", 2013, "Negro", "Sano" );
        
        Date current_date = new Date();
        int current_year = current_date.getYear();
        
        int agePet1 =  current_year - dog2.getBorn_year();
        int agePet2 = current_year - cat2.getBorn_year();
        
        if(agePet1>agePet2){
            System.out.println("La mascota "+ dog2.getName()+ " es mayor que la mascota "+ cat2.getName());
        }else
        if(agePet2>agePet1){
            System.out.println("La mascota "+ cat2.getName()+ " es mayor que la mascota "+ dog2.getName());
        }else{
            System.out.println("La mascota "+ cat2.getName()+ " tiene la misma edad que la mascota "+ dog2.getName());
        }
        
        dog2.eat();
        cat2.eat();
        cat2.move();
        cat2.sound();
        dog2.WalkAround();
        dog2.WalkAround(true);
        dog2.WalkAround(false);
        cat2.SelfCleaning();
    }
    
}
