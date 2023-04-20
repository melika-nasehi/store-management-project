package com.example.finalmidtermproj;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class logIn implements Initializable {
    private Stage stage  ;
    private Scene scene ;
    private Parent root ;

    public TextField logInUsername ;
    public TextField logInPassword ;
    public static boolean isLoggedIn ;
    public AnchorPane anchor ;
    public Button signUp ;
    public static String loggedInUsername ;

    public void logIn(ActionEvent event) throws IOException {
        ArrayList<Client> clientList = Main.clientFileTOArraylist();

        isLoggedIn = false ;
        for (Client i: clientList) {
            if (i.getcUserName().equals(logInUsername.getText()) && i.getcPassWord().equals(logInPassword.getText())) {
                isLoggedIn = true ;
                loggedInUsername = i.getcUserName();

                root = FXMLLoader.load(getClass().getResource("ClientMenu.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
                Main.showAlert("LOGGED IN" , "you logged in successfully" ,null , Alert.AlertType.INFORMATION);
            }
        }
        if (! isLoggedIn) {
            Main.showAlert("ERROR" , "Wrong username or password" , null , Alert.AlertType.ERROR);
        }
    }

    public void goToSignUpPage() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("signUp.fxml"));
        Pane registerPane = fxmlLoader.load();
        try {
            anchor.getChildren().clear();
            anchor.getChildren().add(registerPane);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        signUp.setCursor(Cursor.HAND);
    }
}
