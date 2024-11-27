package com.chige.trigger.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author wangyc
 * @Description TODO
 * @Date 2024/11/26 21:00
 */
@Data
public class ActivityDrawRequestDTO implements Serializable {

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 活动ID
     */
    private Long activityId;


}
