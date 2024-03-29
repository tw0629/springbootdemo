package com.model;

public class TerminalAddressEntity {

    private CarMessage carMessage;

    public CarMessage getCarMessage() {
        return carMessage;
    }

    public void setCarMessage(CarMessage carMessage) {
        this.carMessage = carMessage;
    }

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

//    @Override
//    public String toString() {
//        return "TerminalAddressEntity{" +
//                "labelname='" + labelname + '\'' +
//                ", terminalAddressId=" + terminalAddressId +
//                ", workerCode='" + workerCode + '\'' +
//                ", province='" + province + '\'' +
//                '}';
//    }


    @Override
    public String toString() {
        return "TerminalAddressEntity{" +
                ", terminalAddressId=" + terminalAddressId +
                ", workerCode='" + workerCode + '\'' +
                ", province='" + province + '\'' +
                '}';
    }
}