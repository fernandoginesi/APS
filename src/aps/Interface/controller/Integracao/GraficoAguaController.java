package aps.Interface.controller.Integracao;

import aps.agua.Agua;
import aps.banco.bdAgua;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;

public class GraficoAguaController implements Initializable {

    Agua a2 = new Agua();

    bdAgua a1 = new bdAgua();

    ArrayList<Object> listaValores = new ArrayList();

    @FXML
    private AreaChart<?, ?> ChartsAgua;
    @FXML
    private Label media;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listaValores = a1.select();

        grafico();

        //Insere a media dos meses no campo correspondente
        media.setText(String.format("R$ %.2f", a2.mediaConsumo()));
    }

    public void grafico() {
        ChartsAgua.getData().clear();

        XYChart.Series Agua = new XYChart.Series();
        listaValores = a1.select();
        for (int i = 0; i < listaValores.size(); i++) {
            if (i % 2 == 0) {
                Agua.getData().add(new XYChart.Data(listaValores.get(i), listaValores.get(i + 1)));
            }
        }
        ChartsAgua.getData().addAll(Agua);
    }

}
