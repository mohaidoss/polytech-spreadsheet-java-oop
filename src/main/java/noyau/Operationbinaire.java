package noyau;

import java.util.*; 
/**TODO: on trouve pas la division, multiplication o reste. Faire attention */
public abstract class Operationbinaire extends Formule {
    public Case gauche;
    public Case droite;
    
    public Operationbinaire(Case g,Case d){
        gauche = g;
        droite = d;
    }
}