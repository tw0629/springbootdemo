package com.model;

import java.util.Date;

public class SendReceivePunchModel {
    /**
     * 交接派件打卡ID
     */
    private Long id;

    /**
     * 店小二员工号
     */
    private String workerCode;

    /**
     * 店小二员名字
     */
    private String woekerName;

    /**
     * 网点ID
     */
    private String storeCode;

    /**
     * 网点名称
     */
    private String storeName;

    /**
     * 转运中心ID
     */
    private String transcenterCode;

    /**
     * 转运中心名称
     */
    private String transcenterName;

    /**
     * 打卡地址
     */
    private String punchAddress;

    /**
     * 打卡经度
     */
    private String punchLongitude;

    /**
     * 打卡纬度
     */
    private String punchLatitude;

    /**
     * 交接件打卡时间
     */
    private Date sendreceDate;

    /**
     * 打卡类型
     */
    private Integer type;

    /**
     * 打卡内容
     */
    private String cardType;

    /**
     * 是否删除;1：存在;0：已删除
     */
    private Integer isDel;

    /**
     * 交接派件打卡ID
     * @return ID 交接派件打卡ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 交接派件打卡ID
     * @param id 交接派件打卡ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 店小二员工号
     * @return WORKER_CODE 店小二员工号
     */
    public String getWorkerCode() {
        return workerCode;
    }

    /**
     * 店小二员工号
     * @param workerCode 店小二员工号
     */
    public void setWorkerCode(String workerCode) {
        this.workerCode = workerCode == null ? null : workerCode.trim();
    }

    /**
     * 店小二员名字
     * @return WOEKER_NAME 店小二员名字
     */
    public String getWoekerName() {
        return woekerName;
    }

    /**
     * 店小二员名字
     * @param woekerName 店小二员名字
     */
    public void setWoekerName(String woekerName) {
        this.woekerName = woekerName == null ? null : woekerName.trim();
    }

    /**
     * 网点ID
     * @return STORE_CODE 网点ID
     */
    public String getStoreCode() {
        return storeCode;
    }

    /**
     * 网点ID
     * @param storeCode 网点ID
     */
    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode == null ? null : storeCode.trim();
    }

    /**
     * 网点名称
     * @return STORE_NAME 网点名称
     */
    public String getStoreName() {
        return storeName;
    }

    /**
     * 网点名称
     * @param storeName 网点名称
     */
    public void setStoreName(String storeName) {
        this.storeName = storeName == null ? null : storeName.trim();
    }

    /**
     * 转运中心ID
     * @return TRANSCENTER_CODE 转运中心ID
     */
    public String getTranscenterCode() {
        return transcenterCode;
    }

    /**
     * 转运中心ID
     * @param transcenterCode 转运中心ID
     */
    public void setTranscenterCode(String transcenterCode) {
        this.transcenterCode = transcenterCode == null ? null : transcenterCode.trim();
    }

    /**
     * 转运中心名称
     * @return TRANSCENTER_NAME 转运中心名称
     */
    public String getTranscenterName() {
        return transcenterName;
    }

    /**
     * 转运中心名称
     * @param transcenterName 转运中心名称
     */
    public void setTranscenterName(String transcenterName) {
        this.transcenterName = transcenterName == null ? null : transcenterName.trim();
    }

    /**
     * 打卡地址
     * @return PUNCH_ADDRESS 打卡地址
     */
    public String getPunchAddress() {
        return punchAddress;
    }

    /**
     * 打卡地址
     * @param punchAddress 打卡地址
     */
    public void setPunchAddress(String punchAddress) {
        this.punchAddress = punchAddress == null ? null : punchAddress.trim();
    }

    /**
     * 打卡经度
     * @return PUNCH_LONGITUDE 打卡经度
     */
    public String getPunchLongitude() {
        return punchLongitude;
    }

    /**
     * 打卡经度
     * @param punchLongitude 打卡经度
     */
    public void setPunchLongitude(String punchLongitude) {
        this.punchLongitude = punchLongitude == null ? null : punchLongitude.trim();
    }

    /**
     * 打卡纬度
     * @return PUNCH_LATITUDE 打卡纬度
     */
    public String getPunchLatitude() {
        return punchLatitude;
    }

    /**
     * 打卡纬度
     * @param punchLatitude 打卡纬度
     */
    public void setPunchLatitude(String punchLatitude) {
        this.punchLatitude = punchLatitude == null ? null : punchLatitude.trim();
    }

    /**
     * 交接件打卡时间
     * @return SENDRECE_DATE 交接件打卡时间
     */
    public Date getSendreceDate() {
        return sendreceDate;
    }

    /**
     * 交接件打卡时间
     * @param sendreceDate 交接件打卡时间
     */
    public void setSendreceDate(Date sendreceDate) {
        this.sendreceDate = sendreceDate;
    }

    /**
     * 打卡类型
     * @return TYPE 打卡类型
     */
    public Integer getType() {
        return type;
    }

    /**
     * 打卡类型
     * @param type 打卡类型
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 打卡内容
     * @return CARD_TYPE 打卡内容
     */
    public String getCardType() {
        return cardType;
    }

    /**
     * 打卡内容
     * @param cardType 打卡内容
     */
    public void setCardType(String cardType) {
        this.cardType = cardType == null ? null : cardType.trim();
    }

    /**
     * 是否删除;1：存在;0：已删除
     * @return IS_DEL 是否删除;1：存在;0：已删除
     */
    public Integer getIsDel() {
        return isDel;
    }

    /**
     * 是否删除;1：存在;0：已删除
     * @param isDel 是否删除;1：存在;0：已删除
     */
    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }


    @Override
    public String toString() {
        return "SendReceivePunchEntity{" +
                "id=" + id +
                ", workerCode='" + workerCode + '\'' +
                ", woekerName='" + woekerName + '\'' +
                ", storeCode='" + storeCode + '\'' +
                ", storeName='" + storeName + '\'' +
                ", transcenterCode='" + transcenterCode + '\'' +
                ", transcenterName='" + transcenterName + '\'' +
                ", punchAddress='" + punchAddress + '\'' +
                ", punchLongitude='" + punchLongitude + '\'' +
                ", punchLatitude='" + punchLatitude + '\'' +
                ", sendreceDate=" + sendreceDate +
                ", type=" + type +
                ", cardType='" + cardType + '\'' +
                ", isDel=" + isDel +
                '}';
    }
}