package com.example.finalmidtermproj;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class signUp {
    private Stage stage  ;
    private Scene scene ;
    private Parent root ;
    public AnchorPane anchor ;

    public TextField signUpUsername ;
    public TextField signUpPassword ;

    public void signUp (ActionEvent event) throws IOException {
        File file = new File("clients.txt") ;
        FileWriter fw = new FileWriter(file , true) ;
        ArrayList<Client> clientList = Main.clientFileTOArraylist();
        boolean isFound = false ;

        for (Client i: clientList) {
            if (i.cUserName.equals(signUpUsername.getText())) {
                isFound = true ;
                Main.showAlert("ERROR!" , "this username is not available.\n" +
                        "it is already taken" , null , Alert.AlertType.ERROR);
            }
        }
        if (! isFound) {
            fw.write(signUpUsername.getText() + "\n" + signUpPassword.getText() + "\n");
            fw.close();
            Main.showAlert("SIGNED UP" , "you signed up successfully " , null , Alert.AlertType.INFORMATION);

            isFound = true ;
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("logIn.fxml"));
            Pane registerPane = fxmlLoader.load();
            try {
                anchor.getChildren().clear();
                anchor.getChildren().add(registerPane);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
