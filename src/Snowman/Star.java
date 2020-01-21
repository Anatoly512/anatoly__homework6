package Snowman;

import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class Star extends Pane {

private Integer radius;

Star () {
}


    public void drawStar (TextField Radius) {

        this.radius = IntegerConvertor.convertTextToInteger(Radius);

        System.out.println("\nStar Draw !!!");

        System.out.println("Radius  => " + radius);



    }



}

