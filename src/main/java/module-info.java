module com.sorveteria.sorveteria {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.sorveteria.sorveteria to javafx.fxml;
    exports com.sorveteria.sorveteria;
    exports com.sorveteria.sorveteria.Testes;
    opens com.sorveteria.sorveteria.Testes to javafx.fxml;
}