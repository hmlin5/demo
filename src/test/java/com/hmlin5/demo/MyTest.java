package com.hmlin5.demo;

import org.junit.Test;

/**
 * @ Author ：linhaomiao
 * @ Date   ：2018-11-07
 * @ Desc   ：
 */
public class MyTest {

    @Test
    public void test(){
        double a = 0.0000000000001;
        double b = 0.0;
        System.out.println("a=b?  "+(a==b));
    }
    @Test
    public void test1(){
      // String[] arr = {"1","2"};
       String[] arr = null;
        for (String s : arr) {
            System.out.println(s);
        }

    }
}
