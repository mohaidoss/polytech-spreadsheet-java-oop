package noyau;


import java.util.Observable;
import java.io.*;

public class Case extends Observable implements Serializable{
    String colonne;
    int ligne;
    private double valeur;
    Formule formule;

    public void fixervaleur (double x)
    {
        if (this.valeur != x){
            this.valeur=x;
            setChanged();
            notifyObservers(this);
        }
    }
    
    boolean dansCycle(Formule F){

        /** TODO: Cet method a rien de oriente objet. en oritente objet l'utilisation de instanceof est interdit. Il faut repenser tout ce method en pensant a deleguer. 
         Il faut penser a a F.dansCycle(this), qui va faire le bon morceau de code. 
         Apres ici on a le cas ou ils sont tous des formules ou aucun. C'est pas si facile il faut penser au tout les possibles case. 
         
        
          */
        if(F instanceof Fonction){
            if (((Fonction) F).setCase.contains(this))
                return true;
            else if (((Fonction) F).setCase.stream().allMatch(c -> c.formule == null))
                return false;
            else
                return (((Fonction) F).setCase.stream().filter(c -> c.formule != null).filter(c -> this.dansCycle(c.formule)).toArray().length) == 0;
//(((Fonction) F).setCase.stream().filter(c -> c.formule != null).forEach(c -> this.dansCycle(c.((Fonction) formule))));
        }
        else if (F instanceof Operationbinaire){
            if (((Operationbinaire) F).droite == this || ((Operationbinaire) F).gauche == this)
                return true;
            else if (((Operationbinaire) F).gauche.formule == null && ((Operationbinaire) F).droite.formule == null)
                return false;
            else
                return (this.dansCycle(((Operationbinaire) F).droite.formule) || this.dansCycle(((Operationbinaire) F).gauche.formule));
        }
        return false;
    }
    /*boolean dansCycle(Fonction F){
        if (F.setCase.contains(this))
            return true;
        else if (F.setCase.stream().allMatch(c -> c.formule == null))
            return false;
        else
            return (F.setCase.stream().filter(c -> c.formule != null).forEach(c -> this.dansCycle(c.formule)));
    }
    boolean dansCycle(Operationbinaire F){
        if (F.droite == this || F.gauche == this)
            return true;
        else if (F.gauche.formule == null && F.droite.formule == null)
            return false;
        else
            return (this.dansCycle(F.droite.formule) || this.dansCycle(F.gauche.formule));
    }
    */
    public void Setformule( Formule F ) throws CycleException
    {
        if (this.dansCycle(F))
            throw new CycleException();
        else {
            this.formule = F;
            double x = F.eval();
            if (this.valeur() != x){
                this.fixervaleur(x);
                setChanged();
                notifyObservers(this);
            }
        }
    }
    
    
    public double valeur()
    {         
        return valeur;
    }
    
    public Case(String col, int lig)
    {
        this.colonne = col;
        this.ligne = lig;
    }
}