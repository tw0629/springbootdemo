package com.model;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @author David Tian
 * @desc
 * @since 2019-08-16 10:28
 */
@ToString
@Data
public class LoginUserInfoDTO implements Serializable {

    private static final long serialVersionUID = 4084535553051168608L;

    private String appId;

    private String openId;

    private String unionId;

    private String userId;// 可能为null

    private String phone;

    private String nickname;

    private Integer gender;

    private String city;

    private String province;

    private String country;

    private String avatar;

    private String name;

    private Integer isStudentCertified;

    private Integer userType;

    private Integer userStatus;

    private Integer isCertified;

    private Date dateAuthPrivacy;

    private String origin;

    private Date dateUpdate;
}
