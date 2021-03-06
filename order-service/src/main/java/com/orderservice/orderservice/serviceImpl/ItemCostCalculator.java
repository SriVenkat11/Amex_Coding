package com.orderservice.orderservice.serviceImpl;

import com.orderservice.orderservice.configuration.ItemConfig;
import com.orderservice.orderservice.model.AppleItem;
import com.orderservice.orderservice.model.Item;
import com.orderservice.orderservice.model.OrangeItem;
import com.orderservice.orderservice.service.IItemCostCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.stereotype.Service;


@Service
@ConditionalOnExpression("!'${offer.valid}'")
public class ItemCostCalculator implements IItemCostCalculator {
    AppleItem appleItem;
    OrangeItem orangeItem;

    @Autowired
    ItemConfig itemConfig;

    public ItemCostCalculator(ItemConfig itemConfig) {
        this.appleItem = new AppleItem("Apple", 0.60);;
        this.orangeItem = new OrangeItem("Orange", 0.25);
        this.itemConfig = itemConfig;
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
