package com.example.finalmidtermproj;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import java.util.ArrayList;

public class ShowAllStoreController {
    public TextArea textarea ;
    public Button showButton ;
    public Label totalIncomeLabel ;
    String allStores = "" ;
    int totalIncome = 0 ;


    public void showAllStores() {
        ArrayList<Store> storeList = Main.storeFileTOArraylist() ;
        for (Store i: storeList) {
            allStores += i.toString2();
            totalIncome += i.getIncome();
        }
        textarea.setText(allStores);
        totalIncomeLabel.setText(String.valueOf(totalIncome));
        showButton.setDisable(true);

    }
}
