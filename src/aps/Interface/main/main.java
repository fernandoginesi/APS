package aps.Interface.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class main extends Application {

    public static Stage stage = null;

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/aps/Interface/windows/main.fxml"));
        stage.getIcons().add(new javafx.scene.image.Image("/aps/Interface/icon/main.png") {
        });

        // Retira a opção de fachar, minimizar e Ampliar
        stage.initStyle(StageStyle.TRANSPARENT);

        Scene scene = new Scene(root);

        scene.setFill(Color.TRANSPARENT);
        stage.setScene(scene);
        this.stage = stage;
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
