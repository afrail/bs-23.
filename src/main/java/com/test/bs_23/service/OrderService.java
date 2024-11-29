package com.test.bs_23.service;


import com.test.bs_23.entity.Order;
import org.springframework.data.domain.Page;

import java.util.List;

public interface OrderService {

    OrderItemDto save(OrderItemDto obj);
    List<OrderItemDto> getAll();
    List<OrderItemDto> getId(int id);

}
