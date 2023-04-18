package com.example.finalmidtermproj;

import java.util.ArrayList;

public class Store {
    public String sName ;
    public String sID ;

    boolean hasAdmin1  ;
    boolean hasAdmin2  ;
    boolean hasAdmin3  ;

    //ArrayList<Product> products = new ArrayList<>();


    public Store (String name, String id , boolean A1 , boolean A2 , boolean A3) {       //manager
        sName = name ;
        sID = id ;
        hasAdmin1 = A1 ;
        hasAdmin2 = A2 ;
        hasAdmin3 = A3 ;
    }
    public Store() {
    }


    // Getters & Setters
    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getsID() {
        return sID;
    }

    public void setsID(String sID) {
        this.sID = sID;
    }

    public boolean hasAdmin1() {
        return hasAdmin1;
    }

    public void setHasAdmin1(boolean hasAdmin1) {
        this.hasAdmin1 = hasAdmin1;
    }

    public boolean hasAdmin2() {
        return hasAdmin2;
    }

    public void setHasAdmin2(boolean hasAdmin2) {
        this.hasAdmin2 = hasAdmin2;
    }

    public boolean hasAdmin3() {
        return hasAdmin3;
    }

    public void setHasAdmin3(boolean hasAdmin3) {
        this.hasAdmin3 = hasAdmin3;
    }

    @Override
    public String toString() {
        return "Store{" +
                "sName='" + sName + '\'' +
                ", sID='" + sID + '\'' +
                ", products="  +
                '}';
    }
}


