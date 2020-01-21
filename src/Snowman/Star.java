package Snowman;

import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Star extends Pane {

private Integer radius;

Star () {
}


    public void drawStar (Stage primaryStage, TextField Radius) {

        IntegerConvertor integerConvertor = new IntegerConvertor();
        this.radius = integerConvertor.convertTextToInteger(primaryStage, Radius);

        System.out.println("\nStar Draw !!!");

        System.out.println("Radius  => " + radius);



    }



}

