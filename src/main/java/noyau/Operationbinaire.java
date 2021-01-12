package noyau;

import java.util.*; 
/**TODO: on trouve pas la division, multiplication o reste. Faire attention */
public abstract class Operationbinaire extends Formule {
    public Case gauche;
    public Case droite;
    @Override
    public abstract double eval() throws OperationImpossibleException;
    public boolean dansCycle(Case c){
        if (this.droite == c || this.gauche == c)
            return true;
        else if (this.gauche.formule == null && this.droite.formule == null)
            return false;
        else
            return (this.dansCycle(c) || this.dansCycle(c));
    }
    public Operationbinaire(Case g,Case d){
        gauche = g;
        droite = d;
    }
}