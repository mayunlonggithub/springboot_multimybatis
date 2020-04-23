package org.sang.service;

import org.sang.mapper1.BookMapper;
import org.sang.mapper2.BookMapper2;
import org.sang.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Ma on 20191024
 */
@Service
public class Test {
    @Autowired
    BookMapper bookMapper;
    @Autowired
    BookMapper2 bookMapper2;

    @Transactional(transactionManager = "transactionManager1")
    public Integer test1(){
        Integer i=bookMapper.deleteAllBooks();
        System.out.println("books1:");
        return i;
    }

    @Transactional(transactionManager = "transactionManager2")
    public Integer test2(){
        Integer j=bookMapper2.deleteAllBooks();
        System.out.println("books2:");
        return j;
    }

}
