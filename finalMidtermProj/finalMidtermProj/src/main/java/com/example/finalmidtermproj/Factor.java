package com.example.finalmidtermproj;

public class Factor {
    public String factorID ;
    public String factorInfo ;

    public Factor(String factorID, String factorInfo) {
        this.factorID = factorID;
        this.factorInfo = factorInfo;
    }

    public String getFactorID() {
        return factorID;
    }

    public void setFactorID(String factorID) {
        this.factorID = factorID;
    }

    public String getFactorInfo() {
        return factorInfo;
    }

    public void setFactorInfo(String factorInfo) {
        this.factorInfo = factorInfo;
    }
}
