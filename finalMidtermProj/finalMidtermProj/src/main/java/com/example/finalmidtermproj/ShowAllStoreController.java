package com.example.finalmidtermproj;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import java.util.ArrayList;

public class ShowAllStoreController {
    public TextArea textarea ;
    public Button showButton ;
    public Label totalIncomeLabel ;
    public Label percentageLabel ;
    String allStores = "" ;
    int totalIncome = 0 ;
    double percentage = 0 ;


    public void showAllStores() {
        ArrayList<Store> storeList = Main.storeFileTOArraylist() ;
        for (Store i: storeList) {
            allStores += i.toString2();
            totalIncome += i.getIncome();
            percentage += (i.soldProducts*1.000/i.addedProducts)*100 ;
        }
        textarea.setText(allStores);
        totalIncomeLabel.setText(String.valueOf(totalIncome));
        percentageLabel.setText(String.valueOf(percentage));
        showButton.setDisable(true);

    }
}
