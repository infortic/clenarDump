package com.processClearDump.routes.process;

import java.util.ArrayList;

import org.apache.camel.Exchange;

import com.processClearDump.model.ImageModel;

public class ProcessImageObject implements org.apache.camel.Processor{

	@Override
	public void process(Exchange exchange) throws Exception {
		ArrayList<ImageModel> imageModelList = exchange.getIn().getBody(ArrayList.class);
		for(ImageModel teste : imageModelList ) {
			System.out.println("ID:  "+teste.getProductId()+"    IMAGE:  "+teste.getImage());
		}
	}

}
