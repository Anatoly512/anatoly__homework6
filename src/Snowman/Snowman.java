package Snowman;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

import java.util.concurrent.atomic.AtomicReference;

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
    this.maxCircleRadius = maxCircleRadius;
    this.minCircleRadius = minCircleRadius;

    checkingForAllowableValues();

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

        Scene scene = new Scene(group,880,620);
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
            CreateStar star = new CreateStar();                //  Добавить кнопку "Нарисовать звезду"
            star.Star(stage);                                  //  (открывается соответствующая сцена)
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

        int firstCircleX = 200;                    //  Подготовка начальных координат для головы снеговика
        int firstCircleY = 200;
        int firstCircleRadius = 250;

        Circle circle = new Circle();              //  Создание первого круга (головы снеговика)
        circle.setCenterX(firstCircleX);
        circle.setCenterY(firstCircleY);
        circle.setRadius(firstCircleRadius);
        circle.setStroke(Color.BLACK);
        circle.setFill(Color.WHITE);


        AtomicReference<Shape> snowman = new AtomicReference<>(Shape.union(circle, circle));    //  тогда в кнопке "gradientGrey" можно изменять объект
        snowman.get().setStroke(Color.BLACK);
        snowman.get().setFill(Color.WHITE);

        gradientGrey.setOnAction(e -> {                            //  Добавить кнопку градиента  (фигура <snowman> уже создана)
            snowman.set(gradientSnowmanGrey(snowman.get()));      //  В таком виде лямбда-выражение позволяет изменять объект
        });


        int previousCircleRadius = firstCircleRadius;   //  Это чтобы сохранить первоначальные координаты первого круга (как бы головы снеговика),
        int circleY = firstCircleY;                     //  так как в его границах будут еще три дополнительных круга (глаза и нос)
        int circleRadius;                               //  и нужно помнить где, и в пределах какого радиуса их рисовать.

        for (int i = 1; i < amountOfCircles; i++) {    //  начало с 1,  так как 1 круг (голова снеговика) уже нарисован

           Circle circleNext = new Circle();

       //  circleRadius = (int) (((Math.random() * maxCircleRadius)) + minCircleRadius);    // ??    Попробовать упростить выражение
           circleRadius = (int) ((Math.random() * maxCircleRadius + minCircleRadius));

           circleY = circleY + circleRadius + previousCircleRadius + ((int) (circle.getStrokeWidth()));   // ??    Попробовать упростить выражение

           previousCircleRadius = circleRadius;

           circleNext.setCenterY(circleY);
           circleNext.setCenterX(firstCircleX);    //  Так как ось X для всех кругов одинакова
           circleNext.setRadius(circleRadius);
           circleNext.setStroke(Color.GREY);
           circleNext.setFill(Color.WHITE);

           snowman.set(Shape.union(snowman.get(), circleNext));

        }

        snowman.get().setStroke(Color.BLACK);
        snowman.get().setFill(Color.WHITE);

        group.add(snowman.get(), 0, 0);
        group.add(fillCirclesColourRed, 1, 0);
        group.add(fillCirclesColourBlue, 2,0);
        group.add(gradientGrey, 3,0);
        group.add(drawStar, 5, 0);


     //  Расположение элементов В одну строку
     //   group.addRow(0, snowmanShape);
     //   group.addRow(1, fillCirclesColourRed);
     //   group.addRow(2, fillCirclesColourBlue);
     //   group.addRow(3, gradientGrey);
     //   group.addRow(4, drawStar);


        stage.centerOnScreen();

        stage.show();

    }


    private Shape gradientSnowmanGrey (Shape shape) {
        shape.setFill(Color.GOLD);
        return shape;
    }


    private void checkingForAllowableValues () {

        if (this.amountOfCircles > 100) {this.amountOfCircles = 100;}        //  не в человеческих возможностях строить такие снеговики  :)

        if (this.maxCircleRadius < 2) {this.maxCircleRadius = 2;}   //  т.к. минимальное значение должно быть одновременно и меньше, и хотя бы единицей

        if ((this.amountOfCircles <= 5) && (this.maxCircleRadius > 120)) {     //  зачем нам снеговик который не влезает в экран? :)
            this.maxCircleRadius = 120;}

        //  Процесс утрамбовки снеговика в экран
        if ((this.amountOfCircles > 5)  &&  (this.amountOfCircles <= 10) && (this.maxCircleRadius > 80))  {this.maxCircleRadius = 80;}
        if ((this.amountOfCircles > 10)  &&  (this.amountOfCircles <= 20) && (this.maxCircleRadius > 50))  {this.maxCircleRadius = 50;}
        if ((this.amountOfCircles > 20)  &&  (this.amountOfCircles <= 50) && (this.maxCircleRadius > 12))  {this.maxCircleRadius = 12;}
        if ((this.amountOfCircles > 50)  &&  (this.amountOfCircles <= 80) && (this.maxCircleRadius > 8))  {this.maxCircleRadius = 8;}
        if ((this.amountOfCircles > 80)  &&  (this.amountOfCircles <= 100) && (this.maxCircleRadius > 6))  {this.maxCircleRadius = 6;}


        //  Минимальный радиус должен быть хоть на чуть-чуть, но меньше максимального (а максимальный не может быть меньше 2)
        if (this.minCircleRadius >= this.maxCircleRadius)  {this.minCircleRadius = (this.maxCircleRadius - 1);}

    }



}

