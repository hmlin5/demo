package com.hmlin5.demo.wx;

import com.hmlin5.demo.wx.vo.WxResponse;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.*;

/**
 * @ Author ：linhaomiao.
 * @ Desc   ：wx测试
 */
@RestController
public class WxController {

    private static String appId = "wx86b5903553d88d7d";
    private static String appSecret = "3833670b09fd6a2dd239a3857d2cfaba";

    @Autowired
    private RestTemplate restTemplate;

  

    @RequestMapping("/wx/login")
    public Map<String, String> miniProgramWxLogin(String code){
        String ticket= UUID.randomUUID().toString().replace("-", "");

        //https://api.weixin.qq.com/sns/jscode2session?appid=APPID&secret=SECRET&js_code=JSCODE&grant_type=authorization_code
        String url = "https://api.weixin.qq.com/sns/jscode2session?appid="+appId+"&secret="+appSecret+"&js_code="+code+"&grant_type=authorization_code";
        WxResponse wxResponse = restTemplate.getForObject(url, WxResponse.class);
        JSONObject jsonObject = JSONObject.fromObject(wxResponse);
        System.out.println("==========="+jsonObject.toString());


        Map<String, String> map = new HashMap<>(1);
        map.put("ticket",ticket);
        return map;
    }

    @RequestMapping("miniProgramTestPic")
    public List<String> miniProgramTestPic(){

        List<String> picList = new ArrayList<>();
        picList.add("https://images.unsplash.com/photo-1551214012-84f95e060dee?w=640");
        picList.add("https://images.unsplash.com/photo-1551446591-142875a901a1?w=640");
        picList.add("https://images.unsplash.com/photo-1551446591-142875a901a1?w=640");


        return picList;
    }

}
