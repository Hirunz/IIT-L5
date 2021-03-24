/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.sql.Timestamp;
import java.util.Date;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Hirunz
 */
@WebService(serviceName = "SimpleWebService")
public class SimpleWebService {
    public static final String serverName="Tutorial 3 server";
    
    
    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        System.out.println("[SERVER] - Message received from client: "+txt);
        Date date = new Date();
        Timestamp ts = new Timestamp(date.getTime());
        return "[SERVER] - " + serverName+" "+ts+" Connection from client succeded.";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "isConnected")
    public Boolean isConnected() {
        //TODO write your implementation code here:
        System.out.println("[SERVER] - Testing connection...");
        return true;
    }
}
