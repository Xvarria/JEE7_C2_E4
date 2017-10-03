package com.empresa.math.client.axis;

public class FibonacciServerProxy implements com.empresa.math.client.axis.FibonacciServer {
  private String _endpoint = null;
  private com.empresa.math.client.axis.FibonacciServer fibonacciServer = null;
  
  public FibonacciServerProxy() {
    _initFibonacciServerProxy();
  }
  
  public FibonacciServerProxy(String endpoint) {
    _endpoint = endpoint;
    _initFibonacciServerProxy();
  }
  
  private void _initFibonacciServerProxy() {
    try {
      fibonacciServer = (new com.empresa.math.client.axis.FibonacciServerServiceLocator()).getFibonacciServerPort();
      if (fibonacciServer != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)fibonacciServer)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)fibonacciServer)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (fibonacciServer != null)
      ((javax.xml.rpc.Stub)fibonacciServer)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.empresa.math.client.axis.FibonacciServer getFibonacciServer() {
    if (fibonacciServer == null)
      _initFibonacciServerProxy();
    return fibonacciServer;
  }
  
  public int fib(int arg0) throws java.rmi.RemoteException, com.empresa.math.client.axis.FibException{
    if (fibonacciServer == null)
      _initFibonacciServerProxy();
    return fibonacciServer.fib(arg0);
  }
  
  
}