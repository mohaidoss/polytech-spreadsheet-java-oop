
import java.util.Observable;


public class Case extends Observable{
    String nomCase;
    private double valeur;
    Formule formule;

    public void fixervaleur (double x)
    {
        this.valeur=x;
	setChanged();
	notifyObservers();
    }
    
    boolean dansCycle(Fonction F){
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
        else if (F.droite.formule == null && F.gauche.formule == null)
            return false;
        else
            return (this.dansCycle(F.droite.formule) || F.droite.dansCycle(F));
    }
    
    public void Setformule( Operationbinaire F ) throws CycleException
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

    public void Setformule(Fonction F) throws CycleException
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
    
    public Case(String cellN)
    {
        this.nomCase = cellN;
    }
}