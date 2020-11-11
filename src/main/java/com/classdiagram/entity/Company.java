package com.classdiagram.entity;

import java.util.List;

/**
 * 公司.
 *
 * @author fuwb
 * @date 2020-05-21
 */
public class Company {

    private String companyName;

    /**
     * 成员变量，语义上是公司拥有打印机，has-a的关系，所以是聚合关系.
     */
    private List<Printer> printers;

    /**
     * 成员变量，语义上是部门包含在公司的生命周期中，是contain-a的关系，所以是组合关系.
     */
    private List<Department> departments;


    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    public List<Printer> getPrinters() {
        return printers;
    }

    public void setPrinters(List<Printer> printers) {
        this.printers = printers;
    }
}
