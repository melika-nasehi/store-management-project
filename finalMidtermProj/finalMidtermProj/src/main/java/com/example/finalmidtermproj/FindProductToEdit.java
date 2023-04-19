package com.example.finalmidtermproj;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class FindProductToEdit {
    private Stage stage  ;
    private Scene scene ;
    private Parent root ;
    public AnchorPane anchor ;

    public TextField proIdField ;
    static String productName ;
    static String productID ;
    static int productPrice ;
    static pLabel productLabel ;
    static int productCount ;


    public void findProduct(ActionEvent event) throws IOException {

        productID = proIdField.getText();
        boolean isFound = false ;

        ArrayList<Product> productList = Main.productFileTOArraylist();
        for (Product i: productList) {
            if (i.getpStoreID().equals(AdminLogin.loginStoreID) && i.getpID().equals(productID)) {

                productName = i.getpName();
                productPrice = i.getpPrice();
                productLabel = i.getpLabel();
                productCount = i.getpCount();

                isFound = true ;
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("editProductInfo.fxml"));
                Pane registerPane = fxmlLoader.load();
                try {
                    anchor.getChildren().clear();
                    anchor.getChildren().add(registerPane);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        if(! isFound) {
            Main.showAlert("ERROR!" , "No product was found in the store with this ID" ,
                    null , Alert.AlertType.ERROR);
        }

    }
}
