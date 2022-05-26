package edu.zju.se.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.zju.se.entity.Monitor;
import edu.zju.se.mapper.MonitorMapper;
import edu.zju.se.service.IMonitorService;
import org.springframework.stereotype.Service;

@Service
public class MonitorServiceImpl extends ServiceImpl<MonitorMapper, Monitor> implements IMonitorService {

}
