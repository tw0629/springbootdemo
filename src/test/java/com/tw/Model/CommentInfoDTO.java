package com.tw.Model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author David Tian
 * @since 2019-03-15
 */
public class CommentInfoDTO implements Serializable {

    private static final long serialVersionUID = -2853185580850664339L;

    /**
     * 主键
     */
    private Long id;

    /**
     * 评论类型 - 1:对售前销售评论 2:对售后预约
     */
    private int type;

    /**
     * 评论类型名称 - 1-售前销售-PRE_SALE_SALER 2-售后预约-AFTER_SALE_BOOK
     */
    private String typeName;

    /**
     * 被评论对象ID
     */
    private String targetId;

    /**
     * 评论者ID
     */
    private String fromId;


    /**
     * 评论者名称
     */
    private String fromName;

    /**
     * 评论者头像
     */
    private String fromAvatar;

    /**
     * 评论内容
     */
    private String content;

    /**
     * 评分 10分制
     */
    private Integer score;

    /**
     * 创建人
     */
    private String creator;

    /**
     * 创建时间
     */
    private Date dateCreate;

    /**
     * 评论标签
     */
    private List<CommentTagDTO> commentTagDTOList;

    /**
     * 评论子打分
     */
    private List<CommentSubScoreDTO> commentSubScoreDTOList;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getTargetId() {
        return targetId;
    }

    public void setTargetId(String targetId) {
        this.targetId = targetId;
    }

    public String getFromId() {
        return fromId;
    }

    public void setFromId(String fromId) {
        this.fromId = fromId;
    }

    public String getFromName() {
        return fromName;
    }

    public void setFromName(String fromName) {
        this.fromName = fromName;
    }

    public String getFromAvatar() {
        return fromAvatar;
    }

    public void setFromAvatar(String fromAvatar) {
        this.fromAvatar = fromAvatar;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    public List<CommentTagDTO> getCommentTagDTOList() {
        return commentTagDTOList;
    }

    public void setCommentTagDTOList(List<CommentTagDTO> commentTagDTOList) {
        this.commentTagDTOList = commentTagDTOList;
    }

    public List<CommentSubScoreDTO> getCommentSubScoreDTOList() {
        return commentSubScoreDTOList;
    }

    public void setCommentSubScoreDTOList(List<CommentSubScoreDTO> commentSubScoreDTOList) {
        this.commentSubScoreDTOList = commentSubScoreDTOList;
    }

    @Override
    public String toString() {
        return "CommentInfoDTO{" +
                "id=" + id +
                ", type=" + type +
                ", typeName='" + typeName + '\'' +
                ", targetId='" + targetId + '\'' +
                ", fromId='" + fromId + '\'' +
                ", fromName='" + fromName + '\'' +
                ", fromAvatar='" + fromAvatar + '\'' +
                ", content='" + content + '\'' +
                ", score=" + score +
                ", creator='" + creator + '\'' +
                ", dateCreate=" + dateCreate +
                ", commentTagDTOList=" + commentTagDTOList +
                ", commentSubScoreDTOList=" + commentSubScoreDTOList +
                '}';
    }
}
