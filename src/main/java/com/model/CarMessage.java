package com.model;

import java.io.Serializable;

/**
 * @author David Tian
 * @since 2019-02-02
 */
public class CarMessage implements Serializable {

    private static final long serialVersionUID = 1884392288301615546L;

    private String vin;

    private String serialName;

    private String fitStatus;

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

    public String getFitStatus() {
        return fitStatus;
    }

    public void setFitStatus(String fitStatus) {
        this.fitStatus = fitStatus;
    }

    @Override
    public String toString() {
        return "CarTemplate{" +
                "vin='" + vin + '\'' +
                ", serialName='" + serialName + '\'' +
                ", fitStatus='" + fitStatus + '\'' +
                '}';
    }
}
