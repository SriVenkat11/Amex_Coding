package com.orderservice.orderservice.controller;

import com.orderservice.orderservice.service.IItemCostCalculator;
import com.orderservice.orderservice.serviceImpl.ItemCostCalculator;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class ItemCostController {

    @Autowired
    IItemCostCalculator itemCostCalculator;


    @PostMapping("/v1/api/item/cost")
    public double calculateItemCost(@NotNull @RequestBody String[] itemsList){
        return itemCostCalculator.calculateItemCost(itemsList);
    }

}
