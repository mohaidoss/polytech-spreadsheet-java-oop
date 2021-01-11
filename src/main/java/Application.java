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
        double a = 100.0;
        g.add("A", 1, a);
        g.add("A", 2, 50.0);
        g.add("B", 2, 12.0);
        
        Formule f_add = null;
        
        g.add("C", 1, f_add);
    }
    
}
