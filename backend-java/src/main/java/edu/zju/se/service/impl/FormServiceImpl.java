package edu.zju.se.service.impl;

import edu.zju.se.entity.Form;
import edu.zju.se.mapper.FormMapper;
import edu.zju.se.service.IFormService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Boris Li
 * @since 2022-06-03
 */
@Service
public class FormServiceImpl extends ServiceImpl<FormMapper, Form> implements IFormService {

}
