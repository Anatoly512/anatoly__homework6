package Snowman;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;

public class Star extends BorderPane {

private Integer radius;

private Button randomColor;
private Button randomBorderColor;
private Button returnToMenu;

Star () {
    this.randomColor = new Button("Случайный цвет");
    this.randomBorderColor = new Button(" Только контур  ");;
    this.returnToMenu = new Button("Вернуться в меню");
    checkingForReasonableValues();
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

        DropShadow dropShadow = new DropShadow();
        dropShadow.setRadius(9.0);
        dropShadow.setOffsetX(3.0);
        dropShadow.setOffsetY(3.0);
        dropShadow.setColor(Color.color(0.2, 0.2, 0.3));
        returnToMenu.setEffect(dropShadow);
        randomColor.setEffect(dropShadow);
        randomBorderColor.setEffect(dropShadow);

        randomColor.setOnAction(e -> {
            for (Node node : group.getChildren()) {             //  Закрасить все ноды которые являются фигурами
                if (node instanceof Shape) {
                    double[] randomColor = new double [3];       //  Чтобы цвет заливки и цвет контура был одинаковым
                    randomColor[0] = Snowman.randomColor()[0];
                    randomColor[1] = Snowman.randomColor()[1];
                    randomColor[2] = Snowman.randomColor()[2];
                    ((Shape) node).setFill(Color.color(randomColor[0], randomColor[1], randomColor[2]));
                    ((Shape) node).setStroke(Color.color(randomColor[0], randomColor[1], randomColor[2]));
                }
            }
        });


        randomBorderColor.setOnAction(e -> {
            for (Node node : group.getChildren()) {             //  Выбрать только те ноды которые являются фигурами
                if (node instanceof Shape) {
                    ((Shape) node).setStroke(Color.color(Snowman.randomColor()[0], Snowman.randomColor()[1], Snowman.randomColor()[2]));
                    ((Shape) node).setFill(Color.WHITE);
                }
            }
        });


        returnToMenu.setOnAction(e -> {
            ChooseMenu chooseSceneMenu = new ChooseMenu();        //  Добавить кнопку "Возврат в меню"
            chooseSceneMenu.StartScene(primaryStage);
        });



        double centerX;
        double centerY;
        double innerRadius;
        double outerRadius;
        int numRays;
        double startAngleR;    //  Угол поворота звезды

        centerX = 300;
        centerY = 250;
        innerRadius = 70;
        outerRadius = 150;
        numRays = 8;
        startAngleR = 120;    //  Угол поворота звезды

        path = (Path) drawPathForStar(centerX, centerY, innerRadius, outerRadius, numRays, startAngleR);


        path.setStroke(Color.RED);
        path.setStrokeWidth(5);


        VBox vbox = new VBox();

        vbox.getChildren().addAll(randomColor, randomBorderColor);

        group.setCenter(path);
        group.setRight(returnToMenu);
        group.setBottom(vbox);


        primaryStage.show();

    }



    public Shape drawPathForStar(double x, double y,
                                  double innerRadius, double outerRadius, int numRays,
                                  double startAngleR)
    {
        double deltaAngleR = Math.PI / numRays;
        Path path = new Path();

        for (int i = 0; i < numRays * 2 + 1; i++)    //  на 1 итерацию больше, чтобы при выходе из цикла не передавать close в path
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



    private void checkingForReasonableValues () {



    }


}

