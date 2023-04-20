package com.example.finalmidtermproj;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class AdminLogin {
    public Stage stage  ;
    private Scene scene ;
    private Parent root ;

    @FXML

    public Button loginButtonAdmin  ;
    public TextField adminUserField ; //personal ID
    public PasswordField adminPassField ; //store ID

    public String loginAdminID ;
    static String loginStoreID ;


    public void switchToSceneAdmin(ActionEvent event) throws IOException {

        loginAdminID = adminUserField.getText();
        loginStoreID = adminPassField.getText();
        boolean isFound = false;

        ArrayList<Admin> adminList = Main.adminFileTOArraylist();
        for (Admin i : adminList) {
            if (i.getaID().equals(loginAdminID) && i.getaStoreID().equals(loginStoreID)) {

                isFound = true;

                root = FXMLLoader.load(getClass().getResource("adminMenu.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
        }

        if (!isFound) {
            Main.showAlert("ERROR", "Invalid username or password", null, Alert.AlertType.ERROR);
        }

    }
}
