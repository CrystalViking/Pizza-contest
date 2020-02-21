package com.eugenep.model;

import java.math.BigDecimal;

public class OrderPrice {
     private BigDecimal price;
     private Delivery myDelivery;
     private Discount myDiscount;

     public void setPrice(BigDecimal price, DiscountType discountType, DeliveryPlace deliveryPlace){
         this.price = price;
         myDiscount = new Discount(discountType, this.price);
         myDelivery = new Delivery(deliveryPlace);
     }

     void calculatePrice(){
         price = myDiscount.getDiscount();
         price = price.add(myDelivery.getDeliveryPrice());
     }

     public BigDecimal getFullOrderPrice(){
         calculatePrice();
         return price;
     }
}
