package com.example.finalmidtermproj;

import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class searchProductsClient {

    public TextArea productTextarea ;
    public TextField productNameField ;
    String textToShow = "" ;

    public void searchProducts() {
        ArrayList<Product> productList = Main.productFileTOArraylist();
        boolean isFound = false ;
        for (Product i : productList) {
            if (i.getpName().equals(productNameField.getText())) {
                isFound = true ;
                textToShow += i.toString() ;
            }
        }
        productTextarea.setText(textToShow);

        if(! isFound)
            Main.showAlert("NOT FOUND" , "No product was" +
                    " found with this name" , null , Alert.AlertType.INFORMATION);

    }
}
