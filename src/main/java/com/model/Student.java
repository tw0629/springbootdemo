package com.model;

import lombok.Data;

/**
 * @author David Tian
 * @desc
 * @since 2022/7/18 10:16
 */
@Data
public class Student extends MyModel{

    public String publicName;
    private String privateName;
    protected String protectedName;

    String name;
    School school;

    public School publicSchool;




    @Data
    public static class School {
        String name;
        String addr;
    }

}
