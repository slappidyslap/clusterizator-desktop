package kg.musabaev.clusterizator

import de.saxsys.mvvmfx.ViewModel
import javafx.collections.FXCollections
import javafx.collections.ObservableList
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ClusterTableViewModel : ViewModel {

    @Inject
    val csvService: CsvService = CsvService();

    val headers: ObservableList<String> = FXCollections.observableArrayList()
    val items: ObservableList<Array<String>> = FXCollections.observableArrayList()

    fun loadData() {
        val data: List<Array<String>> = csvService.loadCsv()
        headers.addAll(data[0])
        items.addAll(data.subList(1, data.lastIndex))
    }
}