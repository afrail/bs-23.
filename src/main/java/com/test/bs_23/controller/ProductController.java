package com.test.bs_23.controller;


import com.test.bs_23.entity.Product;
import com.test.bs_23.response.CommonResponse;
import com.test.bs_23.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import static com.test.bs_23.response.ApiConstants.*;
import static com.test.bs_23.response.MessageConstants.*;

@AllArgsConstructor
@RestController
@RequestMapping(PRODUCT_END_POINT+"product")
public class ProductController {

    @Autowired
    CommonResponse commonUtils;

    @Autowired
    ProductService service;

    @PostMapping
    public CommonResponse save(@RequestParam("file") MultipartFile[] file, @RequestParam("obj") String obj){
        try {
            return commonUtils.generateSuccessResponse(service.save(file, obj), SAVE_MESSAGE, SAVE_MESSAGE_BN);
        } catch (Exception e) {
            return commonUtils.generateErrorResponse(e);
        }
    }

    @PutMapping
    public CommonResponse update(@Valid @RequestBody Product body, HttpServletRequest request){
        try {
            return commonUtils.generateSuccessResponse(service.update(body), UPDATE_MESSAGE, UPDATE_MESSAGE_BN);
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



}
