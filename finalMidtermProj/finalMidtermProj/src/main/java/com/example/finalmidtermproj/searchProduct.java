package com.example.finalmidtermproj;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.ArrayList;

public class searchProduct {
    private Stage stage  ;
    private Scene scene ;
    private Parent root ;

    public RadioButton nameOption ;
    public RadioButton IdOption ;
    public TextField textField ;
    public Label toStringLabel ;

    public void searchPro() {
        ArrayList<Product> productList = Main.productFileTOArraylist();
        boolean isFound = false ;

        if (nameOption.isSelected()) {
            for (Product i: productList) {
                if (i.getpName().equals(textField.getText()) && i.getpStoreID().equals(AdminLogin.loginStoreID)) {
                    isFound = true ;
                    toStringLabel.setText(i.toString());
                }
            }
            if (! isFound)
                Main.showAlert("NOT FOUND !" , "no product was found with this name in this store" ,
                        null , Alert.AlertType.ERROR);
        }
        if (IdOption.isSelected()) {
            for (Product i : productList) {
                if (i.getpID().equals(textField.getText())) {
                    isFound = true ;
                    toStringLabel.setText(i.toString());
                }
            }
            if (! isFound)
                Main.showAlert("NOT FOUND !" , "no product was found with this ID in this store" ,
                        null , Alert.AlertType.ERROR);
        }


    }
}

