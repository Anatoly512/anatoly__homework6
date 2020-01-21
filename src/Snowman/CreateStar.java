package Snowman;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CreateStar {

private Button buttonStar;
private Label RadiusStarLabel;
private TextField RadiusStar;

CreateStar() {
    this.RadiusStarLabel = new Label("Введите радиус звезды : ");
    this.RadiusStar = new TextField();
    this.buttonStar = new Button("Нарисовать звезду !");
}


public void Star (Stage primaryStage) {

    DropShadow dropShadow = new DropShadow();
    dropShadow.setRadius(12.0);
    dropShadow.setOffsetX(12.0);
    dropShadow.setOffsetY(12.0);
    dropShadow.setColor(Color.color(0.1, 0.8, 0.9));
    buttonStar.setEffect(dropShadow);


    Reflection reflection = new Reflection();

    reflection.setTopOpacity(0.2);
    reflection.setBottomOpacity(0.5);
    reflection.setTopOffset(10.8);
    reflection.setFraction(12);

    Text text = new Text();
    text.setX(20.0);
    text.setY(100.0);
    text.setCache(true);
    text.setText("   Star ");
    text.setFill(Color.AQUAMARINE);
    text.setFont(Font.font(null, FontPosture.ITALIC, 80));

    text.setEffect(reflection);


    Star star = new Star();
    buttonStar.setOnAction(e -> star.drawStar(primaryStage, RadiusStar));

    GridPane root = new GridPane();
    root.addRow(0, RadiusStarLabel, RadiusStar);
    root.addRow(1, buttonStar);
    root.addRow(2, text);

    primaryStage.setScene(new Scene(root, 800, 300));
    primaryStage.setTitle(" Star ");
    primaryStage.show();


  }

}

