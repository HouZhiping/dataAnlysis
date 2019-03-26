package com.village.dataAnlysis.service.impl;

import com.village.dataAnlysis.domain.entity.UserEntity;
import com.village.dataAnlysis.domain.mapper.UserMapper;
import com.village.dataAnlysis.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * </p>
 *
 * @author houzhiping
 * @since 2019-03-20
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserEntity> implements UserService {


    @Override
    public UserEntity findByUsername(UserEntity userEntity) {
        userEntity.setPassword("bc5aa0a7ed743597f5686d69e87d4faf");//123456
        userEntity.setSalt("66");
        return userEntity;
    }

    @Override
    public UserEntity findByUsername(String userName) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUserName(userName);
        userEntity.setPassword("123456");
        userEntity.setSalt("66");
        return userEntity;
    }
}
