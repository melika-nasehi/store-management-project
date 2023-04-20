package com.example.finalmidtermproj;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.util.ArrayList;


public class Factors {
    private Stage stage  ;
    private Scene scene ;
    private Parent root ;

    public TextField factorIdField ;
    public TextArea factorTextArea ;

    public void adminGetFactors () {
        ArrayList<Factor> factorList = Main.factorFileTOArraylist();
        boolean isFound = false ;
        for (Factor i : factorList) {
            if (i.factorID.equals(factorIdField.getText())) {
                isFound = true ;
                factorTextArea.setText(i.getFactorInfo());
            }
        }
        if (! isFound) {
            Main.showAlert("NOT FOUND !" , "No factor was" +
                    " found with this ID " , null , Alert.AlertType.ERROR);
        }


    }

}
