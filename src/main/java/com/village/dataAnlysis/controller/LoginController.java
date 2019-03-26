package com.village.dataAnlysis.controller;

import com.village.dataAnlysis.domain.entity.UserEntity;
import com.village.dataAnlysis.exception.UnauthorizedException;
import com.village.dataAnlysis.response.BaseResponse;
import com.village.dataAnlysis.service.UserService;
import com.village.dataAnlysis.util.JWTUtil;
import com.village.dataAnlysis.util.MD5Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.security.NoSuchAlgorithmException;

@RestController
public class LoginController {


    @Autowired
    private UserService userService;

//    @Resource
//    private ManagerInfoService managerInfoService;

    private static final Logger _logger = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping("/login")
    public BaseResponse<String> login(@RequestHeader(name="Content-Type", defaultValue = "application/json") String contentType,
                                      UserEntity loginParam) throws Exception {
        _logger.info("用户请求登录获取Token");
        String username = loginParam.getUserName();
        String password = loginParam.getPassword();
        UserEntity userEntity = new UserEntity();
        userEntity.setUserName(username);
        UserEntity user = userService.findByUsername(userEntity);
        //随机数盐
        String salt = user.getSalt();
        //原密码加密（通过username + salt作为盐）
//        String encodedPassword = ShiroKit.md5(password, username + salt);
        //用户密码加上盐
        String encodedPassword = MD5Util.md5(password, username + salt);

        if (user.getPassword().equals(encodedPassword)) {
            return new BaseResponse<>(true, "Login success", JWTUtil.sign(username, encodedPassword));
        } else {
            throw new UnauthorizedException();
        }
    }

     /*@PostMapping("/login")
    public BaseResponse<String> login(@RequestHeader(name="Content-Type", defaultValue = "application/json") String contentType,
                                      @RequestBody LoginParam loginParam) {
        _logger.info("用户请求登录获取Token");
        String username = loginParam.getUsername();
        String password = loginParam.getPassword();
        ManagerInfo user = managerInfoService.findByUsername(username);
        //随机数盐
        String salt = user.getSalt();
        //原密码加密（通过username + salt作为盐）
        String encodedPassword = ShiroKit.md5(password, username + salt);
        if (user.getPassword().equals(encodedPassword)) {
            return new BaseResponse<>(true, "Login success", JWTUtil.sign(username, encodedPassword));
        } else {
            throw new UnauthorizedException();
        }
    }*/


}
