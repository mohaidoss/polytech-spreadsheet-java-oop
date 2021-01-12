package noyau;

import java.util.*; 

public class Moyenne extends Fonction {
    @Override
    public double eval() throws OperationImpossibleException{
        if( super.setCase.isEmpty())
            throw new OperationImpossibleException();
        else
            return (super.setCase.stream().mapToDouble(m->m.valeur()).sum())/(super.setCase.size());
    }
    
    public Moyenne(List<Case> setCase){    
        super(setCase);
    }
    
    @Override
    public String toString(){
        String s = "MOYENNE(";
        for(Case i : setCase){
            s += i.colonne + i.ligne +", ";
        }
        return s + ")";
    }
}