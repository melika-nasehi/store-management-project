package com.example.finalmidtermproj;

import java.util.ArrayList;

public class Admin {
    public String aName ;
    public String aID ;    //Admins password
    public String aStoreID;
    public String aShift ;   // 1 , 2 , 3
    public static ArrayList<Admin> adminList = new ArrayList<>();

    public Admin (String name , String id , String storeID , String shift ) {
        aName = name ;
        aID = id ;
        aStoreID = storeID ;
        aShift = shift ;
    }

    public String getaName() {
        return aName;
    }

    public void setaName(String aName) {
        this.aName = aName;
    }

    public String getaID() {
        return aID;
    }

    public void setaID(String aID) {
        this.aID = aID;
    }

    public String getaStoreID() {
        return aStoreID;
    }

    public void setaStoreID(String aStoreID) {
        this.aStoreID = aStoreID;
    }

    public String getaShift() {
        return aShift;
    }

    public void setaShift(String aShift) {
        this.aShift = aShift;
    }

    public ArrayList<Admin> getAdminList() {
        return adminList;
    }

    public void setAdminList(ArrayList<Admin> adminList) {
        Admin.adminList = adminList;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "aName='" + aName + '\'' +
                ", aID='" + aID + '\'' +
                ", aStoreID='" + aStoreID + '\'' +
                ", aShift='" + aShift + '\'' +
                '}';
    }
}
