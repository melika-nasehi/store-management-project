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

import java.io.IOException;

public class gettingAdminInfoController {

    private Stage stage  ;
    private Scene scene ;
    private Parent root ;
    public TextField  adminNameField , adminIdField;
    public Button submit ;

    public void submitAdmin (ActionEvent event) throws IOException {
        if (AddAdminController.choice == 1) {
            AddNewAdmin(1 );
            AddAdminController.target.setAdmin1(newAdmin);
            showAlert();
            root = FXMLLoader.load(getClass().getResource("managerMenu.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        }
        else if (AddAdminController.choice == 2) {
            AddNewAdmin(2 );
            AddAdminController.target.setAdmin2(newAdmin);
            showAlert();
            root = FXMLLoader.load(getClass().getResource("managerMenu.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        else if (AddAdminController.choice == 3) {
            AddNewAdmin(3 );
            AddAdminController.target.setAdmin3(newAdmin);
            showAlert();
            root = FXMLLoader.load(getClass().getResource("managerMenu.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }


    Admin newAdmin ;
    public void AddNewAdmin (int shift ) {
        String adminName = adminNameField.getText();
        String adminID = adminIdField.getText() ;

        newAdmin = new Admin(adminName , adminID , AddAdminController.storeID , shift) ;
        Admin.adminList.add(newAdmin) ;

    }

    private void showAlert() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Adding Admin");
        alert.setHeaderText("Done!");
        alert.setContentText("Admin added successfully");
        alert.showAndWait();
    }

}
