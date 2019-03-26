package com.village.dataAnlysis.service;

import com.village.dataAnlysis.domain.entity.UserEntity;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 'longqiao_info.an_ren_kou_shu_tong_ji_jia_ting_shu_view' is not BASE TABLE 服务类
 * </p>
 *
 * @author houzhiping
 * @since 2019-03-20
 */
public interface UserService extends IService<UserEntity> {

    UserEntity findByUsername(UserEntity userEntity);
    UserEntity findByUsername(String userName);

}
