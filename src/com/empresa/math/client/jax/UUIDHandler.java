package com.empresa.math.client.jax;
import java.io.IOException;
import java.util.Set;
import java.util.UUID;
import java.util.logging.Logger;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPConstants;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPHeaderElement;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

public class UUIDHandler implements SOAPHandler<SOAPMessageContext> {
	private static final String LoggerName = "ClientSideLogger";
	private Logger logger;
	private final boolean log_p = true; // set to false to turn off

	public UUIDHandler() {
		logger = Logger.getLogger(LoggerName);
	}

	@Override
	public boolean handleMessage(SOAPMessageContext ctx) {
		if (log_p)
			logger.info("handleMessage");
		
		// Handler maneja tanto IN/OUT necesitamos saber si esto es una salida
		// desde la perspectiva del cliente
		Boolean request_p = (Boolean) ctx.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
		
		
		// Manipula SOAP solamente si es un request
		if (request_p) {
			
			// Genera un UUID 
			// Wiki: universally unique identifier (UUID) 
			//       is a 128-bit number used to identify information in computer  
			UUID uuid = UUID.randomUUID();
			try {
				SOAPMessage msg = ctx.getMessage();
				SOAPEnvelope env = msg.getSOAPPart().getEnvelope();
				SOAPHeader hdr = env.getHeader();
			
				// SOAP message header.
				if (hdr == null) {
					hdr = env.addHeader();
				}
				
				QName qname = new QName("http://server.math.empresa.com", "uuid");
				SOAPHeaderElement helem = hdr.addHeaderElement(qname);
				helem.setActor(SOAPConstants.URI_SOAP_ACTOR_NEXT); // default
				helem.addTextNode(uuid.toString());
				msg.saveChanges();
				// For tracking, write to standard output.
				msg.writeTo(System.out);

			} catch (SOAPException e) {
				System.err.println(e);
			} catch (IOException e) {
				System.err.println(e);
			}
		}
		return true;
	}

	@Override
	public boolean handleFault(SOAPMessageContext ctx) {
		if (log_p)
			logger.info("handleFault");
		try {
			ctx.getMessage().writeTo(System.out);
		} catch (SOAPException e) {
			System.err.println(e);
		} catch (IOException e) {
			System.err.println(e);
		}
		return true;
	}

	@Override
	public void close(MessageContext context) {
		if (log_p)
			logger.info("close");

	}

	@Override
	public Set<QName> getHeaders() {
		if (log_p)
			logger.info("getHeaders");
		return null;
	}

}
