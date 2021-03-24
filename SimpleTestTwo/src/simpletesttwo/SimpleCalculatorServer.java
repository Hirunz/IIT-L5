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
public class SimpleCalculatorServer {
    public boolean isServerConnected(){
        System.out.println("[Server] - Connection is being tested...");
        return true;
    }
    
    public int addIntegerNumbers(int a, int b){
        System.out.println("[Server] - Adding  "+a+" and "+b);
        return a+b;
    }
    
    
    public int divideIntegerNumbers(int a, int b)throws Exception{
        //only b infinity
        if(b==0){
            throw new Exception();
        }
        if(b==0 && a==0){
            throw new Exception();
        }
      System.out.println("[Server] - Dividing  "+a+" and "+b +"...");
        return a/b;  
    }
    
    public int substractIntegerNumbers(int a, int b){
        System.out.println("[Server] - Substracting  "+a+" and "+b);
        return a-b;
    }
    
    public int multiplyNumbers(int a, int b){
        System.out.println("[Server] - Multiplying  "+a+" and "+b);
        return a*b;
    }
    
    
    public int[] addIntegerNumbers(int[] a, int[] b)throws Exception{
        System.out.println("[Server] - Adding  "+Arrays.toString(a)
                +" and "+Arrays.toString(b));
        int[] total;
        if(a.length==b.length){
            total= new int[a.length];
            for(int i=0;i<a.length;i++){
            total[i]=a[i]+b[i];
        }
        }
        else{
            throw new Exception();
        }
        System.out.println("[Server] - Adding  "+Arrays.toString(a)
                +" and "+Arrays.toString(b) +"...");

        return total;
    }
    
    public int[] divideIntegerNumbers(int[] a, int[] b)throws Exception{
        System.out.println("[Server] - Dividing  "+Arrays.toString(a)
                +" and "+Arrays.toString(b));
        int[] total;
        if(a.length==b.length){
            total= new int[a.length];
            for(int i=0;i<a.length;i++){
                if(b[i]==0){
                    throw new Exception();
                }
                if(b[i]==0 && a[i]==0){
                    throw new Exception();
                }
            total[i]=a[i]/b[i];
        }
        }
        else{
            throw new Exception();
        }
        System.out.println("[Server] - Dividing  "+Arrays.toString(a)
                +" and "+Arrays.toString(b) +"...");

        return total;
    }
}
