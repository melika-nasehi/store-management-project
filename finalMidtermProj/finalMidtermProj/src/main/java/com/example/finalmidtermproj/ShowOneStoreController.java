package com.example.finalmidtermproj;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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

        for (Store i : AddStoreController.stores) {
            if (i.getsID().equals(idField.getText())) {

                nameLabel.setText(i.getsName());
                idLabel.setText(idField.getText());
//                admin1Label.setText(String.valueOf(i.getAdmin1())) ;
//                admin2Label.setText(String.valueOf(i.getAdmin2())) ;
//                admin3Label.setText(String.valueOf(i.getAdmin3())) ;
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
