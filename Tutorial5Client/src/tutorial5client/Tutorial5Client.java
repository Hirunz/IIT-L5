/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tutorial5client;

import java.util.logging.Level;
import java.util.logging.Logger;
import server.Exception_Exception;
import server.TemperatureSample;

/**
 *
 * @author Hirunz
 */
public class Tutorial5Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Tutorial5Client client = new Tutorial5Client();
        client.execute();
    }

    private static String hello(java.lang.String name) {
        server.Tutorial5WebService_Service service = new server.Tutorial5WebService_Service();
        server.Tutorial5WebService port = service.getTutorial5WebServicePort();
        return port.hello(name);
    }

    private static Boolean isConnected() {
        server.Tutorial5WebService_Service service = new server.Tutorial5WebService_Service();
        server.Tutorial5WebService port = service.getTutorial5WebServicePort();
        return port.isConnected();
    }

    private void execute() {
        System.out.println("{CLIENT - Starting Test...");
        if(isConnected()){
            System.out.println("[CLIENT] - Server is connected, continuing test...");
            
            TemperatureSample s= new TemperatureSample();
            s.setValue(0.1);
            
            try{
                addSample(s);
                System.out.println("[CLIENT] - Server has "+ getNumberOfSamples() +"samples");
                System.out.println("[CLIENT] - Maximum sample on the server is "+getMaximum());
            }catch(Exception_Exception ex){
                Logger.getLogger(Tutorial5Client.class.getName()).log(Level.SEVERE, null, ex);
            }
            s.setValue(1.1);
            
            
            try{
                addSample(s);
                System.out.println("[CLIENT] - Server has "+ getNumberOfSamples() +"samples");
                System.out.println("[CLIENT] - Maximum sample on the server is "+getMaximum());
            }catch(Exception_Exception ex){
                Logger.getLogger(Tutorial5Client.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            s.setValue(-1.1);
            try{
                addSample(s);
                System.out.println("[CLIENT] - Server has "+ getNumberOfSamples() +"samples");
                System.out.println("[CLIENT] - Maximum sample on the server is "+getMaximum());
            }catch(Exception_Exception ex){
                Logger.getLogger(Tutorial5Client.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            System.out.println("[CLIENT] - Server is NOT connected, test failed !");
        }
        System.out.println("[CLIENT] - Test Completed");
    }

    private static Integer getNumberOfSamples() {
        server.Tutorial5WebService_Service service = new server.Tutorial5WebService_Service();
        server.Tutorial5WebService port = service.getTutorial5WebServicePort();
        return port.getNumberOfSamples();
    }

    private static TemperatureSample getMaximum() throws Exception_Exception {
        server.Tutorial5WebService_Service service = new server.Tutorial5WebService_Service();
        server.Tutorial5WebService port = service.getTutorial5WebServicePort();
        return port.getMaximum();
    }

    private static Boolean addSample(server.TemperatureSample sample) throws Exception_Exception {
        server.Tutorial5WebService_Service service = new server.Tutorial5WebService_Service();
        server.Tutorial5WebService port = service.getTutorial5WebServicePort();
        return port.addSample(sample);
    }
    
}
