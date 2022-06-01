package edu.zju.se.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Builder
public class Message implements Serializable {
    private static final long serialVersionUID = 1L;

    private String userid; /*用户id*/

    private String id; /*消息id*/

    private String title; /*消息标题*/

    private String date; /*消息时间*/

    private String detail; /*消息内容*/

    private String read; /*是否已读*/
}
