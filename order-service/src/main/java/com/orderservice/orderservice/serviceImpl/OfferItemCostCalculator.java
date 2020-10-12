package com.orderservice.orderservice.serviceImpl;

import com.orderservice.orderservice.configuration.ItemConfig;
import com.orderservice.orderservice.model.AppleItem;
import com.orderservice.orderservice.model.Item;
import com.orderservice.orderservice.model.OrangeItem;
import com.orderservice.orderservice.service.IItemCostCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@ConditionalOnExpression("${offer.valid}")
public class OfferItemCostCalculator implements IItemCostCalculator {

    List<Item> itemsList = new ArrayList<>();
    AppleItem appleItem;
    OrangeItem orangeItem;

    @Autowired
    ItemConfig itemConfig;

    public OfferItemCostCalculator(ItemConfig itemConfig) {
        this.appleItem = new AppleItem("Apple", 0.60);;
        this.orangeItem = new OrangeItem("Orange", 0.25);
        this.itemConfig = itemConfig;
    }
    @Override
    public Double calculateItemCost(String[] items) {

        int num_of_Apples = 0;
        int num_of_Oranges = 0;

        double appleCost = appleItem.getItemPrice();
        double orangeCost = orangeItem.getItemPrice();

        Double totalCost = 0.0;
        for (String item : items){
            if(item.equalsIgnoreCase(appleItem.getItemName())){
               num_of_Apples++;
            }else if(item.equalsIgnoreCase(orangeItem.getItemName())){
                num_of_Oranges++;
            }else{
                System.out.println("We sell only oranges and apples");
                break;
            }
        }

        if(num_of_Apples > 1 ){
            if(num_of_Apples%2 == 0){
                totalCost += num_of_Apples/2 * appleCost;
            }

            else{
                totalCost += (num_of_Apples/2 + 1) * appleCost;
            }
        }

        else if(num_of_Apples == 1){
            totalCost += num_of_Apples * appleCost;
        }

        if(num_of_Oranges > 2){

          totalCost +=  num_of_Oranges * ((double) 2/3 * orangeCost);

        }else{
            totalCost += num_of_Oranges * orangeCost;
        }

        return totalCost;
    }
}
