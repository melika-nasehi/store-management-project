package com.example.finalmidtermproj;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

public class myShoppingCart implements Initializable {
    private Stage stage  ;
    private Scene scene ;
    private Parent root ;
    public AnchorPane anchor ;

    public TextArea cartTextArea ;
    public Label totalPriceLabel ;
    public Label isLogged ;
    int totalPrice = 0;
    String purchaseProducts = "";
    public static int factorsID ;

    public void purchase() throws IOException {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(null);
        alert.setHeaderText("Are you sure you want to purchase ?");
        alert.setContentText("you can't undo this action");
        Optional<ButtonType> result = alert.showAndWait();

        if (result.get() == ButtonType.OK) {

            ArrayList<ShoppingCart> cartList = Main.cartFileTOArraylist();
            ArrayList<Store> storeList = Main.storeFileTOArraylist();
            ArrayList<Product> productList = Main.productFileTOArraylist();
            for (ShoppingCart i : cartList) {
                if (i.getUsername().equals(logIn.loggedInUsername)) {
                    for (Store j : storeList) {
                        if (i.getStoreID().equals(j.getsID())) {
                            int price = i.getProductPrice() * i.getPurchaseCount();
                            int income = j.getIncome();
                            income += price;
                            int total = j.getTotalProductCount();
                            total -= i.getPurchaseCount();
                            int sold = j.getSoldProducts();
                            sold = sold + i.getPurchaseCount();
                            j.setIncome(income);
                            j.setTotalProductCount(total);
                            j.setSoldProducts(sold);
                            PrintWriter pw = new PrintWriter("stores.txt");
                            pw.close();
                            FileWriter fw = new FileWriter("stores.txt");
                            for (Store k : storeList) {
                                fw.write(k.getsName() + "\n" + k.getsID() + "\n" + k.hasAdmin1() + "\n" +
                                        k.hasAdmin2() + "\n" + k.hasAdmin3() + "\n" + k.getTotalProductCount() +
                                        "\n" + k.getIncome() + "\n" + k.getAddedProducts()+"\n"+k.getSoldProducts()+"\n");
                            }
                            fw.close();
                        }
                    }
                    for (Product j : productList) {
                        if (j.getpID().equals(i.getProductID())) {
                            int count = j.getpCount();
                            int subCount = i.getPurchaseCount();
                            count -= subCount;
                            j.setpCount(count);
                            PrintWriter pw2 = new PrintWriter("products.txt");
                            pw2.close();
                            FileWriter fw2 = new FileWriter("products.txt");
                            for (Product r : productList) {
                                fw2.write(r.getpName() + "\n" + r.getpID() + "\n" + r.getpPrice() + "\n" + r.getpStoreID() +
                                        "\n" + r.getpLabel() + "\n" + r.getpCount() + "\n");
                            }
                            fw2.close();
                        }
                    }

                }

            }
            cartList.removeIf(p -> p.getUsername().equals(logIn.loggedInUsername));
            PrintWriter pw3 = new PrintWriter("cart.txt");
            pw3.close();
            FileWriter fw3 = new FileWriter("cart.txt");
            for (ShoppingCart q : cartList) {
                fw3.write(q.getProductName() + "\n" + q.getProductLabel() + "\n" + q.getProductPrice() + "\n" +
                        q.getPurchaseCount() + "\n" + logIn.loggedInUsername + "\n" + q.getProductID() + "\n" + q.getStoreID() + "\n");
            }
                fw3.close();

                cartTextArea.setText("you shopping cart is empty");
                totalPriceLabel.setText("");


            File file = new File("factors.txt") ;
            FileWriter fw4 = new FileWriter("factors.txt" , true) ;
            factorsID ++ ;
            try {
                BufferedReader reader = new BufferedReader(new FileReader("factorID"));
                String line = reader.readLine();
                if (line != null) {
                    factorsID = Integer.parseInt(line);
                } else {
                    factorsID = 1000;
                }
                reader.close();
            }catch (IOException e ) {
                factorsID = 1000 ;
            }
            factorsID ++ ;
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter("factorID")) ;
                writer.write(Integer.toString(factorsID));
                writer.close();
            }catch (IOException e) {
                 e.printStackTrace();
            }


            fw4.write( factorsID +"\n" + purchaseProducts + "factor\n" );
            fw4.close();
            }
        }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (logIn.isLoggedIn) {
            ArrayList<ShoppingCart> cartList = Main.cartFileTOArraylist();

            for (ShoppingCart i : cartList) {
                if (i.getUsername().equals(logIn.loggedInUsername)) {
                    purchaseProducts += i.toString() ;
                    int purCount = i.getPurchaseCount();
                    int price = i.getProductPrice();
                    totalPrice += purCount * price;

                }
            }
            if (purchaseProducts.equals("")) {
                cartTextArea.setText("your shopping cart is empty !");
            }
            else {
                cartTextArea.setText(purchaseProducts);
                totalPriceLabel.setText(String.valueOf(totalPrice));
            }
        }else
            isLogged.setText("You haven't logged in yet !");
    }
}
