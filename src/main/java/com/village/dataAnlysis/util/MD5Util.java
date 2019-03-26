package com.village.dataAnlysis.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {

    public static String md5(String password, String salt) throws NoSuchAlgorithmException {

        MessageDigest messageDigest = MessageDigest.getInstance("MD5");

        messageDigest.update( (password+salt).getBytes() );

        return new BigInteger(1,messageDigest.digest()).toString(16);

    }



}
