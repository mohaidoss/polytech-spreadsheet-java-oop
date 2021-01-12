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
    
    public Case getCase(String nomCase){
        return this.cases.get(nomCase);
    }
    
    public Case getCase(String colonne, int ligne){
        if (this.cases.get(colonne + ligne) == null)
            return new Case(colonne,ligne);
        else
            return this.cases.get(colonne+ligne);
    }

    public void add(String colonne, int ligne, double x)
    {   
        Case c = this.getCase(colonne,ligne);   
        c.fixervaleur(x);
        c.addObserver(this);
        this.cases.put(colonne + ligne, c);
    
    }
    public void add(String colonne, int ligne, Formule F) {
        Case c = this.getCase(colonne,ligne);
        try{
            c.Setformule(F);
            c.addObserver(this);
            this.cases.put(colonne + ligne, c);
        } catch (OperationImpossibleException e){
            System.out.println("ERREUR FORMULE");
        } catch (CycleException e){
            System.out.println("Cycle detecté");
        }
    }         
    
    public double GetValeur( String nomCase ){
        return cases.get(nomCase).valeur();
    }

    public String GetContenu( String nomCase ){
        if (this.cases.get(nomCase).formule == null)
           return nomCase + " : " + GetValeur(nomCase);
        else
            return nomCase + " : " + this.cases.get(nomCase).formule.toString();
    }
  
    public Grille(){
        this.C = 26;
        this.L = 20;
        this.cases = new TreeMap<>();
    }

    @Override
    public void update (Observable obs, Object arg) {
        System.out.println("update khdem ");
        this.cases.values().stream()
                .filter(c -> c.formule != null)
                .forEach(c -> {
                    try {
                        c.fixervaleur(c.formule.eval());
                    } catch (OperationImpossibleException ex) {
                        System.out.println("ERREUR FORMULE DANS " + c.colonne + c.ligne);
                    }
        });
    }
}