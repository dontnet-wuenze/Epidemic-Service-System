package edu.zju.se.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author Boris Li
 * @since 2022-05-22
 */
@Getter
@Setter
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID-学工号
     */
    private Long id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 密码
     */
    private String password;

    /**
     * 学院
     */
    private String department;

    /**
     * 电话号码
     */
    private String phonenumber;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 权限身份
     */
    private String authorization;

    /**
     * 健康码
     */
    private String healthycode;


}
