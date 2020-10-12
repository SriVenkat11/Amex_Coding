package com.orderservice.orderservice.configuration;

import com.orderservice.orderservice.model.AppleItem;
import com.orderservice.orderservice.model.Item;
import com.orderservice.orderservice.model.OrangeItem;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
@Setter
public class ItemConfig {

    @Value("${offer.valid}")
    public boolean isOfferValid;

    @Bean
    public AppleItem appleItem(){
        return new AppleItem("Apple", 0.60);
    }

    @Bean
    public OrangeItem orangeItem(){
        return new OrangeItem("Orange", 0.25);
    }
}


