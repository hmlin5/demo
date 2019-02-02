package com.hmlin5.demo.sample.service.api;

import com.github.pagehelper.PageHelper;
import com.hmlin5.demo.sample.model.SfaProductIntegralConfig;

import java.util.List;

/**
 * @ Author ：linhaomiao.
 * @ Date   ：2018-11-04 15:42
 * @ Desc   ：
 */
public interface SfaProductIntegralService {
    public List<SfaProductIntegralConfig> findList(SfaProductIntegralConfig param);
}
