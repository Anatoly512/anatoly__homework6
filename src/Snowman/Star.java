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

private Button randomColor;
private Button randomBorderColor;
private Button returnToMenu;

double innerRadius;
double outerRadius;
int numRays;
double startAngleR;

Star () {
    this.randomColor = new Button("Случайный цвет");
    this.randomBorderColor = new Button(" Только контур  ");;
    this.returnToMenu = new Button("Вернуться в меню");
}

    public void drawStar (Stage primaryStage, TextField innerRadius, TextField outerRadius,
                          TextField numRays, TextField startAngleR) {

        System.out.println("\nStar !");

        IntegerConvertor integerConvertor = new IntegerConvertor();

        this.innerRadius = (double) integerConvertor.convertTextToInteger(primaryStage, innerRadius);
        this.outerRadius = (double) integerConvertor.convertTextToInteger(primaryStage, outerRadius);
        this.numRays = integerConvertor.convertTextToInteger(primaryStage, numRays);
        this.startAngleR = (double) integerConvertor.convertTextToInteger(primaryStage, startAngleR);

        //  Проверка на то, заполнены ли поля для ввода.
        //  Значения обязательно должны быть целыми числами
        //  Отрицательные числа будет преобразованы в положительные
        if ((this.innerRadius == 0) || (this.outerRadius == 0) || (this.numRays == 0))  {
            return;
        }

        //  Значение угла поворота звезды может быть равным нулю

        checkingForReasonableValues();     //  Проверка введенных значений на диапазон

        System.out.println("Внутренний радиус звезды  => " + innerRadius);


        BorderPane group = new BorderPane();

        primaryStage.setTitle(" Star ");

        Scene scene = new Scene(group,800,600);
        primaryStage.setScene(scene);

     //
     //   ((Group) scene.getRoot()).getChildren().add(root);    //  Добавить в группу  (просто пример)
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


/*    Тестовый фрагмент

        this.centerX = 300;
        this.centerY = 250;
        this.innerRadius = 70;
        this.outerRadius = 150;
        this.numRays = 8;
        this.startAngleR = 120;    //  Угол поворота звезды

 */
        double centerX = 300;    //  Параметры произвольные, так как звезде в <BorderPane> будет установлен статус <Center>
        double centerY = 250;

        path = (Path) drawPathForStar(centerX, centerY, this.innerRadius, this.outerRadius, this.numRays, this.startAngleR);


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

        for (int i = 0; i < numRays * 2 + 1; i++)    //  на 1 итерацию больше, тогда при выходе из цикла можно не передавать close в path
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

