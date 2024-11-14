package top.xym.service.impl;

import top.xym.entity.User;
import top.xym.mapper.UserMapper;
import top.xym.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xym
 * @since 2024-11-14
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
