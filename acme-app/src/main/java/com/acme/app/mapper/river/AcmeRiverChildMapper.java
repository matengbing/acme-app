package com.acme.app.mapper.river;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.acme.app.model.river.AcmeRiverChild;

public interface AcmeRiverChildMapper {
    int insert(AcmeRiverChild record);

    int insertSelective(AcmeRiverChild record);
    /**
     * 流域下的河流
     * @param riverId
     * @return
     */
    List<AcmeRiverChild> findList(@Param("riverId")Long riverId);
    /**
     *查询合理所属的流域
     * @param riverName
     * @return
     */
    AcmeRiverChild findRiverId(String riverName);
}