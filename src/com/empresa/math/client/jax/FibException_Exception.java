
package com.empresa.math.client.jax;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebFault(name = "FibException", targetNamespace = "http://server.math.empresa.com/")
public class FibException_Exception
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private FibException faultInfo;

    /**
     * 
     * @param faultInfo
     * @param message
     */
    public FibException_Exception(String message, FibException faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param faultInfo
     * @param cause
     * @param message
     */
    public FibException_Exception(String message, FibException faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: com.empresa.math.client.jax.FibException
     */
    public FibException getFaultInfo() {
        return faultInfo;
    }

}
