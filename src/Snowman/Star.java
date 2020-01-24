package Snowman;

import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;

public class Star extends BorderPane {

private Integer radius;

Star () {
}


    public void drawStar (Stage primaryStage, TextField Radius) {

        IntegerConvertor integerConvertor = new IntegerConvertor();
        this.radius = integerConvertor.convertTextToInteger(primaryStage, Radius);

        if (this.radius == 0) {       //  Проверка на то, заполнены ли поля для ввода.
            return;                   //  Значения обязательно должны быть целыми числами.
        }                             //  Отрицательные числа будет преобразованы в положительные.

        System.out.println("\nStar !");

        System.out.println("Радиус звезды  => " + radius);


        BorderPane group = new BorderPane();

        primaryStage.setTitle(" Star ");

        Scene scene = new Scene(group,800,600);
        primaryStage.setScene(scene);

     //
     //   ((Group) scene.getRoot()).getChildren().add(root);    //  Добавить в группу
     //



        Path path = new Path();

 /*
        MoveTo moveTo = new MoveTo(108, 71);

        LineTo line1 = new LineTo(321, 161);
        LineTo line2 = new LineTo(126,232);
        LineTo line3 = new LineTo(232,52);
        LineTo line4 = new LineTo(269, 250);
        LineTo line5 = new LineTo(108, 71);


        path.getElements().add(moveTo);
        path.getElements().addAll(line1, line2, line3, line4, line5);


        path.setStroke(Color.BLUE);
        path.setStrokeWidth(5);

        group.getChildren().add(path);

  */

        double centerX;
        double centerY;
        double innerRadius;
        double outerRadius;
        int numRays;
        double startAngleR;    //  Угол поворота звезды

        centerX = 300;
        centerY = 250;
        innerRadius = 50;
        outerRadius = 100;
        numRays = 12;
        startAngleR = 0;

        path = (Path) drawStar(centerX, centerY, innerRadius, outerRadius, numRays, startAngleR);


        path.setStroke(Color.BLUE);
        path.setStrokeWidth(5);

        group.getChildren().add(path);




        primaryStage.show();

    }



    public Shape drawStar(double x, double y,
                                  double innerRadius, double outerRadius, int numRays,
                                  double startAngleR)
    {
        double deltaAngleR = Math.PI / numRays;
        Path path = new Path();

        for (int i = 0; i < numRays * 2 + 1; i++)
        {
            double angleR = startAngleR + i * deltaAngleR;
            double ca = Math.cos(angleR);
            double sa = Math.sin(angleR);
            double relX = ca;
            double relY = sa;
            if ((i & 1) == 0)
            {
                relX *= outerRadius;
                relY *= outerRadius;
            }
            else
            {
                relX *= innerRadius;
                relY *= innerRadius;
            }
            if (i == 0)
            {
                MoveTo moveTo = new MoveTo(x + relX, y + relY);
                path.getElements().add(moveTo);

            }
            else
            {
                LineTo line = new LineTo(x + relX, y + relY);
                path.getElements().add(line);

            }
        }

        return path;
    }


}

