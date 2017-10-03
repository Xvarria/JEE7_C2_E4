/**
 * FibonacciServerService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.empresa.math.client.axis;

public interface FibonacciServerService extends javax.xml.rpc.Service {
    public java.lang.String getFibonacciServerPortAddress();

    public com.empresa.math.client.axis.FibonacciServer getFibonacciServerPort() throws javax.xml.rpc.ServiceException;

    public com.empresa.math.client.axis.FibonacciServer getFibonacciServerPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
