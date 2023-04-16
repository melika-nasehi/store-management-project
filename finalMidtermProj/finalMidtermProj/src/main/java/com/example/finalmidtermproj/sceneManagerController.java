package com.example.finalmidtermproj;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class sceneManagerController {

    private Stage stage  ;
    private Scene scene ;
    private Parent root ;

    public Button addStoreB ;
    public Button removeStoreB ;
    public Button showStoreB ;
    public Button addAdminB ;
    public Button removeAdminB ;

    public void switchToAddStore(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("AddStore.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToRemoveStore(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("RemoveStore.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToShowStore(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("ShowOneStore.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToAddAdmin(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("AddAdmin.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToRemoveAdmin(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("RemoveAdmin.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }



}
