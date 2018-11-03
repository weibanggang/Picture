package com.wbg.i18n.test;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        System.out.print("请输入月份：");
        Scanner mon=new Scanner(System.in);
        int m=mon.nextInt();
        for (int i = 1; i <m+1 ; i++) {
            System.out.println("第"+i+"个月的兔子为："+abc(i));
        }
    }
    public static long abc(long x){
        if(x==1||x==2){
            return 1;
        }
        else
            return abc(x-1)+abc(x-2);
    }
}
