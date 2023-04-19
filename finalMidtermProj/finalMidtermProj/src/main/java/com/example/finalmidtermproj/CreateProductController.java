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
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class CreateProductController implements Initializable {


    public TextField productNameField ;
    public TextField productIdField ;
    public TextField productPriceField ;

    public TextField productStoreIdField ;
    public TextField countField ;

    public Button createProductButton ;
    public Button addButton ;
    public Button subButton ;
    private Stage stage  ;
    private Scene scene ;
    private Parent root ;

    public ComboBox labelBox ;
    int price , count ;


    public void AddNewProduct (ActionEvent event) throws IOException {

            File file = new File("products.txt");

            FileWriter fw = new FileWriter(file , true) ;

            boolean exception = false ;

            String Name = productNameField.getText();
            String id = productIdField.getText();
        try{
            price = Integer.parseInt(productPriceField.getText());
            count = Integer.parseInt(countField.getText());
        }catch (NumberFormatException e) {
            exception = true ;
            Main.showAlert("hi" , null , null , Alert.AlertType.ERROR);
        }

            String label = (String) labelBox.getValue();


            ArrayList<Product> productList = Main.productFileTOArraylist();

            boolean isFound = false;
            for (Product i : productList) {
                if (i.getpID().equals(id)) {
                    isFound = true;
                    Main.showAlert("ERROR!", "there is already a product with this ID",
                            "product ID should be unique", Alert.AlertType.ERROR);
                }
            }

            boolean isFound2 = false;
            for (Product i : productList) {
                if (i.getpName().equals(Name) && i.getpStoreID().equals(AdminLogin.loginStoreID)) {
                    isFound2 = true;
                    Main.showAlert("ERROR !", "there is already a product with this name in this store",
                            "you can charge it", Alert.AlertType.ERROR);
                }
            }

            if ((!isFound) && (!isFound2) && (!exception)) {
                ArrayList<Store> storeList = Main.storeFileTOArraylist();
                for (Store i: storeList) {
                    if (i.getsID().equals(AdminLogin.loginStoreID)) {
                        int total = i.getTotalProductCount() ;
                        System.out.println(total);
                        total = total + count ;
                        i.setTotalProductCount(total);

                        PrintWriter pw = new PrintWriter("stores.txt") ;
                        pw.close();
                        FileWriter fw2 = new FileWriter("stores.txt" ) ;
                        for (Store j : storeList) {
                            fw2.write(j.getsName() +"\n" + j.getsID() + "\n" + j.hasAdmin1()+ "\n"+
                                    j.hasAdmin2()+ "\n"+ j.hasAdmin3()+"\n" + j.getTotalProductCount() + "\n"+j.getIncome()+"\n" ) ;
                        }fw2.close();
                    }
                }
                fw.write(Name + "\n" + id + "\n" + price + "\n" + AdminLogin.loginStoreID + "\n" + label + "\n" + count + "\n");
                fw.close();

                Main.showAlert("Done!", "product added successfully", null, Alert.AlertType.INFORMATION);

                root = FXMLLoader.load(getClass().getResource("adminMenu.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        labelBox.getItems().addAll("food" , "clothes" , "tools" , "health" , "digital" , "sports" , "furniture") ;
        productStoreIdField.setText(AdminLogin.loginStoreID);
    }
}
