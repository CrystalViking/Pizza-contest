package com.eugenep.model;

import java.math.BigDecimal;

public class Discount {
    DiscountType myDiscountType;
    BigDecimal myDiscount;

    public Discount(DiscountType discountType, BigDecimal orderPrice){
        setMyDiscountType(discountType);
        myDiscount = orderPrice;
    }

    public Discount(DiscountType discountType){
        setMyDiscountType(discountType);
    }

    public DiscountType getMyDiscountType(){
        return myDiscountType;
    }

    public void setMyDiscountType(DiscountType discountType){
        myDiscountType = discountType;
    }

    public BigDecimal getDiscount(){
        switch (myDiscountType)
        {
            case STUDENT:
                myDiscount = myDiscount.multiply(BigDecimal.valueOf(0.80));
                break;
            case NO_DISCOUNT:
                myDiscount.add(BigDecimal.valueOf(0.00));
                break;
            default:
                System.out.println("There is no percentage for this type of discount");
                break;
        }
        return myDiscount;
    }

    public String giveMyDiscountName(){
        String discountName;
        switch (myDiscountType){
            case STUDENT:
                discountName = "zniżka studencka 20%";
                break;
            case NO_DISCOUNT:
                discountName = "brak zniżki";
                break;
            default:
                discountName = "there is no such discount";
                break;
        }
        return discountName;
    }
}
