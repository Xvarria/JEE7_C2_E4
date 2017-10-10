package com.empresa.math.server;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.UUID;

import javax.xml.namespace.QName;
import javax.xml.soap.Node;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPConstants;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPFault;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;
import javax.xml.ws.soap.SOAPFaultException;

public class UUIDValidator implements SOAPHandler<SOAPMessageContext> {
	private static final boolean trace = false; // make true to see message
	private static final int UUIDvariant = 2; // layout
	private static final int UUIDversion = 4; // version


	public boolean handleMessage(SOAPMessageContext ctx) {
		Boolean response_p = (Boolean) ctx.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
		
		// MESSAGE_OUTBOUD_PROPERTY, mensaje de salida del cliente
		if (!response_p) {
			try {
				SOAPMessage msg = ctx.getMessage();
				SOAPEnvelope env = msg.getSOAPPart().getEnvelope();
				SOAPHeader hdr = env.getHeader();

				// Si el mensaje SOAP no tiene header, lanza una excepción
				if (hdr == null) {
					generateSOAPFault(msg, "No existe el header.");
				}
				
				// UUID valor del header block
				Iterator it = hdr.extractHeaderElements(SOAPConstants.URI_SOAP_ACTOR_NEXT);
				if (it == null || !it.hasNext()) {
					generateSOAPFault(msg, "No existe header para procesar.");
				}
				Node next = (Node) it.next();
				String value = (next == null) ? null : next.getValue();
				// Si no existe valor, exception
				if (value == null) {
					generateSOAPFault(msg, "No existe el valor esperado UUID en el header");
				}
				// Si existe el objeto se revisan ciertas propiedades
				UUID uuid = UUID.fromString(value.trim());
				if (uuid.variant() != UUIDvariant || uuid.version() != UUIDversion) {
					generateSOAPFault(msg, "UUID difiere del esperado.");
				}
				if (trace)
					msg.writeTo(System.out);
			} catch (SOAPException e) {
				System.err.println(e);
			} catch (IOException e) {
				System.err.println(e);
			}
		}
		return true; // continue
	} // down
		// the
		// chain

	public boolean handleFault(SOAPMessageContext ctx) {
		return true;
	}

	public Set<QName> getHeaders() {
		return null;
	}

	public void close(MessageContext messageContext) {
	}

	private void generateSOAPFault(SOAPMessage msg, String reason) {
		try {
			SOAPBody body = msg.getSOAPPart().getEnvelope().getBody();
			SOAPFault fault = body.addFault();
			fault.setFaultString(reason);
			// wrapper for a SOAP 1.1 or SOAP 1.2 fault
			throw new SOAPFaultException(fault);
		} catch (SOAPException e) {
		}
	}

}