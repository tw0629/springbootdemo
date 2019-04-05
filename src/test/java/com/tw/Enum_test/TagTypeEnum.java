package com.tw.Enum_test;

import org.springframework.util.StringUtils;

/**
 * @author David Tian
 * @since 2019-03-16
 */
public enum TagTypeEnum {

    GOOD_COMMENT(1,"好评"),
    BAD_COMMENT(2, "差评");

    private Integer code;
    private String desc;

    TagTypeEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static void SqlConditionEnum(String tagTypeEnum) {
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }


    public static TagTypeEnum getByName(String name){
        if (StringUtils.isEmpty(name)){
            return null;
        }
        for (TagTypeEnum tagTypeEnum : TagTypeEnum.values()){
            if (tagTypeEnum.name().equals(name)){
                return tagTypeEnum;
            }
        }
        return null;
    }

    public static String getByCode(Integer code){
        if (StringUtils.isEmpty(code)){
            return null;
        }
        for (TagTypeEnum tagTypeEnum : TagTypeEnum.values()){
            if (tagTypeEnum.code.equals(code)){
                return tagTypeEnum.desc;
            }
        }
        return null;
    }

}
