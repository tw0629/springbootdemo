package com.model;

import java.io.Serializable;

/**
 * @author David Tian
 * @since 2019-02-02
 */
public class EsQueryObject implements Serializable {

    private static final long serialVersionUID = 5778233574600526043L;

    //todo 待定

    private String name;

    private String phoneNumber;

    private String vin;

    private String serialName;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getSerialName() {
        return serialName;
    }

    public void setSerialName(String serialName) {
        this.serialName = serialName;
    }

    @Override
    public String toString() {
        return "EsQueryObject{" +
                "name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", vin='" + vin + '\'' +
                ", serialName='" + serialName + '\'' +
                '}';
    }
}
