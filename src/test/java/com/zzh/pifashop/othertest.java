package com.zzh.pifashop;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class othertest {
    public static void main(String[] args) {
        SimpleDateFormat sdfTime = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
//        System.out.println("时间戳："+sdfTime.format(new Date()));
        String time = sdfTime.format(new Date());
        System.out.println(time);
        time = time.replaceAll("[[\\s-:punct:]]", "");
        Random rm = new Random();
        int random = (int)(rm.nextDouble()*Math.pow(10,rm.nextInt(5)+5)%1000);
        System.out.println(random);
        String temp = time + random;
//        System.out.println(temp);
        long orderNum = Long.parseLong(temp);
        System.out.println(orderNum);
    }

}
