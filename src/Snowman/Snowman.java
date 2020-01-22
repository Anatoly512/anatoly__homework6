package Snowman;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Snowman extends FlowPane {

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


      /*  Тестовый код

        FlowPane group = new FlowPane();
        primaryStage.setTitle("Circle Example");
        Circle circle = new Circle();
        circle.setCenterX(200);
        circle.setCenterY(200);
        circle.setRadius(100);
        circle.setFill(Color.RED);
        group.getChildren().addAll(circle);
        Scene scene = new Scene(group,400,500,Color.BLUE);
        primaryStage.setScene(scene);
        primaryStage.show();

     //  */

    }





}
