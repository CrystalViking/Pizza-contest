package com.eugenep.model;

import javafx.scene.control.CheckBox;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Topper {
    TopperName myTopperName;
    BigDecimal Price;

    public Topper(TopperName topperName) {
        setMyTopperName(topperName);
    }

    public BigDecimal getPrice(){
        return Price;
    }

    public void setPrice(BigDecimal value){
        Price = value;
    }

    public boolean equals(Topper topper)
    {
        if(myTopperName == topper.myTopperName)
        {
            return true;
        }
        return false;
    }

    public void setMyTopperName(TopperName topperName) {
        myTopperName = topperName;
    }

    public TopperName getMyTopperName() {
        return myTopperName;
    }



    public String giveTopperName()
    {
        String topperNameReturner = "";
        switch (myTopperName)
        {
            case Paprica: topperNameReturner = "papryka";
                break;
            case Garlic: topperNameReturner = "czosnek";
                break;
            case Mushrooms: topperNameReturner = "pieczarki";
                break;
            case Pineaple: topperNameReturner = "ananas";
                break;
            case Mozzarella: topperNameReturner = "mozzarella";
                break;
            case Salami: topperNameReturner = "salami";
                break;
            case Spicy_salami: topperNameReturner = "salami pikantne";
                break;
            case Artichokes: topperNameReturner = "karczochy";
                break;
            case Corn: topperNameReturner = "kukurydza";
                break;
            case Tomato_sauce: topperNameReturner = "sos pomidorowy";
                break;
            case Bacon: topperNameReturner = "bekon";
                break;
            case Ham: topperNameReturner = "szynka";
                break;
            case Garlic_sauce: topperNameReturner = "sos czosnkowy";
                break;
            case Olive_oil: topperNameReturner = "oliwa z oliwek";
                break;
            case Black_olives: topperNameReturner = "czarne oliwki";
                break;
            default: System.out.println("There is no such topper in menu");
                break;
        }
        return topperNameReturner;
    }

    public BigDecimal giveTopperPrice()
    {
        Price  = BigDecimal.valueOf(0.00);
        switch (myTopperName)
        {
            case Paprica:
                Price = BigDecimal.valueOf(0.80);
                break;
            case Garlic:
                Price = BigDecimal.valueOf(0.90);
                break;
            case Mushrooms:
                Price = BigDecimal.valueOf(1.10);
                break;
            case Pineaple:
                Price = BigDecimal.valueOf(1.40);
                break;
            case Mozzarella:
                Price = BigDecimal.valueOf(1.50);
                break;
            case Salami:
                //Price = BigDecimal.valueOf(1.60);
                //break;
            case Spicy_salami:
                Price = BigDecimal.valueOf(1.60);
                break;
            case Artichokes:
                Price = BigDecimal.valueOf(1.70);
                break;
            case Corn:
                Price = BigDecimal.valueOf(1.90);
                break;
            case Tomato_sauce:
                Price = BigDecimal.valueOf(2.00);
                break;
            case Bacon:
                Price = BigDecimal.valueOf(2.10);
                break;
            case Ham:
                Price = BigDecimal.valueOf(2.20);
                break;
            case Garlic_sauce:
                Price = BigDecimal.valueOf(2.50);
                break;
            case Olive_oil:
                Price = BigDecimal.valueOf(3.00);
                break;
            case Black_olives:
                Price = BigDecimal.valueOf(3.20);
                break;
            default:
                System.out.println("There is no such topper in topper price list");
                break;
        }
        return Price;
    }


}
