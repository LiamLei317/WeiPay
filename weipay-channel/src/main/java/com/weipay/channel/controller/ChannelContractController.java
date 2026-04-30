package com.weipay.channel.controller;

import com.weipay.channel.dto.ChannelContractDTO;
import com.weipay.channel.service.ChannelContractService;
import com.weipay.channel.vo.ChannelContractVO;
import com.weipay.common.vo.Result;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 渠道签约控制器
 * 
 * @author WeiPay
 * @since 1.0.0
 */
@Slf4j
@RestController
@RequestMapping("/channel-contract")
@RequiredArgsConstructor
public class ChannelContractController {

    private final ChannelContractService channelContractService;

    /**
     * 根据ID查询签约
     * 
     * @param contractId 签约ID
     * @return 签约信息
     */
    @GetMapping("/{contractId}")
    public Result<ChannelContractVO> getById(@PathVariable Long contractId) {
        log.info("查询签约，contractId: {}", contractId);
        ChannelContractVO contractVO = channelContractService.getById(contractId);
        return Result.success(contractVO);
    }

    /**
     * 根据渠道ID查询签约列表
     * 
     * @param channelId 渠道ID
     * @return 签约列表
     */
    @GetMapping("/list/channel/{channelId}")
    public Result<List<ChannelContractVO>> listByChannelId(@PathVariable Long channelId) {
        log.info("根据渠道ID查询签约列表，channelId: {}", channelId);
        List<ChannelContractVO> contractVOList = channelContractService.listByChannelId(channelId);
        return Result.success(contractVOList);
    }

    /**
     * 根据商户号查询签约
     * 
     * @param merchantId 商户号
     * @return 签约信息
     */
    @GetMapping("/merchant/{merchantId}")
    public Result<ChannelContractVO> getByMerchantId(@PathVariable String merchantId) {
        log.info("根据商户号查询签约，merchantId: {}", merchantId);
        ChannelContractVO contractVO = channelContractService.getByMerchantId(merchantId);
        return Result.success(contractVO);
    }

    /**
     * 查询所有签约
     * 
     * @return 签约列表
     */
    @GetMapping("/list")
    public Result<List<ChannelContractVO>> listAll() {
        log.info("查询所有签约");
        List<ChannelContractVO> contractVOList = channelContractService.listAll();
        return Result.success(contractVOList);
    }

    /**
     * 创建签约
     * 
     * @param contractDTO 签约DTO
     * @return 签约ID
     */
    @PostMapping
    public Result<Long> create(@RequestBody ChannelContractDTO contractDTO) {
        log.info("创建签约，contractDTO: {}", contractDTO);
        Long contractId = channelContractService.create(contractDTO);
        return Result.success("创建成功", contractId);
    }

    /**
     * 更新签约
     * 
     * @param contractDTO 签约DTO
     * @return 是否成功
     */
    @PutMapping
    public Result<Boolean> update(@RequestBody ChannelContractDTO contractDTO) {
        log.info("更新签约，contractDTO: {}", contractDTO);
        Boolean success = channelContractService.update(contractDTO);
        return Result.success("更新成功", success);
    }

    /**
     * 删除签约
     * 
     * @param contractId 签约ID
     * @return 是否成功
     */
    @DeleteMapping("/{contractId}")
    public Result<Boolean> delete(@PathVariable Long contractId) {
        log.info("删除签约，contractId: {}", contractId);
        Boolean success = channelContractService.delete(contractId);
        return Result.success("删除成功", success);
    }
}
