package com.model;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * @author David Tian
 * @desc
 * @since 2022/6/29 11:21
 */
@Data
public class JsonTestObject {

    private String id;

    private String name;

    @JSONField(name =  "car_message")
    private String carMessage;

    @JSONField(name =  "car_message")
    private CarMessage car;

    private CarMessage car_message;


    ///@JSONField(name =  "car_message")
    //private CarMessage carMessage;


    //@JSONField(name =  "car_message")
    //private String car;

}
