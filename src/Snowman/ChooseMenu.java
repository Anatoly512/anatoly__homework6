package Snowman;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ChooseMenu {

private Label amountOfCircles;
private Label maxCircleRadius;
private Label minCircleRadius;

private TextField amountTextField;
private TextField maxTextField;
private TextField minTextField;

private Button button1;
private Button button2;


public ChooseMenu() {
    this.amountOfCircles = new Label("Количество кругов : ");
    this.maxCircleRadius = new Label("максимальный радиус круга : ");
    this.minCircleRadius  = new Label("минимальный радиус круга : ");

    this.amountTextField = new TextField();
    this.maxTextField = new TextField();
    this.minTextField = new TextField();

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

        button1.setOnAction(e -> actionForSnowmanButton(primaryStage));
        button2.setOnAction(e -> actionForStarButton(primaryStage));
        GridPane root = new GridPane();
        root.addRow(0, amountOfCircles, amountTextField);
        root.addRow(1, minCircleRadius, minTextField);
        root.addRow(2, maxCircleRadius, maxTextField);
        root.addRow(3, button1);
        root.addRow(4, button2);
        return root;
    }


    private void actionForSnowmanButton(Stage primaryStage) {
        System.out.println("\nSnowman !");
    }


    private void actionForStarButton(Stage primaryStage) {
        System.out.println("\nStar Draw !!!");
    }


}
