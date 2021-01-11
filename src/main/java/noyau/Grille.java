package noyau;

import java.util.*; 

public class Grille { //utilisation d'interface a voir
protected Map<String,Case> cases = new TreeMap<String,Case>();
int L = 20;
int C = 26;

    public void Settaille( int L, int C){
        Scanner sc = new Scanner(System.in);
        this.L= sc.nextInt();
        this.C= sc.nextInt();
    }

    public void add(String colonne, int ligne, double x)
    {   
        Case c = new Case(colonne, ligne);
        c.fixervaleur(x);
        
        cases.put(colonne + ligne, c);
    }
    public void add(String colonne, int ligne, Formule F){
        Case c = new Case(colonne, ligne);
        c.Setformule(F);
        
        cases.put(colonne + ligne, c);
    }         
            
    public double GetValeur( String nomCase ){
        return cases.get(nomCase).valeur();
    }

    public String GetContenu( String nomCase ){
        return "la formule utilisé blabla" + cases.get(nomCase).valeur();
    }

    public String GetContenudev( String nomCase ){
        return "Les formules utilisés en détail blabla" + cases.get(nomCase).valeur();
    }
    
    public Grille(){        
    }
}