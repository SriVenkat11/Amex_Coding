package com.orderservice.orderservice.serviceImpl;

import com.orderservice.orderservice.model.AppleItem;
import com.orderservice.orderservice.model.Item;
import com.orderservice.orderservice.model.OrangeItem;
import com.orderservice.orderservice.service.IItemCostCalculator;
import org.springframework.stereotype.Service;


@Service
public class ItemCostCalculator implements IItemCostCalculator {
    AppleItem appleItem;
    OrangeItem orangeItem;

    public ItemCostCalculator(Item appleItem, Item orangeItem) {
        this.appleItem = new AppleItem("Apple", 0.60);;
        this.orangeItem = new OrangeItem("Orange", 0.25);
    }

    public Double calculateItemCost(String[] items) {

        Double totalCost = 0.0;
        for (String item : items){
            if(item.equalsIgnoreCase(appleItem.getItemName())){
                totalCost+=appleItem.getItemPrice();
            }else if(item.equalsIgnoreCase(orangeItem.getItemName())){
                totalCost+=orangeItem.getItemPrice();
            }else{
                System.out.println("We sell only oranges and apples");
            }
        }


        return totalCost;
    }


}
