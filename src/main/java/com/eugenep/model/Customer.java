package com.eugenep.model;

import java.math.BigDecimal;
import java.text.Bidi;
import java.util.ArrayList;
import java.util.List;

public class Customer {
    List<Pizza> pizzaCart;

    public Customer(){
        pizzaCart = new ArrayList<Pizza>();
    }

    public void AddToCart(Pizza pizzaToAdd){
        Pizza pizza = new Pizza();
        pizza.init(pizzaToAdd);
        pizzaCart.add(pizza);
    }

    public void RemoveFromCart(int index){
        pizzaCart.remove(index);
    }

    public void addExtraTopper(int index, TopperName topperName){
        Pizza buff = pizzaCart.get(index);
        buff.addTopper(topperName);
        pizzaCart.set(index, buff);
    }

    public List<Pizza> getMyCart(){
        return pizzaCart;
    }

    public Pizza getPizzaFromCart(int index){
        return pizzaCart.get(index);
    }

    public BigDecimal getPizzaPriceFromCart(int index){
        return pizzaCart.get(index).giveMyPrice();
    }

    public BigDecimal getOrderPrice()
    {
        BigDecimal FullPrice = BigDecimal.valueOf(0.0);
        BigDecimal buff;
        for(int i = 0; i < pizzaCart.size(); i++){
            FullPrice = FullPrice.add(getPizzaPriceFromCart(i));
        }
        return FullPrice;
    }

}
