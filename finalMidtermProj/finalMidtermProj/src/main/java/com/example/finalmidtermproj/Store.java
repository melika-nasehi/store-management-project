package com.example.finalmidtermproj;

import java.util.ArrayList;

public class Store {
    public String sName ;
    public String sID ;
    public Admin admin1 ;
    public Admin admin2 ;
    public Admin admin3 ;
    //ArrayList<Product> products = new ArrayList<>();


    public Store (String name, String id ) {       //manager
        sName = name ;
        sID = id ;
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

    public Admin getAdmin1() {
        return admin1;
    }

    public void setAdmin1(Admin admin1) {
        this.admin1 = admin1;
    }

    public Admin getAdmin2() {
        return admin2;
    }

    public void setAdmin2(Admin admin2) {
        this.admin2 = admin2;
    }

    public Admin getAdmin3() {
        return admin3;
    }

    public void setAdmin3(Admin admin3) {
        this.admin3 = admin3;
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


