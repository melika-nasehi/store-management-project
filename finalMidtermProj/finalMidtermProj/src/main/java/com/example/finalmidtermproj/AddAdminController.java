package com.example.finalmidtermproj;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
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


    public void checkNewAdmin() {

        storeID = storeIdTextField.getText() ;

        if (admin1RB.isSelected()) {
            boolean isFound = false ;
            for (Store i : AddStoreController.stores) {
                if (i.getsID().equals(storeID) && (i.getAdmin1() == null)) {
                    choice = 1 ;
                    target = i ;
                    isFound = true ;
                    loadInfoPage();
                }
                else if (i.getsID().equals(storeID) && (i.getAdmin1() != null)) {
                    showAlert("Admin #1 already exists");
                    isFound = true;
                }
            }
            if (! isFound )
                showAlert("No Store was found with this ID");
        }

        else if (admin2RB.isSelected()) {

            boolean isFound = false ;
            for (Store i : AddStoreController.stores) {
                if (i.getsID().equals(storeID) && (i.getAdmin2() == null)) {
                    choice = 2 ;
                    target = i ;
                    isFound = true ;
                    loadInfoPage();
                }
                else if (i.getsID().equals(storeID) && (i.getAdmin2() != null)) {
                    showAlert("Admin #2 already exists");
                    isFound = true;
                }
            }
            if (! isFound )
                showAlert("No Store was found with this ID");
        }

        else if (admin3RB.isSelected()) {
            boolean isFound = false ;
            for (Store i : AddStoreController.stores) {
                if (i.getsID().equals(storeID) && (i.getAdmin3() == null)) {
                    choice = 3 ;
                    target = i ;
                    isFound = true ;
                    loadInfoPage();
                }
                else if (i.getsID().equals(storeID) && (i.getAdmin3() != null)) {
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
