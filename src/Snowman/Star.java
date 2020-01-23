package Snowman;

import javafx.scene.Scene;
import javafx.scene.control.TextField;
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

        if (this.radius == 0) {       //  Проверка на то, заполнено ли поле для ввода.
            return;                   //  Значение радиуса обязательно должно быть целым числом
        }                             //  Отрицательное число будет преобразовано в положительное

        System.out.println("\nStar !");

        System.out.println("Радиус звезды  => " + radius);


        Pane group = new Pane();

        primaryStage.setTitle(" Star ");

        Scene scene = new Scene(group,600,500);
        primaryStage.setScene(scene);


   // /*  Тестовый код

        Circle circle = new Circle();
        circle.setCenterX(250);
        circle.setCenterY(150);
        circle.setRadius(100);

        circle.setStroke(Color.color(Snowman.randomColor()[0], Snowman.randomColor()[1], Snowman.randomColor()[2]));
        circle.setFill(Color.WHITE);

        group.getChildren().addAll(circle);

        Circle circle2 = new Circle();
        circle2.setCenterX(250);
        circle2.setCenterY(150);
        circle2.setRadius(50);

        circle2.setStroke(Color.color(Snowman.randomColor()[0], Snowman.randomColor()[1], Snowman.randomColor()[2]));
        circle2.setFill(Color.RED);

        group.getChildren().addAll(circle2);



   // */




        primaryStage.show();


    }



}

