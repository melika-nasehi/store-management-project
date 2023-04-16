package com.example.finalmidtermproj;

import java.util.ArrayList;

public class Store {
    public String sName ;
    public String sID ;

    boolean Admin1 = false ;
    boolean Admin2 = false ;
    boolean Admin3 = false ;

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


    @Override
    public String toString() {
        return "Store{" +
                "sName='" + sName + '\'' +
                ", sID='" + sID + '\'' +
                ", products="  +
                '}';
    }
}


