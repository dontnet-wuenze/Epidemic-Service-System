//打卡表单

package edu.zju.se.entity;


<<<<<<< HEAD
=======
import com.baomidou.mybatisplus.annotation.TableField;
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
@TableName("punch")
>>>>>>> develop
public class Punch implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id; //用户id

    private String name;

    private String date;

    private String campus; //校区

    private String region; //所在地区

    private Boolean oncampus; //是否在校

<<<<<<< HEAD
    private String Codestatus;
=======
    private String codestatus;
>>>>>>> develop

    private Boolean fever; //是否发烧

    private Boolean control; //是否在控制区

    private Boolean contact; //是否密接

    private Boolean status; //是否已打卡
}
