package com.tw2;

/**
 * @author David Tian
 * @desc
 * @since 2020-08-21 14:47
 */
public class Department {

    private Integer departmentId;

    private Integer sunDepartmentId;

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public Integer getSunDepartmentId() {
        return sunDepartmentId;
    }

    public void setSunDepartmentId(Integer sunDepartmentId) {
        this.sunDepartmentId = sunDepartmentId;
    }



    public Integer selectSunDepartmentId(Department d){
        return d.sunDepartmentId;
    }

}
