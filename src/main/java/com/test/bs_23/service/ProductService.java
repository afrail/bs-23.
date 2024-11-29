package com.test.bs_23.service;


import com.test.bs_23.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductService {
    Product save(MultipartFile[] file, String obj);

    Product update(Product obj);

    List<Product> getAll();
}
