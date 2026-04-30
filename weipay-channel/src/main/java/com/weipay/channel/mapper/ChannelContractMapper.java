package com.weipay.channel.mapper;

import com.weipay.channel.entity.ChannelContract;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 渠道签约Mapper接口
 * 
 * @author WeiPay
 * @since 1.0.0
 */
@Mapper
public interface ChannelContractMapper {

    /**
     * 根据ID查询签约
     * 
     * @param contractId 签约ID
     * @return 签约实体
     */
    ChannelContract selectById(Long contractId);

    /**
     * 根据渠道ID查询签约列表
     * 
     * @param channelId 渠道ID
     * @return 签约列表
     */
    List<ChannelContract> selectByChannelId(Long channelId);

    /**
     * 根据商户号查询签约
     * 
     * @param merchantId 商户号
     * @return 签约实体
     */
    ChannelContract selectByMerchantId(String merchantId);

    /**
     * 查询所有签约
     * 
     * @return 签约列表
     */
    List<ChannelContract> selectAll();

    /**
     * 插入签约
     * 
     * @param contract 签约实体
     * @return 影响行数
     */
    int insert(ChannelContract contract);

    /**
     * 更新签约
     * 
     * @param contract 签约实体
     * @return 影响行数
     */
    int update(ChannelContract contract);

    /**
     * 删除签约
     * 
     * @param contractId 签约ID
     * @return 影响行数
     */
    int delete(Long contractId);
}
