package com.tw.A_commonObject;

import lombok.Data;

import java.util.Date;

/**
 * @author David Tian
 * @since 2019-05-22
 */
@Data
public class Order {

    private String no;

    private Date date;

    public Order(String no, Date date) {
        this.no = no;
        this.date = date;
    }

}
