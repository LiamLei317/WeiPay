package com.weipay.channel.service.impl;

import com.weipay.channel.dto.ChannelDTO;
import com.weipay.channel.entity.Channel;
import com.weipay.channel.enums.ChannelTypeEnum;
import com.weipay.channel.mapper.ChannelMapper;
import com.weipay.channel.service.ChannelService;
import com.weipay.channel.vo.ChannelVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 渠道服务实现
 * 
 * @author WeiPay
 * @since 1.0.0
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class ChannelServiceImpl implements ChannelService {

    private final ChannelMapper channelMapper;

    @Override
    public ChannelVO getById(Long channelId) {
        log.info("根据ID查询渠道，channelId: {}", channelId);
        Channel channel = channelMapper.selectById(channelId);
        return convertToVO(channel);
    }

    @Override
    public ChannelVO getByCode(String channelCode) {
        log.info("根据渠道编码查询渠道，channelCode: {}", channelCode);
        Channel channel = channelMapper.selectByCode(channelCode);
        return convertToVO(channel);
    }

    @Override
    public List<ChannelVO> listAll() {
        log.info("查询所有渠道");
        List<Channel> channels = channelMapper.selectAll();
        return channels.stream()
                .map(this::convertToVO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ChannelVO> listByStatus(Integer status) {
        log.info("根据状态查询渠道，status: {}", status);
        List<Channel> channels = channelMapper.selectByStatus(status);
        return channels.stream()
                .map(this::convertToVO)
                .collect(Collectors.toList());
    }

    @Override
    public Long create(ChannelDTO channelDTO) {
        log.info("创建渠道，channelDTO: {}", channelDTO);
        Channel channel = new Channel();
        BeanUtils.copyProperties(channelDTO, channel);
        channelMapper.insert(channel);
        return channel.getChannelId();
    }

    @Override
    public Boolean update(ChannelDTO channelDTO) {
        log.info("更新渠道，channelDTO: {}", channelDTO);
        Channel channel = new Channel();
        BeanUtils.copyProperties(channelDTO, channel);
        int rows = channelMapper.update(channel);
        return rows > 0;
    }

    @Override
    public Boolean delete(Long channelId) {
        log.info("删除渠道，channelId: {}", channelId);
        int rows = channelMapper.delete(channelId);
        return rows > 0;
    }

    /**
     * 实体转VO
     * 
     * @param channel 渠道实体
     * @return 渠道VO
     */
    private ChannelVO convertToVO(Channel channel) {
        if (channel == null) {
            return null;
        }
        ChannelVO vo = new ChannelVO();
        BeanUtils.copyProperties(channel, vo);
        
        // 设置渠道类型名称
        ChannelTypeEnum typeEnum = ChannelTypeEnum.getByCode(channel.getChannelType());
        if (typeEnum != null) {
            vo.setChannelTypeName(typeEnum.getDesc());
        }
        
        return vo;
    }
}
