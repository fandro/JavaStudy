package classdiagram;

/**
 * 雇员服务.
 *
 * @author fuwb
 * @date 2020-05-21
 */
public class EmployeeService {

    private EmployeeDao employeeDao = new EmployeeDao();

    public void save(Employee employee) {

    }

    public IdCard getIdCard(int id) {
        return new IdCard();
    }

    public void modifyDepartment() {
        Department department = new Department();
    }
}
