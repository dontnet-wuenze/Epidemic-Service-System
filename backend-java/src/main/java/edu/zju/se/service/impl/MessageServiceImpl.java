package edu.zju.se.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.zju.se.common.Result;
import edu.zju.se.entity.GetPost;
import edu.zju.se.entity.Message;
import edu.zju.se.mapper.MessageMapper;
import edu.zju.se.service.IMessageService;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class MessageServiceImpl extends ServiceImpl<MessageMapper, Message> implements IMessageService {

//    public Result MsgRead(String userid, GetPost getPost){
    public Result MsgRead(String userid, List readList){
        QueryWrapper<Message> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userid", userid);
        java.util.List<Message> userMsg = list(queryWrapper);
        if(userMsg.isEmpty()){
            return Result.fail("No such message!");
        }else{
            UpdateWrapper<Message> messageUpdateWrapper = new UpdateWrapper<>();
//            for(int i=0;i<getPost.getReadlist().size();i++){
            for(int i=0;i<readList.size();i++){
                messageUpdateWrapper.eq("userid", userid).eq("id", readList.get(i)).setSql("read='true'");
//                messageUpdateWrapper.eq("userid", userid).eq("id", getPost.getReadlist().get(i)).setSql("read='true'");
                update(messageUpdateWrapper);
                messageUpdateWrapper.clear();
            }
            return Result.success("Update successfully!");
        }
    }

    public boolean SendMsg(Message msg){
        Message m = getById(msg.getId());
        if(m != null){
            return false;
        }else{
            save(Message.builder()
                    .userid(msg.getUserid())
                    .date(msg.getDate())
                    .detail(msg.getDetail())
                    .id(msg.getId())
                    .title(msg.getTitle())
                    .read("false")
                    .build());
            return true;
        }
    }
}
