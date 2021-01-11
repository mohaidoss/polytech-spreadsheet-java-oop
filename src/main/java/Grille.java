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

    public double GetValeur( String nomCase ){
        return cases.get(nomCase).valeur();
    }

    public String GetContenu( String nomCase ){
        return "la formule utilisé blabla" + cases.get(nomCase).valeur();
    }

    public String GetContenudev( String nomCase ){
        return "Les formules utilisés en détail blabla" + cases.get(nomCase).valeur();
    }
}