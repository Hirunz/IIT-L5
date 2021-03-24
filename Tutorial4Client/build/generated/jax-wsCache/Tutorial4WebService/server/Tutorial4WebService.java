
package server;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.FaultAction;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebService(name = "Tutorial4WebService", targetNamespace = "http://server/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface Tutorial4WebService {


    /**
     * 
     * @param num1
     * @param num2
     * @return
     *     returns java.lang.Double
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "add", targetNamespace = "http://server/", className = "server.Add")
    @ResponseWrapper(localName = "addResponse", targetNamespace = "http://server/", className = "server.AddResponse")
    @Action(input = "http://server/Tutorial4WebService/addRequest", output = "http://server/Tutorial4WebService/addResponse")
    public Double add(
        @WebParam(name = "num1", targetNamespace = "")
        Double num1,
        @WebParam(name = "num2", targetNamespace = "")
        Double num2);

    /**
     * 
     * @param a
     * @param b
     * @return
     *     returns java.lang.Double
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "divide", targetNamespace = "http://server/", className = "server.Divide")
    @ResponseWrapper(localName = "divideResponse", targetNamespace = "http://server/", className = "server.DivideResponse")
    @Action(input = "http://server/Tutorial4WebService/divideRequest", output = "http://server/Tutorial4WebService/divideResponse")
    public Double divide(
        @WebParam(name = "a", targetNamespace = "")
        Double a,
        @WebParam(name = "b", targetNamespace = "")
        Double b);

    /**
     * 
     * @param a
     * @param b
     * @return
     *     returns java.lang.Double
     * @throws Exception_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "substractExceptions", targetNamespace = "http://server/", className = "server.SubstractExceptions")
    @ResponseWrapper(localName = "substractExceptionsResponse", targetNamespace = "http://server/", className = "server.SubstractExceptionsResponse")
    @Action(input = "http://server/Tutorial4WebService/substractExceptionsRequest", output = "http://server/Tutorial4WebService/substractExceptionsResponse", fault = {
        @FaultAction(className = Exception_Exception.class, value = "http://server/Tutorial4WebService/substractExceptions/Fault/Exception")
    })
    public Double substractExceptions(
        @WebParam(name = "a", targetNamespace = "")
        Double a,
        @WebParam(name = "b", targetNamespace = "")
        Double b)
        throws Exception_Exception
    ;

    /**
     * 
     * @param name
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "hello", targetNamespace = "http://server/", className = "server.Hello")
    @ResponseWrapper(localName = "helloResponse", targetNamespace = "http://server/", className = "server.HelloResponse")
    @Action(input = "http://server/Tutorial4WebService/helloRequest", output = "http://server/Tutorial4WebService/helloResponse")
    public String hello(
        @WebParam(name = "name", targetNamespace = "")
        String name);

    /**
     * 
     * @param a
     * @param b
     * @return
     *     returns java.lang.Double
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "multiply", targetNamespace = "http://server/", className = "server.Multiply")
    @ResponseWrapper(localName = "multiplyResponse", targetNamespace = "http://server/", className = "server.MultiplyResponse")
    @Action(input = "http://server/Tutorial4WebService/multiplyRequest", output = "http://server/Tutorial4WebService/multiplyResponse")
    public Double multiply(
        @WebParam(name = "a", targetNamespace = "")
        Double a,
        @WebParam(name = "b", targetNamespace = "")
        Double b);

    /**
     * 
     * @return
     *     returns java.lang.Boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "isConnected", targetNamespace = "http://server/", className = "server.IsConnected")
    @ResponseWrapper(localName = "isConnectedResponse", targetNamespace = "http://server/", className = "server.IsConnectedResponse")
    @Action(input = "http://server/Tutorial4WebService/isConnectedRequest", output = "http://server/Tutorial4WebService/isConnectedResponse")
    public Boolean isConnected();

    /**
     * 
     * @param a
     * @param b
     * @return
     *     returns java.lang.Double
     * @throws Exception_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "addExceptions", targetNamespace = "http://server/", className = "server.AddExceptions")
    @ResponseWrapper(localName = "addExceptionsResponse", targetNamespace = "http://server/", className = "server.AddExceptionsResponse")
    @Action(input = "http://server/Tutorial4WebService/addExceptionsRequest", output = "http://server/Tutorial4WebService/addExceptionsResponse", fault = {
        @FaultAction(className = Exception_Exception.class, value = "http://server/Tutorial4WebService/addExceptions/Fault/Exception")
    })
    public Double addExceptions(
        @WebParam(name = "a", targetNamespace = "")
        Double a,
        @WebParam(name = "b", targetNamespace = "")
        Double b)
        throws Exception_Exception
    ;

    /**
     * 
     * @param a
     * @param b
     * @return
     *     returns server.DoubleArray
     * @throws Exception_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "addArrays", targetNamespace = "http://server/", className = "server.AddArrays")
    @ResponseWrapper(localName = "addArraysResponse", targetNamespace = "http://server/", className = "server.AddArraysResponse")
    @Action(input = "http://server/Tutorial4WebService/addArraysRequest", output = "http://server/Tutorial4WebService/addArraysResponse", fault = {
        @FaultAction(className = Exception_Exception.class, value = "http://server/Tutorial4WebService/addArrays/Fault/Exception")
    })
    public DoubleArray addArrays(
        @WebParam(name = "a", targetNamespace = "")
        DoubleArray a,
        @WebParam(name = "b", targetNamespace = "")
        DoubleArray b)
        throws Exception_Exception
    ;

    /**
     * 
     * @param a
     * @param b
     * @return
     *     returns java.lang.Double
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "substract", targetNamespace = "http://server/", className = "server.Substract")
    @ResponseWrapper(localName = "substractResponse", targetNamespace = "http://server/", className = "server.SubstractResponse")
    @Action(input = "http://server/Tutorial4WebService/substractRequest", output = "http://server/Tutorial4WebService/substractResponse")
    public Double substract(
        @WebParam(name = "a", targetNamespace = "")
        Double a,
        @WebParam(name = "b", targetNamespace = "")
        Double b);

    /**
     * 
     * @param a
     * @param b
     * @return
     *     returns java.lang.Double
     * @throws Exception_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "divideExceptions", targetNamespace = "http://server/", className = "server.DivideExceptions")
    @ResponseWrapper(localName = "divideExceptionsResponse", targetNamespace = "http://server/", className = "server.DivideExceptionsResponse")
    @Action(input = "http://server/Tutorial4WebService/divideExceptionsRequest", output = "http://server/Tutorial4WebService/divideExceptionsResponse", fault = {
        @FaultAction(className = Exception_Exception.class, value = "http://server/Tutorial4WebService/divideExceptions/Fault/Exception")
    })
    public Double divideExceptions(
        @WebParam(name = "a", targetNamespace = "")
        Double a,
        @WebParam(name = "b", targetNamespace = "")
        Double b)
        throws Exception_Exception
    ;

    /**
     * 
     * @param a
     * @param b
     * @return
     *     returns java.lang.Double
     * @throws Exception_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "multiplyExceptions", targetNamespace = "http://server/", className = "server.MultiplyExceptions")
    @ResponseWrapper(localName = "multiplyExceptionsResponse", targetNamespace = "http://server/", className = "server.MultiplyExceptionsResponse")
    @Action(input = "http://server/Tutorial4WebService/multiplyExceptionsRequest", output = "http://server/Tutorial4WebService/multiplyExceptionsResponse", fault = {
        @FaultAction(className = Exception_Exception.class, value = "http://server/Tutorial4WebService/multiplyExceptions/Fault/Exception")
    })
    public Double multiplyExceptions(
        @WebParam(name = "a", targetNamespace = "")
        Double a,
        @WebParam(name = "b", targetNamespace = "")
        Double b)
        throws Exception_Exception
    ;

}
