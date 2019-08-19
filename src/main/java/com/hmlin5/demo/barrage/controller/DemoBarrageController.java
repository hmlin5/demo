package com.hmlin5.demo.barrage.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hmlin5.demo.barrage.entity.DemoBarrage;
import com.hmlin5.demo.barrage.service.IDemoBarrageService;
import com.hmlin5.demo.utils.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author hmlin5
 * @since 2019-08-13
 */
@RestController
@RequestMapping("/barrage")
@CrossOrigin
public class DemoBarrageController {

    @Autowired
    private IDemoBarrageService iDemoBarrageService;


    @RequestMapping("/findBarrage")
    public Map<String, Object> findBarrage( ){
        Map<String, Object> map = new HashMap<>(1);

        try {

            QueryWrapper<DemoBarrage> bw = new QueryWrapper<>();
            bw.orderByDesc("create_time");
            //bw.eq()
          //  bw.last("limit 0,3");
           // List<DemoBarrage> list = iDemoBarrageService.list(bw);
            //new page(current,size) current当前页, size 页码大小
          //  bw.eq(DemoBarrage.ID,9);
         //   bw.ge(DemoBarrage.ID,9);
            IPage<DemoBarrage> page = iDemoBarrageService.page(new Page<>(1,10), bw);
            List<DemoBarrage> list = page.getRecords();

            map.put("list",list);
            map.put("total",page.getTotal());



        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;

    }




    @RequestMapping("addBarrage")
    public Map<String, Object> addBarrage(@RequestParam("msg")String msg){
        Map<String, Object> map = new HashMap<>(1);
        map.put("msg","新增失败");
        map.put("code","1");

        try {
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            String ipAddr = getIpAddr(request);

         //   msg = FileUtils.getContentByRandomLine();
            if (!StringUtils.isEmpty(msg)){
                DemoBarrage record = new DemoBarrage();
                record.setCreateTime(LocalDateTime.now());
                record.setIp(ipAddr);
                record.setMsg(msg);
                iDemoBarrageService.save(record);

                map.put("msg","新增成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;

    }



    /**获取随机汉字串*/
    public static String getRandomChars() {

        StringBuffer sb = new StringBuffer();
        Random random = new Random();
        int maxCount = random.nextInt(20)+1;
        int count = 1;
        while (count < maxCount){
           char word =  (char) (0x4e00 + (int) (Math.random() * (0x9fa5 - 0x4e00 + 1)));
            sb.append(word);
           count++;
        }
        return sb.toString();
    }


    /**获取访问ip地址*/
    public static String getIpAddr(HttpServletRequest request) throws Exception{
        String ip = request.getHeader("X-Real-IP");
        if (!StringUtils.isEmpty(ip) && !"unknown".equalsIgnoreCase(ip)) {
            return ip;
        }
        ip = request.getHeader("X-Forwarded-For");
        if (!StringUtils.isEmpty(ip) && !"unknown".equalsIgnoreCase(ip)) {
// 多次反向代理后会有多个IP值，第一个为真实IP。
            int index = ip.indexOf(',');
            if (index != -1) {
                return ip.substring(0, index);
            } else {
                return ip;
            }
        } else {
            return request.getRemoteAddr();
        }
    }


}

