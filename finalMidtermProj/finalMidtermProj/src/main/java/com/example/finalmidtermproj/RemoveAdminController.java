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

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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

        ArrayList<Admin> adminList = Main.adminFileTOArraylist();
        boolean isFound = false ;
        for (Admin i: adminList) {
            if (i.getaID().equals(adminDeleteID.getText())) {

                adminList.remove(i) ;
                int shift = Integer.parseInt(i.getaShift());
                String storeID = i.aStoreID ;

                PrintWriter pw = new PrintWriter("admins.txt");
                pw.close();
                FileWriter fw = new FileWriter("admins.txt" ) ;
                for (Admin j: adminList) {
                    fw.write(j.getaName() +"\n" + j.getaID() + "\n" + j.getaStoreID()+ "\n"+ j.getaShift()+ "\n") ;
                }fw.close();

                ArrayList<Store> storeList = Main.storeFileTOArraylist();
                for (Store j: storeList) {
                    if (j.getsID().equals(storeID)) {
                        if (shift == 1) {
                            j.setHasAdmin1(false);
                        } else if (shift == 2) {
                            j.setHasAdmin2(false);
                        } else if (shift == 3) {
                            j.setHasAdmin3(false);
                        }
                    }
                }

                PrintWriter pw2 = new PrintWriter("stores.txt");
                pw2.close();
                FileWriter fw2 = new FileWriter("stores.txt" ) ;
                for (Store j: storeList) {
                    fw2.write(j.getsName() +"\n" + j.getsID() + "\n" + j.hasAdmin1()+ "\n"+ j.hasAdmin2()+
                            "\n"+ j.hasAdmin3()+"\n" + j.getTotalProductCount() + "\n"+j.getIncome()+"\n") ;
                }fw2.close();

                Main.showAlert("DONE!" , "Admin removed successfully", null , Alert.AlertType.INFORMATION);

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
