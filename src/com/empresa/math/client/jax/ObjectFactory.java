
package com.empresa.math.client.jax;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.empresa.math.client.jax package. 
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

    private final static QName _FibResponse_QNAME = new QName("http://server.math.empresa.com/", "fibResponse");
    private final static QName _Fib_QNAME = new QName("http://server.math.empresa.com/", "fib");
    private final static QName _FibException_QNAME = new QName("http://server.math.empresa.com/", "FibException");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.empresa.math.client.jax
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link FibResponse }
     * 
     */
    public FibResponse createFibResponse() {
        return new FibResponse();
    }

    /**
     * Create an instance of {@link Fib }
     * 
     */
    public Fib createFib() {
        return new Fib();
    }

    /**
     * Create an instance of {@link FibException }
     * 
     */
    public FibException createFibException() {
        return new FibException();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FibResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.math.empresa.com/", name = "fibResponse")
    public JAXBElement<FibResponse> createFibResponse(FibResponse value) {
        return new JAXBElement<FibResponse>(_FibResponse_QNAME, FibResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Fib }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.math.empresa.com/", name = "fib")
    public JAXBElement<Fib> createFib(Fib value) {
        return new JAXBElement<Fib>(_Fib_QNAME, Fib.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FibException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.math.empresa.com/", name = "FibException")
    public JAXBElement<FibException> createFibException(FibException value) {
        return new JAXBElement<FibException>(_FibException_QNAME, FibException.class, null, value);
    }

}
