package edu.zju.se.service;

import com.baomidou.mybatisplus.extension.service.IService;
import edu.zju.se.common.Result;
import edu.zju.se.entity.GetPost;
import edu.zju.se.entity.Message;

import java.util.List;


public interface IMessageService extends IService<Message> {
//    Result MsgRead(String userid, GetPost getPost);
    Result MsgRead(String userid, List readList);
}
