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

    private Boolean oncampus; //是否在校

    private String Codestatus;

    private Boolean fever; //是否发烧

    private Boolean control; //是否在控制区

    private Boolean contact; //是否密接

    private Boolean status; //是否已打卡
}
