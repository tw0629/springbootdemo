package com.model;

import java.io.Serializable;

/**
 * @author David Tian
 * @since 2019-02-28
 */
public class TagInfoVo implements Serializable {

    private static final long serialVersionUID = 7892539180119394266L;

    /**
     * 评论标签ID
     */
    private Long id;

    /**
     * 标签类型 - 1:好评，2:坏评
     */
    private Byte type;

    /**
     * 标签适用的评论类型
     */
    private Byte commentType;

    /**
     * 标签内容
     */
    private String tag;

    /**
     * 数量
     */
    private Integer count;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public Byte getCommentType() {
        return commentType;
    }

    public void setCommentType(Byte commentType) {
        this.commentType = commentType;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "TagInfoVo{" +
                "id=" + id +
                ", type=" + type +
                ", commentType=" + commentType +
                ", tag='" + tag + '\'' +
                ", count=" + count +
                '}';
    }
}
