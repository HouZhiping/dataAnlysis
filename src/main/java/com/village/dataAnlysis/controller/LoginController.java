package com.village.dataAnlysis.controller;

import com.village.dataAnlysis.domain.entity.UserEntity;
import com.village.dataAnlysis.exception.UnauthorizedException;
import com.village.dataAnlysis.response.BaseResponse;
import com.village.dataAnlysis.service.UserService;
import com.village.dataAnlysis.shiro.JWTToken;
import com.village.dataAnlysis.util.JWTUtil;
import com.village.dataAnlysis.util.MD5Util;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController {


    @Autowired
    private UserService userService;

//    @Resource
//    private ManagerInfoService managerInfoService;

    private static final Logger _logger = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping("/login")
    public BaseResponse<String> login1(@RequestHeader(name="Content-Type", defaultValue = "application/json") String contentType,
                                       @RequestBody UserEntity loginParam) throws Exception {
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



    @PostMapping("/login1")
    public BaseResponse<String> login(@RequestHeader(name="Content-Type", defaultValue = "application/json") String contentType,
                                      UserEntity loginParam) {
        try {
                Subject subject = SecurityUtils.getSubject();

            String username = loginParam.getUserName();
            String password = loginParam.getPassword();
            UserEntity userEntity = new UserEntity();
            userEntity.setUserName(username);
            UserEntity user = userService.findByUsername(userEntity);
            //随机数盐
            String salt = user.getSalt();

            String token = null;
            try {
                token = JWTUtil.sign(username, MD5Util.md5(password, username + salt));
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
            JWTToken jwtToken = new JWTToken(token);
            subject.login(jwtToken);


            /*if (user.getPassword().equals(encodedPassword)) {
                return new BaseResponse<>(true, "Login success", JWTUtil.sign(username, encodedPassword));
            } else {
                throw new UnauthorizedException();
            }*/
            return new BaseResponse<>(true, "登录成功", token);

//            return RespData.successMsg("登录成功");
        } catch (UnknownAccountException ex) {
            return new BaseResponse<>(false, "用户不存在!","");
//            return RespData.errorMsg("用户不存在！");
        } catch (IncorrectCredentialsException ex) {
            return new BaseResponse<>(false, "用户名无效!","");
//            return RespData.errorMsg("用户名无效！");
        } catch (AuthenticationException ae) {
            return new BaseResponse<>(false, "密码错误!","");
//            return RespData.errorMsg("密码错误！");
        }
    }



    @GetMapping("/401")
    public Map<String,String> qureyPopulationByPage(){


        Map<String,String> map = new HashMap<>();
        map.put("test","99999");

        return map;//这个查询会分页
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
