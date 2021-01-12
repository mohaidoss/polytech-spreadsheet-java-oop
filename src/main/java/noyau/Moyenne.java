package noyau;

import java.util.*; 

public class Moyenne extends Fonction {
    @Override
    public double eval(){
        /** TODO: Commentest-ce que tu  pense gerer le case de formule sans cases?= 0/0 */
        return (super.setCase.stream().mapToDouble(m->m.valeur()).sum())/(super.setCase.size());
    }
}