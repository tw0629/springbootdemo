package com.model;

import java.io.Serializable;

/**
 * @author David Tian
 * @since 2019-02-27
 */
public class CommentSubScoreDTO implements Serializable {

    private static final long serialVersionUID = 248774660892873178L;

    /**
     * 子评分标题ID
     */
    private long subSubjectId;

    /**
     * 子评论标题
     */
    private String subSubject;

    /**
     * 得分
     */
    private Integer score;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public long getSubSubjectId() {
        return subSubjectId;
    }

    public void setSubSubjectId(long subSubjectId) {
        this.subSubjectId = subSubjectId;
    }

    public String getSubSubject() {
        return subSubject;
    }

    public void setSubSubject(String subSubject) {
        this.subSubject = subSubject;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "CommentSubScoreDTO{" +
                "subSubjectId=" + subSubjectId +
                ", subSubject='" + subSubject + '\'' +
                ", score=" + score +
                '}';
    }
}
