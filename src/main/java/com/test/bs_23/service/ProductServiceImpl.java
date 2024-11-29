package com.test.bs_23.service;


import com.google.gson.Gson;

import com.test.bs_23.entity.Product;
import com.test.bs_23.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;


@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    ProductRepository repo;

    @Override
    public Product save(MultipartFile[] files, String obj) {

        Product product = new Gson().fromJson(obj, Product.class);
        return repo.save(product);
    }

    @Override
    public Product update(Product obj) {
        return repo.save(obj);
    }


    @Override
    public List<Product> getAll() {
        return repo.findAll();
    }

}
