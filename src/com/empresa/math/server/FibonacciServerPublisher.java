package com.empresa.math.server;



import javax.xml.ws.Endpoint;

/**
 * Esta aplicación publica el SIB
 * 
 * Servidor:localhost
 * Puerto:9876
 * Contexto: /ts
 * 
 * Esta clase publica el SIB
 * 
 * La aplicación corre indefinidamente.
 * 
 * La aplicación se puede examinar 
 * siguiente dirección
 * 
 * http://127.0.0.1:9876/ts?wsdl
 * 
 * Si la prueba es exitosa se puede probar el
 * cliente.
 * 
 * @author mars
 *
 */
public class FibonacciServerPublisher {
	
	
	public static void main(String args[]){
		Endpoint.publish("http://127.0.0.1:9876/fib", new FibonacciServer());
		//System.out.println("Hola Mundo!!");
	}
	
	
	
}
