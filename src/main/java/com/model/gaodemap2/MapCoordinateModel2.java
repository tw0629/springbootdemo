package com.model.gaodemap2;

import com.base.IModel;

//public class MapCoordinateModel implements IModel {
//    private static final long serialVersionUID = 7403737434835803872L;
public class MapCoordinateModel2 implements IModel {

    private static final long serialVersionUID = 5468517535342356475L;
    /**
     * 秘钥key
     */
    private String key;
    /**
     * 地址
     */
    private String origins;
    private String destination;

    public MapCoordinateModel2() {
    }

    public MapCoordinateModel2(String key, String origins, String destination) {
        this.key = key;
        this.origins = origins;
        this.destination = destination;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getOrigins() {
        return origins;
    }

    public void setOrigins(String origins) {
        this.origins = origins;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    @Override
    public String toString() {
//        try {
//            //return String.format("location=%s&output=JSON&key=%s", URLEncoder.encode(this.location, "UTF-8"),this.key);
//
//        } catch (UnsupportedEncodingException e) {
//
//        }
        return String.format("origins=%s&destination=%s&output=JSON&key=%s", this.origins,this.destination, this.key);
//        return "";
    }
}
