package noyau;

import java.util.*; 
import java.util.Observer;
public abstract class Formule implements Observer
{
    public abstract double eval();   
    
    public void update(Observable observable, Case CaseChanged){
	this.eval();
    }
    
    //public abstract String toStringdev();
}