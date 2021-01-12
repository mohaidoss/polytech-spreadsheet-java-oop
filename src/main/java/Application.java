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

public class Application {

    public static void main(String[] args) {    
        Grille g = new Grille();
        g.add("A", 1, 100.0);
        g.add("A", 2, 50.0);
        g.add("B", 2, 12.0);
        System.out.println("Hello this is B2 " + g.getCase("B2").valeur());

        Formule f_add = new Addition(g.getCase("A2"),g.getCase("B2"));
        
        g.add("C", 1, f_add);
        System.out.println("Hello this is C1 " + g.getCase("C1").valeur());
      //  g.getCase("B2").addObserver(g);
        g.add("B", 2, 50);
        System.out.println("Hello this is B2 " + g.getCase("B2").valeur());

        System.out.println("Hello this is C1 " + g.getCase("C1").valeur());
    }
    
}
