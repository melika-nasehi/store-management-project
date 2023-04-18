package com.example.finalmidtermproj;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import java.io.BufferedReader;
import java.io.File;
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
            boolean Admin1 = false ;
            boolean Admin2 = false;
            boolean Admin3;
            int num =1 ;
            while ((line = br.readLine()) != null) {

                if (num==1) {
                    storeName = line ;
                    num++ ;
                }
                else if(num==2) {
                    storeID = line ;
                    num++ ;
                }
                else if (num==3) {
                    Admin1 = Boolean.valueOf(line) ;
                    num++ ;
                }
                else if (num==4) {
                    Admin2 = Boolean.valueOf(line) ;
                    num++ ;
                }
                else if(num==5) {
                    Admin3 = Boolean.valueOf(line) ;
                    num = 1 ;
                    Store store = new Store(storeName , storeID , Admin1 , Admin2 , Admin3 );
                    storeList.add(store);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return storeList ;
    }

    public static ArrayList<Admin> adminFileTOArraylist() {
        ArrayList<Admin> adminList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("admins.txt"))) {
            String line ;
            String adminName = null ;
            String adminID = null ;
            String adminStoreID = null ;
            String shift = null ;
            int num = 1 ;
            while ((line = br.readLine()) != null) {

                if (num ==1) {
                    adminName = line ;
                    num++ ;
                }
                else if (num == 2) {
                    adminID = line ;
                    num++ ;
                }
                else if (num ==3 ) {
                    adminStoreID = line ;
                    num++ ;
                }
                else if (num == 4) {
                    shift = line ;
                    num = 1 ;
                    Admin admin = new Admin(adminName , adminID , adminStoreID , shift) ;
                    adminList.add(admin) ;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return adminList ;
    }

    public static ArrayList<Product> productFileTOArraylist() {
        ArrayList<Product> productList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("products.txt"))) {
            String line ;
            String productName = null ;
            String productID = null ;
            String productStoreID = null ;
            int price = 0 ;
            int count = 0 ;
            pLabel label = null ;

            int num = 1 ;
            while ((line = br.readLine()) != null) {

                if (num ==1) {
                    productName = line ;
                    num++ ;
                }
                else if (num == 2) {
                    productID = line ;
                    num++ ;
                }
                else if (num ==3 ) {
                    productStoreID = line ;
                    num++ ;
                }
                else if (num == 4) {
                    price = Integer.valueOf(line) ;
                    num ++ ;
                }
                else if (num == 5) {
                    count = Integer.valueOf(line) ;
                    num++ ;
                }
                else if (num == 6) {
                    label = pLabel.valueOf(line) ;
                    num = 1 ;
                    Product newProduct = new Product(productName , productID , price , productStoreID , label , count) ;
                    productList.add(newProduct) ;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return productList ;
    }

    public static void main(String[] args) {
        launch();

    }
}