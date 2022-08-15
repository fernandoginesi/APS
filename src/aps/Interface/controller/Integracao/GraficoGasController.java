package aps.Interface.controller.Integracao;

import aps.banco.bdGas;
import aps.gas.gas;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;

public class GraficoGasController implements Initializable {

    gas g2 = new gas();

    bdGas g1 = new bdGas();

    ArrayList<Object> listaValores = new ArrayList();

    @FXML
    private AreaChart<?, ?> ChartsAgua;
    @FXML
    private Label media;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listaValores = g1.select();

        grafico();

        //Insere a media dos meses no campo correspondente
        media.setText(String.format("R$ %.2f", g2.mediaConsumo()));
    }

    public void grafico() {
        ChartsAgua.getData().clear();

        XYChart.Series Gas = new XYChart.Series();
        listaValores = g1.select();
        for (int i = 0; i < listaValores.size(); i++) {
            if (i % 2 == 0) {
                Gas.getData().add(new XYChart.Data(listaValores.get(i), listaValores.get(i + 1)));
            }
        }
        ChartsAgua.getData().addAll(Gas);
    }

}
