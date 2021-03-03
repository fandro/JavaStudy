package com.classdiagram;

import com.classdiagram.entity.Company;
import com.classdiagram.entity.Department;
import com.classdiagram.entity.Employee;

/**
 * 雇员服务.
 *
 * @author fuwb
 * @since 2020-05-21
 */
public class EmployeeServiceImpl implements EmployeeService{

    /**
     * 成员变量，关联关系, new EmployeeDaoImpl 依赖关系.
     */
    private EmployeeDao employeeDao = new EmployeeDaoImpl();

    /**
     * 方法参数，依赖关系.
     * @param employee
     */
    @Override
    public void save(Employee employee) {
        employeeDao.save(employee);
    }

    /**
     * 返回类型, 依赖关系.
     * @param id
     * @return
     */
    @Override
    public Company getCompany(int id) {
        return null;
    }

    /**
     * 方法中使用Department, 依赖关系.
     */
    @Override
    public void modifyDepartment() {
        Department department = new Department();
    }

}
