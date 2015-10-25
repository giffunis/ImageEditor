package Histograma;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
 
public class Histograma extends Application {

    final static String tituloVentana = "Histograma";
    final static String tituloGrafico = "Histograma absoluto";
 
    @Override public void start(Stage stage) {
        stage.setTitle(tituloVentana);
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();

        final BarChart<String,Number> bc = new BarChart<String,Number>(xAxis,yAxis);
        bc.setTitle(tituloVentana);
        // xAxis.setLabel("Country");       
        // yAxis.setLabel("Value");
 
 		XYChart.Series gris = new XYChart.Series();
 		gris.setName("Griss");
 		for(int i = 0; i < 256; i++){
 			gris.getData().add(new XYChart.Data(String.valueOf(i), i));
 		}
 	
        
        Scene scene  = new Scene(bc,600,400);
        bc.getData().addAll(gris);
        stage.setScene(scene);
        stage.show();
    }
 
    public static void main(String[] args) {
        launch(args);
    }
}