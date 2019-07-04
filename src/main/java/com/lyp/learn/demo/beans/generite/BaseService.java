package com.lyp.learn.demo.beans.generite;

import org.springframework.beans.factory.annotation.Autowired;

public class BaseService<T> {

    @Autowired
    public BaseRepository<T> repository;

    public void add(){
        System.out.println(repository);
        System.out.println("baseService add ...");
        repository.save();
    }
}
