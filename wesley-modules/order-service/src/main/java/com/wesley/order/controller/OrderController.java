package com.wesley.order.controller;

import com.wesley.order.domain.OrderDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *
 * </p>
 *
 * @author Created by Yani on 2019/12/24
 */
@RestController
@Slf4j
public class OrderController {

    /**
     * 注解@AuthenticationPrincipal UserDTO 是通过UserDetailsService查询
     * 还可用 expression = "#this.id" 来去特点的参数
     */
    @PostMapping("/orders")
    public OrderDTO create(@RequestBody OrderDTO orderDto, String username) {
        // 获取认证中的信息
        log.info(" ----- 认证信息: username: {} -----", username);
        orderDto.setOrderId(123455L);
        return orderDto;
    }

    @GetMapping("/orders/{id}")
    public OrderDTO findOne(@PathVariable Long id) {
        OrderDTO res = new OrderDTO();
        res.setOrderId(id);
        res.setPrice("21.2");
        return res;
    }

}

