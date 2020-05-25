package classdiagram.entity;

import java.util.List;

/**
 * 部门.
 *
 * @author fuwb
 * @date 2020-05-21
 */
public class Department {

    /**
     * 部门名称.
     */
    private String deptName;

    /**
     * 雇员.
     */
    private List<Employee> employees;

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
