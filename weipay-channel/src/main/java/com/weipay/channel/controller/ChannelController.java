package com.weipay.channel.controller;

import com.weipay.channel.dto.ChannelDTO;
import com.weipay.channel.service.ChannelService;
import com.weipay.channel.vo.ChannelVO;
import com.weipay.common.vo.Result;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 渠道控制器
 * 
 * @author WeiPay
 * @since 1.0.0
 */
@Slf4j
@RestController
@RequestMapping("/channel")
@RequiredArgsConstructor
public class ChannelController {

    private final ChannelService channelService;

    /**
     * 根据ID查询渠道
     * 
     * @param channelId 渠道ID
     * @return 渠道信息
     */
    @GetMapping("/{channelId}")
    public Result<ChannelVO> getById(@PathVariable Long channelId) {
        log.info("查询渠道，channelId: {}", channelId);
        ChannelVO channelVO = channelService.getById(channelId);
        return Result.success(channelVO);
    }

    /**
     * 根据渠道编码查询渠道
     * 
     * @param channelCode 渠道编码
     * @return 渠道信息
     */
    @GetMapping("/code/{channelCode}")
    public Result<ChannelVO> getByCode(@PathVariable String channelCode) {
        log.info("根据渠道编码查询渠道，channelCode: {}", channelCode);
        ChannelVO channelVO = channelService.getByCode(channelCode);
        return Result.success(channelVO);
    }

    /**
     * 查询所有渠道
     * 
     * @return 渠道列表
     */
    @GetMapping("/list")
    public Result<List<ChannelVO>> listAll() {
        log.info("查询所有渠道");
        List<ChannelVO> channelVOList = channelService.listAll();
        return Result.success(channelVOList);
    }

    /**
     * 根据状态查询渠道
     * 
     * @param status 状态
     * @return 渠道列表
     */
    @GetMapping("/list/status/{status}")
    public Result<List<ChannelVO>> listByStatus(@PathVariable Integer status) {
        log.info("根据状态查询渠道，status: {}", status);
        List<ChannelVO> channelVOList = channelService.listByStatus(status);
        return Result.success(channelVOList);
    }

    /**
     * 创建渠道
     * 
     * @param channelDTO 渠道DTO
     * @return 渠道ID
     */
    @PostMapping
    public Result<Long> create(@RequestBody ChannelDTO channelDTO) {
        log.info("创建渠道，channelDTO: {}", channelDTO);
        Long channelId = channelService.create(channelDTO);
        return Result.success("创建成功", channelId);
    }

    /**
     * 更新渠道
     * 
     * @param channelDTO 渠道DTO
     * @return 是否成功
     */
    @PutMapping
    public Result<Boolean> update(@RequestBody ChannelDTO channelDTO) {
        log.info("更新渠道，channelDTO: {}", channelDTO);
        Boolean success = channelService.update(channelDTO);
        return Result.success("更新成功", success);
    }

    /**
     * 删除渠道
     * 
     * @param channelId 渠道ID
     * @return 是否成功
     */
    @DeleteMapping("/{channelId}")
    public Result<Boolean> delete(@PathVariable Long channelId) {
        log.info("删除渠道，channelId: {}", channelId);
        Boolean success = channelService.delete(channelId);
        return Result.success("删除成功", success);
    }
}
