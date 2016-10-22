package sk.posta.boc.util;

import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class SOAPLoggingHandler implements SOAPHandler<SOAPMessageContext>{
	// change this to redirect output if desired
	private static final Logger logger = LoggerFactory.getLogger(SOAPLoggingHandler.class.getName());

    public Set<QName> getHeaders() {
        return null;
    }

    public boolean handleMessage(SOAPMessageContext smc) {
        logToSystemOut(smc);
        return true;
    }

    public boolean handleFault(SOAPMessageContext smc) {
        logToSystemOut(smc);
        return true;
    }

    // nothing to clean up
    public void close(MessageContext messageContext) {
    }

    /*
     * Check the MESSAGE_OUTBOUND_PROPERTY in the context
     * to see if this is an outgoing or incoming message.
     * Write a brief message to the print stream and
     * output the message. The writeTo() method can throw
     * SOAPException or IOException
     */
    private void logToSystemOut(SOAPMessageContext smc) {
        Boolean outboundProperty = (Boolean) smc.get (MessageContext.MESSAGE_OUTBOUND_PROPERTY);
        String endpointAddress = (String)smc.get(BindingProvider.ENDPOINT_ADDRESS_PROPERTY);

        if (outboundProperty.booleanValue()) {
        	logger.info("\n=========    Outbound message to: " + endpointAddress);
        } else {
        	logger.info("\n=========    Inbound message:");
        }

 
        	
        SOAPMessage message = smc.getMessage();
        
        
        try {
        	ByteArrayOutputStream baos = new ByteArrayOutputStream();
            message.writeTo(baos);
            logger.info(baos.toString("UTF8"));
        } catch (Exception e) {
        	logger.info("Exception in handler: " + e);
        }
    }
}
