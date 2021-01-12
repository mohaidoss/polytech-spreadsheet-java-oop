package noyau;

import java.util.*; 
import java.io.*;

public class Grille implements Observer{ //utilisation d'interface a voir
    Map<String,Case> cases;
    int L ;
    int C ;
    public void save() throws IOException, ClassNotFoundException{     
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("grille.bin"));
        out.writeObject(cases);
        out.close();
    }
    public void load(String fileName) throws IOException, ClassNotFoundException{
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName));
        cases = (TreeMap<String,Case>) in.readObject();
        in.close();
    }
    public void add(String colonne, int ligne, double x)
    {   /** 
    TODO: la cuqalite du code des add n'est pas bonne, on a beaucoup des lignes repetees plusieurs fois
    je te conseille de faire une methode auxiliere qui gere s'il faut o non creer une nouvelle instance, genre prendreOuInstantier(colonne, ligne).
    Il faudrait un argument tres for pour avoir utilise hashmap. 
    Pense a ca lors de  la confection du report.

    */
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

    /** TODO: Le code commente est une indication de mauvaise qualite de code. fait attention */
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