package noyau;

import java.util.*; 

public class Somme extends Fonction {
    public double eval(){
        return (super.setCase.stream().mapToDouble(m->m.valeur()).sum());
    }
    public Somme(List<Case> setCase){
        super(setCase);
    }
    
    @Override
    public String toString(){
        String s = "SOMME(";
        for(Case i : setCase){
            s += i.colonne + i.ligne +", ";
        }
        return s + ")";
    }
}