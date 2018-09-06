package com.baizhi.cmfz.util;

import java.util.Random;


public class CodeUtil {
    public static String getCode(){
        String str = "0123456789";
        Random rd = new Random();
        String code = "";
        for (int i = 0; i < 4; i++) {
            int j = rd.nextInt(9);
            code+=str.substring(j,j+1);
        }
        return code;
    }
}
