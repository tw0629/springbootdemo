package com.common.Model;

import lombok.Data;

/**
 * @author David Tian
 * @desc
 * @since 2019-10-04 16:58
 */
@Data
public class VisitEventBasicInfo {

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
}
