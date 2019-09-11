package com.hmlin5.demo;

import org.junit.Test;


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

}
