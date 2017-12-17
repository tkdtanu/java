
package com.tkd.springboot.SimpleSpringboot.controller;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author TKD
 *
 */
@RestController
public class DataController {
	
	private static final Logger LOGGER = Logger.getLogger(DataController.class);

	@RequestMapping(method = RequestMethod.GET, value = "/getdata")
	public String getData() {
		LOGGER.debug("getdata api called");
		return "Hello User";
	}

}
