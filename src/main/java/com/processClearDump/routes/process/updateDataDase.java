package com.processClearDump.routes.process;

import java.util.ArrayList;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.beans.factory.annotation.Autowired;
import com.processClearDump.entity.ProductImage;
import com.processClearDump.repository.ProductImageRepository;

public class updateDataDase implements  Processor {

	@Autowired
	private ProductImageRepository dao;
	
	@Override
	public void process(Exchange exchange) throws Exception {
		ArrayList<ProductImage> productImageList = exchange.getIn().getBody(ArrayList.class);
		for(ProductImage prodImage : productImageList) {
		//	dao.save(prodImage);
		}
	}

}
