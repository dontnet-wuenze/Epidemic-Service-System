package edu.zju.se.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.zju.se.entity.Monitor;
import edu.zju.se.entity.User;
import edu.zju.se.mapper.MonitorMapper;
import edu.zju.se.service.IMonitorService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MonitorServiceImpl extends ServiceImpl<MonitorMapper, Monitor> implements IMonitorService {

}
