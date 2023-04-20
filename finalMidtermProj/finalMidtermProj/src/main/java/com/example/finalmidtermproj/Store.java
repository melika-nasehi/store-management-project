package com.example.finalmidtermproj;

import java.util.ArrayList;

public class Store {
    public String sName ;
    public String sID ;

    boolean hasAdmin1  ;
    boolean hasAdmin2  ;
    boolean hasAdmin3  ;
    int totalProductCount ;
    int income ;
    int addedProducts ;
    int soldProducts ;


    public Store (String name, String id , boolean A1 , boolean A2 , boolean A3 ,
                  int totalProCount , int income , int addedProducts , int soldProducts) {       //manager
        sName = name ;
        sID = id ;
        hasAdmin1 = A1 ;
        hasAdmin2 = A2 ;
        hasAdmin3 = A3 ;
        totalProductCount = totalProCount ;
        this.income = income ;
        this.addedProducts = addedProducts;
        this.soldProducts = soldProducts ;
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

    public int getTotalProductCount() {
        return totalProductCount;
    }

    public void setTotalProductCount(int totalProductCount) {
        this.totalProductCount = totalProductCount;
    }

    public int getAddedProducts() {
        return addedProducts;
    }

    public void setAddedProducts(int addedProducts) {
        this.addedProducts = addedProducts;
    }

    public int getSoldProducts() {
        return soldProducts;
    }

    public void setSoldProducts(int soldProducts) {
        this.soldProducts = soldProducts;
    }

    public int getIncome() {
        return income;
    }

    public void setIncome(int income) {
        this.income = income;
    }

    @Override
    public String toString() {
        return "Store{" +
                "sName='" + sName + '\'' +
                ", sID='" + sID + '\'' +
                ", products="  +
                '}';
    }

    public String toString2() {
        return "Name of store : " +sName +"\nTotal count of products : " + totalProductCount + "\nIncome : "
                + income + "\nPercentage (sold/added) : "+ (soldProducts*1.000/addedProducts)*100 +
                "\n ________________________________\n" ;
    }

    public String toString3 () {
        return "Store name : " + sName +"\n" + "Store ID : " + sID + "\n____________________________________\n" ;
    }
}


