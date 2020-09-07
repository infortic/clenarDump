package com.processClearDump.entity;

import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;

import org.apache.camel.spi.annotations.Component;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;
import javax.persistence.Table;

@Service
@Entity
@Table(name="TAB_IMAGES_PRODUCTS")
public class ProductImage implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String productId;
	
	// @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private ArrayList<String> images = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public ArrayList<String> getImages() {
		return images;
	}

	public void setImages(ArrayList<String> images) {
		this.images = images;
	}

	public ProductImage(Long id, String productId, ArrayList<String> images) {
		super();
		this.id = id;
		this.productId = productId;
		this.images = images;
	}

	public ProductImage() {
		super();
		// TODO Auto-generated constructor stub
	}	
	
	
	
	
}
