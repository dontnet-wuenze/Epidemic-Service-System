//打卡表单

package edu.zju.se.entity;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Builder
public class Punch implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id; //用户id

    private String name;

    private String date;

    private String campus; //校区

    private String region; //所在地区

    private String oncampus; //是否在校

    private String Codestatus;

    private String fever; //是否发烧

    private String control; //是否在控制区

    private String contact; //是否密接

    private String status; //是否已打卡
}
