package com.orderservice.orderservice;


import com.orderservice.orderservice.configuration.ItemConfig;
import com.orderservice.orderservice.model.AppleItem;
import com.orderservice.orderservice.model.Item;
import com.orderservice.orderservice.model.OrangeItem;
import com.orderservice.orderservice.serviceImpl.ItemCostCalculator;
import com.orderservice.orderservice.serviceImpl.OfferItemCostCalculator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class OfferItemCostCalculatorTest {

    Item appleItem;
    Item orangeItem;

    OfferItemCostCalculator itemCostCalculator;

    ItemConfig itemConfig = new ItemConfig();

    @Before
    public void init(){
        appleItem = new AppleItem("Apple", 0.60);
        orangeItem = new OrangeItem("Orange", 0.25);
        itemConfig.isOfferValid = true;
        itemCostCalculator = new OfferItemCostCalculator(itemConfig);

    }

    @Test
    public void checkCalculatePrice(){
        Double totalSum = itemCostCalculator.calculateItemCost(new String[]{"Apple", "apple", "Orange", "appLe"});
        Assert.assertEquals(totalSum, (Double) 1.45);
    }

    @Test
    public void checkCalculatePrice_withOranges(){
        Double totalSum = itemCostCalculator.calculateItemCost(new String[]{"Apple", "apple", "Orange", "appLe", "Orange", "Orange"});
        Assert.assertEquals(totalSum, (Double) 1.7);
    }
}
