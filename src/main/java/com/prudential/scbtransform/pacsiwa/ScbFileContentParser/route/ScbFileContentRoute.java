package com.prudential.scbtransform.pacsiwa.ScbFileContentParser.route;


import org.apache.camel.builder.RouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.prudential.scbtransform.pacsiwa.ScbFileContentParser.processors.*;


@Component
public class ScbFileContentRoute extends RouteBuilder{
	
	private static final Logger logger = LoggerFactory.getLogger(ScbFileContentRoute.class);
	private final ScbFileContentParser processors;
	
	public ScbFileContentRoute (ScbFileContentParser processors) {
		this.processors = processors;
	}
	
	@Override
	public void configure() throws Exception {
		logger.info("------- SCB File Content Route -------");
        
		from("{{records.input.uri}}").process(processors).to("{{records.output.uri}}");
		
		logger.info("------- Transfered to out folder -------");
	}
}
