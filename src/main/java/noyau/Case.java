package noyau;


import java.util.Observable;


public class Case extends Observable{
    String colonne;
    int ligne;
    private double valeur;
    Formule formule;

    public void fixervaleur (double x)
    {
        this.valeur=x;
	setChanged();
	notifyObservers();
    }
    
    boolean dansCycle(Formule F){
        if(F instanceof Fonction){
            if (F.setCase.contains(this))
                return true;
            else if (F.setCase.stream().allMatch(c -> c.formule == null))
                return false;
            else
                return (F.setCase.stream().filter(c -> c.formule != null).forEach(c -> this.dansCycle(c.formule)));
        }
        else {
            if (F.droite == this || F.gauche == this)
                return true;
            else if (F.gauche.formule == null && F.droite.formule == null)
                return false;
            else
                return (this.dansCycle(F.droite.formule) || this.dansCycle(F.gauche.formule));
        }
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
            setChanged();
            notifyObservers();
            this.fixervaleur(F.eval());
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