package com.ls.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.Scanner;

/**
 * Created by LS on 2017/8/21 14:18.
 * To Be or Not to Be
 */
public class Input {
    public static String getString(){
//        BufferedReader br=new BufferedReader
//                (new InputStreamReader(System.in));
        Scanner scanner=new Scanner(System.in);
        String s=null;
        while (true){
            s=scanner.next();
            if (s!=null){
                return s;
            }
        }
    }
    public static Double getDouble() {
        while (true) {
            try {
                String s = getString().trim();
                Double i = Double.parseDouble(s);
                return i;
            } catch (NumberFormatException e) {
                System.out.println("输入错误请重新输入");
            }
        }
    }
    public static BigDecimal getDecimal() {
        while (true) {
            try {
                String s = getString().trim();
                BigDecimal a =new BigDecimal(s);
                return a;
            } catch (NumberFormatException e) {
                System.out.println("输入错误请重新输入");
            }
        }
    }
    public static Integer getInteger() {
        while (true) {
            try {
                String s = getString().trim();
                Integer i=new Integer(s);
                return i;
            } catch (NumberFormatException e) {
                System.out.println("输入错误请重新输入");
            }
        }
    }
}
