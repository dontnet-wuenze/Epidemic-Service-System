package edu.zju.se.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author Boris Li
 * @since 2022-06-01
 */
@Getter
@Setter
@Builder
@TableName("nucleic")
public class Nucleic implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID-表单ID
     */
    @JsonProperty("form_id")
    @TableId(value = "form_id", type = IdType.ASSIGN_ID)
    private Long formId;

    /**
     * 姓名
     */
    @TableField("name")
    private String name;

    /**
     * 学工号
     */
    @JsonProperty("staff_id")
    @TableField("staff_id")
    private String staffId;

    /**
     * 预约日期
     */
    @TableField("app_date")
    private String appDate;

    /**
     * 预约时间(1/2/3/4代表四个时间段)
     */
    @TableField("app_time")
    private Integer appTime;

    /**
     * 预约检查点
     */
    @TableField("app_address")
    private String appAddress;

    /**
     * 电话号码
     */
    @TableField("telenum")
    private String telenum;

    /**
     * 电子邮箱
     */
    @TableField("email")
    private String email;

    /**
     * 所在校区
     */
    @TableField("campus")
    private String campus;

    /**
     * 0阴性，1阳性，2未知
     */
    @TableField("result")
    private Integer result;

}
