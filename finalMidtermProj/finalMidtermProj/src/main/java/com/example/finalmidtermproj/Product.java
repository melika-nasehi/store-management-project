package com.example.finalmidtermproj;

import javafx.scene.control.Label;

public class Product {

    public String pName ;
    public String pID ;
    public int pPrice ;
    public String pStoreID ;
    public pLabel label ;
    public int pCount = 0 ;

    public Product(String name , String id , int price ,  String storeid , pLabel label , int count ) {
        pName = name ;
        pPrice = price ;
        pID = id ;
        pStoreID = storeid ;
        this.label = label ;
        pCount = count ;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public int getpPrice() {
        return pPrice;
    }

    public void setpPrice(int pPrice) {
        this.pPrice = pPrice;
    }

    public String getpID() {
        return pID;
    }

    public void setpID(String pID) {
        this.pID = pID;
    }

    public String getpStoreID() {
        return pStoreID;
    }

    public void setpStoreID(String pStoreID) {
        this.pStoreID = pStoreID;
    }

    public pLabel getpLabel() {
        return label ;
    }

    public void setpLabel(pLabel label) {
        this.label = label;
    }

    public int getpCount() {
        return pCount;
    }

    public void setpCount(int pCount) {
        this.pCount = pCount;
    }

    @Override
    public String toString() {
        return "Name = " + pName + "\n\n" +
                "ID = " + pID + "\n\n" +
                "Price = " + pPrice + "\n\n" +
                "StoreID = " + pStoreID + "\n\n" +
                " label = " + label + "\n\n" +
                " Count=" + pCount + "\n______________________________________\n";
    }

    public String toString2() {
        return "Name : " + pName + "\n" +
                "Label : " + label + "\n" +
                "Price : " + pPrice + "\n" +
                "available in stock : " + pCount + "\n_____________________________________\n" ;
    }
}

