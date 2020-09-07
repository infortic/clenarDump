package com.processClearDump.routes.process;

import java.io.IOException;
import java.sql.Array;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;

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
		ImageModel[] imageModelList = exchange.getIn().getBody(ImageModel[].class);
		ArrayList<ImageModel> arrayList = new ArrayList<ImageModel>(Arrays.asList(imageModelList));
		
		ArrayList<ProductImage> productImageList = new ArrayList<>();
		
		int cont = 0;
		ProductImage productImage = new ProductImage();
		
		for(ImageModel productid : arrayList ) {
			ArrayList<String> imageList =	this.hendleProducImage(productid.getProductId(), arrayList);
			productImage.setProductId(productid.getProductId());
			productImage.setImages(imageList);
			productImageList.add(productImage);
			arrayList.remove(productid);
			
		}
		
		exchange.getOut().setBody(productImageList);
		
	}
	
	
	public ArrayList<String> hendleProducImage(String productId, ArrayList<ImageModel> tempList) throws IOException {
		ArrayList<String> listImage = new ArrayList<>();
		for(ImageModel prodImage : tempList) {
			
			if(productId.equals(prodImage.getProductId())) {
				if(getResponseCODE(prodImage.getImage())) {
					listImage.add(prodImage.getImage());
				}
			}
			if(listImage.size() >= 3) {
				break;
			}else {
				continue;
			}
		}
		return listImage;
	}
	
	
	
	
	public Boolean getResponseCODE(String urlString) throws IOException {
        URL u = new URL(urlString);
        int CODEResponse = 0;
        HttpURLConnection huc = (HttpURLConnection) u.openConnection();
        huc.setRequestMethod("GET");
        huc.connect();
        CODEResponse = huc.getResponseCode();
        if (CODEResponse != 200) {
            return false;
        } else {
            return true;
        }
    }

}
