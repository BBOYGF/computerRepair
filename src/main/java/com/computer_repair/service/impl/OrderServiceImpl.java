package com.computer_repair.service.impl;

import com.computer_repair.pojo.Order;
import com.computer_repair.mapper.OrderMapper;
import com.computer_repair.service.IOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author guofan
 * @since 2021-10-31
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {
}
