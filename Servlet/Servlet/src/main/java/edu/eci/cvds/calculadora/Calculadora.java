package edu.eci.cvds.calculadora;

import java.util.ArrayList;
import java.util.Random;

import javax.faces.bean.ApplicationScoped; 
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.*;

@ManagedBean(name = "calculadoraBean")
@ApplicationScoped

@SessionScoped
public class Calculadora{
	
    public Calculadora(){     	
    }

    public static double mean(double[] m) {
        double sum = 0;
        for (int i = 0; i < m.length; i++) {
            sum += m[i];
        }
        return sum / m.length;
    }
    
    public static double variance(double m[]){
        double sqDiff = 0;
        double n = m.length;
        for (int i = 0; i < n; i++) 
            sqDiff += (m[i] - mean(m)) * (m[i] - mean(m));
         
        return (double)sqDiff/n;
    }
    
    public static double standardDeviation(double m[]){
        return Math.sqrt(variance(m));
    }
    
    public static double mode(double m[]) {
        double maxValue = 0; 
        double maxCount = 0;
        double n = m.length;
        for (int i = 0; i < n; ++i) {
           double count = 0;
           for (int j = 0; j < n; ++j) {
              if (m[j] == m[i])
              ++count;
           }
           if (count > maxCount) {
              maxCount = count;
              maxValue = m[i];
           }
        }
        return maxValue;
     }
}
    

