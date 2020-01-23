package Snowman;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

public class Snowman extends GridPane {

private Button fillCirclesColourRed;
private Button fillCirclesColourBlue;
private Button gradientGrey;
private Button drawStar;
private Integer amountOfCircles;
private Integer minCircleRadius;
private Integer maxCircleRadius;

Snowman (Integer amountOfCircles, Integer minCircleRadius, Integer maxCircleRadius)  {
    this.amountOfCircles = amountOfCircles;
    this.minCircleRadius = minCircleRadius;
    this.maxCircleRadius = maxCircleRadius;

    this.fillCirclesColourRed = new Button("Залить красным");
    this.fillCirclesColourBlue = new Button("Залить синим");
    this.gradientGrey = new Button("Градиент");
    this.drawStar = new Button("Нарисовать звезду");
}

    public void drawSnowman (Stage stage) {

        System.out.println("\nSnowman !");

        System.out.println("Количество кругов  =>  " + amountOfCircles);
        System.out.println("Минимальный радиус круга   =>  " + minCircleRadius);
        System.out.println("Максимальный радиус круга  =>  " + maxCircleRadius);


        GridPane group = new GridPane();

        stage.setTitle(" Snowman ");

        Scene scene = new Scene(group,880,600);
        stage.setScene(scene);

        DropShadow dropShadow = new DropShadow();
        dropShadow.setRadius(9.0);
        dropShadow.setOffsetX(3.0);
        dropShadow.setOffsetY(3.0);
        dropShadow.setColor(Color.color(0.2, 0.2, 0.3));
        fillCirclesColourRed.setEffect(dropShadow);
        fillCirclesColourBlue.setEffect(dropShadow);
        gradientGrey.setEffect(dropShadow);

        DropShadow dropShadow2 = new DropShadow();
        dropShadow2.setRadius(10.0);
        dropShadow2.setOffsetX(8.0);
        dropShadow2.setOffsetY(8.0);
        dropShadow2.setColor(Color.color(0.1, 0.8, 0.9));
        drawStar.setEffect(dropShadow2);

        drawStar.setOnAction(e -> {
            CreateStar star = new CreateStar();              //  Нарисовать звезду  (открывается соответствующая сцена)
            star.Star(stage);
        });

        fillCirclesColourRed.setOnAction(e -> {
            for (Node node : group.getChildren()) {            //  Закрасить все ноды которые являются фигурами
                if (node instanceof Shape) {                   // (т.е. наследуются от класса Shape)
                    ((Shape) node).setFill(Color.RED);
                }
            }
        });

        fillCirclesColourBlue.setOnAction(e -> {
            for (Node node : group.getChildren()) {           //  Закрасить все ноды которые являются фигурами
                if (node instanceof Shape) {                  // (т.е. наследуются от класса Shape)
                    ((Shape) node).setFill(Color.BLUE);
                }
            }
        });


   //  Собственно создание снеговика

        int x = 200;                      //  Подготовка начальных координат для головы снеговика
        int y = 200;
        int radius = 150;

        Circle circle = new Circle();      //  Создание первого круга (головы снеговика)
        circle.setCenterX(x);
        circle.setCenterY(y);
        circle.setRadius(radius);
        circle.setStroke(Color.BLACK);
        circle.setFill(Color.WHITE);

        Shape snowman = Shape.union(circle, circle);
        snowman.setStroke(Color.BLACK);
        snowman.setFill(Color.WHITE);

        gradientGrey.setOnAction(e -> {        //  Добавить кнопку градиента  (фигура <snowman> уже создана)
            snowman.setFill(Color.GOLD);
        });

        for (int i = 0; i < amountOfCircles; i++) {
           int circleX = x;                           //  Это чтобы сохранить первоначальные координаты первого круга (как бы головы снеговика),
           int circleY = y;                           //  так как в его границах там еще три дополнительных круга (глаза и нос) прорисовывать
           int circleR = radius;                      //  и нужно помнить где, и в пределах какого радиуса.


        }


        group.add(snowman, 0, 0);
        group.add(fillCirclesColourRed, 1,1);
        group.add(fillCirclesColourBlue, 1,2);
        group.add(gradientGrey, 1,4);
        group.add(drawStar, 2, 8);



     //  Расположение элементов В одну строку

     //   group.addRow(0, snowmanShape);
     //   group.addRow(1, fillCirclesColourRed);
     //   group.addRow(2, fillCirclesColourBlue);
     //   group.addRow(3, gradientGrey);
     //   group.addRow(4, drawStar);


        stage.centerOnScreen();

        stage.show();

    }

}

