package com.example.finalmidtermproj;

public class ShoppingCart {
    public String productName ;
    public pLabel productLabel ;
    public int productPrice ;
    public int purchaseCount;

    public String username ;
    public String productID ;
    public String storeID ;


    public ShoppingCart(String productName, pLabel productLabel, int productPrice, int purchaseCount,
                        String username, String productID , String storeID) {
        this.productName = productName;
        this.productLabel = productLabel;
        this.productPrice = productPrice;
        this.purchaseCount = purchaseCount;
        this.username = username;
        this.productID = productID;
        this.storeID = storeID ;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public pLabel getProductLabel() {
        return productLabel;
    }

    public void setProductLabel(pLabel productLabel) {
        this.productLabel = productLabel;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public int getPurchaseCount() {
        return purchaseCount;
    }

    public void setPurchaseCount(int productCount) {
        this.purchaseCount = productCount;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getStoreID() {
        return storeID;
    }

    public void setStoreID(String storeID) {
        this.storeID = storeID;
    }

    @Override
    public String toString() {
        return "product name = " + productName + "\n" +
                "productLabel = " + productLabel + "\n"+
                "productPrice = " + productPrice +"\n"+
                "purchaseCount = " + purchaseCount +"\n\n" ;
    }
}
