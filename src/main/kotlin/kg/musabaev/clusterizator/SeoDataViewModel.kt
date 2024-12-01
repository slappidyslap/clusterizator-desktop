package kg.musabaev.clusterizator

import javafx.beans.property.ListProperty
import javafx.beans.property.SimpleStringProperty
import javafx.beans.property.StringProperty
import javafx.collections.FXCollections
import javafx.collections.ObservableList

class SeoDataViewModel {
    private val cluster: StringProperty
    private val keyword: StringProperty
    private val others: ObservableList<String>

    constructor(cluster: String, keyword: String, others: List<String>) {
        this.cluster = SimpleStringProperty(cluster)
        this.keyword = SimpleStringProperty(keyword)
        this.others = FXCollections.observableArrayList(others);
    }
}