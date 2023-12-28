package com.basket.demo;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface BasketService {

    void add(List<Integer> ids);

    public Object get() throws JsonProcessingException;
}
