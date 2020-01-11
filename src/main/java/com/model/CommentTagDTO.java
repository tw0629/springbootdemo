package com.model;

import java.io.Serializable;

/**
 * @author David Tian
 * @since 2019-02-27
 */
public class CommentTagDTO implements Serializable {

    private static final long serialVersionUID = -6517034902320454456L;

    /**
     * 评论标签ID
     */
    private Long commentTagId;

    /**
     * 评论标签内容
     */
    private String tagContent;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getCommentTagId() {
        return commentTagId;
    }

    public void setCommentTagId(Long commentTagId) {
        this.commentTagId = commentTagId;
    }

    public String getTagContent() {
        return tagContent;
    }

    public void setTagContent(String tagContent) {
        this.tagContent = tagContent;
    }

    @Override
    public String toString() {
        return "CommentTagDTO{" +
                "commentTagId=" + commentTagId +
                ", tagContent='" + tagContent + '\'' +
                '}';
    }
}
