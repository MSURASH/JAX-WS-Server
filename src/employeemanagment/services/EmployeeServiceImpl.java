package employeemanagment.services;

import javax.annotation.Resource;
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;

import employeemanagement.model.Employee;
import employeemanagement.model.EmployeeUtil;
import employeemanagement.security.AuthenticationService;

@WebService(endpointInterface = "employeemanagment.services.EmployeeService")
public class EmployeeServiceImpl implements EmployeeService {

	@Resource
    private WebServiceContext wsctx;
	
	@Override
	public Employee getEmployeeById(String id) {
		
		AuthenticationService.authentication(wsctx);
        
		return EmployeeUtil.getEmployee(id);
	}

}
