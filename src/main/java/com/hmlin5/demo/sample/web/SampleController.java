package com.hmlin5.demo.sample.web;

import com.hmlin5.demo.utils.PropertiesUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @ Author ：linhaomiao.
 * @ Date   ：2018-11-02 15:41
 * @ Desc   ：测试springboot类
 */
@RestController
@RequestMapping("/sample")
public class SampleController {


    @RequestMapping("/")
    public String home(){
        return "hello springboot";
    }


    @RequestMapping("/now")
    public Date currentDate(){

        return new Date();
    }

    @RequestMapping("testChangeProperties")
    public String testChangeProperties(){
        String str = "";
        str = PropertiesUtil.getProperty("test.properties", "b");
        return str;

    }


}
