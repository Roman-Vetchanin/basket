package com.basket.demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@SessionScope
@Service
public class BasketServiceImpl implements BasketService {

    private final BasketService basketService;

    private final ObjectMapper objectMapper;

    public BasketServiceImpl(BasketService basketService, ObjectMapper objectMapper) {
        this.basketService = basketService;
        this.objectMapper = objectMapper;
    }


    List<Integer> products = new ArrayList<>(List.of());

    Map<Integer, String> productsId = new HashMap<>(Map.of(
            1, "Картофель",
            2, "Яйцо",
            3, "Куриное филе",
            4, "Фарш свиной",
            5, "Молоко",
            6, "Хлеб",
            7, "Мандарины",
            8, "Печенье",
            9, "Творожный сыр",
            10, "Чай"));

    @Override
    public void add(List<Integer> ids) {
        products.addAll(ids);
    }

    @Override
    public Object get() throws JsonProcessingException {
        Map<String, Integer> basketProduct = new HashMap<>();
        for (Integer prod : products) {
            if (basketProduct.containsKey(productsId.get(prod))) {
                basketProduct.put(productsId.get(prod), basketProduct.get(productsId.get(prod)) + 1);
            } else {
                basketProduct.put(productsId.get(prod), 1);
            }
        }
        return objectMapper.writeValueAsString(basketProduct);
    }
}
