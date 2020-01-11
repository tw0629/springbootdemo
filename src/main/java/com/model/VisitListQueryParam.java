package com.model;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author David Tian
 * @desc
 * @since 2019-09-05 16:51
 */
@ApiModel
public class VisitListQueryParam implements Serializable {

    @ApiModelProperty("集团号")
    private String groupCode;

    @ApiModelProperty("店铺号")
    private String shopCode;

    /**
     *  回访计划类型: CSI,SSI
     */
    @ApiModelProperty("回访计划类型")
    private String visitPlanType;

    @ApiModelProperty("回访状态")
    private String visitEventStatus;

    @ApiModelProperty("回访结果")
    private String visitEventResult;

    @ApiModelProperty("执行人姓名")
    private String executorName;

    /**
     *  顾问: CSI服务顾问,SSI销售顾问
     */
    @ApiModelProperty("顾问")
    private String businessAssistant;
    @ApiModelProperty("顾问姓名")
    private String businessAssistantName;

    /**
     * 业务时间（关键时间，譬如交车时间，计算时间等））
     */
    @ApiModelProperty("业务开始时间")
    private Date businessTimeStart;
    @ApiModelProperty("业务结束时间")
    private Date businessTimeEnd;

    @ApiModelProperty("计划回访开始时间")
    private Date planVisitTimeStart;
    @ApiModelProperty("计划回访结束时间")
    private Date planVisitTimeEnd;

    @ApiModelProperty("当前页码")
    private Integer currentIndex;

    @ApiModelProperty("页面条数")
    private Integer pageSize;

    @ApiModelProperty("店铺下所有子门店的code包括自己")
    private List<String> shopCodes;

     @ApiModelProperty("客户Id")
    private String customerId;

    @ApiModelProperty("日期字段-排序的日期字段组合")
    private String times;

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        groupCode = groupCode;
    }

    public String getShopCode() {
        return shopCode;
    }

    public void setShopCode(String shopCode) {
        this.shopCode = shopCode;
    }

    public String getVisitPlanType() {
        return visitPlanType;
    }

    public void setVisitPlanType(String visitPlanType) {
        this.visitPlanType = visitPlanType;
    }

    public String getVisitEventStatus() {
        return visitEventStatus;
    }

    public void setVisitEventStatus(String visitEventStatus) {
        this.visitEventStatus = visitEventStatus;
    }

    public String getVisitEventResult() {
        return visitEventResult;
    }

    public void setVisitEventResult(String visitEventResult) {
        this.visitEventResult = visitEventResult;
    }

    public String getBusinessAssistant() {
        return businessAssistant;
    }

    public void setBusinessAssistant(String businessAssistant) {
        this.businessAssistant = businessAssistant;
    }

    public String getBusinessAssistantName() {
        return businessAssistantName;
    }

    public void setBusinessAssistantName(String businessAssistantName) {
        this.businessAssistantName = businessAssistantName;
    }

    public Date getBusinessTimeStart() {
        return businessTimeStart;
    }

    public void setBusinessTimeStart(Date businessTimeStart) {
        this.businessTimeStart = businessTimeStart;
    }

    public Date getBusinessTimeEnd() {
        return businessTimeEnd;
    }

    public void setBusinessTimeEnd(Date businessTimeEnd) {
        this.businessTimeEnd = businessTimeEnd;
    }

    public Date getPlanVisitTimeStart() {
        return planVisitTimeStart;
    }

    public void setPlanVisitTimeStart(Date planVisitTimeStart) {
        this.planVisitTimeStart = planVisitTimeStart;
    }

    public Date getPlanVisitTimeEnd() {
        return planVisitTimeEnd;
    }

    public void setPlanVisitTimeEnd(Date planVisitTimeEnd) {
        this.planVisitTimeEnd = planVisitTimeEnd;
    }

    public Integer getCurrentIndex() {
        return currentIndex;
    }

    public void setCurrentIndex(Integer currentIndex) {
        this.currentIndex = currentIndex;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getExecutorName() {
        return executorName;
    }

    public void setExecutorName(String executorName) {
        this.executorName = executorName;
    }

    public List<String> getShopCodes() {
        return shopCodes;
    }

    public void setShopCodes(List<String> shopCodes) {
        this.shopCodes = shopCodes;
    }

    public String getTimes() {
        return times;
    }

    public void setTimes(String times) {
        this.times = times;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "VisitListQueryParam{" +
                "groupCode='" + groupCode + '\'' +
                ", shopCode='" + shopCode + '\'' +
                ", visitPlanType='" + visitPlanType + '\'' +
                ", visitEventStatus='" + visitEventStatus + '\'' +
                ", visitEventResult='" + visitEventResult + '\'' +
                ", executorName='" + executorName + '\'' +
                ", businessAssistant='" + businessAssistant + '\'' +
                ", businessAssistantName='" + businessAssistantName + '\'' +
                ", businessTimeStart=" + businessTimeStart +
                ", businessTimeEnd=" + businessTimeEnd +
                ", planVisitTimeStart=" + planVisitTimeStart +
                ", planVisitTimeEnd=" + planVisitTimeEnd +
                ", currentIndex=" + currentIndex +
                ", pageSize=" + pageSize +
                ", shopCodes=" + shopCodes +
                ", customerId='" + customerId + '\'' +
                ", times='" + times + '\'' +
                '}';
    }

    public VisitListQueryParam() {

    }
}
