package edu.zju.se.entity;

<<<<<<< HEAD
=======
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
@TableName("monitor")
>>>>>>> develop
public class Monitor implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID-学工号
     */
    private String id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 密码
     */
    private String password;

    /**
     * 学院
     */
    private String department;

    /**
     * 电话号码
     */
    private String phonenumber;

    /**
     * 权限身份
     */
    private String authorization="Monitor";

    public void setAuthorization(String authorization) {
        this.authorization = authorization;
    }

//    public void register(){
//
//    }

//    public void changeUserInfo(){
//
//    }
}
