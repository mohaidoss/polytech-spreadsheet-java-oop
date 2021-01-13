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

    public void Setformule( Formule F ) throws CycleException, OperationImpossibleException
    {
        if (F.dansCycle(this))
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
        this.valeur = 0;
        this.formule = (Formule) null;
    }
}