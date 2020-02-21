package com.eugenep.model;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

public class PizzaDeck {
    private ArrayList<Pizza> pizzas;

    public PizzaDeck(){
        pizzas = new ArrayList<Pizza>();
    }

    private void Add(PizzaName pizzaName, CrustType crustType){
        Pizza pizza = new Pizza(pizzaName, new Crust(crustType));
        pizzas.add(pizza);
    }

    private Pizza Cook(Pizza pizza){
        PizzaRecipe myRecipe = new PizzaRecipe(pizza);
        myRecipe.SetPizzaFromMenu();
        return myRecipe.GetPizzaFromMenu();
    }

    public void MakeList(CrustType crust){
        for(int i = 0; i < PizzaName.values().length; i++)
        {
            Add(PizzaName.values()[i], crust);
            pizzas.set(i, Cook(pizzas.get(i)));
        }
    }

    public void MakeThinList(){
        Clear();
        MakeList(CrustType.Thin);
    }

    public void MakeThickList(){
        Clear();
        MakeList(CrustType.Thick);
    }

    public void ShowAllInfo()
    {
        for (Pizza pizza : pizzas) {
            System.out.println(pizza.giveMyName() + "    (" + pizza.giveMyToppers() + ")    " + pizza.giveMyPrice().toString());
        }
    }

    public ArrayList<Topper> giveTopperMenu()
    {
        ArrayList<Topper> myTopMenu = new ArrayList<Topper>();
        for(int i = 0; i < TopperName.values().length; i++)
        {
            myTopMenu.add(new Topper(TopperName.values()[i]));
        }
        return myTopMenu;
    }

    public ArrayList<Pizza> GetPizzaList(){
        return pizzas;
    }

    public Pizza getPizzaFromDeck(int index){
        return pizzas.get(index);
    }

    public String getPizzaname(int index){
        return pizzas.get(index).giveMyName();
    }

    void Clear(){
        pizzas.clear();
    }

}
