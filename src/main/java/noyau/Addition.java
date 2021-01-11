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

    @Override
    public void update(Observable o, Object arg) {
        this.eval();
    }    
    
    public Addition(Case g,Case d){
        super(g,d);
    }
}
