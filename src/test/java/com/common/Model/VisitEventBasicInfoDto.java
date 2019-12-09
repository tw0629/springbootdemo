package com.common.Model;

/**
 * @author David Tian
 * @desc
 * @since 2019-10-04 13:18
 */
public class VisitEventBasicInfoDto {

    /**
     * 客户id
     */
    private String customerId;

    /**
     * 客户id
     */
    private String customerName;

    /**
     * 客户电话
     */
    private String customerPhone;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    @Override
    public String toString() {
        return "VisitEventBasicInfoDto{" +
                "customerId='" + customerId + '\'' +
                ", customerName='" + customerName + '\'' +
                ", customerPhone='" + customerPhone + '\'' +
                '}';
    }
}
