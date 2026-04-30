package com.weipay.channel.service.impl;

import com.weipay.channel.dto.ChannelContractDTO;
import com.weipay.channel.entity.Channel;
import com.weipay.channel.entity.ChannelContract;
import com.weipay.channel.mapper.ChannelContractMapper;
import com.weipay.channel.mapper.ChannelMapper;
import com.weipay.channel.service.ChannelContractService;
import com.weipay.channel.vo.ChannelContractVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 渠道签约服务实现
 * 
 * @author WeiPay
 * @since 1.0.0
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class ChannelContractServiceImpl implements ChannelContractService {

    private final ChannelContractMapper channelContractMapper;
    private final ChannelMapper channelMapper;

    @Override
    public ChannelContractVO getById(Long contractId) {
        log.info("根据ID查询签约，contractId: {}", contractId);
        ChannelContract contract = channelContractMapper.selectById(contractId);
        return convertToVO(contract);
    }

    @Override
    public List<ChannelContractVO> listByChannelId(Long channelId) {
        log.info("根据渠道ID查询签约列表，channelId: {}", channelId);
        List<ChannelContract> contracts = channelContractMapper.selectByChannelId(channelId);
        return contracts.stream()
                .map(this::convertToVO)
                .collect(Collectors.toList());
    }

    @Override
    public ChannelContractVO getByMerchantId(String merchantId) {
        log.info("根据商户号查询签约，merchantId: {}", merchantId);
        ChannelContract contract = channelContractMapper.selectByMerchantId(merchantId);
        return convertToVO(contract);
    }

    @Override
    public List<ChannelContractVO> listAll() {
        log.info("查询所有签约");
        List<ChannelContract> contracts = channelContractMapper.selectAll();
        return contracts.stream()
                .map(this::convertToVO)
                .collect(Collectors.toList());
    }

    @Override
    public Long create(ChannelContractDTO contractDTO) {
        log.info("创建签约，contractDTO: {}", contractDTO);
        ChannelContract contract = new ChannelContract();
        BeanUtils.copyProperties(contractDTO, contract);
        channelContractMapper.insert(contract);
        return contract.getContractId();
    }

    @Override
    public Boolean update(ChannelContractDTO contractDTO) {
        log.info("更新签约，contractDTO: {}", contractDTO);
        ChannelContract contract = new ChannelContract();
        BeanUtils.copyProperties(contractDTO, contract);
        int rows = channelContractMapper.update(contract);
        return rows > 0;
    }

    @Override
    public Boolean delete(Long contractId) {
        log.info("删除签约，contractId: {}", contractId);
        int rows = channelContractMapper.delete(contractId);
        return rows > 0;
    }

    /**
     * 实体转VO
     * 
     * @param contract 签约实体
     * @return 签约VO
     */
    private ChannelContractVO convertToVO(ChannelContract contract) {
        if (contract == null) {
            return null;
        }
        ChannelContractVO vo = new ChannelContractVO();
        BeanUtils.copyProperties(contract, vo);
        
        // 设置渠道名称
        if (contract.getChannelId() != null) {
            Channel channel = channelMapper.selectById(contract.getChannelId());
            if (channel != null) {
                vo.setChannelName(channel.getChannelName());
            }
        }
        
        return vo;
    }
}
