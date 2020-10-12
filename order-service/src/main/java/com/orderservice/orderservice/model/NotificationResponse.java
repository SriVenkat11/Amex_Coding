package com.orderservice.orderservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@AllArgsConstructor
@ToString
public class NotificationResponse {

    Double totalCost;

    String message;

}
