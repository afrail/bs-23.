package com.test.bs_23.service;


import com.test.bs_23.entity.Order;
import com.test.bs_23.entity.OrderItem;
import com.test.bs_23.repository.OrderItemRepository;
import com.test.bs_23.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    OrderRepository repo;

    @Autowired
    OrderItemRepository orderItemRepository;


    @Override
    public OrderItemDto save(OrderItemDto obj) {

        Order entity = obj.getOrder();
        List<OrderItem> details = obj.getOrderItems();
        /*save master*/
        Order saveEntity = repo.save(entity);

        /*save details*/
        if(!ObjectUtils.isEmpty(saveEntity)){
            for(OrderItem detail: details){
                detail.setOrder(saveEntity);
                orderItemRepository.save(detail);
            }
        }
        return obj;
    }
    @Override
    public List<OrderItemDto>getAll() {
        return convertMasterToMasterDetails(repo.findAll());
    }

    @Override
    public List<OrderItemDto> getId(int id) {
        return convertMasterToMasterDetails(repo.findById(id));
    }

    private List<OrderItemDto> convertMasterToMasterDetails(List<Order> list) {
        List<OrderItemDto> returnList = new ArrayList<>();
        for (Order master: list) {
            OrderItemDto tmp = new OrderItemDto();
            /*set master*/
            tmp.setOrder(master);
            /*set details*/
            tmp.setOrderItems(orderItemRepository.findByOrder(master));
            returnList.add(tmp);
        }
        return  returnList;
    }


}
