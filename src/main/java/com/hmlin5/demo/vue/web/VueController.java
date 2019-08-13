package com.hmlin5.demo.vue.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ Author ：linhaomiao.
 * @ Date   ：2018-11-03 16:35
 * @ Desc   ：vue测试
 */
@Controller
public class VueController {


    @RequestMapping("testVue")
    public String testVue(){
        return "vue/testVue";
    }
    @RequestMapping("testElementUI")
    public String testElementUI(){
        return "vue/testElementUI";
    }

    @RequestMapping("jumpTest")
    @ResponseBody
    public String jumpTest(){
        return "hello Vue!";
    }





}
