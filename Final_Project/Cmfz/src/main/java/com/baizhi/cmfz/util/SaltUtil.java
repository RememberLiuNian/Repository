package com.baizhi.cmfz.util;

import java.util.Random;

/**
 * Created by SK on 2018/8/8.
 */
public class SaltUtil {
    public static String getSalt(){
        String str = "abcdefghijklmnopqrstuvwxyz";
        Random rd = new Random();
        String salt = "";
        for (int i = 0; i < 4; i++) {
            int j = rd.nextInt(23);
            salt+=str.substring(j,j+1);
        }
        return salt;
    }
}
