package com.chige.controller;

import com.chige.trigger.IRaffleActivityService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author wangyc
 * @Description TODO
 * @Date 2024/11/26 21:03
 */
@Slf4j
@RestController()
@CrossOrigin("${app.config.cross-origin}")
@RequestMapping("/api/${app.config.api-version}/raffle/activity/")
@DubboService(version = "1.0")
public class RaffleActivityController implements IRaffleActivityService {
}
