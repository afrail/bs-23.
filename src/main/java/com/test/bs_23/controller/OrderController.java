package com.test.bs_23.controller;


import com.test.bs_23.entity.Order;
import com.test.bs_23.response.CommonResponse;
import com.test.bs_23.service.OrderItemDto;
import com.test.bs_23.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import static com.test.bs_23.response.ApiConstants.*;
import static com.test.bs_23.response.MessageConstants.*;

@AllArgsConstructor
@RestController
@RequestMapping(PRODUCT_END_POINT+"order")
public class OrderController {

    @Autowired
    CommonResponse commonUtils;

    @Autowired
    OrderService service;

    @PostMapping
    public CommonResponse save(@Valid @RequestBody OrderItemDto body, HttpServletRequest request){
        try {
            return commonUtils.generateSuccessResponse(service.save(body), SAVE_MESSAGE, SAVE_MESSAGE_BN);
        } catch (Exception e) {
            return commonUtils.generateErrorResponse(e);
        }
    }


    @GetMapping
    public CommonResponse getAll(){
        try {
            return commonUtils.generateSuccessResponse(service.getAll());
        } catch (Exception e) {
            return commonUtils.generateErrorResponse(e);
        }
    }

    @GetMapping( value = "order/{id}", produces = EXTERNAL_MEDIA_TYPE)
    public CommonResponse getOrderItem(@PathVariable("id") int id){
        try {
            return commonUtils.generateSuccessResponse(service.getId(id));
        }catch (Exception e){
            return commonUtils.generateErrorResponse(e);
        }
    }




}
