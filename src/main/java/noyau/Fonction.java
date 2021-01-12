package noyau;

import java.util.*; 

public abstract class Fonction extends Formule{
    /**TODO: le type set ne garantis pas l'ordre des cases. Pour la somme n'est pas un probleme, de qu'on veut implementer des fonctions non commutatives on aurais des problemes ici.
    Aussi, le set ne laisse pas la repetition. De qu'on veut utiliser la meme case pour plusieurs parties d'une fonction, on ne peut pas non plus. 
    */
    public Set<Case> setCase = new HashSet<Case>();
}