package com.test.bs_23.service;

import com.test.bs_23.entity.Order;
import com.test.bs_23.entity.OrderItem;
import lombok.Data;

import java.util.List;

@Data
public class OrderItemDto {

   private Order order;
   private List<OrderItem> orderItems;


}
