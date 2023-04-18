package com.example.finalmidtermproj;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.ArrayList;

public class ShowOneStoreController {
    private Stage stage  ;
    private Scene scene ;
    private Parent root ;

    public TextField idField ;
    public Button showButton ;
    public Label nameLabel ;
    public Label idLabel ;
    public Label admin1Label ;
    public Label admin2Label ;
    public Label admin3Label ;


    public void ShowInfo () {

        boolean isFound = false ;
        ArrayList<Store> storeList = Main.storeFileTOArraylist();
        ArrayList<Admin> adminList = Main.adminFileTOArraylist();

        for (Store i : storeList) {
            if (i.getsID().equals(idField.getText())) {

                nameLabel.setText(i.getsName());
                idLabel.setText(i.getsID());
                admin1Label.setText("Empty"); ;
                admin2Label.setText("Empty"); ;
                admin3Label.setText("Empty"); ;

                for (Admin j: adminList) {
                    if (j.getaStoreID().equals(idField.getText()))
                    {
                        if (j.getaShift().equals("1"))
                            admin1Label.setText(j.toString()) ;
                        else if (j.getaShift().equals("2"))
                            admin2Label.setText(j.toString()) ;
                        else if (j.getaShift().equals("3"))
                            admin3Label.setText(j.toString()) ;

                    }

                }

                isFound = true ;

            }
        }
        if (! isFound)
            showAlert();

    }

    private void showAlert() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("NOT FOUND!");
        alert.setHeaderText("No store with this ID was found");
        alert.showAndWait();
    }


}
