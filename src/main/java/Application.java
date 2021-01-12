/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MEHDI
 */
import noyau.*;
import java.io.*;
public class Application{

    public static void main(String[] args) throws IOException, ClassNotFoundException{    
        Grille g = new Grille();
        g.add("A", 1, 100.0);
        g.add("A", 2, 50.0);
        g.add("B", 2, 12.0);
        System.out.println("Hello this is B2 " + g.getCase("B2").valeur());

        Formule f_add = new Addition(g.getCase("A2"),g.getCase("B2"));
        
        g.add("C", 1, f_add);
        System.out.println("Hello this is C1 " + g.getCase("C1").valeur());

        g.add("B", 2, 50);
        System.out.println("Hello this is B2 " + g.getCase("B2").valeur());
        Formule f_addcycle = new Addition(g.getCase("A1"),g.getCase("C1"));
        
        g.add("C", 1, f_addcycle);
        System.out.println("Hello this is C1 " + g.getCase("C1").valeur());
        
        g.save();
        /* LOAD SERIALIZABLE
        g.load("grille.bin");
        System.out.println("Hello this is C1 " + g.getCase("C1").valeur());
        System.out.println("Hello this is B2 " + g.getCase("B2").valeur());
        */
    }
    
}
