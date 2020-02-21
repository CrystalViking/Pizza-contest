package com.eugenep.model;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Delivery {
    DeliveryPlace myPlace;
    BigDecimal deliveryPrice;

    public Delivery(){

    }

    public Delivery(DeliveryPlace deliveryPlace){
        setMyDeliveryPlace(deliveryPlace);
    }
    public DeliveryPlace getDeliveryPlace(){
        return myPlace;
    }

    public void setMyDeliveryPlace(DeliveryPlace myPlace) {
        this.myPlace = myPlace;
    }

    public ArrayList<Delivery> getDeliveryPlacesList()
    {
        ArrayList<Delivery> deliveryPlaces = new ArrayList<Delivery>();
        for(int i = 0; i < DeliveryPlace.values().length; i++)
        {
            Delivery tempDelivery = new Delivery(DeliveryPlace.values()[i]);
            deliveryPlaces.add(tempDelivery);
        }
        return deliveryPlaces;
    }


    public BigDecimal getDeliveryPrice()
    {
        deliveryPrice = BigDecimal.valueOf(0.00);
        switch (myPlace)
        {
            case GRUNWALD:
                deliveryPrice = deliveryPrice.add(BigDecimal.valueOf(4.00));
                break;
            case STARE_MIASTO:

            case WILDA:

            case JEZYCE:
                deliveryPrice = deliveryPrice.add(BigDecimal.valueOf(5.00));
                break;
            case NOWE_MIASTO:
                deliveryPrice = deliveryPrice.add(BigDecimal.valueOf(6.00));
                break;
            case ON_PLACE:
                break;
            default:
                System.out.println("There is no price set for this place");
                break;
        }
        return deliveryPrice;
    }

    public String giveDeliveryPlaceName(){
        String placeName = "";
        switch (myPlace)
        {
            case GRUNWALD:
                placeName = "Grunwald";
                break;
            case STARE_MIASTO:
                placeName = "Stare miasto";
                break;
            case WILDA:
                placeName = "Wilda";
                break;
            case JEZYCE:
                placeName = "Jezyce";
                break;
            case NOWE_MIASTO:
                placeName = "Nowe miasto";
                break;
            case ON_PLACE:
                placeName = "Odbiór na miejscu";
                break;
            default:
                System.out.println("There is no name set for this place");
                break;
        }
        return placeName;
    }
}
