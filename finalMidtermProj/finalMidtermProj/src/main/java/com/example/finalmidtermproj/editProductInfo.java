package com.example.finalmidtermproj;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class editProductInfo implements Initializable {
    private Stage stage  ;
    private Scene scene ;
    private Parent root ;

    public TextField exName ;
    public TextField exID ;
    public TextField exPrice ;
    public TextField exLabel ;
    public TextField count ;
    public TextField newName ;
    public TextField newID ;
    public TextField newPrice ;
    public Label storeIdLabel ;
    public ComboBox labelBox ;

    public void editProduct(ActionEvent event) throws IOException {
        String name = newName.getText();
        String id = newID.getText();
        int price = Integer.parseInt(newPrice.getText());
        String label = (String) labelBox.getValue();

        ArrayList<Product> productList = Main.productFileTOArraylist();
        boolean isFound = false ;
        for (Product i: productList) {
            if (i.getpName().equals(name) && i.getpStoreID().equals(AdminLogin.loginStoreID) &&  ! exName.getText().equals(name)) {
                isFound = true ;
                Main.showAlert("ERROR!" , "there is already a product with this name in this store" ,
                        "change new name" , Alert.AlertType.ERROR);
            }
            if(i.getpID().equals(id) && ! exID.getText().equals(id)) {
                isFound = true ;
                Main.showAlert("ERROR!" , "this ID is already taken" ,
                        "change new ID" , Alert.AlertType.ERROR );
            }
        }
        if (! isFound) {
            for (Product i: productList) {
                if (i.getpID().equals(FindProductToEdit.productID)) {
                    i.setpName(name);
                    i.setpID(id);
                    i.setpPrice(price);
                    i.setpLabel(pLabel.valueOf(label));
                }
            }
            PrintWriter pw = new PrintWriter("products.txt");
            pw.close();
            FileWriter fw = new FileWriter("products.txt" ) ;
            for (Product i: productList) {
                fw.write(i.getpName() + "\n" + i.getpID() + "\n" + i.getpPrice() + "\n" + i.getpStoreID() +
                        "\n" + i.getpLabel() + "\n" + i.getpCount() + "\n");
            }fw.close();

            Main.showAlert("DONE!" , "Product info edeited successfully" ,null , Alert.AlertType.INFORMATION );

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
        storeIdLabel.setText(AdminLogin.loginStoreID);
        exName.setText(FindProductToEdit.productName);
        exID.setText(FindProductToEdit.productID);
        exPrice.setText(String.valueOf(FindProductToEdit.productPrice));
        exLabel.setText(String.valueOf(FindProductToEdit.productLabel));
        count.setText(String.valueOf(FindProductToEdit.productCount));

    }
}
