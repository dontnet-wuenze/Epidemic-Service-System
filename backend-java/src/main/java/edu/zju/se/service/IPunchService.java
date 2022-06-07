package edu.zju.se.service;

import com.baomidou.mybatisplus.extension.service.IService;
import edu.zju.se.entity.Punch;

public interface IPunchService extends IService<Punch> {
    Punch GetPunch(String id);

    boolean AttendPunch(Punch punch);
}
