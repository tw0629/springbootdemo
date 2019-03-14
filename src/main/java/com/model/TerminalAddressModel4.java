package com.model;

public class TerminalAddressModel4 {
    private static final long serialVersionUID = -249659481195952276L;
    /**
     * 终点站地址ID
     */
    private Long terminalAddressId;

    /**
     * 店小二员工号
     */
    private String workerCode;

    /**
     * 省
     */
    private String province;

    /**
     * 市
     */
    private String city;

    /**
     * 地区/县
     */
    private String area;

    /**
     * 详细地址
     */
    private String detailAddress;

    /**
     * 经度
     */
    private String longitude;

    /**
     * 纬度
     */
    private String latitude;

    /**
     * 是否是默认地址
     */
    private Integer isdefault;

    /**
     * 是否删除
     */
    private Integer isdel;

    /**
     * 标签ID
     */
    private Long labelId;

    /**
     * 标签名
     */
    private String labelName;

    /**
     * 终点站地址ID
     *
     * @return TERMINAL_ADDRESS_ID 终点站地址ID
     */
    public Long getTerminalAddressId() {
        return terminalAddressId;
    }

    /**
     * 终点站地址ID
     *
     * @param terminalAddressId 终点站地址ID
     */
    public void setTerminalAddressId(Long terminalAddressId) {
        this.terminalAddressId = terminalAddressId;
    }

    /**
     * 店小二员工号
     *
     * @return WORKER_CODE 店小二员工号
     */
    public String getWorkerCode() {
        return workerCode;
    }

    /**
     * 店小二员工号
     *
     * @param workerCode 店小二员工号
     */
    public void setWorkerCode(String workerCode) {
        this.workerCode = workerCode == null ? null : workerCode.trim();
    }

    /**
     * 省
     *
     * @return PROVINCE 省
     */
    public String getProvince() {
        return province;
    }

    /**
     * 省
     *
     * @param province 省
     */
    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    /**
     * 市
     *
     * @return CITY 市
     */
    public String getCity() {
        return city;
    }

    /**
     * 市
     *
     * @param city 市
     */
    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    /**
     * 地区/县
     *
     * @return AREA 地区/县
     */
    public String getArea() {
        return area;
    }

    /**
     * 地区/县
     *
     * @param area 地区/县
     */
    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    /**
     * 详细地址
     *
     * @return DETAIL_ADDRESS 详细地址
     */
    public String getDetailAddress() {
        return detailAddress;
    }

    /**
     * 详细地址
     *
     * @param detailAddress 详细地址
     */
    public void setDetailAddress(String detailAddress) {
        this.detailAddress = detailAddress == null ? null : detailAddress.trim();
    }

    /**
     * 经度
     *
     * @return LONGITUDE 经度
     */
    public String getLongitude() {
        return longitude;
    }

    /**
     * 经度
     *
     * @param longitude 经度
     */
    public void setLongitude(String longitude) {
        this.longitude = longitude == null ? null : longitude.trim();
    }

    /**
     * 纬度
     *
     * @return LATITUDE 纬度
     */
    public String getLatitude() {
        return latitude;
    }

    /**
     * 纬度
     *
     * @param latitude 纬度
     */
    public void setLatitude(String latitude) {
        this.latitude = latitude == null ? null : latitude.trim();
    }

    /**
     * 是否是默认地址
     *
     * @return ISDEFAULT 是否是默认地址
     */
    public Integer getIsdefault() {
        return isdefault;
    }

    /**
     * 是否是默认地址
     *
     * @param isdefault 是否是默认地址
     */
    public void setIsdefault(Integer isdefault) {
        this.isdefault = isdefault;
    }

    /**
     * 是否删除
     *
     * @return ISDEL 是否删除
     */
    public Integer getIsdel() {
        return isdel;
    }

    /**
     * 是否删除
     *
     * @param isdel 是否删除
     */
    public void setIsdel(Integer isdel) {
        this.isdel = isdel;
    }

    /**
     * 标签ID
     *
     * @return labelId
     */
    public Long getLabelId() {
        return labelId;
    }

    /**
     * 标签ID
     *
     * @param labelId
     */
    public void setLabelId(Long labelId) {
        this.labelId = labelId;
    }

    /**
     * 标签名
     *
     * @return labelName
     */
    public String getLabelName() {
        return labelName;
    }

    /**
     * 标签名
     *
     * @param labelName
     */
    public void setLabelName(String labelName) {
        this.labelName = labelName;
    }

    @Override
    public String toString() {
        return "TerminalAddressModel{" +
                "terminalAddressId=" + terminalAddressId +
                ", workerCode='" + workerCode + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", area='" + area + '\'' +
                ", detailAddress='" + detailAddress + '\'' +
                ", longitude='" + longitude + '\'' +
                ", latitude='" + latitude + '\'' +
                ", isdefault=" + isdefault +
                ", isdel=" + isdel +
                ", labelId=" + labelId +
                ", labelName='" + labelName + '\'' +
                '}';
    }
}
