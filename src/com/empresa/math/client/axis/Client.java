package com.empresa.math.client.axis;

import java.rmi.RemoteException;

public class Client {

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FibonacciServerProxy proxy = new FibonacciServerProxy();
	
		try {
			System.out.println(proxy.fib(45));
		} catch (FibException e) {
			System.err.println("Fib Exception" + e.getMessage1());
		} catch (RemoteException e){
			System.err.println("RemoteException Exception");
		}
	}

}
