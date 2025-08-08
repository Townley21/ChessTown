module com.example.chesstown {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.chesstown to javafx.fxml;
    exports com.example.chesstown;
}