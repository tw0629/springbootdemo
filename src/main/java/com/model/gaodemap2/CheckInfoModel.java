package com.model.gaodemap2;

import com.base.IModel;

public class CheckInfoModel implements IModel {

    /**
     * serialVersionUID:（用一句话描述这个变量表示什么）
     *
     * @since Ver 1.1
     */

    private static final long serialVersionUID = -4367466957068787508L;

    private Boolean success;

    private String resultMsg;

    public CheckInfoModel() {
        success = true;
    }


    public CheckInfoModel(Boolean success, String resultMsg) {
        super();
        this.success = success;
        this.resultMsg = resultMsg;
    }


    /**
     * success
     *
     * @return  the success
     * @since   CodingExample Ver(编码范例查看) 1.0
     */

    public Boolean getSuccess() {
        return success;
    }


    /**
     * @param success the success to set
     */
    public void setSuccess(Boolean success) {
        this.success = success;
    }


    /**
     * resultMsg
     *
     * @return  the resultMsg
     * @since   CodingExample Ver(编码范例查看) 1.0
     */

    public String getResultMsg() {
        return resultMsg;
    }


    /**
     * @param resultMsg the resultMsg to set
     */
    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }


    public void setValue(boolean success, String resultMsg) {

        this.success = success;
        this.resultMsg = resultMsg;
    }

    @Override
    public String toString() {
        return "CheckInfoModel{" +
                "success=" + success +
                ", resultMsg='" + resultMsg + '\'' +
                '}';
    }
}
