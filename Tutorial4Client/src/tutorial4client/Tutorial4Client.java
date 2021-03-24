/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tutorial4client;
import java.util.ArrayList;
import java.util.List;
import server.DoubleArray;
import java.util.logging.Level;
import java.util.logging.Logger;

import server.Exception_Exception;

/**
 *
 * @author Hirunz
 */
public class Tutorial4Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception_Exception {
        Tutorial4Client client=new Tutorial4Client();
        client.execute();
    }

    private void execute() throws Exception_Exception {
        System.out.println("[CLIENT] - Starting excecution...");
        if(isConnected()){
            System.out.println("[CLIENT] - Server connected successfully...");
            System.out.println("[CLIENT] - ADDING TWO NUMBERS...");
            Double x=12.5;
            Double y=13.5;
            Double z=add(x,y);
            System.out.println("[CLIENT] - server replied addition of"
                    +x+ "  and "+y +" = "+z);
            if(z==x+y){
                System.out.println("[CLIENT] - ADDITION Is correct");
            }
            else{
                System.out.println("[CLIENT] - ADDITION is incorrect !");
            }
//            
//            System.out.println("[CLIENT] - Testing the addion with exceptions...");
//            testAddExceptions(x,y);
//            System.out.println("[CLIENT] - Testing add with exceptions complete.");
//            
            // independent tasks tests
            
            
            // testing  substraction
            System.out.println("[CLIENT] - SUBSTRACTING TWO NUMBERS...");

            z=substract(x,y);
            System.out.println("[CLIENT] - server replied substraction of"
                    +x+ "  and "+y +" = "+z);
            if(z==x-y){
                System.out.println("[CLIENT] - SUBSTRACTION Is correct");
            }
            else{
                System.out.println("[CLIENT] - SUBSTRACTION is incorrect !");
            }
            
            //System.out.println("[CLIENT] - Testing the substraction with exceptions...");
            //testSubstractExceptions(x,y);
            //System.out.println("[CLIENT] - Testing substraction with exceptions complete.");
            
            
            
            // testing  multiplication
            System.out.println("[CLIENT] - MULTIPLYING TWO NUMBERS...");

            z=multiply(x,y);
            System.out.println("[CLIENT] - server replied multiplication of"
                    +x+ "  and "+y +" = "+z);
            if(z==x*y){
                System.out.println("[CLIENT] - MULTIPLICATION Is correct");
            }
            else{
                System.out.println("[CLIENT] - MULTIPLICATION is incorrect !");
            }
            
            //System.out.println("[CLIENT] - Testing the multiplication with exceptions...");
            //testMultiplyExceptions(x,y);
            //System.out.println("[CLIENT] - Testing multiplication with exceptions complete.");
            
            
             // testing  division
            System.out.println("[CLIENT] - DIVIDING TWO NUMBERS...");

            z=divide(x,y);
            System.out.println("[CLIENT] - server replied division of"
                    +x+ "  and "+y +" = "+z);
            if(z==x/y){
                System.out.println("[CLIENT] - DIVISION Is correct");
            }
            else{
                System.out.println("[CLIENT] - DIVISION is incorrect !");
            }
            
            //System.out.println("[CLIENT] - Testing the division with exceptions...");
            //testDivideExceptions(x,y);
            //System.out.println("[CLIENT] - Testing division with exceptions complete.");
            
            
            // testing addition of arrays
            System.out.println("[CLIENT] - Adding Two Arrays...");
            Double[] p={1.0,2.0,3.8};
            Double[] q={4.5,5.4,6.1};
            
            
            
           List<Double> result=addArrays(new DoubleArray(p), new DoubleArray(q)).getArr();
           for(Double i:result){
               System.out.print(i+" ");
           }
            
            
        }
        else{
            System.out.println("[CLIENT] - Server connection failed !");
        }
        
        System.out.println("[CLIENT] - Excecution ended.");

                
    }
    
    public  void testAddExceptions(Double x, Double y){
       
        try {
            Double error=addExceptions(x,y);
        } catch (Exception_Exception ex) {
            Logger.getLogger(Tutorial4Client.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            Double error=addExceptions(null,y);
        } catch (Exception_Exception ex) {
            Logger.getLogger(Tutorial4Client.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            Double error=addExceptions(x,null);
        } catch (Exception_Exception ex) {
            Logger.getLogger(Tutorial4Client.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            Double error=addExceptions(null,null);
        } catch (Exception_Exception ex) {
            Logger.getLogger(Tutorial4Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
        public  void testSubstractExceptions(Double x, Double y){
       
        try {
            Double error=substractExceptions(x,y);
        } catch (Exception_Exception ex) {
            Logger.getLogger(Tutorial4Client.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            Double error=substractExceptions(null,y);
        } catch (Exception_Exception ex) {
            Logger.getLogger(Tutorial4Client.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            Double error=substractExceptions(x,null);
        } catch (Exception_Exception ex) {
            Logger.getLogger(Tutorial4Client.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            Double error=substractExceptions(null,null);
        } catch (Exception_Exception ex) {
            Logger.getLogger(Tutorial4Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
    public  void testMultiplyExceptions(Double x, Double y){
       
        try {
            Double error=multiplyExceptions(x,y);
        } catch (Exception_Exception ex) {
            Logger.getLogger(Tutorial4Client.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            Double error=multiplyExceptions(null,y);
        } catch (Exception_Exception ex) {
            Logger.getLogger(Tutorial4Client.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            Double error=multiplyExceptions(x,null);
        } catch (Exception_Exception ex) {
            Logger.getLogger(Tutorial4Client.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            Double error=multiplyExceptions(null,null);
        } catch (Exception_Exception ex) {
            Logger.getLogger(Tutorial4Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public  void testDivideExceptions(Double x, Double y){
       
        try {
            Double error=divideExceptions(x,y);
        } catch (Exception_Exception ex) {
            Logger.getLogger(Tutorial4Client.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            Double error=divideExceptions(null,y);
        } catch (Exception_Exception ex) {
            Logger.getLogger(Tutorial4Client.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            Double error=divideExceptions(x,null);
        } catch (Exception_Exception ex) {
            Logger.getLogger(Tutorial4Client.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            Double error=divideExceptions(null,null);
        } catch (Exception_Exception ex) {
            Logger.getLogger(Tutorial4Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // testing division by zero and division when both numbers are zero
        try {
            divideExceptions(x,0.0);
        } catch (Exception_Exception ex) {
            Logger.getLogger(Tutorial4Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Double error=divideExceptions(0.0,0.0);
        } catch (Exception_Exception ex) {
            Logger.getLogger(Tutorial4Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static Boolean isConnected() {
        server.Tutorial4WebService_Service service = new server.Tutorial4WebService_Service();
        server.Tutorial4WebService port = service.getTutorial4WebServicePort();
        return port.isConnected();
    }

    private static Double add(java.lang.Double num1, java.lang.Double num2) {
        server.Tutorial4WebService_Service service = new server.Tutorial4WebService_Service();
        server.Tutorial4WebService port = service.getTutorial4WebServicePort();
        return port.add(num1, num2);
    }

    private static Double addExceptions(java.lang.Double a, java.lang.Double b) throws Exception_Exception {
        server.Tutorial4WebService_Service service = new server.Tutorial4WebService_Service();
        server.Tutorial4WebService port = service.getTutorial4WebServicePort();
        return port.addExceptions(a, b);
    }

    private static Double substract(java.lang.Double a, java.lang.Double b) {
        server.Tutorial4WebService_Service service = new server.Tutorial4WebService_Service();
        server.Tutorial4WebService port = service.getTutorial4WebServicePort();
        return port.substract(a, b);
    }

    private static Double substractExceptions(java.lang.Double a, java.lang.Double b) throws Exception_Exception {
        server.Tutorial4WebService_Service service = new server.Tutorial4WebService_Service();
        server.Tutorial4WebService port = service.getTutorial4WebServicePort();
        return port.substractExceptions(a, b);
    }

    private static Double multiply(java.lang.Double a, java.lang.Double b) {
        server.Tutorial4WebService_Service service = new server.Tutorial4WebService_Service();
        server.Tutorial4WebService port = service.getTutorial4WebServicePort();
        return port.multiply(a, b);
    }

    private static Double multiplyExceptions(java.lang.Double a, java.lang.Double b) throws Exception_Exception {
        server.Tutorial4WebService_Service service = new server.Tutorial4WebService_Service();
        server.Tutorial4WebService port = service.getTutorial4WebServicePort();
        return port.multiplyExceptions(a, b);
    }

    private static Double divide(java.lang.Double a, java.lang.Double b) {
        server.Tutorial4WebService_Service service = new server.Tutorial4WebService_Service();
        server.Tutorial4WebService port = service.getTutorial4WebServicePort();
        return port.divide(a, b);
    }

    private static Double divideExceptions(java.lang.Double a, java.lang.Double b) throws Exception_Exception {
        server.Tutorial4WebService_Service service = new server.Tutorial4WebService_Service();
        server.Tutorial4WebService port = service.getTutorial4WebServicePort();
        return port.divideExceptions(a, b);
    }

    private static DoubleArray addArrays(server.DoubleArray a, server.DoubleArray b) throws Exception_Exception {
        server.Tutorial4WebService_Service service = new server.Tutorial4WebService_Service();
        server.Tutorial4WebService port = service.getTutorial4WebServicePort();
        return port.addArrays(a, b);
    }
    
    
}
