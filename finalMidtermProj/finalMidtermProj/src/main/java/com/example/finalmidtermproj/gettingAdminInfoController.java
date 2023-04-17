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

public class gettingAdminInfoController {

    private Stage stage  ;
    private Scene scene ;
    private Parent root ;
    public TextField  adminNameField , adminIdField;
    public Button submit ;

    File admins = new File("admins.txt") ;


    public void submitAdmin (ActionEvent event) throws IOException {
        if (AddAdminController.choice == 1) {
            AddNewAdmin(1 );
            showAlert();
            root = FXMLLoader.load(getClass().getResource("managerMenu.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        }
        else if (AddAdminController.choice == 2) {
            AddNewAdmin(2 );
            showAlert();
            root = FXMLLoader.load(getClass().getResource("managerMenu.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        else if (AddAdminController.choice == 3) {
            AddNewAdmin(3 );
            showAlert();
            root = FXMLLoader.load(getClass().getResource("managerMenu.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }


    public void AddNewAdmin (int shift ) throws IOException {
        String adminName = adminNameField.getText();
        String adminID = adminIdField.getText() ;
        FileWriter fw = new FileWriter(admins , true) ;
        fw.write(adminName +"\n"+ adminID +"\n"+ AddAdminController.storeID +"\n"+ shift +"\n");
        fw.close();
    }
    private void showAlert() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Adding Admin");
        alert.setHeaderText("Done!");
        alert.setContentText("Admin added successfully");
        alert.showAndWait();
    }

}
