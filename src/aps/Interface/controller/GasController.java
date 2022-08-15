package aps.Interface.controller;

import aps.Interface.Models.CategoriaMes;
import aps.banco.bdGas;
import aps.gas.gas;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class GasController implements Initializable {

    ArrayList<Object> listaValores = new ArrayList();

    gas g2 = new gas();

    bdGas g1 = new bdGas();

    boolean flag = true;

    private List<CategoriaMes> CategoriaMes = new ArrayList<>();

    private ObservableList<CategoriaMes> ObsCategoriaMes;

    @FXML
    private JFXComboBox<CategoriaMes> Categoria;
    @FXML
    private JFXTextField text_ValorMensal;
    @FXML
    private Label LabelResultMs;
    @FXML
    private Pane PaneMain_ConsGsB;
    @FXML
    private Pane PaneMain_ConsGsE;
    @FXML
    private JFXRadioButton RadioSim;
    @FXML
    private JFXRadioButton RadioNao;
    @FXML
    private JFXTextField gasB;
    @FXML
    private JFXTextField horasGB;
    @FXML
    private JFXTextField gasE;
    @FXML
    private JFXTextField horasGE;
    @FXML
    private Label LabelResultConsgas;
    @FXML
    private BorderPane BorderGrafico;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listaValores = g1.select();

        grafico();

        CarregarCategoraMes();

        RadioButtonSim();
        PaneMain_ConsGsB.setDisable(true);

        RadioButtonNao();
        PaneMain_ConsGsE.setDisable(true);

        //Botão que realiza ação correspondente
        text_ValorMensal.setOnAction((ActionEvent event) -> {

            //Campo a onde o usuario escolhe os meses que deseja inserir
            CategoriaMes catMes = Categoria.getSelectionModel().getSelectedItem();

            //Adiciona o dados Recebidos na Banco de Dados
            g1.insert(catMes.getMes(), Double.valueOf(text_ValorMensal.getText()));

            grafico();
        });

        //Botão que realiza ação correspondente
        gasE.setOnAction((ActionEvent e) -> {
            //Insere o valor do calculo do consumo de gás encanado no campo correspondente
            LabelResultConsgas.setText(String.format("R$ %.2f", g2.calcConsumoGas(Double.valueOf(gasE.getText()), 0, true)));
        });

        //Botão que realiza ação correspondente
        horasGB.setOnAction((ActionEvent e) -> {
            //Insere o valor do calculo do consumo de gas de Butijão no campo correspondente
            LabelResultConsgas.setText(String.format("R$ %.2f", g2.calcConsumoGas(Double.valueOf(gasB.getText()), Double.valueOf(horasGB.getText()), false)));
        });
    }

    //Metodo que habilita a opção de Gás encanado por meio de um radio-Buttun
    public void RadioButtonSim() {
        RadioSim.setOnAction((ActionEvent event) -> {
            PaneMain_ConsGsB.setDisable(true);
            PaneMain_ConsGsE.setDisable(true);

            if (RadioSim.isSelected()) {
                PaneMain_ConsGsE.setDisable(false);
                horasGE.setDisable(true);
            } else {
                PaneMain_ConsGsB.setDisable(true);
                PaneMain_ConsGsE.setDisable(true);
            }
        });
    }

    //Metodo que desabilita a opção de Gás encanado por meio de um radio-Buttun / Habilita o Gás de Butijão
    public void RadioButtonNao() {
        RadioNao.setOnAction((ActionEvent event) -> {
            PaneMain_ConsGsB.setDisable(true);
            PaneMain_ConsGsE.setDisable(true);

            if (RadioNao.isSelected()) {
                PaneMain_ConsGsB.setDisable(false);
            } else {
                PaneMain_ConsGsB.setDisable(true);
                PaneMain_ConsGsE.setDisable(true);
            }
        });
    }

    //Grafico (Adiciona os Meses e os valores no grafico)
    public void grafico() {
        try {
            Parent Grafico = FXMLLoader.load(getClass().getResource("/aps/Interface/windows/Integracao/Grafico-Gas.fxml"));

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
}
