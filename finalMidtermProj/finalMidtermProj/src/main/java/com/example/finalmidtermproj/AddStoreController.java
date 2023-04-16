package com.example.finalmidtermproj;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class AddStoreController  {
    public TextField storeNameField ;
    public TextField storeIdField ;
    public Button submit ;
    private Stage stage  ;
    private Scene scene ;
    private Parent root ;

    public static ArrayList<Store> stores = new ArrayList<>();

    public ArrayList<Store> returnStoreList () {
        return stores ;
    }

    public void AddNewStore (ActionEvent event) throws IOException {
        File file = new File("stores.txt");
        FileWriter fw = new FileWriter(file , true) ;

        String newStoreName = storeNameField.getText();
        String newStoreId = storeIdField.getText();
        Store newStore = new Store(newStoreName, newStoreId);
        stores.add(newStore);
        fw.write(newStoreName +"\n"+newStoreId +"\n");
        fw.close();


        showAlert();

        root = FXMLLoader.load(getClass().getResource("managerMenu.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    private void showAlert() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Adding Store");
        alert.setHeaderText("Done!");
        alert.setContentText("Store added successfully");
        alert.showAndWait();
    }




}
