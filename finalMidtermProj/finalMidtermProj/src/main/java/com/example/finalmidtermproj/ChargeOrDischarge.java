package com.example.finalmidtermproj;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class ChargeOrDischarge {

    private Stage stage  ;
    private Scene scene ;
    private Parent root ;

    public TextField proIdField ;
    public TextField countField ;
    public RadioButton charge ;
    public RadioButton discharge ;
    public Button submit ;
    int proCount ;

    public void chargeOrDischarge (ActionEvent event) throws IOException {

        ArrayList<Product> productList = Main.productFileTOArraylist();
        boolean isFound = false ;
        int newCount = Integer.parseInt(countField.getText()) ;

        for (Product i: productList) {
            if (i.getpID().equals(proIdField.getText()) && i.getpStoreID().equals(AdminLogin.loginStoreID)) {

                ArrayList<Store> storeList = Main.storeFileTOArraylist() ;
                isFound = true ;

                    for (Store j: storeList) {
                        if (j.getsID().equals(AdminLogin.loginStoreID)) {

                            int total = j.getTotalProductCount() ;
                            proCount = i.getpCount() ;
                            int income = j.getIncome();
                            int proPrice = i.getpPrice();

                            if (charge.isSelected()) {
                                proCount = proCount + newCount ;
                                total = total + newCount ;
                                i.setpCount(proCount);
                                j.setTotalProductCount(total);
                            }
                            else if (discharge.isSelected()) {
                                proCount = proCount - newCount ;
                                total = total - newCount ;
                                income = income + proPrice*newCount ;

                                if (proCount <0 ){
                                    Main.showAlert("ERROR!" , "There are only "+i.getpCount() +
                                            " of this product !" , "enter a smaller value" , Alert.AlertType.ERROR);
                                    break;
                                }
                                i.setpCount(proCount);
                                j.setTotalProductCount(total);
                                j.setIncome(income);
                            }

                            PrintWriter pw = new PrintWriter("products.txt") ;
                            pw.close();
                            FileWriter fw1 = new FileWriter("products.txt" ) ;
                            for (Product k : productList) {
                                fw1.write(k.getpName() + "\n" + k.getpID() + "\n" + k.getpPrice() + "\n" + AdminLogin.loginStoreID +
                                        "\n" + k.getpLabel() + "\n" + k.getpCount() + "\n"); ;
                            }fw1.close();

                            PrintWriter pw2 = new PrintWriter("stores.txt") ;
                            pw2.close();
                            FileWriter fw2 = new FileWriter("stores.txt" ) ;
                            for (Store r : storeList) {
                                fw2.write(r.getsName() +"\n" + r.getsID() + "\n" + r.hasAdmin1()+ "\n"+
                                        r.hasAdmin2()+ "\n"+ r.hasAdmin3()+"\n" + r.getTotalProductCount() + "\n" +r.getIncome()+"\n" ) ;
                            }fw2.close();
                        }
                    }

                    if (proCount >= 0) {
                        Main.showAlert("DONE!", "The products have been charged/discharged successfully.",
                                null, Alert.AlertType.INFORMATION);
                        root = FXMLLoader.load(getClass().getResource("adminMenu.fxml"));
                        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        scene = new Scene(root);
                        stage.setScene(scene);
                        stage.show();
                    }
            }
        }

        if (! isFound) {
            Main.showAlert("ERROR!" , "No product was found with this ID in this Store" , null , Alert.AlertType.ERROR);
        }
    }

}
