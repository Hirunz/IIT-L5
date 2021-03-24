/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Hirunz
 */
@WebService(serviceName = "Tutorial5WebService")
public class Tutorial5WebService {

    ArrayList<TemperatureSample> samples = new ArrayList();
    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "isConnected")
    public Boolean isConnected() {
        System.out.println("[SERVER] - Testing Connection...");
        return true;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "addSample")
    public Boolean addSample(@WebParam(name = "sample") TemperatureSample sample) throws Exception {
        if(sample==null){
            throw new Exception();
        }
        System.out.println("[SERVER - addSample("+sample+") to"+samples);
        samples.add(sample);
        System.out.println("[SERVER] - Now samples are "+samples);
        return true;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getNumberOfSamples")
    public Integer getNumberOfSamples() {
        System.out.println("[SERVER] - getNumberOfSamples()");
        return samples.size();
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getMaximum")
    public TemperatureSample getMaximum() throws Exception {
        if(samples.isEmpty()){
            throw new Exception();
        }
        TemperatureSample max = new TemperatureSample();
        max=samples.get(0);
        for(int i=0; i< samples.size();i++){
            if(samples.get(i).getValue() > max.getValue()){
                max=samples.get(i);
            }
        }
        
        return max;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getMinimum")
    public TemperatureSample getMinimum() throws Exception {
        if(samples.isEmpty()){
            throw new Exception();
        }
        TemperatureSample min = new TemperatureSample();
        min=samples.get(0);
        for(int i=0; i< samples.size();i++){
            if(samples.get(i).getValue() < min.getValue()){
                min=samples.get(i);
            }
        }
        
        return min;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getAverage")
    public Double getAverage() throws Exception {
        if(samples.isEmpty()){
            throw new Exception();
        }
        
        Double total=0.0;
        for(int i=0; i< samples.size();i++){
            total+=samples.get(i).getValue();
        }
        
        if(total == 0.0){
            throw new Exception();
        }
        return total;
    }

}
