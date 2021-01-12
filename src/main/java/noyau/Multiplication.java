/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package noyau;

/**
 *
 * @author MEHDI
 */
public class Multiplication extends Operationbinaire {
      @Override
    public double eval() {
        return super.droite.valeur() * super.gauche.valeur();
    }

    public Multiplication(Case g,Case d){
        super(g,d);
    }
       @Override
    public String toString(){
        return "(" + super.gauche.colonne + super.gauche.ligne + " * " + super.droite.colonne + super.droite.ligne + ")";
    }
}
