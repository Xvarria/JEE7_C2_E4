package com.empresa.math.client.jax;

public class ClienteJax {

	public static void main(String[] args) {
		FibonacciServerService service = new FibonacciServerService();
		FibonacciServer sf = service.getFibonacciServerPort();
		
		try {
			System.out.println(sf.fib(45));
		} catch (FibException_Exception e) {
			System.err.println(e.getMessage());
		}

	}

}
