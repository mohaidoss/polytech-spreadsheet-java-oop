package noyau;

import java.util.*; 

public abstract class Fonction extends Formule{
    /**TODO: le type set ne garantis pas l'ordre des cases. Pour la somme n'est pas un probleme, de qu'on veut implementer des fonctions non commutatives on aurais des problemes ici.
    Aussi, le set ne laisse pas la repetition. De qu'on veut utiliser la meme case pour plusieurs parties d'une fonction, on ne peut pas non plus. 
    */
    public List<Case> setCase = new ArrayList();
    @Override
    public abstract double eval() throws OperationImpossibleException;
    @Override
    public boolean dansCycle(Case c){
        if (this.setCase.contains(c))
            return true;
        else if (this.setCase.stream().allMatch(cs -> cs.formule == null))
            return false;
        else
            return (this.setCase.stream().filter(cs -> cs.formule != null).filter(cs -> this.dansCycle(c)).toArray().length) == 0;    
    }
    
    public Fonction( List<Case> setCase){
        this.setCase = setCase;
    }
}