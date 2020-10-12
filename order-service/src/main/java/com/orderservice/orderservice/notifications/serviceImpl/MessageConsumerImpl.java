package com.orderservice.orderservice.notifications.serviceImpl;

import com.orderservice.orderservice.model.NotificationResponse;
import com.orderservice.orderservice.service.IItemCostCalculator;
import com.orderservice.orderservice.service.IMessageSend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.jms.annotation.JmsListener;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

@Component
public class MessageConsumerImpl implements IMessageSend {

    @Autowired
    IItemCostCalculator itemCostCalculator;

    NotificationResponse notificationResponse;

    @JmsListener(destination = "simple-jms-queue")
    public void listener(String[] items){

        double totalCost = itemCostCalculator.calculateItemCost(items);

        notificationResponse = new NotificationResponse( totalCost, "Total Cost ");

        Date deliveryDate = new Date();
        deliveryDate = addDays(deliveryDate, 2);

        System.out.println("Message Received: "+notificationResponse + "Estimated Delivery is ::"+ deliveryDate);

    }

    public static Date addDays(Date date, int days)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, days); //minus number would decrement the days
        return cal.getTime();
    }
}
