package com.processClearDump.routes.process;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.apache.camel.Exchange;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;
import com.processClearDump.model.ImageModel;

public class ProcessListString implements org.apache.camel.Processor{

	@Autowired
	private ImageModel imageModel;

	@SuppressWarnings("deprecation")
	@Override
	public void process(Exchange exchange) throws Exception {
		Gson gson = new Gson();
		String[] stringList = exchange.getIn().getBody(String[].class);
		ArrayList<ImageModel> imageModelList = new ArrayList<>();
		
		for(int i = 0; (stringList.length - 1) > i; i++) {
			String imageJson = stringList[i]+"}";
			imageModel = gson.fromJson(imageJson, ImageModel.class);
				imageModelList.add(imageModel);
		}
		
		/*
		 * 
		 * 
		 * removendo itens repetidos da lista
		 * 
		 * 
		 * */
		
		Set<ImageModel> noDuplicateList = new HashSet<>(imageModelList);
		exchange.getOut().setBody(noDuplicateList);
	}

}
