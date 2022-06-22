package edu.zju.se.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author Boris Li
 * @since 2022-06-06
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@TableName("form")
public class Form implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 表单 ID
     */
    @TableId(value = "form_id", type = IdType.ASSIGN_UUID)
    @JsonProperty("form_id")
    @JsonAlias("id")
    private String formId;

    /**
     * 学工号
     */
    @TableField("staff_id")
    @JsonProperty("staff_id")
    @JsonAlias({"stu_id", "st_id"})
    private String staffId;

    /**
     * 审批人 ID
     */
    @TableField("audit_id")
    @JsonProperty("audit_id")
    private String auditId;

    /**
     * 表单类型
     */
    @TableField("form_type")
    private String formType;

    /**
     * 表单状态
     */
    @TableField("status")
    @JsonProperty("status")
    private String status;

    /**
     * 表单内容
     */
    @TableField("content")
    private String content;

    /**
     * 申请时间
     */
    @TableField("application_time")
    private String applicationTime;


}
