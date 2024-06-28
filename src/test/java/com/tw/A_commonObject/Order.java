package com.tw.A_commonObject;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.Date;
import java.util.List;

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

    // 分期期数
    private List<String> list ;

    public Order(String no, Date date) {
        this.no = no;
        this.date = date;
    }

    public List<String> getList() {
        if(!CollectionUtils.isEmpty(this.list)){
            Collections.sort(this.list);
        }
        return this.list;
    }
}
