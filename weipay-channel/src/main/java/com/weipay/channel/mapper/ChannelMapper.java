package com.weipay.channel.mapper;

import com.weipay.channel.entity.Channel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 渠道Mapper接口
 * 
 * @author WeiPay
 * @since 1.0.0
 */
@Mapper
public interface ChannelMapper {

    /**
     * 根据ID查询渠道
     * 
     * @param channelId 渠道ID
     * @return 渠道实体
     */
    Channel selectById(Long channelId);

    /**
     * 根据渠道编码查询渠道
     * 
     * @param channelCode 渠道编码
     * @return 渠道实体
     */
    Channel selectByCode(String channelCode);

    /**
     * 查询所有渠道
     * 
     * @return 渠道列表
     */
    List<Channel> selectAll();

    /**
     * 根据状态查询渠道
     * 
     * @param status 状态
     * @return 渠道列表
     */
    List<Channel> selectByStatus(Integer status);

    /**
     * 插入渠道
     * 
     * @param channel 渠道实体
     * @return 影响行数
     */
    int insert(Channel channel);

    /**
     * 更新渠道
     * 
     * @param channel 渠道实体
     * @return 影响行数
     */
    int update(Channel channel);

    /**
     * 删除渠道
     * 
     * @param channelId 渠道ID
     * @return 影响行数
     */
    int delete(Long channelId);
}
