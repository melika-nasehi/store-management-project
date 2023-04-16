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

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
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

        ArrayList<Store> storeList = new ArrayList<>();
        Scanner mySc = new Scanner("stores.txt");

        while (mySc.hasNext()) {
            String name = mySc.nextLine() ;
            String id = mySc.nextLine() ;
            Store store = new Store(name , id);
            storeList.add(store);
        }
        mySc.close();


        boolean isFound = false ;
        for (Store i: storeList) {
            if (i.getsID().equals(deleteID.getText())) {

                storeList.remove(i) ;

                PrintWriter pw = new PrintWriter("stores.txt");
                pw.close();

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
