package com.village.dataAnlysis.shiro;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * 自定义一个对象用来封装token
 */
public class JWTToken implements AuthenticationToken {

    // 密钥
    private String token;

    public JWTToken(String token) {
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
