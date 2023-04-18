package com.example.finalmidtermproj;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class CreateProductController implements Initializable {


    public TextField productNameField ;
    public TextField productIdField ;
    public TextField productPriceField ;
    @FXML
    Label productStoreIdField  ;
    public TextField countField ;


    public int count ;

    public Button createProductButton ;
    public Button addButton ;
    public Button subButton ;
    private Stage stage  ;
    private Scene scene ;
    private Parent root ;

    public ComboBox labelBox ;

    public void AddNewProduct (ActionEvent event) throws IOException {
        try{
            File file = new File("products.txt");

            FileWriter fw = null;

            fw = new FileWriter("products.txt", true);


            String Name = productNameField.getText();
            String id = productIdField.getText();
            int price = Integer.valueOf(productPriceField.getText());
            productStoreIdField.setText(String.valueOf(AdminLogin.loginStoreID));
            String label = (String) labelBox.getValue();
            count = Integer.valueOf(countField.getText());


            ArrayList<Product> productList = Main.productFileTOArraylist();

            boolean isFound = false;
            for (Product i : productList) {
                if (i.getpID().equals(id)) {
                    isFound = true;
                    Main.showAlert("ERROR!", "there is already a product with this ID",
                            "product ID should be unique", Alert.AlertType.ERROR);
                }
            }

            boolean isFound2 = false ;
            for (Product i: productList) {
                if (i.getpName().equals(Name) && i.getpStoreID().equals(AdminLogin.loginStoreID)) {
                    isFound2 = true ;
                    Main.showAlert("ERROR !" , "there is already a product with this name in this store" ,
                            "you can charge it" , Alert.AlertType.ERROR );
                }
            }
            System.out.println(isFound2);

            if (!isFound && ! isFound2) {
                fw.write(Name + "\n" + id + "\n" + AdminLogin.loginStoreID + "\n" + price + "\n" + count + "\n" + label + "\n");
                fw.close();

                Main.showAlert("Done!", "product added successfully", null, Alert.AlertType.INFORMATION);

                root = FXMLLoader.load(getClass().getResource("adminMenu.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
        }catch (Exception e) {
            Main.showAlert("ERROR" , "price and count should be numbers" , null , Alert.AlertType.ERROR);
            e.toString();
        }
    }

    public void addCount() {
        count ++ ;
    }

    public void subCount () {
        count -- ;
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        labelBox.getItems().addAll("food" , "clothes" , "tools" , "health" , "digital" , "sports" , "furniture") ;
    }
}
