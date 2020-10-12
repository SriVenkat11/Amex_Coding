package com.orderservice.orderservice;


import com.orderservice.orderservice.model.AppleItem;
import com.orderservice.orderservice.model.Item;
import com.orderservice.orderservice.model.OrangeItem;
import com.orderservice.orderservice.serviceImpl.ItemCostCalculator;
import org.junit.Assert;

import org.junit.Before;
import org.junit.Test;

public class ItemCostCalculatorTest {

    Item appleItem;
    Item orangeItem;

    ItemCostCalculator itemCostCalculator;

    @Before
    public void init(){
        appleItem = new AppleItem("Apple", 0.60);
        orangeItem = new OrangeItem("Orange", 0.25);
        itemCostCalculator = new ItemCostCalculator(appleItem, orangeItem);

    }

    @Test
    public void checkCalculatePrice(){
        Double totalSum = itemCostCalculator.calculateItemCost(new String[]{"Apple", "apple", "Orange", "appLe"});
        Assert.assertEquals(totalSum, (Double) 2.05);
    }

    @Test
    public void checkCalculatePrice_withEmpty(){
        Double totalSum = itemCostCalculator.calculateItemCost(new String[]{"",""});
        Assert.assertEquals(totalSum, (Double) 0.0);
    }
}
