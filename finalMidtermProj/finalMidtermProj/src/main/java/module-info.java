module com.example.finalmidtermproj {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.finalmidtermproj to javafx.fxml;
    exports com.example.finalmidtermproj;
}