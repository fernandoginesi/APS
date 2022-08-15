package aps.Interface.controller;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import aps.Interface.main.main;
import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import aps.Interface.Models.Temporizador;
import java.util.TimerTask;
import javafx.application.Platform;
import javafx.scene.text.Text;

public class mainController extends Temporizador implements Initializable {

    Temporizador t1 = new Temporizador();

    double x = 0;

    double y = 0;

    boolean flag = true;

    boolean Up = true;

    @FXML
    private AnchorPane anchorpane_main;
    @FXML
    private BorderPane borderPane_main;
    @FXML
    private JFXButton btn_agua;
    @FXML
    private JFXButton btn_eletrecidade;
    @FXML
    private Pane PopUp;
    @FXML
    private Text texte;
    @FXML
    private FontAwesomeIconView closePOP;
    @FXML
    private HBox alinhamento;
    @FXML
    private JFXButton btn_home;
    @FXML
    private JFXButton btn_gas;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        //Abre a Tela Correspondente
        if (flag == true) {
            abreInicio();
            flag = true;
        }

        t1.timerOpen();
        temp();

        //Carrega o TopBar Correspondente
        try {
            Parent topbar = FXMLLoader.load(getClass().getResource("/aps/Interface/windows/topbar.fxml"));

            borderPane_main.setTop(topbar);
        } catch (IOException exemplo) {
            System.out.println("Deu erro meu chapa");
        }

        //Abre a Tela Correspondente
        btn_home.setOnAction((ActionEvent event) -> {
            if (flag == true) {
                abreInicio();
                flag = true;
            }
        });

        //Abre a Tela Correspondente
        btn_agua.setOnAction((ActionEvent event) -> {
            if (flag == true) {
                abreAgua();
                flag = true;
            }
        });

        //Abre a Tela Correspondente
        btn_eletrecidade.setOnAction((ActionEvent event) -> {
            if (flag == true) {
                abreEletrecidade();
                flag = true;
            }
        });

        //Abre a Tela Correspondente
        btn_gas.setOnAction((ActionEvent event) -> {
            if (flag == true) {
                abreGas();
                flag = true;
            }
        });
    }

    //movimento de tela
    @FXML
    private void dragged() {
        anchorpane_main.setOnMousePressed((event) -> {
            x = event.getSceneX();
            y = event.getSceneY();
        });
        anchorpane_main.setOnMouseDragged((event) -> {
            main.stage.setX(event.getScreenX() - x);
            main.stage.setY(event.getScreenY() - y);
            main.stage.setOpacity(0.8f);
        });
        anchorpane_main.setOnDragDone((event) -> {
            main.stage.setOpacity(1.0f);
        });
        anchorpane_main.setOnMouseReleased((event) -> {
            main.stage.setOpacity(1.0f);
        });
    }

    //Abre a Tela Correspondente
    public void abreEletrecidade() {
        try {
            Parent Eletrecidade = FXMLLoader.load(getClass().getResource("/aps/Interface/windows/Eletrecidade.fxml"));
            if (flag == true) {
                borderPane_main.setCenter(Eletrecidade);
                flag = false;
            }
        } catch (IOException exemplo) {
            System.out.println("Deu erro meu chapa");
        }
    }

    //Fecha a Tela Correspondente
    public void fechaEletrecidade() {
        try {
            Parent Eletrecidade = FXMLLoader.load(getClass().getResource("/aps/Interface/windows/Eletrecidade.fxml"));
            if (flag == false) {
                borderPane_main.setCenter(null);
                flag = true;
            }

        } catch (IOException exemplo) {
            System.out.println("Deu erro meu chapa");
        }
    }

    //Abre a Tela Correspondente
    public void abreAgua() {
        try {
            Parent Agua = FXMLLoader.load(getClass().getResource("/aps/Interface/windows/Agua.fxml"));
            if (flag == true) {
                borderPane_main.setCenter(Agua);
                flag = false;
            }
        } catch (IOException exemplo) {
            System.out.println("Deu erro meu chapa");
        }
    }

    //Fecha a Tela Correspondente
    public void fechaAgua() {
        try {
            Parent Agua = FXMLLoader.load(getClass().getResource("/aps/Interface/windows/Agua.fxml"));
            if (flag == false) {
                borderPane_main.setCenter(null);
                flag = true;
            }

        } catch (IOException exemplo) {
            System.out.println("Deu erro meu chapa");
        }
    }

    //Abre a Tela Correspondente
    public void abreGas() {
        try {
            Parent Gas = FXMLLoader.load(getClass().getResource("/aps/Interface/windows/Gas.fxml"));
            if (flag == true) {
                borderPane_main.setCenter(Gas);
                flag = false;
            }
        } catch (IOException exemplo) {
            System.out.println("Deu erro meu chapa");
        }
    }

    //Fecha a Tela Correspondente
    public void fechaGas() {
        try {
            Parent Gas = FXMLLoader.load(getClass().getResource("/aps/Interface/windows/Gas.fxml"));
            if (flag == false) {
                borderPane_main.setCenter(null);
                flag = true;
            }

        } catch (IOException exemplo) {
            System.out.println("Deu erro meu chapa");
        }
    }

    //Abre a Tela Correspondente
    public void abreInicio() {
        try {
            Parent Inicio = FXMLLoader.load(getClass().getResource("/aps/Interface/windows/Inicio.fxml"));
            if (flag == true) {
                borderPane_main.setCenter(Inicio);
                flag = false;
            }
        } catch (IOException exemplo) {
            System.out.println("Deu erro meu chapa");
        }
    }

    //Fecha a Tela Correspondente
    public void fechaInicio() {
        try {
            Parent Inicio = FXMLLoader.load(getClass().getResource("/aps/Interface/windows/Inicio.fxml"));
            if (flag == false) {
                borderPane_main.setCenter(null);
                flag = true;
            }

        } catch (IOException exemplo) {
            System.out.println("Deu erro meu chapa");
        }
    }

    //Abre o Temporizador do PopUp
    public void temp() {
        t1.getTimer().schedule(new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {

                        PopUp.setVisible(true);
                        closePOP.setVisible(true);
                        texte.setVisible(true);

                        texte.setText(frases());
                    }
                });
            }
        }, 0, 10000);
    }

    //Minimiza o PopUp
    @FXML
    private void minuspop(MouseEvent event) {

        if (Up == true) {
            t1.timerClose();

            PopUp.setPrefWidth(32);
            PopUp.setPrefHeight(32);
            texte.setVisible(false);

            alinhamento.setAlignment(Pos.CENTER_LEFT);
            closePOP.setVisible(false);

            Up = false;
        } else {
            t1.timerOpen();
            temp();

            PopUp.setPrefWidth(358);
            PopUp.setPrefHeight(202);
            texte.setVisible(true);

            alinhamento.setAlignment(Pos.CENTER_RIGHT);
            closePOP.setVisible(true);

            Up = true;
        }
    }

    //Fecha o PopUp
    @FXML
    private void closepop(MouseEvent event) {

        PopUp.setVisible(false);
        closePOP.setVisible(false);
        texte.setVisible(false);
    }
}
