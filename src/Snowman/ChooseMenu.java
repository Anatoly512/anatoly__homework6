package Snowman;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ChooseMenu {

private Label amountOfCirclesLabel;
private Label maxCircleRadiusLabel;
private Label minCircleRadiusLabel;

private TextField amountOfCircles;
private TextField maxCircleRadius;
private TextField minCircleRadius;

private Button button1;
private Button button2;

public ChooseMenu() {
    this.amountOfCirclesLabel = new Label("Количество кругов : ");
    this.maxCircleRadiusLabel = new Label("максимальный радиус круга : ");
    this.minCircleRadiusLabel  = new Label("минимальный радиус круга : ");

    this.amountOfCircles = new TextField();
    this.maxCircleRadius = new TextField();
    this.minCircleRadius = new TextField();

    this.button1 = new Button(" Снеговик ");
    this.button2 = new Button(" Звезда ");
}

    public GridPane StartScene(Stage primaryStage){

        DropShadow dropShadow1 = new DropShadow();
        dropShadow1.setRadius(5.0);
        dropShadow1.setOffsetX(3.0);
        dropShadow1.setOffsetY(3.0);
        dropShadow1.setColor(Color.color(0.4, 0.5, 0.5));
        button1.setEffect(dropShadow1);

        DropShadow dropShadow2 = new DropShadow();
        dropShadow2.setRadius(12.0);
        dropShadow2.setOffsetX(12.0);
        dropShadow2.setOffsetY(12.0);
        dropShadow2.setColor(Color.color(0.1, 0.8, 0.9));
        button2.setEffect(dropShadow2);

        button1.setOnAction(e -> actionSnowmanButton(primaryStage));
        button2.setOnAction(e -> actionStarButton(primaryStage));
        GridPane root = new GridPane();
        root.addRow(0, amountOfCirclesLabel, amountOfCircles);
        root.addRow(1, minCircleRadiusLabel, minCircleRadius);
        root.addRow(2, maxCircleRadiusLabel, maxCircleRadius);
        root.addRow(3, button1);
        root.addRow(4, button2);
        return root;
    }


    private void actionSnowmanButton(Stage primaryStage) {

        Snowman snowman = new Snowman(amountOfCircles, minCircleRadius, maxCircleRadius);
        snowman.drawSnowman();
        Scene scene = new Scene(snowman, 850, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle(" Snowman ");
        primaryStage.show();

    }


    private void actionStarButton(Stage primaryStage) {

       CreateStar star = new CreateStar();
       star.Star(primaryStage);

    }


}
