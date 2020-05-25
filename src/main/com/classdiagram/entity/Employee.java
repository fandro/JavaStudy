package classdiagram.entity;

/**
 * 雇员.
 *
 * @author fuwb
 * @date 2020-05-21
 */
public class Employee extends Person {

    /**
     * 岗位.
     */
    private String position;

    /**
     * 部门编号.
     */
    private int departmentId;

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }
}
