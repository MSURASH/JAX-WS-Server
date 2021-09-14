package employeemanagement.model;

import java.util.HashMap;
import java.util.Map;

public class EmployeeUtil {

	
	private static Map<String, Employee> map;
	 
    static {
        map = new HashMap<String, Employee>();
        map.put("1", new Employee("1", "Mary"));
        map.put("2", new Employee("2", "Terry"));
        map.put("3", new Employee("3", "Ben Best"));
        map.put("4", new Employee("4", "Alex Life"));
        map.put("5", new Employee("5", "David Music"));
    }
 
    private EmployeeUtil() {
    }
 
    public static Employee getEmployee(String id) {
        return  map.get(id);
    }
}
