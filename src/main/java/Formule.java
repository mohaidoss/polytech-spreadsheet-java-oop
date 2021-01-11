import java.util.*; 

public abstract class Formule implements Observer 
{	
    abstract double eval();
        
    public void update(Observable observable, Case CaseChanged){
	this.eval();
    }
}