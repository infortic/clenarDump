package com.processClearDump.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.processClearDump.model.ImageModel;

@Service
public class ImageUltil {

	@Autowired
	private ImageModel imageModel;
	
	public ImageModel strungToJsonImage(String productId, String image) {
		imageModel.setProductId(productId);
		imageModel.setImage(image);		
		return imageModel;
	}
	
}
