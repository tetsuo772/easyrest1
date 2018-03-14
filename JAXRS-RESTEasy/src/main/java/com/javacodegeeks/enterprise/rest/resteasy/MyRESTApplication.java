package com.javacodegeeks.enterprise.rest.resteasy;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
 
//   Añadido
@ApplicationPath ("/rest")

public class MyRESTApplication  extends Application {
	
	private Set<Object> singletons = new HashSet<Object>();
	 
	public MyRESTApplication() {
		singletons.add(new RESTEasyHelloWorldService());

		singletons.add(new RESTEasyHelloWorldService2());
		singletons.add(new ComRestService());
	}
 
	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}

}
