package Snowman;

import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Star extends Pane {

private Integer radius;

Star () {
}


    public void drawStar (Stage primaryStage, TextField Radius) {

        IntegerConvertor integerConvertor = new IntegerConvertor();
        this.radius = integerConvertor.convertTextToInteger(primaryStage, Radius);

        System.out.println("\nStar Draw !!!");

        System.out.println("Radius  => " + radius);


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

     // */


    }



}

