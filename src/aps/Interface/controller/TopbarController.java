package aps.Interface.controller;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import aps.Interface.main.main;

public class TopbarController implements Initializable {

    @FXML
    private FontAwesomeIconView minus;
    @FXML
    private FontAwesomeIconView close;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    //Botão de Minimizar a Interface
    @FXML
    private void minus(MouseEvent event) {
        main.stage.setIconified(true);
    }

    //Botão de Fechar a Interface
    @FXML
    private void close(MouseEvent event) {
        System.exit(0);
    }
}
