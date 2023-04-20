package com.example.finalmidtermproj;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

public class Buy2 implements Initializable {
    private Stage stage  ;
    private Scene scene ;
    private Parent root ;
    public AnchorPane anchor ;

    public TextField productNameField ;
    public TextArea allProducts ;
    String allProduct = "";
    public Spinner<Integer> spinner ;

    public void addToCart(ActionEvent event) throws IOException {
        File file = new File("cart.txt") ;
        FileWriter fw = new FileWriter(file , true);

        if ( ! logIn.isLoggedIn) {

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle(null);
            alert.setHeaderText("you Haven't logged in yet !");
            alert.setContentText("going to log in page ?");
            Optional<ButtonType> result = alert.showAndWait();

            if (result.get() == ButtonType.OK) {
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
        else {
            ArrayList<Product> productList = Main.productFileTOArraylist();
            boolean isFound = false;
            for (Product i : productList) {
                if (i.getpName().equals(productNameField.getText())) {
                    isFound = true ;
                    int availableCount = i.getpCount();
                    int purchaseCount = spinner.getValue();
                    if (purchaseCount > availableCount) {
                        Main.showAlert(null ,"Sorry ! \n your order count is more than available " +
                                "products in stock." , "enter a lower value " , Alert.AlertType.WARNING);
                        break;
                    }
                    fw.write(i.getpName() +"\n" + i.getpLabel() +"\n"+ i.getpPrice() +"\n" +
                            purchaseCount +"\n"+ logIn.loggedInUsername +"\n" +i.getpID() +"\n" + i.getpStoreID() + "\n");
                    fw.close();

                    Main.showAlert("DONE!" , "products added to your shopping cart" ,
                            "you can finalize your purchase in\"my shopping cart\" section" , Alert.AlertType.INFORMATION);
                }
            }
            if (! isFound) {
                Main.showAlert("ERROR!" , "Invalid name" ,
                        null , Alert.AlertType.ERROR);
            }
        }


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ArrayList<Product> productList = Main.productFileTOArraylist();
        for (Product i : productList) {
            if (i.getpStoreID().equals(Buy.storeID))
              allProduct += i.toString2();
        }
        allProducts.setText(allProduct);

        SpinnerValueFactory<Integer> valueFactory =
                new SpinnerValueFactory.IntegerSpinnerValueFactory(1 , 10000000) ;
        valueFactory.setValue(1);
        spinner.setValueFactory(valueFactory);
    }
}
