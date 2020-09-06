package com.processClearDump.model;

import org.springframework.stereotype.Service;

//{"productId":"pid3687","image":"http://localhost:4567/images/61791.png"}

@Service
public class ImageModel {
	private String productId;
	private String image;
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public ImageModel(String productId, String image) {
		super();
		this.productId = productId;
		this.image = image;
	}
	public ImageModel() {
		super();
	}
}
