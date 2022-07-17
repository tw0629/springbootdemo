package com.tw.A_commonObject;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author David Tian
 * @since 2019-05-22
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    private String no;

    private Date date;

    private Long order;

    private Long dataLong;

    public Order(String no, Date date) {
        this.no = no;
        this.date = date;
    }
}
