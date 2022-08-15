package aps.Interface.controller;

import aps.Interface.Models.CategoriaAno;
import aps.Interface.Models.CategoriaMes;
import aps.eletrecidade.Eletrecidade;
import aps.banco.bdEletrecidade;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

public class EletrecidadeController implements Initializable {

    ArrayList<Object> listaValores = new ArrayList();

    Eletrecidade e2 = new Eletrecidade();

    bdEletrecidade e1 = new bdEletrecidade();

    mainController m1 = new mainController();

    boolean flag = true;

    private List<CategoriaMes> CategoriaMes = new ArrayList<>();

    private ObservableList<CategoriaMes> ObsCategoriaMes;
    @FXML
    private JFXComboBox<CategoriaMes> Categoria;

    private List<CategoriaAno> CategoriaAno = new ArrayList<>();

    private ObservableList<CategoriaAno> ObsCategoriaAno;
    @FXML
    private JFXComboBox<CategoriaAno> CategoriaAnos;
    @FXML
    private JFXTextField text_ValorMensal;
    @FXML
    private JFXTextField horas;
    @FXML
    private JFXTextField dias;
    @FXML
    private JFXTextField tarifa;
    @FXML
    private JFXTextField watts;
    @FXML
    private Label LabelResultAp;
    @FXML
    private JFXTextField wattsEn;
    @FXML
    private JFXTextField horasEn;
    @FXML
    private JFXTextField diasEn;
    @FXML
    private Label LabelResultMs;
    @FXML
    private BorderPane BorderGrafico;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listaValores = e1.select();

        CarregarCategoraMes();
        CarregarCategoraAno();

        grafico();

        //Botão que realiza ação correspondente
        text_ValorMensal.setOnAction((ActionEvent event) -> {

            //Campo a onde o usuario escolhe os meses que deseja inserir
            CategoriaMes catMes = Categoria.getSelectionModel().getSelectedItem();

            //Adiciona o dados Recebidos na Banco de Dados
            e1.insert(catMes.getMes(), Double.valueOf(text_ValorMensal.getText()));

            grafico();
        });

        //Insere a media de uma aparelho no campo correspondente
        tarifa.setOnAction((ActionEvent event) -> {
            LabelResultMs.setText(String.format("R$ %.2f", e2.calcConsumo(Integer.valueOf(watts.getText()), Integer.valueOf(horas.getText()), Integer.valueOf(dias.getText()), Double.valueOf(tarifa.getText()))));
        });

        //Insere o consumo da Eletrecidade no campo correspondente
        diasEn.setOnAction((ActionEvent event) -> {
            LabelResultAp.setText("kWh: " + String.valueOf(e2.calcConsumo(Integer.valueOf(wattsEn.getText()), Integer.valueOf(horasEn.getText()), Integer.valueOf(diasEn.getText()), 1)));
        });
    }

    //Grafico (Adiciona os Meses e os valores no grafico)
    public void grafico() {
        try {
            Parent Grafico = FXMLLoader.load(getClass().getResource("/aps/Interface/windows/Integracao/Grafico-Eletrecidade.fxml"));

            BorderGrafico.setCenter(Grafico);
        } catch (IOException exemplo) {
            System.out.println("Deu erro meu chapa");
        }
    }

    //Combo-Box (meses)
    public void CarregarCategoraMes() {
        CategoriaMes categoriaMes1 = new CategoriaMes("Janeiro");
        CategoriaMes categoriaMes2 = new CategoriaMes("Fevereiro");
        CategoriaMes categoriaMes3 = new CategoriaMes("Março");
        CategoriaMes categoriaMes4 = new CategoriaMes("Abril");
        CategoriaMes categoriaMes5 = new CategoriaMes("Maio");
        CategoriaMes categoriaMes6 = new CategoriaMes("Junho");
        CategoriaMes categoriaMes7 = new CategoriaMes("Julho");
        CategoriaMes categoriaMes8 = new CategoriaMes("Agosto");
        CategoriaMes categoriaMes9 = new CategoriaMes("Setembro");
        CategoriaMes categoriaMes10 = new CategoriaMes("Outubro");
        CategoriaMes categoriaMes11 = new CategoriaMes("Novembro");
        CategoriaMes categoriaMes12 = new CategoriaMes("Dezembro");

        CategoriaMes.add(categoriaMes1);
        CategoriaMes.add(categoriaMes2);
        CategoriaMes.add(categoriaMes3);
        CategoriaMes.add(categoriaMes4);
        CategoriaMes.add(categoriaMes5);
        CategoriaMes.add(categoriaMes6);
        CategoriaMes.add(categoriaMes7);
        CategoriaMes.add(categoriaMes8);
        CategoriaMes.add(categoriaMes9);
        CategoriaMes.add(categoriaMes10);
        CategoriaMes.add(categoriaMes11);
        CategoriaMes.add(categoriaMes12);

        ObsCategoriaMes = FXCollections.observableArrayList(CategoriaMes);

        Categoria.setItems(ObsCategoriaMes);
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
