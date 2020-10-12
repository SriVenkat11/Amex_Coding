package com.orderservice.orderservice.stockstate;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Getter
@Setter
public class ItemQuantityState {

    @Value("#{${simple.map}}")
    HashMap<String, Integer> itemQuantityMap = new HashMap<>();



}
