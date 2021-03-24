/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simpletesttwo;

import java.util.Arrays;

/**
 *
 * @author Hirunz
 */
public class SimpleClient {

    SimpleCalculatorServer server=new SimpleCalculatorServer();
    public static void main(String[] args) {
        System.out.println("[Client] - Client object created... ");
        SimpleClient simpleClient = new SimpleClient();
        simpleClient.executeTest();
    }
    
    
    private void executeTest(){
        System.out.println("[Client] - Testing if the server is connected...");
        if(server.isServerConnected()){
            System.out.println("[Client] - The Client is connected," 
                    +" the test can be proceded.");
            // basic arithemetic operations
            
            // addition
            int x=2;
            int y=3;
            
            System.out.println("[Client] - Asking the server"
                    + " what is the sum of " +x+" and "+y );
            int z = server.addIntegerNumbers(x, y);
            System.out.println("[Client] - The server has replied"
                    + " thst sum of "+x+ " and "+y +" is "+z);
            
            if(z==x+y){
                System.out.println("[Client] - The server has returned"
                        + " the correct answer...");
            }
            else{
                System.out.println("[Client] - Server has returned "
                        + "the wrong answer...");
            }
            
            System.out.println("[Client] - Asking the server"
                    + " what is division sum of " +x+" and "+y );
            
            
            x=4;
            y=3;
            try{
                z = server.divideIntegerNumbers(x, y);
            
            System.out.println("[Client] - The server has replied"
                    + " thst division of "+x+ " and "+y +" is "+z);
            
            if(z==x/y){
                System.out.println("[Client] - The server has returned"
                        + " the correct answer...");
            }
            else{
                System.out.println("[Client] - Server has returned "
                        + "the wrong answer...");
            }
            }catch(Exception e){
                e.printStackTrace();
                System.out.println("[Client] - Error from the server.");
            }
            
            
            x=2;
            y=3;
            
            System.out.println("[Client] - Asking the server"
                    + " what is the substraction of " +x+" and "+y );
             z = server.substractIntegerNumbers(x, y);
            System.out.println("[Client] - The server has replied"
                    + " thst substraction of "+x+ " and "+y +" is "+z);
            
            if(z==x-y){
                System.out.println("[Client] - The server has returned"
                        + " the correct answer...");
            }
            else{
                System.out.println("[Client] - Server has returned "
                        + "the wrong answer...");
            }
            
            
            x=2;
            y=3;
            
            System.out.println("[Client] - Asking the server"
                    + " what is the multiplication of " +x+" and "+y );
             z = server.substractIntegerNumbers(x, y);
            System.out.println("[Client] - The server has replied"
                    + " thst multiplication of "+x+ " and "+y +" is "+z);
            
            if(z==x*y){
                System.out.println("[Client] - The server has returned"
                        + " the correct answer...");
            }
            else{
                System.out.println("[Client] - Server has returned "
                        + "the wrong answer...");
            }
            
            // with arrays
            
            
            int[] a={3,4,5};
            int[] b={1,2,3};
            System.out.println("[Client] - Asking the server"
                    + " what is the addition of " +Arrays.toString(a)
                    +" and "+Arrays.toString(b) );
            try{
                int[] c = server.addIntegerNumbers(a, b);
            
            System.out.println("[Client] - The server has replied"
                    + " thst addition of arrays "+Arrays.toString(a)
                    + " and "+Arrays.toString(b) +" is "+Arrays.toString(c));
            
            
            }catch(Exception e){
                e.printStackTrace();
                System.out.println("[Client] - Error from the server.");
            }
            
            
            
            int[] e={1,2,3,0};
            int[] f={3,2,4,2};
            System.out.println("[Client] - Asking the server"
                    + " what is the division of " +Arrays.toString(e)
                    +" and "+Arrays.toString(f) );
            try{
                int[] g = server.divideIntegerNumbers(e,f);
            
            System.out.println("[Client] - The server has replied"
                    + " thst division of arrays "+Arrays.toString(e)
                    + " and "+Arrays.toString(f) +" is "+Arrays.toString(g));
            
            
            }catch(Exception ex){
                ex.printStackTrace();
                System.out.println("[Client] - Error from the server.");
            }
            
            
            
        }
        else{
            System.out.println("[Client] - The client is not connected, "
                    + "the test has failed...");
        }
    }
    
}


/*
Question 24 
    since 4 and 3 are integers, when division operator is used,
    it will give the integer result, thus 4/3 =1

    when float number is used to divide, it will give the result as float.
    Therefore, to solve this issue,
        we can accept float numbers instead of integers in server class divide method.
        since java uses austo typecasting, it will accept integers as well,
        and typecase to float.




*/