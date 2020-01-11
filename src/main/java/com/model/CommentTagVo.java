package com.model;

import java.io.Serializable;

/**
 * @author David Tian
 * @since 2019-02-28
 */
public class CommentTagVo implements Serializable {

    private static final long serialVersionUID = 7541223720643118936L;

    /**
     * 评论记录ID
     */
    private Long commentid;

    /**
     * 评论类型
     */
    private Integer commenttype;

    /**
     * 被评论对象ID
     */
    private String targetid;

    /**
     * 所有评论标签ID
     */
    private String commenttagids;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getCommentid() {
        return commentid;
    }

    public void setCommentid(Long commentid) {
        this.commentid = commentid;
    }

    public Integer getCommenttype() {
        return commenttype;
    }

    public void setCommenttype(Integer commenttype) {
        this.commenttype = commenttype;
    }

    public String getTargetid() {
        return targetid;
    }

    public void setTargetid(String targetid) {
        this.targetid = targetid;
    }

    public String getCommenttagids() {
        return commenttagids;
    }

    public void setCommenttagids(String commenttagids) {
        this.commenttagids = commenttagids;
    }

    @Override
    public String toString() {
        return "CommentTagVo{" +
                "commentid=" + commentid +
                ", commenttype=" + commenttype +
                ", targetid='" + targetid + '\'' +
                ", commenttagids='" + commenttagids + '\'' +
                '}';
    }
}
