package com.example.finalmidtermproj;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Buy implements Initializable {

    private Stage stage  ;
    private Scene scene ;
    private Parent root ;

    public TextField storeIdField ;
    public TextArea allStores ;
    public AnchorPane anchor ;
    String allStore = "";
    static String storeID ;

    public void showAllStores() throws IOException {
        ArrayList<Store> storeList = Main.storeFileTOArraylist();
        boolean isFound = false ;
        for (Store i: storeList) {
            if (i.getsID().equals(storeIdField.getText())) {
                storeID = storeIdField.getText();
                isFound = true ;

                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Buy2.fxml"));
                Pane registerPane = fxmlLoader.load();
                try {
                    anchor.getChildren().clear();
                    anchor.getChildren().add(registerPane);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }
        if (!isFound) {
            Main.showAlert("ERROR!" , "Invalid ID" , null , Alert.AlertType.ERROR);
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ArrayList<Store> storeList = Main.storeFileTOArraylist();
        for (Store i: storeList) {
            allStore += i.toString3() ;
        }
        allStores.setText(allStore);
    }
}
