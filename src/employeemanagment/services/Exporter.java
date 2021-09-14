package employeemanagment.services;

import javax.annotation.Resource;
import javax.xml.ws.Endpoint;
import javax.xml.ws.WebServiceContext;

import employeemanagement.security.AuthenticationService;

public class Exporter {

//	@Resource
//    private static WebServiceContext wsctx;
	
	public static void main(String[] args) {

		//AuthenticationService.authentication(wsctx);

		 Endpoint ep = Endpoint.create(new EmployeeServiceImpl());
	     ep.publish("http://localhost:8081/employeeservice");
		 //Endpoint.publish("http://localhost:8080/any/name/you/like/employeeservice", new EmployeeServiceImpl());
	}

}
