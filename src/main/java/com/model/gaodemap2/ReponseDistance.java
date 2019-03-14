package com.model.gaodemap2;

import com.base.IModel;

import java.util.List;

public class ReponseDistance implements IModel {

    private String status;

    private String info;

    private String infocode;

    private List<Resultinfo> results;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getInfocode() {
        return infocode;
    }

    public void setInfocode(String infocode) {
        this.infocode = infocode;
    }

    public List<Resultinfo> getResults() {
        return results;
    }

    public void setResults(List<Resultinfo> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "reponseDistance{" +
                "status='" + status + '\'' +
                ", info='" + info + '\'' +
                ", infocode='" + infocode + '\'' +
                ", results=" + results +
                '}';
    }
}
