package week_07;
// java_homework # 3

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.FontPosture;

public class ColorfulBoxes extends Application {

    @Override
    public void start(Stage primaryStage) {
        GridPane pane = new GridPane();
        //create 10x10 matrix
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                Integer rnd = (int) (Math.random() * 100) + 1;
                pane.add(new CustomPane(rnd), i, j);
            }
        }
        //create scene, place into stage
        Scene scene = new Scene(pane);
        primaryStage.setTitle("10 by 10 matrix");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

class CustomPane extends StackPane {

    public CustomPane(Integer text) {
        //create rectangle object(30x30, random-color, opacity:0.5)
        Rectangle r = new Rectangle(0, 0, 30, 30);
        r.setFill(new Color(Math.random(), Math.random(), Math.random(), 0.5));
        //create text object(numbers as string)
        Text number = new Text(text.toString());
        number.setFont(Font.font("Calibri", FontWeight.BOLD, FontPosture.REGULAR, 12));
        //adding 
        getChildren().addAll(r, number);
    }
}
