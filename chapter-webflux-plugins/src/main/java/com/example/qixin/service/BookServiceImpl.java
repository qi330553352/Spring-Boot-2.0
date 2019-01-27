package com.example.qixin.service;

import com.example.qixin.entity.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 创  建   时  间： 2019/1/27 13:11
 * 版           本: V1.0
 * 作           者: qixin
 * 版  权   所  有: 版权所有(C)2016-2026
 */
@Service
public class BookServiceImpl {

    // 模拟数据库，存储 Book 信息
    // 第五章《﻿数据存储》会替换成 H2 数据源存储
    private static Map<Long, Book> BOOK_DB = new HashMap<>();

    public List<Book> findAll() {
        return new ArrayList<>(BOOK_DB.values());
    }

    public Book insertByBook(Book book) {
        book.setId(BOOK_DB.size() + 1L);
        BOOK_DB.put(book.getId(), book);
        return book;
    }

    public Book update(Book book) {
        BOOK_DB.put(book.getId(), book);
        return book;
    }

    public Book delete(Long id) {
        return BOOK_DB.remove(id);
    }

    public Book findById(Long id) {
        return BOOK_DB.get(id);
    }

}
