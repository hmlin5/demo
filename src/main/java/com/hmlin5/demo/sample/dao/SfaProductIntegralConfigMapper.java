package com.hmlin5.demo.sample.dao;


import com.hmlin5.demo.hrWagesDetail.model.BaseQueryBean;
import com.hmlin5.demo.sample.model.SfaProductIntegralConfig;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SfaProductIntegralConfigMapper  {


    public List<SfaProductIntegralConfig> findList(SfaProductIntegralConfig param);

    /**
     * @description 批量保存工资考勤明细
     * @param data
     * @author linhaomiao
     * @date 2018-11-29
     */
    int insertList(BaseQueryBean data);

}