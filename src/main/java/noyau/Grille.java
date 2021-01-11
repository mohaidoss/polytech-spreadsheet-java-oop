package noyau;

import java.util.*; 

public class Grille { //utilisation d'interface a voir
protected Map<String,Case> cases = new TreeMap<String,Case>();
int L = 20;
int C = 26;

    public void add(String colonne, int ligne, double x)
    {   
        Case c = new Case(colonne, ligne);
        c.fixervaleur(x);
        
        this.cases.put(colonne + ligne, c);
    }
    public void add(String colonne, int ligne, Formule F){
        try{
            Case c = new Case(colonne, ligne);
            c.Setformule(F);
            this.cases.put(colonne + ligne, c);
        } catch (CycleException e){
            System.out.println("Cycle detecté");
        }
    }         
    public Case getCase(String nomCase){
        return this.cases.get(nomCase);
    }    
    
    public double GetValeur( String nomCase ){
        return cases.get(nomCase).valeur();
    }
/*
    public String GetContenu( String nomCase ){
        if (cases.get(nomCase).formule == null)
           return nomCase + " " + GetValeur(nomCase);
        else
            return nomCase + " : " + cases.get(nomCase).formule.toString();
    }

    public String GetContenudev( String nomCase ){
        if (cases.get(nomCase).formule == null)
           return nomCase + " " + GetValeur(nomCase);
        else
            return nomCase + " : " + cases.get(nomCase).formule.toStringdev();
    }
  */  
}