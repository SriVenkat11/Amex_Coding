package com.orderservice.orderservice.configuration;

import com.orderservice.orderservice.model.AppleItem;
import com.orderservice.orderservice.model.Item;
import com.orderservice.orderservice.model.OrangeItem;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ItemConfig {

    @Bean
    public AppleItem appleItem(){
        return new AppleItem("Apple", 0.60);
    }

    @Bean
    public OrangeItem orangeItem(){
        return new OrangeItem("Orange", 0.25);
    }
}


