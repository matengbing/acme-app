package com.acme.app.mapper.river;

import com.acme.app.model.river.AcmeRiver;

public interface AcmeRiverMapper {
    int deleteByPrimaryKey(Long riverId);

    int insert(AcmeRiver record);

    int insertSelective(AcmeRiver record);

    AcmeRiver selectByPrimaryKey(Long riverId);

    int updateByPrimaryKeySelective(AcmeRiver record);

    int updateByPrimaryKey(AcmeRiver record);
}