package Snowman;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Snowman extends GridPane {

private Group snowman;
private Button fillCirclesColour;
private Button gradientGrey;
private Button drawStar;
private Integer amountOfCircles;
private Integer minCircleRadius;
private Integer maxCircleRadius;

Snowman (Integer amountOfCircles, Integer minCircleRadius, Integer maxCircleRadius)  {
    this.amountOfCircles = amountOfCircles;
    this.minCircleRadius = minCircleRadius;
    this.maxCircleRadius = maxCircleRadius;
}

    public void drawSnowman (Stage primaryStage) {

        System.out.println("\nSnowman !");

        System.out.println("AmountOfCircles  =>  " + amountOfCircles);
        System.out.println("minCircleRadius  =>  " + minCircleRadius);
        System.out.println("maxCircleRadius  =>  " + maxCircleRadius);

        GridPane root = new GridPane();
        primaryStage.setScene(new Scene(root, 800, 300));
        primaryStage.setTitle(" Snowball drawing ");
        primaryStage.show();

    }





}
