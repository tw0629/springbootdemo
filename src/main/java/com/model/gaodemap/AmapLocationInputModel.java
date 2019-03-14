package com.model.gaodemap;


import com.base.IModel;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * 项目名称：com-ycg-rosefinch-location-siteservice-model
 * 类名称： AmapLocInputModel
 * 类描述：    高德地图地理位置获取入参，可通过地址获取经纬度/通过经纬度获取地址
 * 创建人：mengzw
 * 创建时间：2018年5月11日 下午2:49:56
 * 修改人：mengzw
 * 修改时间：2018年5月11日 下午2:49:56
 * 修改备注：
 */
public class AmapLocationInputModel implements IModel {

    /**
     * @since Ver 1.1
     */

    private static final long serialVersionUID = -821011969399440804L;

    /**
     * 地址
     */
    private String address;

    /**
     * 秘钥key
     */
    private String key;


    public AmapLocationInputModel() {
        super();
    }

    public AmapLocationInputModel(String address, String key) {
        super();
        this.address = address;
        this.key = key;
    }

    /**
     * address
     *
     * @return the address
     * @since CodingExample Ver(编码范例查看) 1.0
     */

    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * key
     *
     * @return the key
     * @since CodingExample Ver(编码范例查看) 1.0
     */

    public String getKey() {
        return key;
    }

    /**
     * @param key the key to set
     */
    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public String toString() {
        try {
            return String.format("address=%s&output=JSON&key=%s", URLEncoder.encode(this.address, "UTF-8"), this.key);

        } catch (UnsupportedEncodingException e) {

        }
        return "";

    }


}
