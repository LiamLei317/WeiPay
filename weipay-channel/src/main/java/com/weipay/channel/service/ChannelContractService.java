package com.weipay.channel.service;

import com.weipay.channel.dto.ChannelContractDTO;
import com.weipay.channel.entity.ChannelContract;
import com.weipay.channel.vo.ChannelContractVO;

import java.util.List;

/**
 * 渠道签约服务接口
 * 
 * @author WeiPay
 * @since 1.0.0
 */
public interface ChannelContractService {

    /**
     * 根据ID查询签约
     * 
     * @param contractId 签约ID
     * @return 签约VO
     */
    ChannelContractVO getById(Long contractId);

    /**
     * 根据渠道ID查询签约列表
     * 
     * @param channelId 渠道ID
     * @return 签约VO列表
     */
    List<ChannelContractVO> listByChannelId(Long channelId);

    /**
     * 根据商户号查询签约
     * 
     * @param merchantId 商户号
     * @return 签约VO
     */
    ChannelContractVO getByMerchantId(String merchantId);

    /**
     * 查询所有签约
     * 
     * @return 签约VO列表
     */
    List<ChannelContractVO> listAll();

    /**
     * 创建签约
     * 
     * @param contractDTO 签约DTO
     * @return 签约ID
     */
    Long create(ChannelContractDTO contractDTO);

    /**
     * 更新签约
     * 
     * @param contractDTO 签约DTO
     * @return 是否成功
     */
    Boolean update(ChannelContractDTO contractDTO);

    /**
     * 删除签约
     * 
     * @param contractId 签约ID
     * @return 是否成功
     */
    Boolean delete(Long contractId);
}
