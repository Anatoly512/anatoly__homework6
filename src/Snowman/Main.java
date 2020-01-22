package Snowman;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        ChooseMenu chooseSceneMenu = new ChooseMenu();
        GridPane root = chooseSceneMenu.StartScene(primaryStage);

        primaryStage.setTitle(" Snowman ");
        primaryStage.setScene(new Scene(root, 800, 300));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
