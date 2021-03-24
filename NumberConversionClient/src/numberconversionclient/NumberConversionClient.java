/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numberconversionclient;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 *
 * @author Hirunz
 */
public class NumberConversionClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        NumberConversionClient ncc=new NumberConversionClient();
        System.out.println("{CLIENT] - Testing number to dollars...");

//        BigDecimal bd=new BigDecimal("20");
//        System.out.println("{CLIENT] - Sending "+bd.toString()+" to the server.");
//        System.out.println("{CLIENT] - Server responded with "+ ncc.numberToDollars_1(bd));
        
        BigInteger bi=new BigInteger("40");
        System.out.println("{CLIENT] - Sending "+bi+" to the server.");
        System.out.println("{CLIENT] - Server responded with "+ ncc.numberToWords_1(bi));
        
    }

    private static String numberToDollars(java.math.BigDecimal dNum) {
        numberconversionclient.NumberConversion service = new numberconversionclient.NumberConversion();
        numberconversionclient.NumberConversionSoapType port = service.getNumberConversionSoap();
        return port.numberToDollars(dNum);
    }

    private static String numberToWords(java.math.BigInteger ubiNum) {
        numberconversionclient.NumberConversion service = new numberconversionclient.NumberConversion();
        numberconversionclient.NumberConversionSoapType port = service.getNumberConversionSoap();
        return port.numberToWords(ubiNum);
    }

    private static String numberToDollars_1(java.math.BigDecimal dNum) {
        numberconversionclient.NumberConversion service = new numberconversionclient.NumberConversion();
        numberconversionclient.NumberConversionSoapType port = service.getNumberConversionSoap12();
        return port.numberToDollars(dNum);
    }

    private static String numberToWords_1(java.math.BigInteger ubiNum) {
        numberconversionclient.NumberConversion service = new numberconversionclient.NumberConversion();
        numberconversionclient.NumberConversionSoapType port = service.getNumberConversionSoap12();
        return port.numberToWords(ubiNum);
    }
    
}
