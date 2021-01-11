import java.util.*; 

public abstract class Fonction extends Formule{
    protected Set<Case> setCase = new HashSet<Case>();
    void init(){
        setCase.stream().forEach(c -> c.addObserver(this));
    }
}