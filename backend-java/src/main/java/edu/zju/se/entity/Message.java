package edu.zju.se.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@TableName("message")
public class Message implements Serializable {
    private static final long serialVersionUID = 1L;

    @JsonProperty("id")
    private String userid; /*用户id*/

    @TableId(value = "msgid", type = IdType.ASSIGN_ID)
    private String msgid; /*消息id*/

    @JsonProperty("title")
    private String title; /*消息标题*/

    @JsonProperty("date")
    private String date; /*消息时间*/

    @JsonProperty("detail")
    private String detail; /*消息内容*/

    private Boolean read; /*是否已读*/
}
