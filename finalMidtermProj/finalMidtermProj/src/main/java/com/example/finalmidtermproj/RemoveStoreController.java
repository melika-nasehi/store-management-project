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
import java.util.Iterator;
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
                FileWriter fw = new FileWriter("stores.txt" ) ;
                for (Store j: storeList) {
                    fw.write(j.getsName() +"\n" + j.getsID() + "\n" + j.hasAdmin1()+ "\n"+
                            j.hasAdmin2()+ "\n"+ j.hasAdmin3()+"\n" + j.getTotalProductCount() +
                            "\n"+j.getIncome()+"\n"+j.getAddedProducts()+ "\n" +j.getSoldProducts()+"\n" ) ;
                }fw.close();

                ArrayList<Admin> adminList = Main.adminFileTOArraylist();

                adminList.removeIf(j -> j.aStoreID.equals(deleteID.getText()));

                PrintWriter pw2 = new PrintWriter("admins.txt") ;
                pw2.close();
                FileWriter fw2 = new FileWriter("admins.txt" ) ;
                for (Admin k : adminList) {
                    fw2.write(k.getaName() + "\n" + k.getaID()+"\n"+k.getaStoreID()+"\n"+k.getaShift()+"\n");
                }fw2.close();



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
