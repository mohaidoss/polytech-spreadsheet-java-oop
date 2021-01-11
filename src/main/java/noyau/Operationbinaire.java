package noyau;

import java.util.*; 

public abstract class Operationbinaire extends Formule {
    public Case gauche;
    public Case droite;
    public void init(Case CaseObserverG, Case CaseObserverD){
        CaseObserverG.addObserver(this);
        CaseObserverD.addObserver(this);
    }
    
    public Operationbinaire(Case g,Case d){
        gauche = g;
        droite = d;
    }
}