package com.hmlin5.demo;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class MyTest2 {

    @Test
    public void test(){
        System.out.println("spring".equalsIgnoreCase(Season.spring.name()) );
        System.out.println(Season.valueOf("spring") );
    }

    @Test
    public void test1(){

        String city = "a县";
        System.out.println(city.length());

    }

    @Test
    public void test2(){
        String property = System.getProperty("user.dir");
        System.out.println(property);
    }


    @Test
    public void test3(){
        String content = "2019-9-11";
        String encrypt = EncryptAndDecryptUtil_A.encrypt(content);
        String decrypt = EncryptAndDecryptUtil_B.decrypt(encrypt);
        System.out.println("加密后===="+encrypt+"解密后==="+decrypt);
    }


    @Test
    public void test4(){

        String phone = "018719371170";
        boolean isNum = isNumeric(phone);
        System.out.println(isNum);


    }



    /**
     * 判断是否数字表示
     *
     * @param src
     *            源字符串
     * @return 是否数字的标志
     */
    public static boolean isNumeric(String src) {
        Pattern numericPattern = Pattern.compile("^[0-9\\-]+$");
        boolean return_value = false;
        if (src != null && src.length() > 0) {
            Matcher m = numericPattern.matcher(src);
            if (m.find()) {
                return_value = true;
            }
        }
        return return_value;
    }


    @Test
    public void testStringlength(){
        String str = "55一一";
        System.out.println(str.length());
        System.out.println(str.substring(0, 4));
    }

    @Test
    public void testformatDate(){
        try {
            String str = "2019-09-25 22:16";

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            Date parse = sdf.parse(str);
            System.out.println(parse);
        } catch (ParseException e) {
            e.printStackTrace();
        }


    }

    @Test
    public void testArrayList(){
        try {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(1);
            list.add(2);
            list.add(3);

            int count = 1;
            for (Integer num : list) {
                System.out.println("count=="+count+"  num=="+num);
                count++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testCeateNum(){

        long time = System.currentTimeMillis();
        System.out.println(time);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmsss");
        String code = sdf.format(new Date());
        int suffix = (int) ((Math.random() * 9 + 1) * 1000);
        System.out.println(code+suffix);
        System.out.println(Long.parseLong(code + suffix));

    }

    @Test
    public void testCompareIntegerAndLong(){

        Integer i1 = 10011;
        Integer i2 = 10022;
        List<Integer> list = new ArrayList<>(5);
        list.add(i1);
        list.add(i2);
        int i3 = 10011;
        System.out.println("=========="+list.contains(i3));



        Long x = 128L;
        Long y = 128L;
/*
        Long x = 80000892L;
        Long y = 80000892L;
*/

        System.out.println("=========="+(x.longValue() == y));


        Integer i = 10000;
        long l = 10001;

        System.out.println("整型与long类型比较===="+(l>i));



    }


    @Test
    public void testMaxInteger(){


        Long i = 4294967294L;

    }


}
