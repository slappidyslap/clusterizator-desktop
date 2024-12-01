module kg.musabaev.clusterizator.clusterizator {
    requires javafx.controls;
    requires javafx.fxml;
    requires kotlin.stdlib;


    opens kg.musabaev.clusterizator.clusterizator to javafx.fxml;
    exports kg.musabaev.clusterizator.clusterizator;
}