package edu.zju.se.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author Boris Li
 * @since 2022-06-03
 */
@Getter
@Setter
@TableName("form")
public class Form implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 表单 ID
     */
    @TableId("form_id")
    private String formId;

    /**
     * test boolean
     */
    @TableField("is_true")
    private Boolean isTrue;


}
