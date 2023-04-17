package com.example.finalmidtermproj;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("scene1.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
//        stage.setFullScreen(true);
    }

    public static void showAlert(String title , String header , String content , Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }

    public static ArrayList<Store> storeFileTOArraylist() {
        ArrayList<Store> storeList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("stores.txt"))) {
            String line ;
            String storeName = null ;
            String storeID = null ;
            boolean hasName = false ;
            while ((line = br.readLine()) != null) {
                if (!hasName) {
                    storeName = line ;
                    hasName = true ;
                }
                else {
                    storeID = line ;
                    Store store = new Store(storeName , storeID);
                    hasName = false ;
                    storeList.add(store);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return storeList ;
    }

    public static void main(String[] args) {

        launch();

    }
}