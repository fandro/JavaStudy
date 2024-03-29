package com.classdiagram;

import com.classdiagram.entity.Employee;

/**
 * 雇员dao.
 *
 * @author fuwb
 * @since 2020-05-25
 */
public interface EmployeeDao {
    /**
     * 保存雇员信息.
     * @param employee
     */
    void save(Employee employee);
}
