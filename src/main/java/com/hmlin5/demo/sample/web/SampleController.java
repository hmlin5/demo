package com.hmlin5.demo.sample.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hmlin5.demo.sample.model.SfaProductIntegralConfig;
import com.hmlin5.demo.sample.service.api.SfaProductIntegralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * @ Author ：linhaomiao.
 * @ Date   ：2018-11-02 15:41
 * @ Desc   ：测试springboot类
 */
@RestController
@RequestMapping("/sample")
public class SampleController {

    @Autowired
    private SfaProductIntegralService sfaProductIntegralService;

    @RequestMapping("/")
    public String home(){
        return "hello springboot";
    }


    @RequestMapping("/now")
    public Date currentDate(){

        return new Date();
    }

    @RequestMapping("findList")
    public PageInfo<SfaProductIntegralConfig> findList(){
        PageHelper.startPage(2,2);
        List<SfaProductIntegralConfig> list = sfaProductIntegralService.findList(new SfaProductIntegralConfig());
        PageInfo<SfaProductIntegralConfig> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @RequestMapping("testChangeProperties")
    public String testChangeProperties(){
        String str = "";
        str = PropertiesUtil.getProperty("test.properties", "b");
        return str;

    }


}
