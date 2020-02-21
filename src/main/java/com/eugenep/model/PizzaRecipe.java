package com.eugenep.model;

public class PizzaRecipe {
    Pizza pizzaFromMenu;

    public PizzaRecipe(Pizza pizza){
        pizzaFromMenu = pizza;
    }

    public void SetPizzaFromMenu(){
        switch (pizzaFromMenu.getPizzaName())
        {
            case MARGHERITTA:
                pizzaFromMenu.addTopper(TopperName.Tomato_sauce);
                pizzaFromMenu.addTopper(TopperName.Mozzarella);
                break;
            case MARINARA:
                pizzaFromMenu.addTopper(TopperName.Tomato_sauce);
                pizzaFromMenu.addTopper(TopperName.Mozzarella);
                pizzaFromMenu.addTopper(TopperName.Garlic);
                break;
            case NAPOLETANA:
                pizzaFromMenu.addTopper(TopperName.Tomato_sauce);
                pizzaFromMenu.addTopper(TopperName.Mozzarella);
                pizzaFromMenu.addTopper(TopperName.Black_olives);
                break;
            case HAWAJSKA:
                pizzaFromMenu.addTopper(TopperName.Tomato_sauce);
                pizzaFromMenu.addTopper(TopperName.Mozzarella);
                pizzaFromMenu.addTopper(TopperName.Pineaple);
                break;
            case FUNGHI:
                pizzaFromMenu.addTopper(TopperName.Tomato_sauce);
                pizzaFromMenu.addTopper(TopperName.Mozzarella);
                pizzaFromMenu.addTopper(TopperName.Mushrooms);
                break;
            case QUATRO_STAGIONI:
                pizzaFromMenu.addTopper(TopperName.Tomato_sauce);
                pizzaFromMenu.addTopper(TopperName.Mozzarella);
                pizzaFromMenu.addTopper(TopperName.Ham);
                pizzaFromMenu.addTopper(TopperName.Artichokes);
                pizzaFromMenu.addTopper(TopperName.Paprica);
                break;
            case CAPRICIOSA:
                pizzaFromMenu.addTopper(TopperName.Tomato_sauce);
                pizzaFromMenu.addTopper(TopperName.Mozzarella);
                pizzaFromMenu.addTopper(TopperName.Ham);
                pizzaFromMenu.addTopper(TopperName.Mushrooms);
                break;
            case DINAMITE:
                pizzaFromMenu.addTopper(TopperName.Tomato_sauce);
                pizzaFromMenu.addTopper(TopperName.Mozzarella);
                pizzaFromMenu.addTopper(TopperName.Spicy_salami);
                break;
        }
    }

    public Pizza GetPizzaFromMenu() {
        return pizzaFromMenu;
    }

}
