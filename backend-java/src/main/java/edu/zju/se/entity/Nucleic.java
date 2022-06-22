package edu.zju.se.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
 * @since 2022-06-10
 */
@Getter
@Setter
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@TableName("nucleic")
public class Nucleic implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID-表单ID
     */
    @TableId(value = "form_id", type = IdType.ASSIGN_ID)
    @JsonProperty("form_id")
    private String formId;

    /**
     * 姓名
     */
    @TableField("name")
    private String name;

    /**
     * 学工号
     */
    @TableField("staff_id")
    @JsonProperty("staff_id")
    @JsonAlias("id")
    private String staffId;

    /**
     * 预约日期
     */
    @JsonProperty("appDate")
    @TableField("app_date")
    @JsonAlias("date")
    private String appDate;

    /**
     * 预约时间(1/2/3/4代表四个时间段)
     */
    @JsonProperty("appTime")
    @TableField("app_time")
    private Integer appTime;

    /**
     * 预约检查点
     */
    @JsonProperty("appAddress")
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
