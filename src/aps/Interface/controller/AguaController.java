package aps.Interface.controller;

import aps.Interface.Models.CategoriaMes;
import aps.agua.Agua;
import aps.banco.bdAgua;
import java.util.List;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

public class AguaController implements Initializable {

    boolean flag = true;

    Agua a2 = new Agua();

    bdAgua a1 = new bdAgua();

    ArrayList<Object> listaValores = new ArrayList();

    private List<CategoriaMes> CategoriaMes = new ArrayList<>();

    private ObservableList<CategoriaMes> ObsCategoriaMes;
    @FXML
    private JFXComboBox<CategoriaMes> Categoria;
    @FXML
    private BorderPane BorderGrafico;
    @FXML
    private JFXTextField text_ValorMensal;
    @FXML
    private JFXTextField quantLitros;
    @FXML
    private Label LabelResult;
    @FXML
    private Label esgotoResult;
    @FXML
    private Label aguaResult;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        //grafico();
        CarregarCategoraMes();

        grafico();

        //Botão que realiza ação correspondente
        text_ValorMensal.setOnAction((ActionEvent event) -> {

            //Campo a onde o usuario escolhe os meses que deseja inserir
            CategoriaMes catMes = Categoria.getSelectionModel().getSelectedItem();

            //Adiciona o dados Recebidos na Banco de Dados
            a1.insert(catMes.getMes(), Double.valueOf(text_ValorMensal.getText()));

            grafico();
        });

        //Botão que realiza ação correspondente
        quantLitros.setOnAction((ActionEvent event) -> {

            //Campo a onde o usuario insere a quantidade de litros de agua gasto
            LabelResult.setText(String.format("R$ %.2f", a2.calcConsumo(Integer.valueOf(quantLitros.getText()))));

            //Insere o valor do esgoto no campo correspondente
            esgotoResult.setText(String.format("R$ %.2f", a2.getValorEsgoto()));

            //Insere o valor da Agua(Sem tarifa) no campo correspondente
            aguaResult.setText(String.format("R$ %.2f", a2.getValorAgua()));
        });
    }

    //Grafico (Adiciona os Meses e os valores no grafico)
    public void grafico() {
        try {
            Parent Grafico = FXMLLoader.load(getClass().getResource("/aps/Interface/windows/Integracao/Grafico-Agua.fxml"));

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
