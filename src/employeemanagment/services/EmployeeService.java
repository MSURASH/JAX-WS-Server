package employeemanagment.services;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import employeemanagement.model.Employee;

@WebService
public interface EmployeeService {

	@WebMethod
	Employee getEmployeeById(@WebParam(name = "empId") String id);
}
