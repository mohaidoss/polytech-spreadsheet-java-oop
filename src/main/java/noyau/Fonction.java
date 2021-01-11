package noyau;

import java.util.*; 

public class Fonction extends Formule{
    public Set<Case> setCase = new HashSet<Case>();
    public void init(){
        setCase.stream().forEach(c -> c.addObserver(this));
    }
}