package edu.zju.se.entity;

import java.io.Serializable;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author Boris Li
 * @since 2022-05-28
 */
@Getter
@Setter
@Builder
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID-学工号
     */
    private String id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 密码
     */
    private String password;

    /**
     * 权限身份
     */
    private String permission;

    /**
     * 学院
     */
    private String department;

    /**
     * 专业
     */
    private String major;

    /**
     * 班级
     */
    private String administrativeclass;

    private String campus;

    /**
     * 电话号码
     */
    private String phone;

    /**
     * 通行码
     */
    private String code; // 0: 蓝码, 1: 黄码, 2: 红码

    private Boolean attend; //是否已打卡
}
