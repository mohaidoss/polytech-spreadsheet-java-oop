import java.util.*; 

public abstract class Operationbinaire extends Formule {
    Case gauche;
    Case droite;
    void init(Case CaseObserverG, Case CaseObserverD){
        CaseObserverG.addObserver(this);
        CaseObserverD.addObserver(this);
    }
    
}