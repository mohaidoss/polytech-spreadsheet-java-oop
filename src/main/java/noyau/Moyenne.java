package noyau;

import java.util.*; 

public class Moyenne extends Fonction {
    @Override
    public double eval(){
        return (super.setCase.stream().mapToDouble(m->m.valeur()).sum())/(super.setCase.size());
    }
}