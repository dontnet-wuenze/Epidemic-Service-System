package edu.zju.se.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.zju.se.entity.Message;
import edu.zju.se.mapper.MessageMapper;
import edu.zju.se.service.IMessageService;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl extends ServiceImpl<MessageMapper, Message> implements IMessageService {
}
