package com.eugenep.model;

import java.math.BigDecimal;

public class Crust {
    CrustType myCrystType;
    BigDecimal Price;

    public Crust(CrustType crustType){
        setMyCrystType(crustType);
    }

    public BigDecimal getPrice(){
        return Price;
    }

    public void setPrice(BigDecimal value){
        Price = value;
    }

    public CrustType getMyCrystType() {
        return myCrystType;
    }

    public void setMyCrystType(CrustType myCrystType) {
        this.myCrystType = myCrystType;
    }

    public String giveCrustName(){
        String crustName = "";
        switch (myCrystType)
        {
            case Thin: crustName = "ciasto cienkie";
            break;
            case Thick: crustName = "ciasto grube";
            break;
        }
        return crustName;
    }

    public BigDecimal giveCrustPrice()
    {
        switch (myCrystType)
        {
            case Thin: Price = BigDecimal.valueOf(10.00);
            break;
            case Thick: Price = BigDecimal.valueOf(12.00);
            break;
        }
        return Price;
    }

}
