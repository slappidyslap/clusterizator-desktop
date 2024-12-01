package kg.musabaev.clusterizator

import com.opencsv.CSVReader
import java.io.FileInputStream
import java.io.IOException
import java.io.InputStreamReader
import javax.inject.Singleton

@Singleton
class CsvService {
    fun loadCsv(filePath: String = "proseller.csv") : List<Array<String>> { // FIXME
        CSVReader(InputStreamReader(FileInputStream(filePath), "UTF-8")).use { reader ->
            val data = reader.readAll()
            if (data.isEmpty()) throw IOException("Файл пустой!")
            return data
        }
    }
}