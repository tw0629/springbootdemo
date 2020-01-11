package com.model;

import java.util.Date;

/**
 * @author David Tian
 * @since 2019-03-03
 */
public class Comment {

    /**
     * 主键
     */
    private Long id;

    /**
     * 评论类型
     */
    private Byte type;

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
     * 评分
     */
    private Integer score;

    /**
     * 创建人
     */
    private String creator;

    /**
     * 修改人
     */
    private String modifier;

    /**
     * 创建时间
     */
    private Date dateCreate;

    /**
     * 更新时间
     */
    private Date dateUpdate;

    /**
     * 删除时间
     */
    private Date dateDelete;

    /**
     * 主键
     * @return id 主键
     */
    public Long getId() {
        return id;
    }

    /**
     * 主键
     * @param id 主键
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 评论类型
     * @return type 评论类型
     */
    public Byte getType() {
        return type;
    }

    /**
     * 评论类型
     * @param type 评论类型
     */
    public void setType(Byte type) {
        this.type = type;
    }

    /**
     * 被评论对象ID
     * @return target_id 被评论对象ID
     */
    public String getTargetId() {
        return targetId;
    }

    /**
     * 被评论对象ID
     * @param targetId 被评论对象ID
     */
    public void setTargetId(String targetId) {
        this.targetId = targetId == null ? null : targetId.trim();
    }

    /**
     * 评论者ID
     * @return from_id 评论者ID
     */
    public String getFromId() {
        return fromId;
    }

    /**
     * 评论者ID
     * @param fromId 评论者ID
     */
    public void setFromId(String fromId) {
        this.fromId = fromId == null ? null : fromId.trim();
    }

    /**
     * 评论者名称
     * @return from_name 评论者名称
     */
    public String getFromName() {
        return fromName;
    }

    /**
     * 评论者名称
     * @param fromName 评论者名称
     */
    public void setFromName(String fromName) {
        this.fromName = fromName == null ? null : fromName.trim();
    }

    /**
     * 评论者头像
     * @return from_avatar 评论者头像
     */
    public String getFromAvatar() {
        return fromAvatar;
    }

    /**
     * 评论者头像
     * @param fromAvatar 评论者头像
     */
    public void setFromAvatar(String fromAvatar) {
        this.fromAvatar = fromAvatar == null ? null : fromAvatar.trim();
    }

    /**
     * 评论内容
     * @return content 评论内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 评论内容
     * @param content 评论内容
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * 评分
     * @return score 评分
     */
    public Integer getScore() {
        return score;
    }

    /**
     * 评分
     * @param score 评分
     */
    public void setScore(Integer score) {
        this.score = score;
    }

    /**
     * 创建人
     * @return creator 创建人
     */
    public String getCreator() {
        return creator;
    }

    /**
     * 创建人
     * @param creator 创建人
     */
    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    /**
     * 修改人
     * @return modifier 修改人
     */
    public String getModifier() {
        return modifier;
    }

    /**
     * 修改人
     * @param modifier 修改人
     */
    public void setModifier(String modifier) {
        this.modifier = modifier == null ? null : modifier.trim();
    }

    /**
     * 创建时间
     * @return date_create 创建时间
     */
    public Date getDateCreate() {
        return dateCreate;
    }

    /**
     * 创建时间
     * @param dateCreate 创建时间
     */
    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    /**
     * 更新时间
     * @return date_update 更新时间
     */
    public Date getDateUpdate() {
        return dateUpdate;
    }

    /**
     * 更新时间
     * @param dateUpdate 更新时间
     */
    public void setDateUpdate(Date dateUpdate) {
        this.dateUpdate = dateUpdate;
    }

    /**
     * 删除时间
     * @return date_delete 删除时间
     */
    public Date getDateDelete() {
        return dateDelete;
    }

    /**
     * 删除时间
     * @param dateDelete 删除时间
     */
    public void setDateDelete(Date dateDelete) {
        this.dateDelete = dateDelete;
    }
}
