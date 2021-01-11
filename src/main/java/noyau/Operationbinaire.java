package noyau;

import java.util.*; 

public abstract class Operationbinaire extends Formule {
    public Case gauche;
    public Case droite;
    
    public Operationbinaire(Case g,Case d){
        gauche = g;
        droite = d;
    }
}