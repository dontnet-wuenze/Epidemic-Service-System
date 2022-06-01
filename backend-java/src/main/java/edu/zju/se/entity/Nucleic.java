package edu.zju.se.entity;

import java.io.Serializable;
import java.time.LocalDate;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
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
 * @since 2022-05-29
 */
@Getter
@Setter
@Builder
public class Nucleic implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID-表单ID
     */
    @TableId(type = IdType.ASSIGN_ID)
    @JsonProperty("form_id")
    private Long formId;

    /**
     * 姓名
     */
    private String name;

    /**
     * 学工号
     */
    @JsonProperty("staff_id")
    private String staffId;

    /**
     * 预约日期
     */
    private LocalDate appdate;

    /**
     * 预约时间(1/2/3/4代表四个时间段)
     */
    private Integer apptime;

    /**
     * 预约检查点
     */
    private String appaddress;

    /**
     * 电话号码
     */
    private String telenum;

    /**
     * 电子邮箱
     */
    private String email;

    /**
     * 所在校区
     */
    private String campus;

    /**
     * 0阴性，1阳性，2未知
     */
    private Integer result;


}
