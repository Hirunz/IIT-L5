/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tutorial1;

/**
 *
 * @author Hirunz
 */
public class Tutorial1 {
    DummyServer server=new DummyServer();
    private String clientId;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Tutorial1 tutorial1 =new Tutorial1();
       System.out.println("Info: [CLIENT] - object being called");
       tutorial1.clientId="20";
       tutorial1.execute();
       
    }
    
    private void execute(){
        System.out.println("Info: [CLIENT] - start execute() method");

        String output=server.testConnection(clientId);
        System.out.println(output);
        
        System.out.println("Info: [CLIENT] - end execute()");
    }
    
}
