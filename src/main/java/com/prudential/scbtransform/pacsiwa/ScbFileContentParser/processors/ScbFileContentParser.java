package com.prudential.scbtransform.pacsiwa.ScbFileContentParser.processors;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ScbFileContentParser implements Processor {
	private static final Logger logger = LoggerFactory.getLogger(ScbFileContentParser.class);
	
	@Override
    public void process(Exchange exchange) {
		logger.info("------- Starting to remove windows breakline symbol in file -------");
		String originalFileContent = (String) exchange.getIn().getBody(String.class);
		
        String upperCaseFileContent = originalFileContent.replaceAll("(\\r\\n|\\n)", "\n");
        logger.info("------- Finished processing -------");
        exchange.getIn().setBody(upperCaseFileContent);
        
	}
}
