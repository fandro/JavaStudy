package classdiagram;

import classdiagram.entity.Company;
import classdiagram.entity.Employee;

/**
 * 雇员服务.
 *
 * @author fuwb
 * @date 2020-05-25
 */
public interface EmployeeService {
    void save(Employee employee);

    Company getCompany(int id);

    void modifyDepartment();
}
