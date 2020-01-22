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

        if (this.radius == 0) {       //  Проверка на то, заполнено ли поле для ввода
            return;                   //  Значение радиуса обязательно должно быть целым числом
        }                             //  Отрицательное число будет преобразовано в положительное

        System.out.println("\nStar Draw !!!");

        System.out.println("Radius  => " + radius);


        Pane group = new Pane();

        primaryStage.setTitle(" Star ");

        Scene scene = new Scene(group,600,500);
        primaryStage.setScene(scene);


   // /*  Тестовый код

        Circle circle = new Circle();
        circle.setCenterX(250);
        circle.setCenterY(150);
        circle.setRadius(100);
        circle.setFill(Color.RED);
        group.getChildren().addAll(circle);

   // */




        primaryStage.show();


    }



}

