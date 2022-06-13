package edu.zju.se.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.zju.se.entity.People;
import edu.zju.se.mapper.PeopleMapper;
import edu.zju.se.service.IPeopleService;
import org.springframework.stereotype.Service;
@Service
public class PeopleServiceImlp extends ServiceImpl<PeopleMapper, People> implements IPeopleService{
}
