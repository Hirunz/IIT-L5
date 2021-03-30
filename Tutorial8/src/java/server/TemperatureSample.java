/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.Serializable;

/**
 *
 * @author Hirunz
 */
public class TemperatureSample implements Serializable{
        Double value=null;


    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "TemperatureSample{" + "value=" + value + '}';
    }
    
    
    

    

}
