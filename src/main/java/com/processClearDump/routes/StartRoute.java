package com.processClearDump.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import com.processClearDump.routes.process.ProcessImageObject;
import com.processClearDump.routes.process.ProcessListString;


@Component
public class StartRoute extends RouteBuilder{

	
	
	@Override
	public void configure() throws Exception {
		from("file:mainFile?fileName=input-dump&noop=true").process(new ProcessStartRoute())
		.to("direct:processStringLins").end();
		
		from("direct:processStringLins")
		.process(new ProcessListString())
		.to("direct:processImageList").end();
		
		from("direct:processImageList")
		.process(new ProcessImageObject());
		
	}

	
}
