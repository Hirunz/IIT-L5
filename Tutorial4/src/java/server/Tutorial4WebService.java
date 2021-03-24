/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Hirunz
 */
@WebService(serviceName = "Tutorial4WebService")
public class Tutorial4WebService {

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
        System.out.println("{SERVER] - Testing Connection");
        return true;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "add")
    public Double add(@WebParam(name = "num1") Double num1, @WebParam(name = "num2") Double num2) {
        System.out.println("[SERVER] - ADDING ( "+num1+" + "+num2+" )...");
        return num1+num2;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "addExceptions")
    public Double addExceptions(@WebParam(name = "a") Double a, @WebParam(name = "b") Double b) throws Exception {
       System.out.println("[SERVER] - ADDING ( "+a+" + "+b+" )...");
       if(a==null || b==null){
           System.err.println("[SERVER] - Either a or b cannot be null");
           throw new Exception();
       }
       if(a==null && b==null){
           System.err.println("[SERVER] - Either a or b cannot be null");
           throw new Exception();
       }
        return a+b;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "substract")
    public Double substract(@WebParam(name = "a") Double a, @WebParam(name = "b") Double b) {
        System.out.println("[SERVER] - Substracting ( "+a+" - "+b+" )...");
        return a-b;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "multiply")
    public Double multiply(@WebParam(name = "a") Double a, @WebParam(name = "b") Double b) {
        System.out.println("[SERVER] - Multiplying ( "+a+" x "+b+" )...");
        return a*b;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "divide")
    public Double divide(@WebParam(name = "a") Double a, @WebParam(name = "b") Double b) {
        System.out.println("[SERVER] - Dividing ( "+a+" / "+b+" )...");
        return a/b;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "substractExceptions")
    public Double substractExceptions(@WebParam(name = "a") Double a, @WebParam(name = "b") Double b) throws Exception {
        System.out.println("[SERVER] - Substracting ( "+a+" - "+b+" )...");
       if(a==null || b==null){
           System.err.println("[SERVER] - Either a or b cannot be null");
           throw new Exception();
       }
       if(a==null && b==null){
           System.err.println("[SERVER] - Either a or b cannot be null");
           throw new Exception();
       }
        return a-b;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "multiplyExceptions")
    public Double multiplyExceptions(@WebParam(name = "a") Double a, @WebParam(name = "b") Double b) throws Exception {
        System.out.println("[SERVER] - ADDING ( "+a+" x "+b+" )...");
       if(a==null || b==null){
           System.err.println("[SERVER] - Either a or b cannot be null");
           throw new Exception();
       }
       if(a==null && b==null){
           System.err.println("[SERVER] - Either a or b cannot be null");
           throw new Exception();
       }
        return a*b;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "divideExceptions")
    public Double divideExceptions(@WebParam(name = "a") Double a, @WebParam(name = "b") Double b) throws Exception {
        System.out.println("[SERVER] - ADDING ( "+a+" / "+b+" )...");
       if(a==null || b==null){
           System.err.println("[SERVER] - Either a or b cannot be null");
           throw new Exception();
       }
       if(a==null && b==null){
           System.err.println("[SERVER] - Either a or b cannot be null");
           throw new Exception();
       }
       if(b==0 || (a==0 &&b==0)){
           System.err.println("[SERVER] - Either b or (a and b both) cannot be 0");
           throw new Exception();
       }
        return a/b;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "addArrays")
    public DoubleArray addArrays(@WebParam(name = "a") DoubleArray a, @WebParam(name = "b") DoubleArray b) throws Exception {
        System.out.println("[SERVER] - Performing addition for 2 arrays...");
        Double[] x=a.getArr();      
        Double[] y=b.getArr();
        DoubleArray z=null;

        if(a==null || b==null){
            System.err.println("[SERVER] - Either a or b cannot be null");
            throw new Exception();
        }
        if(a==null && b==null){
            System.err.println("[SERVER] - Either a or b cannot be null");
            throw new Exception();
        }else{
        
            if(x.length != y.length){
                System.out.println("[SERVER] - arrays must be of same size !");
                throw new Exception();
            }
            else{
                Double[] c=new Double[x.length];
                for(int i=0; i<x.length;i++){
                    c[i]=x[i]+y[i];
                }
                z=new DoubleArray(c);
                
            }
        }
        return z;
    }





}
