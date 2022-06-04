package edu.zju.se.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("user")
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

    private String identity; //身份

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

    private String grade;

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

    private String healthycode;

    private Boolean attend; //是否已打卡

    private String nucleic; //"已检测"/"未检测"

    private String date; //最近检测日期yyyymmdd
}
