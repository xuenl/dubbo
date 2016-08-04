package com.xuel.manager.mapper;

import com.xuel.manager.po.Neteasenews;
import com.xuel.manager.po.NeteasenewsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NeteasenewsMapper {
    int countByExample(NeteasenewsExample example);

    int deleteByExample(NeteasenewsExample example);

    int insert(Neteasenews record);

    int insertSelective(Neteasenews record);

    List<Neteasenews> selectByExample(NeteasenewsExample example);

    int updateByExampleSelective(@Param("record") Neteasenews record, @Param("example") NeteasenewsExample example);

    int updateByExample(@Param("record") Neteasenews record, @Param("example") NeteasenewsExample example);
}