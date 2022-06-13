package edu.zju.se.entity;

import java.io.Serializable;

<<<<<<< HEAD
=======
import com.baomidou.mybatisplus.annotation.TableName;
>>>>>>> develop
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
<<<<<<< HEAD
=======
@TableName("user")
>>>>>>> develop
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

<<<<<<< HEAD
=======
    private String identity; //身份

>>>>>>> develop
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

<<<<<<< HEAD
=======
    private String grade;

>>>>>>> develop
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

<<<<<<< HEAD
    private Boolean attend; //是否已打卡
=======
    private String healthycode;

    private Boolean attend; //是否已打卡

    private String nucleic; //"已检测"/"未检测"

    private String date; //最近检测日期yyyymmdd
>>>>>>> develop
}
