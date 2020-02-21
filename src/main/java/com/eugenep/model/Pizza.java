package com.eugenep.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Pizza {
    PizzaName myName;
    Crust myCrust;
    ArrayList<Topper> myToppers;
    BigDecimal Price;
    boolean extraTopperAdded;

    public Pizza(){
        myName = null;
    }

    public Pizza(PizzaName pizzaName, Crust crust)
    {
        myName = pizzaName;
        myCrust = crust;
        myToppers = new ArrayList<Topper>();
        extraTopperAdded = false;
        Price = BigDecimal.valueOf(0.00);
    }

    public boolean isEmpty()
    {
        return myName == null;
    }

    public void init(Pizza pizza)
    {
        myName = pizza.myName;
        myCrust = pizza.myCrust;
        initToppers(pizza.myToppers);
        extraTopperAdded = false;
        Price = pizza.Price;
    }

    private void initToppers(ArrayList<Topper> toppers)
    {
        ArrayList<Topper> initToppers = new ArrayList<Topper>(toppers);
        myToppers = initToppers;
    }


    private void calculatePrice(){
        for (Topper myTopper : myToppers) {
            Price = Price.add(myTopper.giveTopperPrice());
        }
        Price = Price.add(myCrust.giveCrustPrice());
    }

    public PizzaName getPizzaName(){
        return myName;
    }

    public void setCrust(CrustType crustType){
        myCrust = new Crust(crustType);
    }

    public void addTopper(TopperName topperName) {
        myToppers.add(new Topper(topperName));
        extraTopperAdded = true;
    }

    public void removeTopper(TopperName topperName) {
        Topper topperToRemove = new Topper(topperName);
        int i = myToppers.size()-1;
        boolean removed = false;
        while(!removed && i > 0){
            if(myToppers.get(i).equals(topperToRemove))
            {
                myToppers.remove(i);
                removed = true;
            }
            i--;
        }
        extraTopperAdded = true;
    }

    public void setName(PizzaName name){
        myName = name;
    }

    public BigDecimal giveMyPrice(){
        if(Price.equals(BigDecimal.valueOf(0.00)))
            calculatePrice();
        if(extraTopperAdded){
            Price = BigDecimal.valueOf(0.00);
            calculatePrice();
            extraTopperAdded = false;
        }
        return Price;
    }

    public String giveMyName(){
        String nameReturner = "";
        switch (myName)
        {
            case MARGHERITTA: nameReturner = "Margherita";
                break;
            case MARINARA: nameReturner = "Marinara";
                break;
            case NAPOLETANA: nameReturner = "Napoletana";
                break;
            case HAWAJSKA: nameReturner = "Hawajska";
                break;
            case FUNGHI: nameReturner = "Funghi";
                break;
            case QUATRO_STAGIONI: nameReturner = "Quatro Stagioni";
                break;
            case CAPRICIOSA: nameReturner = "Cappriciosa";
                break;
            case DINAMITE: nameReturner = "Dinamite";
                break;
            default: System.out.println("There is no such pizza in menu");
                break;
        }
        return nameReturner;
    }

    public String giveMyToppers()
    {
        StringBuilder topperString = new StringBuilder();
        for(int i = 0; i < myToppers.size(); i++){
            topperString.append(myToppers.get(i).giveTopperName());
            if(i != myToppers.size()-1)
                topperString.append(", ");
        }
        return topperString.toString();
    }


    public Crust getCrust(){
        return  myCrust;
    }

    public void setThinCrust()
    {
        setCrust(CrustType.Thin);
        extraTopperAdded = true;
    }
    public void setThickCrust()
    {
        setCrust(CrustType.Thick);
        extraTopperAdded = true;
    }



}
