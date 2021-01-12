/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package noyau;

import java.io.*;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author MEHDI
 */
public abstract class Formule implements Serializable{
    public abstract double eval();   
    public Formule(){}
    //public abstract String toStringdev();
}
