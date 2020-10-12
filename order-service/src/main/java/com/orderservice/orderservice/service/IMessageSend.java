package com.orderservice.orderservice.service;

import com.orderservice.orderservice.model.NotificationResponse;

public interface IMessageSend {

    void listener(String[] items);
}
