/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tutorial3client;

/**
 *
 * @author Hirunz
 */
public class Tutorial3Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Tutorial3Client client=new Tutorial3Client();
        client.execute();
        client.sendMessageToServer("Hi ! I'm Hirun");
        
    }
    
    public void execute(){
        System.out.println("[CLIENT] - Starting test...");
        if(isConnected()){
            System.out.println("[CLIENT] - Server is connected, test can continue...");
        }
        else{
            System.out.println("[CLIENT] - Server is not connected, test has failed ");
        }
        System.out.println("{CLIENT] - Test completed...");
    }
    
    public void sendMessageToServer(String message){
        System.out.println("{CLIENT} - Sending a message to server");
   
        System.out.println("[CLIENT] - Server replied: "+ hello(message));
        
        System.out.println("[CLIENT] - Server message session ended...");
    }

    private static Boolean isConnected() {
        tutorial3client.SimpleWebService_Service service = new tutorial3client.SimpleWebService_Service();
        tutorial3client.SimpleWebService port = service.getSimpleWebServicePort();
        return port.isConnected();
    }

    private static String hello(java.lang.String name) {
        tutorial3client.SimpleWebService_Service service = new tutorial3client.SimpleWebService_Service();
        tutorial3client.SimpleWebService port = service.getSimpleWebServicePort();
        return port.hello(name);
    }

    
}
