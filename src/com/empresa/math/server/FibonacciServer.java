package com.empresa.math.server;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.jws.HandlerChain;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService //(targetNamespace = "http://server.math.empresa.com")
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, 
             use = SOAPBinding.Use.LITERAL, 
             parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
@HandlerChain(file = "handler-chain.xml")
public class FibonacciServer {

	/** Cache */
	private Map<Integer, Integer> cache = Collections.synchronizedMap(new HashMap<Integer, Integer>());

	@WebMethod
	public int fib(int n) throws FibException {
		// fib(n), n<0, Exception
		if (n < 0) {
			throw new FibException("Valores negativos.", n + " < 0");
		}
		// fib(2) = 2
		if (n < 2) {
			return n;
		}

		// Evita el recalculo de valores Cache
		if (cache.containsKey(n)) {
			return cache.get(n);
		}

		if (cache.containsKey(n - 1) && cache.containsKey(n - 2)) {
			cache.put(n, cache.get(n - 1) + cache.get(n - 2));
			return cache.get(n);
		}

		// Calcule y guardelo.
		int fib = 1;
		int prev = 0;
		for (int i = 2; i <= n; i++) {
			int temp = fib;
			fib += prev;
			prev = temp;
		}
		cache.put(n, fib); // cache value for later lookup
		return fib;
	}
}
