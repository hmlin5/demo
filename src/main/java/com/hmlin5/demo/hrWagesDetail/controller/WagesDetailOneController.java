package com.hmlin5.demo.hrWagesDetail.controller;

import com.hmlin5.demo.hrWagesDetail.model.BaseQueryBean;
import com.hmlin5.demo.hrWagesDetail.model.HrWagesDetail;
import com.hmlin5.demo.sample.dao.SfaProductIntegralConfigMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 员工自助平台一线工资查询管理接口
 * @author lsh
 * @Created by 2018/11/20.
 */
@RestController
@RequestMapping("/wagesDetailOne")
public class WagesDetailOneController {

    @Autowired
    private SfaProductIntegralConfigMapper sfaProductIntegralConfigMapper;


    /**
     * @description 导入工资明细
     * @param param
     * @author linhaomiao
     * @date 2018-11-29
     */
    @RequestMapping("importData")
    public Map<String, Object> importData(@RequestBody BaseQueryBean param){
        Map<String, Object> map = new HashMap<>();
        if(param.getImportList()== null || param.getImportList().size()<1){
            map.put("status",500);
            map.put("msg","请提交有效数据...");
            return map;
        }

        try {

            Date date = new Date();
            List<HrWagesDetail> importList = param.getImportList();
            if (importList == null || importList.size()<1){
                map.put("status",500);
                map.put("msg","请提交有效数据...");
                return map;
            }

            for (HrWagesDetail wd:importList ) {
                wd.setChangedCode(param.getChangedCode());
                wd.setChangedName(param.getChangedName());
                wd.setChangedTime(date);
            }

            //hrWagesDetailOneService.insertList(param);
            sfaProductIntegralConfigMapper.insertList(param);

            map.put("status",200);
            map.put("oldCount",1);
            map.put("newCount",1);
            map.put("addCount",1);//新增数据数量
        } catch (Exception e) {
            e.printStackTrace();
            map.put("status",500);
            map.put("msg","系统异常...");
        }

        return map;

    }




}
