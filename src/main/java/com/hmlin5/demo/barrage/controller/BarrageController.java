package com.hmlin5.demo.barrage.controller;

import com.hmlin5.demo.barrage.dao.BarrageMapper;
import com.hmlin5.demo.barrage.model.Barrage;
import com.hmlin5.demo.barrage.model.BarrageExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/barrage")
public class BarrageController {


    @Autowired
    private BarrageMapper barrageMapper;

    @RequestMapping("addBarrage")
    public Map<String, Object> addBarrage( String msg){
        Map<String, Object> map = new HashMap<>(1);

        try {
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            String ipAddr = getIpAddr(request);

            if (!StringUtils.isEmpty(map)){
                Barrage barrage = new Barrage();
                barrage.setMsg(msg);
                barrage.setCreateTime(new Date());
                barrage.setIp(ipAddr);
                barrageMapper.insertSelective(barrage);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;

    }

    @RequestMapping("findBarrage")
    public Map<String, Object> findBarrage( ){
        Map<String, Object> map = new HashMap<>(1);

        try {

            BarrageExample bx = new BarrageExample();
            BarrageExample.Criteria c = bx.createCriteria();
            bx.setOrderByClause("create_time desc");


            List<Barrage> barrages = barrageMapper.selectByExample(bx);
            map.put("list",barrages);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;

    }




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
