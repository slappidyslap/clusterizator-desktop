package kg.musabaev.clusterizator

import de.saxsys.mvvmfx.FxmlView
import de.saxsys.mvvmfx.InjectViewModel
import de.saxsys.mvvmfx.JavaView
import de.saxsys.mvvmfx.internal.viewloader.View
import javafx.beans.property.ReadOnlyObjectWrapper
import javafx.beans.property.SimpleStringProperty
import javafx.collections.ObservableList
import javafx.fxml.Initializable
import javafx.scene.control.Button
import javafx.scene.control.TableColumn
import javafx.scene.control.TableView
import javafx.scene.layout.BorderPane
import javafx.scene.layout.HBox
import javafx.scene.layout.VBox
import java.net.URL
import java.util.*
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ClusterTableView : VBox(), JavaView<ClusterTableViewModel>, Initializable {

    @InjectViewModel
    lateinit var viewModel: ClusterTableViewModel

    private val tableView: TableView<List<List<String>>>
    private val loadButton: Button

    init {
        tableView = TableView()
        loadButton = Button("Load File")

    }

    private fun loadSampleData() {
        // Пример данных, как будто загруженных из файла

        // Динамическое создание столбцов
        tableView.columns.clear()
        /*if (data.isNotEmpty()) {
            data[0].keys.forEach { columnKey ->
//                val column: TableColumn<Map<String, String>, String> = TableColumn(columnKey)
//                column.setCellValueFactory { ReadOnlyObjectWrapper(columnKey) }
//                tableView.columns.add(column);

                val column = TableColumn<Map<String, String>, String>(columnKey).apply {
                    cellValueFactory = { cellData: Map<String, String>, String> ->
                        SimpleStringProperty("")
                    }
                }


            }
        }*/
        viewModel.headers.forEach { key ->
            val col = TableColumn<List<List<String>>, String>(key)
            tableView.columns.add(col)
        }
        /*val column = TableColumn<Map<String, String>, String>(columnKey).apply {
            cellValueFactory = { cellData: Map<String, String>, String> ->
                SimpleStringProperty(cellData.value[columnKey] ?: "")
            }
        }*/


    }

    override fun initialize(location: URL?, resources: ResourceBundle?) {
        loadButton.setOnAction {
            viewModel.loadData()
            viewModel.headers.forEach { key ->
                val col = TableColumn<List<List<String>>, String>(key)
                tableView.columns.add(col)
            }
        }

        this.children.add(loadButton)
        this.children.add(tableView)

    }
}