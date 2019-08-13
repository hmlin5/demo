package com.hmlin5.demo.barrage.dao;

import com.hmlin5.demo.barrage.model.Barrage;
import com.hmlin5.demo.barrage.model.BarrageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BarrageMapper {
    int countByExample(BarrageExample example);

    int deleteByExample(BarrageExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Barrage record);

    int insertSelective(Barrage record);

    List<Barrage> selectByExample(BarrageExample example);

    Barrage selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Barrage record, @Param("example") BarrageExample example);

    int updateByExample(@Param("record") Barrage record, @Param("example") BarrageExample example);

    int updateByPrimaryKeySelective(Barrage record);

    int updateByPrimaryKey(Barrage record);
}