package edu.zju.se.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import edu.zju.se.entity.Message;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;

public interface MessageMapper extends BaseMapper<Message> {
    @Options(useGeneratedKeys = true,keyProperty = "msgid")
    @Insert("insert into message(userid,title,date,detail) values(#{userid},#{title},#{date},#{detail})")
    public int userInsert(Message msg);
}
