package com.model.gaodemap;

import com.base.IModel;

//public class MapCoordinateModel implements IModel {
//    private static final long serialVersionUID = 7403737434835803872L;
public class MapCoordinateModel implements IModel {
    /**
     * 秘钥key
     */
    private String key;
    /**
     * 地址
     */
    private String location;

    public MapCoordinateModel() {
    }

    public MapCoordinateModel(String key, String coordinate) {
        this.key = key;
        this.location = coordinate;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getCoordinate() {
        return location;
    }

    public void setCoordinate(String coordinate) {
        this.location = coordinate;
    }

    @Override
    public String toString() {
//        try {
//            //return String.format("location=%s&output=JSON&key=%s", URLEncoder.encode(this.location, "UTF-8"),this.key);
//
//        } catch (UnsupportedEncodingException e) {
//
//        }
        return String.format("location=%s&output=JSON&key=%s", this.location, this.key);
//        return "";
    }
}
