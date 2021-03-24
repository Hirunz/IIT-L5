
package server;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the server package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Exception_QNAME = new QName("http://server/", "Exception");
    private final static QName _GetMaximumResponse_QNAME = new QName("http://server/", "getMaximumResponse");
    private final static QName _GetMaximum_QNAME = new QName("http://server/", "getMaximum");
    private final static QName _GetAverage_QNAME = new QName("http://server/", "getAverage");
    private final static QName _GetMinimumResponse_QNAME = new QName("http://server/", "getMinimumResponse");
    private final static QName _IsConnected_QNAME = new QName("http://server/", "isConnected");
    private final static QName _GetNumberOfSamples_QNAME = new QName("http://server/", "getNumberOfSamples");
    private final static QName _IsConnectedResponse_QNAME = new QName("http://server/", "isConnectedResponse");
    private final static QName _GetAverageResponse_QNAME = new QName("http://server/", "getAverageResponse");
    private final static QName _GetNumberOfSamplesResponse_QNAME = new QName("http://server/", "getNumberOfSamplesResponse");
    private final static QName _Hello_QNAME = new QName("http://server/", "hello");
    private final static QName _GetMinimum_QNAME = new QName("http://server/", "getMinimum");
    private final static QName _HelloResponse_QNAME = new QName("http://server/", "helloResponse");
    private final static QName _AddSample_QNAME = new QName("http://server/", "addSample");
    private final static QName _AddSampleResponse_QNAME = new QName("http://server/", "addSampleResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: server
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetNumberOfSamples }
     * 
     */
    public GetNumberOfSamples createGetNumberOfSamples() {
        return new GetNumberOfSamples();
    }

    /**
     * Create an instance of {@link IsConnected }
     * 
     */
    public IsConnected createIsConnected() {
        return new IsConnected();
    }

    /**
     * Create an instance of {@link GetMaximum }
     * 
     */
    public GetMaximum createGetMaximum() {
        return new GetMaximum();
    }

    /**
     * Create an instance of {@link GetAverage }
     * 
     */
    public GetAverage createGetAverage() {
        return new GetAverage();
    }

    /**
     * Create an instance of {@link GetMinimumResponse }
     * 
     */
    public GetMinimumResponse createGetMinimumResponse() {
        return new GetMinimumResponse();
    }

    /**
     * Create an instance of {@link Exception }
     * 
     */
    public Exception createException() {
        return new Exception();
    }

    /**
     * Create an instance of {@link GetMaximumResponse }
     * 
     */
    public GetMaximumResponse createGetMaximumResponse() {
        return new GetMaximumResponse();
    }

    /**
     * Create an instance of {@link AddSample }
     * 
     */
    public AddSample createAddSample() {
        return new AddSample();
    }

    /**
     * Create an instance of {@link AddSampleResponse }
     * 
     */
    public AddSampleResponse createAddSampleResponse() {
        return new AddSampleResponse();
    }

    /**
     * Create an instance of {@link HelloResponse }
     * 
     */
    public HelloResponse createHelloResponse() {
        return new HelloResponse();
    }

    /**
     * Create an instance of {@link GetMinimum }
     * 
     */
    public GetMinimum createGetMinimum() {
        return new GetMinimum();
    }

    /**
     * Create an instance of {@link GetAverageResponse }
     * 
     */
    public GetAverageResponse createGetAverageResponse() {
        return new GetAverageResponse();
    }

    /**
     * Create an instance of {@link GetNumberOfSamplesResponse }
     * 
     */
    public GetNumberOfSamplesResponse createGetNumberOfSamplesResponse() {
        return new GetNumberOfSamplesResponse();
    }

    /**
     * Create an instance of {@link Hello }
     * 
     */
    public Hello createHello() {
        return new Hello();
    }

    /**
     * Create an instance of {@link IsConnectedResponse }
     * 
     */
    public IsConnectedResponse createIsConnectedResponse() {
        return new IsConnectedResponse();
    }

    /**
     * Create an instance of {@link TemperatureSample }
     * 
     */
    public TemperatureSample createTemperatureSample() {
        return new TemperatureSample();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Exception }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server/", name = "Exception")
    public JAXBElement<Exception> createException(Exception value) {
        return new JAXBElement<Exception>(_Exception_QNAME, Exception.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMaximumResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server/", name = "getMaximumResponse")
    public JAXBElement<GetMaximumResponse> createGetMaximumResponse(GetMaximumResponse value) {
        return new JAXBElement<GetMaximumResponse>(_GetMaximumResponse_QNAME, GetMaximumResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMaximum }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server/", name = "getMaximum")
    public JAXBElement<GetMaximum> createGetMaximum(GetMaximum value) {
        return new JAXBElement<GetMaximum>(_GetMaximum_QNAME, GetMaximum.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAverage }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server/", name = "getAverage")
    public JAXBElement<GetAverage> createGetAverage(GetAverage value) {
        return new JAXBElement<GetAverage>(_GetAverage_QNAME, GetAverage.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMinimumResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server/", name = "getMinimumResponse")
    public JAXBElement<GetMinimumResponse> createGetMinimumResponse(GetMinimumResponse value) {
        return new JAXBElement<GetMinimumResponse>(_GetMinimumResponse_QNAME, GetMinimumResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IsConnected }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server/", name = "isConnected")
    public JAXBElement<IsConnected> createIsConnected(IsConnected value) {
        return new JAXBElement<IsConnected>(_IsConnected_QNAME, IsConnected.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetNumberOfSamples }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server/", name = "getNumberOfSamples")
    public JAXBElement<GetNumberOfSamples> createGetNumberOfSamples(GetNumberOfSamples value) {
        return new JAXBElement<GetNumberOfSamples>(_GetNumberOfSamples_QNAME, GetNumberOfSamples.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IsConnectedResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server/", name = "isConnectedResponse")
    public JAXBElement<IsConnectedResponse> createIsConnectedResponse(IsConnectedResponse value) {
        return new JAXBElement<IsConnectedResponse>(_IsConnectedResponse_QNAME, IsConnectedResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAverageResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server/", name = "getAverageResponse")
    public JAXBElement<GetAverageResponse> createGetAverageResponse(GetAverageResponse value) {
        return new JAXBElement<GetAverageResponse>(_GetAverageResponse_QNAME, GetAverageResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetNumberOfSamplesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server/", name = "getNumberOfSamplesResponse")
    public JAXBElement<GetNumberOfSamplesResponse> createGetNumberOfSamplesResponse(GetNumberOfSamplesResponse value) {
        return new JAXBElement<GetNumberOfSamplesResponse>(_GetNumberOfSamplesResponse_QNAME, GetNumberOfSamplesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Hello }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server/", name = "hello")
    public JAXBElement<Hello> createHello(Hello value) {
        return new JAXBElement<Hello>(_Hello_QNAME, Hello.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMinimum }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server/", name = "getMinimum")
    public JAXBElement<GetMinimum> createGetMinimum(GetMinimum value) {
        return new JAXBElement<GetMinimum>(_GetMinimum_QNAME, GetMinimum.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HelloResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server/", name = "helloResponse")
    public JAXBElement<HelloResponse> createHelloResponse(HelloResponse value) {
        return new JAXBElement<HelloResponse>(_HelloResponse_QNAME, HelloResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddSample }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server/", name = "addSample")
    public JAXBElement<AddSample> createAddSample(AddSample value) {
        return new JAXBElement<AddSample>(_AddSample_QNAME, AddSample.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddSampleResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server/", name = "addSampleResponse")
    public JAXBElement<AddSampleResponse> createAddSampleResponse(AddSampleResponse value) {
        return new JAXBElement<AddSampleResponse>(_AddSampleResponse_QNAME, AddSampleResponse.class, null, value);
    }

}
