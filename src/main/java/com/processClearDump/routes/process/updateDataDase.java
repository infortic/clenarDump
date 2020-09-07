package com.processClearDump.routes.process;

import java.util.ArrayList;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.beans.factory.annotation.Autowired;

import com.processClearDump.entity.ProductImage;
//import com.processClearDump.repository.ProductImageRepository;

public class updateDataDase implements  Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		ProductImage[] productImageList = exchange.getIn().getBody(ProductImage[].class);
		for(ProductImage prodImage : productImageList) {
			System.out.println("id: " + prodImage.getProductId());
		}
	}

}
