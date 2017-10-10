package com.empresa.math.client.jax.handlers;

import java.util.logging.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.ws.LogicalMessage;
import javax.xml.ws.handler.LogicalHandler;
import javax.xml.ws.handler.LogicalMessageContext;
import javax.xml.ws.handler.MessageContext;

import com.empresa.math.client.jax.Fib;

public class NegativeHandler implements LogicalHandler<LogicalMessageContext> {

	private static final String LoggerName = "ClientSideLogger";
	private Logger logger;
	private static final boolean LOG_ON = true; // set to false to turn off

	public NegativeHandler() {
		logger = Logger.getLogger(LoggerName);
	}

	@Override
	public boolean handleMessage(LogicalMessageContext context) {
		// Handler maneja tanto IN/OUT necesitamos saber si esto es una salida
		// desde la perspectiva del cliente
		Boolean outboundP = (Boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);

		// Manipula SOAP solamente si es un request
		if (outboundP) {
			if (LOG_ON)
				logger.info("Negative Handler Handle menssage");
			LogicalMessage msg = context.getMessage();
			
				try {
					JAXBContext jabxCtx = JAXBContext.newInstance("com.empresa.math.client.jax");
					Object payload = context.getMessage().getPayload(jabxCtx);
					if (payload instanceof JAXBElement) {
						Object obj = ((JAXBElement) payload).getValue();
						Fib fib = (Fib) obj;
						int n = fib.getArg0(); //Current value
						fib.setArg0(Math.abs(n)); //Set make it non-negative
						((JAXBElement) payload).setValue(fib);
						msg.setPayload(payload, jabxCtx);
					} 
				} catch (JAXBException e) {
					System.err.println("Exception error: "+e.getMessage());
				}
			

		}
		return true;
	}

	@Override
	public boolean handleFault(LogicalMessageContext context) {
		if (LOG_ON)
			logger.info("handle LOGIC Fault");

		try {
			context.getMessage();
		} catch (Exception e) {
			logger.info("Error on handleFault: " + e.getMessage());
		}
		return true;
	}

	@Override
	public void close(MessageContext context) {
		if (LOG_ON)
			logger.info("close LOGIC Handler");
	}

}
