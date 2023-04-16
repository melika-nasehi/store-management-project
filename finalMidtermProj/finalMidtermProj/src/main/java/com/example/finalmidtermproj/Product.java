package com.example.finalmidtermproj;

import javafx.scene.control.Label;

public class Product {

    public String pStoreID ;
    public String pName ;
    public double pPrice ;
    public String pID ;
    public Label pLabel ;
    public int pCount ;

    public Product(String storeid ,String name , double price , String id , Label label  , int count ) {
        pStoreID = storeid ;
        pName = name ;
        pPrice = price ;
        pID = id ;
        pLabel = label ;
        pCount = count ;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public double getpPrice() {
        return pPrice;
    }

    public void setpPrice(double pPrice) {
        this.pPrice = pPrice;
    }

    public String getpID() {
        return pID;
    }

    public void setpID(String pID) {
        this.pID = pID;
    }

    public Label getpLabel() {
        return pLabel;
    }

    public void setpLabel(Label label) {
        this.pLabel = label;
    }

    public int getpCount() {
        return pCount;
    }

    public void setpCount(int count) {
        this.pCount = count;
    }
}

