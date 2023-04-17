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

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class RemoveStoreController {
    private Stage stage  ;
    private Scene scene ;
    private Parent root ;

    @FXML
    private Button delete ;
    @FXML
    private TextField deleteID ;


    @FXML
    private void deleteStore (ActionEvent event) throws IOException {


        boolean isFound = false ;
        ArrayList<Store> storeList = Main.storeFileTOArraylist();

        for (Store i: storeList) {
            if (i.getsID().equals(deleteID.getText())) {

                storeList.remove(i) ;

                PrintWriter pw = new PrintWriter("stores.txt");
                pw.close();
                FileWriter fw3 = new FileWriter("stores.txt" ) ;
                for (Store j: storeList) {
                    fw3.write(j.getsName() +"\n" + j.getsID() + "\n") ;
                }fw3.close();

                Main.showAlert("DONE!" , "Store removed successfully", null , Alert.AlertType.INFORMATION);

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
            Main.showAlert("ERROR" , "NO Store was found with this ID" , null , Alert.AlertType.ERROR);
    }

}
