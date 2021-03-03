package com.classdiagram;

import com.classdiagram.entity.Company;
import com.classdiagram.entity.Employee;

/**
 * 雇员服务.
 *
 * @author fuwb
 * @since 2020-05-25
 */
public interface EmployeeService {
    void save(Employee employee);

    Company getCompany(int id);

    void modifyDepartment();
}
