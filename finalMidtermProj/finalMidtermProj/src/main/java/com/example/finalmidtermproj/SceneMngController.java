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

public class SceneMngController {
    private Stage stage  ;
    private Scene scene ;
    private Parent root ;

    @FXML

    public Button loginButton  ;
    public TextField usernameField ;
    public PasswordField passwordField ;


    public void switchToSceneManager(ActionEvent event) throws IOException {
        if (usernameField.getText().equals("") && passwordField.getText().equals("")) {
            root = FXMLLoader.load(getClass().getResource("managerMenu.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        else
            showAlert();
    }

    private void showAlert() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText("Invalid username or password");
        alert.showAndWait();
    }





}
