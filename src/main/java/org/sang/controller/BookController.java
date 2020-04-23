package org.sang.controller;

import org.sang.model.Book;
import org.sang.service.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Ma on 20191024
 */
@RestController
public class BookController {
     @Autowired
     Test test;

    @GetMapping("/test1")
    public void test1() {
        Integer i=test.test2();
        System.out.println("数据源2删除"+i);
        Integer j=test.test1();
        System.out.println("数据源1删除"+j);


    }
}
