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
public class DummyServer {
    
    String testConnection(String id){
        System.out.println("Info: [SERVER] - Dummy server => Connection testing...");
        return "Info: [CLIENT: "+id+"] - Connection Succeded";
    }
}
