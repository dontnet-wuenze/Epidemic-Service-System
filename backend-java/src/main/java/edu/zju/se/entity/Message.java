package edu.zju.se.entity;

<<<<<<< HEAD
=======
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
>>>>>>> develop
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Builder
<<<<<<< HEAD
=======
@TableName("message")
>>>>>>> develop
public class Message implements Serializable {
    private static final long serialVersionUID = 1L;

    private String userid; /*用户id*/

<<<<<<< HEAD
    private String id; /*消息id*/
=======
    @TableId(value = "msgid", type = IdType.ASSIGN_ID)
    private String msgid; /*消息id*/
>>>>>>> develop

    private String title; /*消息标题*/

    private String date; /*消息时间*/

    private String detail; /*消息内容*/

    private Boolean read; /*是否已读*/
}
