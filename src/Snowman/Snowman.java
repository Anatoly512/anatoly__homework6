package Snowman;

import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class Snowman extends GridPane {

private Group snowman;
private Button fillCirclesColour;
private Button gradientGrey;
private Button drawStar;
private TextField amountOfCirclesText;
private TextField minCircleRadiusText;
private TextField maxCircleRadiusText;
private Integer amountOfCircles;
private Integer minCircleRadius;
private Integer maxCircleRadius;

Snowman (TextField amountOfCirclesText, TextField minCircleRadiusText, TextField maxCircleRadiusText)  {
    this.amountOfCirclesText = amountOfCirclesText;
    this.minCircleRadiusText = minCircleRadiusText;
    this.maxCircleRadiusText = maxCircleRadiusText;

    this.amountOfCircles = IntegerConvertor.convertTextToInteger(this.amountOfCirclesText);
    this.minCircleRadius = IntegerConvertor.convertTextToInteger(this.minCircleRadiusText);
    this.maxCircleRadius = IntegerConvertor.convertTextToInteger(this.maxCircleRadiusText);
}

    public void drawSnowman () {

        System.out.println("\nSnowman !");

        System.out.println("AmountOfCircles  =>  " + amountOfCircles);
        System.out.println("minCircleRadius  =>  " + minCircleRadius);
        System.out.println("maxCircleRadius  =>  " + maxCircleRadius);


    }





}
