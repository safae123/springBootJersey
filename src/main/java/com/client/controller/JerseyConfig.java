package com.client.controller;




import org.glassfish.jersey.server.ResourceConfig;


public class JerseyConfig extends ResourceConfig  {

	public JerseyConfig() {
        packages(this.getClass().getPackage().getName());
    }
}
