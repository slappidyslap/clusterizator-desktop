package kg.musabaev.clusterizator

import de.saxsys.mvvmfx.FluentViewLoader
import de.saxsys.mvvmfx.ViewTuple
import de.saxsys.mvvmfx.easydi.MvvmfxEasyDIApplication
import javafx.application.Application
import javafx.geometry.Rectangle2D
import javafx.scene.Scene
import javafx.stage.Screen
import javafx.stage.Stage


class Starter : MvvmfxEasyDIApplication() {

    override fun startMvvmfx(stage: Stage) {
        val tuple: ViewTuple<ClusterTableView, ClusterTableViewModel> =
            FluentViewLoader.javaView(ClusterTableView::class.java).load()
        val scene = Scene(tuple.view)
        stage.title = "Hello!"
        stage.scene = scene
        val screen: Screen = Screen.getPrimary()
        val bounds: Rectangle2D = screen.visualBounds

        stage.x = bounds.minX
        stage.y = bounds.minY
        stage.width = bounds.width
        stage.height = bounds.height
        stage.show()
    }
}

fun main() {
    Application.launch(Starter::class.java)
}