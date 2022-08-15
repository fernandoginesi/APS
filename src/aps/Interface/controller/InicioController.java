package aps.Interface.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

import aps.agua.Agua;
import aps.gas.gas;
import aps.eletrecidade.Eletrecidade;

import aps.banco.bdAgua;
import aps.banco.bdEletrecidade;
import aps.banco.bdGas;
import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;

public class InicioController implements Initializable {

    Agua a2 = new Agua();

    bdAgua a1 = new bdAgua();

    Eletrecidade e2 = new Eletrecidade();

    bdEletrecidade e1 = new bdEletrecidade();

    gas g2 = new gas();

    bdGas g1 = new bdGas();

    ArrayList<Object> listaValoresAgua = new ArrayList();

    ArrayList<Object> listaValoresEletrecidade = new ArrayList();

    ArrayList<Object> listaValoresGas = new ArrayList();

    @FXML
    private AreaChart<?, ?> ChartsAll;
    @FXML
    private Label MediaAgua;
    @FXML
    private Label MediaEletrecidade;
    @FXML
    private Label MediaGas;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        grafico();

        //Media da todos valores de cada categarias ex(Eletrecidade, Água, Gas)
        MediaAgua.setText(String.format("R$ %.2f", a2.mediaConsumo()));

        MediaEletrecidade.setText(String.format("R$ %.2f", e2.mediaConsumo()));

        MediaGas.setText(String.format("R$ %.2f", g2.mediaConsumo()));
    }

    //Grafico
    public void grafico() {
        //Limpa o Grafico
        ChartsAll.getData().clear();

        //Grafico - Água (Adiciona os Meses e os valores no grafico)
        XYChart.Series Agua = new XYChart.Series();
        Agua.setName("Agua");
        listaValoresAgua = a1.select();
        for (int i = 0; i < listaValoresAgua.size(); i++) {
            if (i % 2 == 0) {
                Agua.getData().add(new XYChart.Data(listaValoresAgua.get(i), listaValoresAgua.get(i + 1)));
            }
        }

        //Grafico - Eletrecidade (Adiciona os Meses e os valores no grafico)
        XYChart.Series Eletrecidade = new XYChart.Series();
        Eletrecidade.setName("Eletrecidade");
        listaValoresEletrecidade = e1.select();
        for (int i = 0; i < listaValoresEletrecidade.size(); i++) {
            if (i % 2 == 0) {
                Eletrecidade.getData().add(new XYChart.Data(listaValoresEletrecidade.get(i), listaValoresEletrecidade.get(i + 1)));
            }
        }

        //Grafico - Gás (Adiciona os Meses e os valores no grafico)
        XYChart.Series Gas = new XYChart.Series();
        Gas.setName("Gas");
        listaValoresGas = g1.select();
        for (int i = 0; i < listaValoresGas.size(); i++) {
            if (i % 2 == 0) {
                Gas.getData().add(new XYChart.Data(listaValoresGas.get(i), listaValoresGas.get(i + 1)));
            }
        }

        ChartsAll.getData().addAll(Agua, Eletrecidade, Gas);
    }
}
