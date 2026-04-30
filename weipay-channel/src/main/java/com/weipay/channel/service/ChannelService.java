package com.weipay.channel.service;

import com.weipay.channel.dto.ChannelDTO;
import com.weipay.channel.entity.Channel;
import com.weipay.channel.vo.ChannelVO;

import java.util.List;

/**
 * 渠道服务接口
 * 
 * @author WeiPay
 * @since 1.0.0
 */
public interface ChannelService {

    /**
     * 根据ID查询渠道
     * 
     * @param channelId 渠道ID
     * @return 渠道VO
     */
    ChannelVO getById(Long channelId);

    /**
     * 根据渠道编码查询渠道
     * 
     * @param channelCode 渠道编码
     * @return 渠道VO
     */
    ChannelVO getByCode(String channelCode);

    /**
     * 查询所有渠道
     * 
     * @return 渠道VO列表
     */
    List<ChannelVO> listAll();

    /**
     * 根据状态查询渠道
     * 
     * @param status 状态
     * @return 渠道VO列表
     */
    List<ChannelVO> listByStatus(Integer status);

    /**
     * 创建渠道
     * 
     * @param channelDTO 渠道DTO
     * @return 渠道ID
     */
    Long create(ChannelDTO channelDTO);

    /**
     * 更新渠道
     * 
     * @param channelDTO 渠道DTO
     * @return 是否成功
     */
    Boolean update(ChannelDTO channelDTO);

    /**
     * 删除渠道
     * 
     * @param channelId 渠道ID
     * @return 是否成功
     */
    Boolean delete(Long channelId);
}
