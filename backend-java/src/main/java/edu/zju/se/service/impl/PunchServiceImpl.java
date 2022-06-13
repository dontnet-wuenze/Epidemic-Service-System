package edu.zju.se.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.zju.se.entity.Punch;
import edu.zju.se.entity.User;
import edu.zju.se.mapper.PunchMapper;
import edu.zju.se.service.IPunchService;
import edu.zju.se.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class PunchServiceImpl extends ServiceImpl<PunchMapper, Punch> implements IPunchService {
    @Override
    public Punch GetPunch(String id){
        Punch tmpPunch = getById(id);
<<<<<<< HEAD
        if(tmpPunch.getStatus().equals("false")){ //未打卡
=======
        if(!tmpPunch.getStatus()){ //未打卡
>>>>>>> develop
            return Punch.builder()
                    .status(tmpPunch.getStatus())
                    .id(tmpPunch.getId())
                    .name(tmpPunch.getName())
                    .build();
        }
        else{
            return Punch.builder()
                    .status(tmpPunch.getStatus())
                    .id(tmpPunch.getId())
                    .name(tmpPunch.getName())
                    .date(tmpPunch.getDate())
                    .campus(tmpPunch.getCampus())
                    .region(tmpPunch.getRegion())
                    .oncampus(tmpPunch.getOncampus())
<<<<<<< HEAD
                    .Codestatus(tmpPunch.getCodestatus())
=======
                    .codestatus(tmpPunch.getCodestatus())
>>>>>>> develop
                    .fever(tmpPunch.getFever())
                    .control(tmpPunch.getControl())
                    .contact(tmpPunch.getContact())
                    .build();
        }
    }

    @Override
    public boolean AttendPunch(Punch punch){
        if(getById(punch.getId()) == null){
            return false;
        }
        else{
            UpdateWrapper<Punch> punchUpdateWrapper = new UpdateWrapper<>();
            punchUpdateWrapper.eq("id", punch.getId())
                    .set("name", punch.getName())
                    .set("date", punch.getDate())
                    .set("campus", punch.getCampus())
                    .set("region", punch.getRegion())
<<<<<<< HEAD
                    .set("oncampus", punch.getOncampus())
                    .set("codestatus", punch.getCodestatus())
                    .set("fever", punch.getFever())
                    .set("control", punch.getControl())
                    .set("contact", punch.getContact())
                    .set("status","true");
=======
                    .set("onCampus", punch.getOncampus())
                    .set("codeStatus", punch.getCodestatus())
                    .set("fever", punch.getFever())
                    .set("control", punch.getControl())
                    .set("contact", punch.getContact())
                    .set("status",true);
>>>>>>> develop
            update(punchUpdateWrapper);
            return true;
        }
    }
}
