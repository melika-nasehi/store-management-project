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
            boolean Admin3 = false;
            int totalProductCount =0;
            int income = 0 ;
            int added = 0;
            int sold = 0 ;
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
                    num ++ ;
                }
                else if (num == 6) {
                    totalProductCount = Integer.valueOf(line) ;
                    num ++ ;
                }
                else if (num == 7) {
                    income = Integer.valueOf(line) ;
                    num ++ ;
                }
                else if (num == 8) {
                    added = Integer.valueOf(line) ;
                    num++ ;
                }
                else if (num == 9) {
                    sold = Integer.valueOf(line) ;
                    num = 1 ;
                    Store store = new Store(storeName , storeID , Admin1 , Admin2 , Admin3 ,
                            totalProductCount , income , added , sold);
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
                    price = Integer.valueOf(line) ;
                    num++ ;
                }
                else if (num == 4) {
                    productStoreID = line ;
                    num ++ ;
                }
                else if (num == 5) {
                    label = pLabel.valueOf(line) ;
                    num++ ;
                }
                else if (num == 6) {
                    count = Integer.valueOf(line) ;
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

    public static ArrayList<Client> clientFileTOArraylist() {
        ArrayList<Client> clientList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("clients.txt"))) {
            String line ;
            String username = null ;
            String password = null ;
            int num = 1 ;
            while ((line = br.readLine()) != null) {

                if (num ==1) {
                    username = line ;
                    num++ ;
                }
                else if (num == 2) {
                    password= line ;
                    num = 1 ;
                    Client client = new Client(username , password) ;
                    clientList.add(client);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return clientList ;
    }

    public static ArrayList<ShoppingCart> cartFileTOArraylist() {
        ArrayList<ShoppingCart> cartList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("cart.txt"))) {
            String line ;
            String productName = null ;
            pLabel productLabel = null ;
            int productPrice = 0 ;
            int purchaseCount = 0 ;
            String username = null ;
            String productID = null ;
            String storeID = null ;
            int num = 1 ;
            while ((line = br.readLine()) != null) {

                if (num ==1) {
                    productName  = line ;
                    num++ ;
                }
                else if (num == 2) {
                    productLabel= pLabel.valueOf(line);
                    num ++ ;

                }
                else if (num == 3) {
                    productPrice = Integer.parseInt(line);
                    num++ ;
                }
                else if (num == 4) {
                    purchaseCount = Integer.parseInt(line);
                    num++ ;
                }
                else if (num == 5) {
                    username = line;
                    num++ ;
                }
                else if (num == 6) {
                    productID = line;
                    num ++ ;
                }
                else if (num == 7) {
                    storeID = line ;
                    num = 1 ;
                    ShoppingCart shoppingCart = new ShoppingCart(productName , productLabel , productPrice ,
                            purchaseCount , username , productID , storeID) ;
                    cartList.add(shoppingCart) ;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cartList ;
    }

    public static ArrayList<Factor> factorFileTOArraylist() {
        File file = new File("factors.txt") ;
        ArrayList<Factor> factorList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("factors.txt"))) {
            String line ;
            String factor = null ;
            String ID = null ;
            String info = null ;
            int num = 1 ;
            while ((line = br.readLine()) != null) {

                 if (num == 1) {
                    ID = line ;
                    num ++ ;
                }
                else if (num == 2) {
                    if( ! line.contains("factor") ) {
                        info += line ;
                        info += "\n" ;
                        continue;
                    }
                    Factor newFactor = new Factor(ID , info) ;
                    factorList.add(newFactor) ;
                     info = null ;
                    num = 1 ;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return factorList ;
    }

    public static void main(String[] args) {
        launch();

    }
}