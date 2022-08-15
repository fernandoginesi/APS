package aps.Interface.controller.Integracao;

import aps.Interface.Models.CategoriaAno;
import aps.banco.bdEletrecidade;
import aps.eletrecidade.Eletrecidade;
import com.jfoenix.controls.JFXComboBox;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;

public class GraficoEletrecidadeController implements Initializable {

    Eletrecidade e2 = new Eletrecidade();

    bdEletrecidade e1 = new bdEletrecidade();

    ArrayList<Object> listaValores = new ArrayList();

    private List<CategoriaAno> CategoriaAno = new ArrayList<>();

    private ObservableList<CategoriaAno> ObsCategoriaAno;
    @FXML
    private JFXComboBox<CategoriaAno> CategoriaAnos;
    @FXML
    private AreaChart<?, ?> ChartsAgua;
    @FXML
    private Label media;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listaValores = e1.select();

        grafico();
        CarregarCategoraAno();

        //Insere a media dos meses no campo correspondente
        media.setText(String.format("R$ %.2f", e2.mediaConsumo()));
    }

    public void grafico() {
        ChartsAgua.getData().clear();

        XYChart.Series Eletrecidade = new XYChart.Series();
        listaValores = e1.select();
        for (int i = 0; i < listaValores.size(); i++) {
            if (i % 2 == 0) {
                Eletrecidade.getData().add(new XYChart.Data(listaValores.get(i), listaValores.get(i + 1)));
            }
        }
        ChartsAgua.getData().addAll(Eletrecidade);
    }

    public void CarregarCategoraAno() {
        CategoriaAno categoriaAno1 = new CategoriaAno("2000");
        CategoriaAno categoriaAno2 = new CategoriaAno("2001");
        CategoriaAno categoriaAno3 = new CategoriaAno("2002");
        CategoriaAno categoriaAno4 = new CategoriaAno("2003");
        CategoriaAno categoriaAno5 = new CategoriaAno("2004");
        CategoriaAno categoriaAno6 = new CategoriaAno("2005");
        CategoriaAno categoriaAno7 = new CategoriaAno("2006");
        CategoriaAno categoriaAno8 = new CategoriaAno("2007");
        CategoriaAno categoriaAno9 = new CategoriaAno("2008");
        CategoriaAno categoriaAno10 = new CategoriaAno("2009");
        CategoriaAno categoriaAno11 = new CategoriaAno("2010");
        CategoriaAno categoriaAno12 = new CategoriaAno("2011");
        CategoriaAno categoriaAno13 = new CategoriaAno("2012");
        CategoriaAno categoriaAno14 = new CategoriaAno("2013");
        CategoriaAno categoriaAno15 = new CategoriaAno("2014");
        CategoriaAno categoriaAno16 = new CategoriaAno("2015");
        CategoriaAno categoriaAno17 = new CategoriaAno("2016");
        CategoriaAno categoriaAno18 = new CategoriaAno("2017");
        CategoriaAno categoriaAno19 = new CategoriaAno("2018");
        CategoriaAno categoriaAno20 = new CategoriaAno("2019");
        CategoriaAno categoriaAno21 = new CategoriaAno("2020");
        CategoriaAno categoriaAno22 = new CategoriaAno("2021");

        CategoriaAno.add(categoriaAno1);
        CategoriaAno.add(categoriaAno2);
        CategoriaAno.add(categoriaAno3);
        CategoriaAno.add(categoriaAno4);
        CategoriaAno.add(categoriaAno5);
        CategoriaAno.add(categoriaAno6);
        CategoriaAno.add(categoriaAno7);
        CategoriaAno.add(categoriaAno8);
        CategoriaAno.add(categoriaAno9);
        CategoriaAno.add(categoriaAno10);
        CategoriaAno.add(categoriaAno11);
        CategoriaAno.add(categoriaAno12);
        CategoriaAno.add(categoriaAno13);
        CategoriaAno.add(categoriaAno14);
        CategoriaAno.add(categoriaAno15);
        CategoriaAno.add(categoriaAno16);
        CategoriaAno.add(categoriaAno17);
        CategoriaAno.add(categoriaAno18);
        CategoriaAno.add(categoriaAno19);
        CategoriaAno.add(categoriaAno20);
        CategoriaAno.add(categoriaAno21);
        CategoriaAno.add(categoriaAno22);

        ObsCategoriaAno = FXCollections.observableArrayList(CategoriaAno);

        CategoriaAnos.setItems(ObsCategoriaAno);
    }
}
