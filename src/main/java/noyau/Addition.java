/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package noyau;

import java.util.Observable;

/**
 *
 * @author MEHDI
 */
public class Addition extends Operationbinaire{

    @Override
    public double eval() {
        return super.droite.valeur() + super.gauche.valeur();
    }

    public Addition(Case g,Case d){
        super(g,d);
    }
       @Override
    public String toString(){
        return "(" + super.gauche.colonne + super.gauche.ligne + " + " + super.droite.colonne + super.droite.ligne + ")";
    }
}
