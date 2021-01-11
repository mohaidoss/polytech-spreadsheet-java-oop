package noyau;

import java.util.*; 

public class Somme extends Fonction {
    public double eval(){
        return (super.setCase.stream().mapToDouble(m->m.valeur()).sum());
    }
    public void update(Observable o, Object arg) {
        this.eval();
    }
}