package com.example.finalmidtermproj;

import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class productsCategory implements Initializable {
    public ComboBox labelBox ;
    public TextArea textArea ;
    String showText = "";

    public void category(){
        String label = (String) labelBox.getValue();
        showText = "" ;
        ArrayList<Product> productList = Main.productFileTOArraylist();
        boolean isFound = false ;
        for (Product i : productList) {
            if (i.getpLabel().equals(pLabel.valueOf(label))) {
                isFound = true ;
                showText += i.toString();
            }
        }
        textArea.setText(showText);

        if(! isFound)
            Main.showAlert("NOT FOUND" , "No product was" +
                    " found with this Label" , null , Alert.AlertType.INFORMATION);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        labelBox.getItems().addAll("food" , "clothes" , "tools" , "health" , "digital" , "sports" , "furniture") ;
    }
}
