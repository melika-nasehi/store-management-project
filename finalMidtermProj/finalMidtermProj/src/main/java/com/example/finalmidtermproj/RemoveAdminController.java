package com.example.finalmidtermproj;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class RemoveAdminController {
    private Stage stage  ;
    private Scene scene ;
    private Parent root ;

    @FXML
    private TextField adminDeleteID ;
    @FXML
    private Button delete ;

    @FXML
    private void deleteAdmin (ActionEvent event) throws IOException {

        boolean isFound = false ;
        ArrayList<Admin> adminList = Main.adminFileTOArraylist();
        for (Admin i: adminList) {
            if (i.getaID().equals(adminDeleteID.getText())) {

                adminList.remove(i) ;
                String shift = i.getaShift() ;
                Main.showAlert("DONE!" , "Admin removed successfully", null , Alert.AlertType.INFORMATION);
                AddStoreController addStoreController = new AddStoreController();
                for (Store j: AddStoreController.stores) {
//                    if (shift == 1) {
//                        j.setAdmin1(null);
//                    }
//                    else if (shift == 2) {
//                        j.setAdmin2(null);
//                    }
//                    else if (shift == 3) {
//                        j.setAdmin3(null);
//                    }
                }

                root = FXMLLoader.load(getClass().getResource("managerMenu.fxml"));
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
                isFound = true ;

                break;
            }
        }

        if (! isFound)
            Main.showAlert("ERROR" , "NO Admin was found with this ID" , null , Alert.AlertType.ERROR);

    }
}
