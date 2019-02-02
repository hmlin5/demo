package com.hmlin5.demo.sample.service.impl;

import com.github.pagehelper.PageHelper;
import com.hmlin5.demo.sample.dao.SfaProductIntegralConfigMapper;
import com.hmlin5.demo.sample.model.SfaProductIntegralConfig;
import com.hmlin5.demo.sample.service.api.SfaProductIntegralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ Author ：linhaomiao
 * @ Date   ：2018-11-04 15:42
 * @ Desc   ：
 */
@Service("sfaProductIntegralService")
public class SfaProductIntegralServiceImpl implements SfaProductIntegralService {

    @Autowired
    private SfaProductIntegralConfigMapper sfaProductIntegralConfigMapper;

    @Override
    public List<SfaProductIntegralConfig> findList(SfaProductIntegralConfig param) {
        return sfaProductIntegralConfigMapper.findList(param);
    }
}
