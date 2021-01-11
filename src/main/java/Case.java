
import java.util.Observable;


public class Case extends Observable{
    String colonne;
    int ligne;
    double valeur;
    Formule formule;

    public void fixervaleur (double x)
    {
        this.valeur=x;
	setChanged();
	notifyObservers();
    }
    
    public void Setformule( Operationbinaire F ) throws CycleException
    {
        if (F.droite == this || F.gauche == this)
            throw new CycleException();
        else {
            this.formule = F;
            setChanged();
            notifyObservers();
            this.fixervaleur(F.eval());
        }
    }

    public void Setformule(Fonction F) throws CycleException
    {
        if (F.setCase.contains(this))
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
    
    public Case(String col, int lin)
    {
        
        colonne = col;
        ligne = lin;
    }
}