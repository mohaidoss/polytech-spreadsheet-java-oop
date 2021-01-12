package noyau;

import java.util.*; 

public class Grille implements Observer{ //utilisation d'interface a voir
Map<String,Case> cases;
int L ;
int C ;

    public void add(String colonne, int ligne, double x)
    {   
        if (this.cases.get(colonne + ligne) == null){
            Case c = new Case(colonne, ligne);
            c.fixervaleur(x);
            c.addObserver(this);
            this.cases.put(colonne + ligne, c);
        } else {
            Case c = this.cases.get(colonne + ligne);
            c.fixervaleur(x);
            c.addObserver(this);
            this.cases.put(colonne + ligne, c);
        }
    
    }
    public void add(String colonne, int ligne, Formule F){
        try{
            if (this.cases.get(colonne + ligne) == null){
                Case c = new Case(colonne, ligne);
                c.Setformule(F);
                c.addObserver(this);
                this.cases.put(colonne + ligne, c);
            } else {
                Case c = this.cases.get(colonne+ligne);
                c.Setformule(F);
                c.addObserver(this);
                this.cases.put(colonne + ligne, c);
            }
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
    public Grille(){
        this.C = 26;
        this.L = 20;
        this.cases = new TreeMap<>();
    }

    @Override
    public void update(Observable obs, Object arg) {
        System.out.println("update khdem ");
        this.cases.values().stream().filter(c -> c.formule != null).forEach(c -> c.fixervaleur(c.formule.eval()));
    }
}