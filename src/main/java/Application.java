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
        Grille grille = new Grille();
        grille.add("A", 1, 100.0);
        grille.add("A", 2, 50.0);
        grille.add("B", 2, 12.0);
        
        Formule f_add = Addition("A1","A2");
        grille.add("C", 1, f_add);
        
    }
    
}