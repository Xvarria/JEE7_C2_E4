/**
 * FibonacciServerServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.empresa.math.client.axis;

import static com.empresa.math.client.jax.ServiceConstant.SERVICE_URL;

public class FibonacciServerServiceLocator extends org.apache.axis.client.Service implements com.empresa.math.client.axis.FibonacciServerService {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FibonacciServerServiceLocator() {
    }


    public FibonacciServerServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public FibonacciServerServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for FibonacciServerPort
    private java.lang.String FibonacciServerPort_address = SERVICE_URL;

    public java.lang.String getFibonacciServerPortAddress() {
        return FibonacciServerPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String FibonacciServerPortWSDDServiceName = "FibonacciServerPort";

    public java.lang.String getFibonacciServerPortWSDDServiceName() {
        return FibonacciServerPortWSDDServiceName;
    }

    public void setFibonacciServerPortWSDDServiceName(java.lang.String name) {
        FibonacciServerPortWSDDServiceName = name;
    }

    public com.empresa.math.client.axis.FibonacciServer getFibonacciServerPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(FibonacciServerPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getFibonacciServerPort(endpoint);
    }

    public com.empresa.math.client.axis.FibonacciServer getFibonacciServerPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.empresa.math.client.axis.FibonacciServerPortBindingStub _stub = new com.empresa.math.client.axis.FibonacciServerPortBindingStub(portAddress, this);
            _stub.setPortName(getFibonacciServerPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setFibonacciServerPortEndpointAddress(java.lang.String address) {
        FibonacciServerPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.empresa.math.client.axis.FibonacciServer.class.isAssignableFrom(serviceEndpointInterface)) {
                com.empresa.math.client.axis.FibonacciServerPortBindingStub _stub = new com.empresa.math.client.axis.FibonacciServerPortBindingStub(new java.net.URL(FibonacciServerPort_address), this);
                _stub.setPortName(getFibonacciServerPortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("FibonacciServerPort".equals(inputPortName)) {
            return getFibonacciServerPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://server.math.empresa.com/", "FibonacciServerService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://server.math.empresa.com/", "FibonacciServerPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("FibonacciServerPort".equals(portName)) {
            setFibonacciServerPortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
