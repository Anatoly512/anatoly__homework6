package Snowman;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.*;
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

    checkingForReasonableValues();

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




   //  Создание снеговика

        int firstCircleX = 200;                    //  Подготовка начальных координат для головы снеговика
        int firstCircleY = 200;
        int firstCircleRadius = (int) ((Math.random() * maxCircleRadius + minCircleRadius));


        Circle circle = new Circle();


        AtomicReference<Shape> snowman = new AtomicReference<>(Shape.union(circle, circle));

        gradientGrey.setOnAction(e -> {                            //  Добавить кнопку градиента  (фигура <snowman> уже создана)
            snowman.set(gradientSnowmanGrey(snowman.get()));
        });



        int previousCircleRadius = firstCircleRadius;   //  Это чтобы сохранить первоначальные координаты первого круга (головы снеговика),
        int circleY = firstCircleY;
        int circleRadius;





        for (int i = 0; i < amountOfCircles; i++) {     //  Прорисовка всех кругов

           Circle circleNext = new Circle();

           circleRadius = (int) ((Math.random() * maxCircleRadius + minCircleRadius));

           circleY = circleY + circleRadius + previousCircleRadius + ((int) (circleNext.getStrokeWidth()));

           previousCircleRadius = circleRadius;

           circleNext.setCenterY(circleY);
           circleNext.setCenterX(firstCircleX);    //  Так как ось X для всех кругов одинакова
           circleNext.setRadius(circleRadius);

           circleNext.setStroke(Color.color(randomColor()[0], randomColor()[1], randomColor()[2]));



                Circle circle1 = new Circle();
                circle1.setCenterX(firstCircleX);
                circle1.setCenterY(circleY);
                circle1.setRadius((int) (circleRadius / 4));
                circle1.setStroke(Color.RED);
                circle1.setFill(Color.MAGENTA);

                Shape shipe1 = Shape.union(circle1, circle1);

             //   snowman.set(Shape.union(snowman.get(), shipe1));

                group.getChildren().add(shipe1);



            snowman.set(Shape.union(snowman.get(), circleNext));


        }

        snowman.get().setStroke(Color.color(randomColor()[0], randomColor()[1], randomColor()[2]));
        snowman.get().setFill(Color.WHITE);


        group.add(snowman.get(), 0, 0);
        group.add(fillCirclesColourRed, 1, 0);
        group.add(fillCirclesColourBlue, 2,0);
        group.add(gradientGrey, 3,0);
        group.add(drawStar, 5, 0);






/*


        Circle circle1 = new Circle();

        int x = firstCircleX;
        int y = firstCircleY;

        circle1.setCenterX(x);
        circle1.setCenterY(y);
        circle1.setRadius(10);

        circle1.setStroke(Color.color(randomColor()[0], randomColor()[1], randomColor()[2]));

        group.getChildren().add(circle1);




        Path path = new Path();
        Integer startX = 50;
        Integer startY = 50;
        Integer width = 80;
        Integer height = 40;
        Integer radius = 10;
        Integer triangle = 10;

        MoveTo moveTo = new MoveTo(startX+radius, startY);
        LineTo line1 = new LineTo(startX+width-radius, startY);
        ArcTo arc1 = new ArcTo(radius, radius, 0, startX+width, startY+radius, false, true);
        LineTo line2 = new LineTo(startX+width, startY+height-triangle);
        LineTo line21 = new LineTo(startX+width+triangle, startY+height);
        LineTo line3 = new LineTo(startX+radius, startY+height);
        ArcTo arc3 = new ArcTo(radius, radius, 0, startX, startY+height-radius, false, true);
        LineTo line4 = new LineTo(startX, startY+radius);
        ArcTo arc4 = new ArcTo(radius, radius, 0, startX+radius, startY, false, true);
        path.getElements().add(moveTo);
        path.getElements().addAll(line1, arc1, line2, line21, line3, arc3, line4, arc4);
        path.setFill(Color.BLUE);
        Group root = new Group(path);

        group.getChildren().add(path);

 */




        stage.centerOnScreen();

        stage.show();

    }


    private Shape gradientSnowmanGrey (Shape shape) {

       LinearGradient lg = new LinearGradient(0, 1, 0, 0, true, CycleMethod.NO_CYCLE, new Stop(0, Color.BLACK), new Stop(1, Color.WHITE));

        shape.setFill(lg);
        shape.setStroke(Color.GREY);

        return shape;
    }


    public static double[] randomColor() {

        double[] randomColor = new double [3];  // rgb colours

        randomColor[0] = Math.random();
        randomColor[1] = Math.random();
        randomColor[2] = Math.random();

        return randomColor;
    }


    private void checkingForReasonableValues () {

        if (this.amountOfCircles > 100) {this.amountOfCircles = 100;}        //  не в человеческих возможностях строить такие снеговики  :)

        if (this.maxCircleRadius < 2) {this.maxCircleRadius = 2;}   //  т.к. минимальное значение должно быть одновременно и меньше, и хотя бы единицей

        if ((this.amountOfCircles <= 5) && (this.minCircleRadius < 20) && (this.maxCircleRadius > 100)) {    //  зачем нам снеговик который не влезает в экран? :)
            this.maxCircleRadius = 100;}    //  теперь должен поместиться
        if ((this.amountOfCircles <= 5) && (this.minCircleRadius >= 20) && (this.minCircleRadius <= 50) && (this.maxCircleRadius > 80)) {
            this.maxCircleRadius = 80;}
        if ((this.amountOfCircles <= 5) && (this.minCircleRadius > 50) && (this.minCircleRadius < 70) && (this.maxCircleRadius > 70)) {
            this.maxCircleRadius = 70;} else {this.maxCircleRadius = 72;}


        //  Процесс утрамбовки снеговика в экран
        if ((this.amountOfCircles > 5)  &&  (this.amountOfCircles <= 10) && (this.maxCircleRadius > 35))  {this.maxCircleRadius = 35;}
        if ((this.amountOfCircles > 10)  &&  (this.amountOfCircles <= 20) && (this.maxCircleRadius > 18))  {this.maxCircleRadius = 18;}
        if ((this.amountOfCircles > 20)  &&  (this.amountOfCircles <= 50) && (this.maxCircleRadius > 8))  {this.maxCircleRadius = 8;}
        if ((this.amountOfCircles > 50)  &&  (this.amountOfCircles <= 80) && (this.maxCircleRadius > 5))  {this.maxCircleRadius = 5;}
        if ((this.amountOfCircles > 80)  &&  (this.amountOfCircles <= 100) && (this.maxCircleRadius > 4))  {this.maxCircleRadius = 4;}


        //  Минимальный радиус должен быть хоть на чуть-чуть, но меньше максимального (а максимальный не может быть меньше 2)
        if (this.minCircleRadius >= this.maxCircleRadius)  {this.minCircleRadius = (this.maxCircleRadius - 1);}

    }


}

