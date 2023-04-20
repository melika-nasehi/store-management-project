package com.example.finalmidtermproj;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class ClientMenu implements Initializable {
    @FXML
    private BorderPane bp3 ;
    @FXML
    private AnchorPane ap3;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    @FXML
    private void buy (MouseEvent event) {
        loadPage("Buy");

    }
    @FXML
    private void shoppingCart (MouseEvent event) {
        loadPage("myShoppingCart");
    }
    @FXML
    private void searchProductsClient (MouseEvent event) {
        loadPage("searchProductsClient");
    }
    @FXML
    private void productsCategory (MouseEvent event) {
        loadPage("productsCategory");
    }

    @FXML
    private void signUp (MouseEvent event) {
        loadPage("signUp");
    }

    @FXML
    private void logIn (MouseEvent event) {
        loadPage("logIn");
    }

    @FXML
    private void logout (MouseEvent event) throws IOException {

        Stage stage ;
        Scene scene ;
        Parent root ;

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("logout");
        alert.setHeaderText("Are you sure you want to logout?");
        alert.setContentText(null);
        Optional<ButtonType> result = alert.showAndWait();

        if (result.get() == ButtonType.OK) {
            logIn.isLoggedIn = false ;

            root = FXMLLoader.load(getClass().getResource("scene1.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }

    }

    private void loadPage (String page) {
        Parent root;

        try {
            root = FXMLLoader.load(getClass().getResource(page+".fxml")) ;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        bp3.setCenter(root);


    }


}

