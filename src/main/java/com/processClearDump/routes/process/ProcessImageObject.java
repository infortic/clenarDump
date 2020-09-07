package com.processClearDump.routes.process;

import java.util.ArrayList;

import org.apache.camel.Exchange;
import org.springframework.beans.factory.annotation.Autowired;

import com.processClearDump.entity.ProductImage;
import com.processClearDump.model.ImageModel;
import com.processClearDump.util.Util;

public class ProcessImageObject implements org.apache.camel.Processor{

	@Autowired
	private Util util;
	
	@SuppressWarnings("deprecation")
	@Override
	public void process(Exchange exchange) throws Exception {
		ArrayList<ImageModel> imageModelList = exchange.getIn().getBody(ArrayList.class);
		ArrayList<ProductImage> productImageList = new ArrayList<>();
		
		int cont = 0;
		
		for(ImageModel productid : imageModelList ) {
			
			ProductImage productImage = new ProductImage();
			for(ImageModel image : imageModelList ) {
				productImage.setProductId(productid.getProductId());
				
				if(productImage.getProductId().equals( image.getProductId())) {
					if(util.getResponseCODE(image.getImage())) {
						productImage.getImages().add(image.getImage());
						cont += 1;
					}		
				}
				
				if(cont == 3) {
					cont = 0;
					break;
				}else {
					continue;
				}	
			}
			productImageList.add(productImage);
		}
		
		exchange.getOut().setBody(productImageList);
		
	}

}
