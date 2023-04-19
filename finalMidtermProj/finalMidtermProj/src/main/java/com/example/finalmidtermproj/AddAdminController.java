package com.example.finalmidtermproj;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
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

    ArrayList<Store> storeList = new ArrayList<>();

    public void checkNewAdmin() throws IOException {

        ArrayList<Store> storeList = Main.storeFileTOArraylist();

        storeID = storeIdTextField.getText() ;


        if (admin1RB.isSelected()) {
            boolean isFound = false ;
            for (Store i : storeList) {
                if (i.getsID().equals(storeID) && (!i.hasAdmin1)) {
                    choice = 1 ;
                    isFound = true ;
                    i.setHasAdmin1(true);

                    PrintWriter pw = new PrintWriter("stores.txt");
                    pw.close();
                    FileWriter fw = new FileWriter("stores.txt" ) ;
                    for (Store j: storeList) {
                        fw.write(j.getsName() +"\n" + j.getsID() + "\n" + j.hasAdmin1()+ "\n"+ j.hasAdmin2()+
                                "\n"+ j.hasAdmin3()+"\n" + j.getTotalProductCount()+"\n" + j.getIncome()+"\n") ;
                    }fw.close();


                    loadInfoPage();
                }
                else if (i.getsID().equals(storeID) && (i.hasAdmin1)) {
                    showAlert("Admin #1 already exists");
                    isFound = true;
                }
            }
            if (! isFound )
                showAlert("No Store was found with this ID");
        }

        else if (admin2RB.isSelected()) {

            boolean isFound = false ;
            for (Store i : storeList) {
                if (i.getsID().equals(storeID) && (!i.hasAdmin2)) {
                    choice = 2 ;
                    isFound = true ;
                    i.setHasAdmin2(true);

                    PrintWriter pw = new PrintWriter("stores.txt");
                    pw.close();
                    FileWriter fw = new FileWriter("stores.txt" ) ;
                    for (Store j: storeList) {
                        fw.write(j.getsName() +"\n" + j.getsID() + "\n" + j.hasAdmin1()+ "\n"+ j.hasAdmin2()+
                                "\n"+ j.hasAdmin3()+"\n" + j.getTotalProductCount() + "\n"+j.getIncome()+"\n") ;
                    }fw.close();

                    loadInfoPage();
                }
                else if (i.getsID().equals(storeID) && (i.hasAdmin2)) {
                    showAlert("Admin #2 already exists");
                    isFound = true;
                }
            }
            if (! isFound )
                showAlert("No Store was found with this ID");
        }

        else if (admin3RB.isSelected()) {
            boolean isFound = false ;
            for (Store i : storeList) {
                if (i.getsID().equals(storeID) && (i.hasAdmin3== false)) {
                    choice = 3 ;
                    isFound = true ;
                    i.setHasAdmin3(true);

                    PrintWriter pw = new PrintWriter("stores.txt");
                    pw.close();
                    FileWriter fw = new FileWriter("stores.txt" ) ;
                    for (Store j: storeList) {
                        fw.write(j.getsName() +"\n" + j.getsID() + "\n" + j.hasAdmin1()+ "\n"+ j.hasAdmin2()+
                                "\n"+ j.hasAdmin3()+"\n" + j.getTotalProductCount() + "\n"+j.getIncome()+"\n") ;
                    }fw.close();

                    loadInfoPage();
                }
                else if (i.getsID().equals(storeID) && (i.hasAdmin3)) {
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
