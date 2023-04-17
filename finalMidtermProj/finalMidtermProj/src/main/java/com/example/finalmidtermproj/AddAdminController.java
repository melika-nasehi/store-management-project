package com.example.finalmidtermproj;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AddAdminController implements Initializable {
    private Stage stage  ;
    private Scene scene ;
    private Parent root ;
    public BorderPane bpane ;

    public TextField storeIdTextField ;
    @FXML
    ToggleGroup adminGroup = new ToggleGroup();
    @FXML
    private RadioButton admin1RB , admin2RB , admin3RB ;

    @FXML
    private Button next ;

    public static int choice ;
    public static String storeID ;
    public static Store target;

    ArrayList<Store> storeList = new ArrayList<>();

    public void checkNewAdmin() {

        ArrayList<Store> storeList = Main.storeFileTOArraylist();


        storeID = storeIdTextField.getText() ;

        if (admin1RB.isSelected()) {
            boolean isFound = false ;
            for (Store i : storeList) {
                if (i.getsID().equals(storeID) && (i.hasAdmin1 == false)) {
                    choice = 1 ;
                    isFound = true ;
                    System.out.println(String.valueOf(i.hasAdmin1));
                    i.hasAdmin1 = true;
                    loadInfoPage();
                }
                else if (i.getsID().equals(storeID) && (i.hasAdmin1 == true)) {
                    showAlert("Admin #1 already exists");
                    isFound = true;
                }
            }
            if (! isFound )
                showAlert("No Store was found with this ID");
        }

        else if (admin2RB.isSelected()) {

            boolean isFound = false ;
            for (Store i : storeList) {
                if (i.getsID().equals(storeID) && (!i.hasAdmin2())) {
                    choice = 2 ;
                    isFound = true ;
                    i.setHasAdmin2(true);
                    loadInfoPage();
                }
                else if (i.getsID().equals(storeID) && (i.hasAdmin2())) {
                    showAlert("Admin #2 already exists");
                    isFound = true;
                }
            }
            if (! isFound )
                showAlert("No Store was found with this ID");
        }

        else if (admin3RB.isSelected()) {
            boolean isFound = false ;
            for (Store i : storeList) {
                if (i.getsID().equals(storeID) && (!i.hasAdmin3())) {
                    choice = 3 ;
                    isFound = true ;
                    i.setHasAdmin3(true);
                    loadInfoPage();
                }
                else if (i.getsID().equals(storeID) && (!i.hasAdmin3())) {
                    showAlert("Admin #3 already exists");
                    isFound = true;
                }
            }
            if (! isFound )
                showAlert("No Store was found with this ID");
        }

    }
    private void loadInfoPage () {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("gettingAdminInfo.fxml")) ;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        bpane.setBottom(root);
    }

    private void showAlert(String text) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("ERROR");
        alert.setHeaderText(text);
        alert.showAndWait();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
