package com.may.ple.dg.ricoh;

import javax.ws.rs.ApplicationPath;

import org.apache.log4j.Logger;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.may.ple.dg.ricoh.restserv.UserAction;

@Component
@ApplicationPath(value="/restServ")
public class JerseyConfig extends ResourceConfig {
	private static final Logger LOG = Logger.getLogger(JerseyConfig.class.getName());
	
	public JerseyConfig() {
		LOG.debug(":----------: Register Rest Service :----------:");
		register(UserAction.class);
	}

}
