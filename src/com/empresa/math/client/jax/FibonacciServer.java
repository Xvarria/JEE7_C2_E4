
package com.empresa.math.client.jax;

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
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "FibonacciServer", targetNamespace = "http://server.math.empresa.com/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface FibonacciServer {


    /**
     * 
     * @param arg0
     * @return
     *     returns int
     * @throws FibException_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "fib", targetNamespace = "http://server.math.empresa.com/", className = "com.empresa.math.client.jax.Fib")
    @ResponseWrapper(localName = "fibResponse", targetNamespace = "http://server.math.empresa.com/", className = "com.empresa.math.client.jax.FibResponse")
    @Action(input = "http://server.math.empresa.com/FibonacciServer/fibRequest", output = "http://server.math.empresa.com/FibonacciServer/fibResponse", fault = {
        @FaultAction(className = FibException_Exception.class, value = "http://server.math.empresa.com/FibonacciServer/fib/Fault/FibException")
    })
    public int fib(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0)
        throws FibException_Exception
    ;

}
