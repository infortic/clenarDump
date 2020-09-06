package com.processClearDump.routes;

import org.apache.camel.Exchange;

public class ProcessStartRoute implements org.apache.camel.Processor {
	
	@SuppressWarnings("deprecation")
	@Override
	public void process(Exchange exchange) throws Exception {
		 String fileContent = exchange.getIn().getBody(String.class);
		 String[] listJsonString = fileContent.split("}");
		 exchange.getOut().setBody(listJsonString);
	}

}
