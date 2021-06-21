package week_10;
// java_homework # 4

import javafx.animation.FadeTransition;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class CircleWithName extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        Pane pane = new Pane();
        double width = 600;
        double height = 600;
        Scene scene = new Scene(pane, width, height);
        double radius = Math.min(width, height) * 0.25;
        Circle circle = new Circle(width / 2, height / 2, radius, Color.TRANSPARENT);
        circle.setStroke(Color.RED);
        circle.setRotate(180);
        Text text = new Text("EDA NUR COŞKUN");
        Font font = Font.font("Calibri", FontWeight.BOLD, FontPosture.ITALIC, 24);
        text.setFont(font);

        //1. Create a path transition. 
        PathTransition path = new PathTransition();
        path.setOrientation(PathTransition.OrientationType.NONE);

        //2. Set the duration of this animation as 10000
        path.setDuration(Duration.millis(10000));

        //3. The path will be the circle
        path.setPath(circle);

        //4. The node will be the text
        path.setNode(text);

        //5. The animation will cycle indefinite number of cycles
        path.setCycleCount(Timeline.INDEFINITE);

        //6. The animation will automatically reverse 
        path.setAutoReverse(true);

        //7. Start the path transition
        path.play();

        //8. Create a fade transition on the text
        FadeTransition fade = new FadeTransition();

        //9. Set the duration of this animation as 5000
        fade.setDuration(Duration.millis(5000));

        //10. The node will be the text
        fade.setNode(text);

        //11. The animation fade value will change from 1.0 to 0.0
        fade.setFromValue(1.0);
        fade.setToValue(0.0);

        //12. The animation will cycle indefinite number of cycles
        fade.setCycleCount(Timeline.INDEFINITE);

        //13. The animation will automatically reverse
        fade.setAutoReverse(true);

        //14. Start the fade transition
        fade.play();

        //15. When the mouse is pressed on the pane both of the animations should pause
        pane.setOnMousePressed(e -> {
            path.pause();
            fade.pause();
        });

        //16. When the mouse is released from the pane both of the animations will continue to play
        pane.setOnMouseReleased(e -> {
            path.play();
            fade.play();
        });

        pane.getChildren().addAll(text, circle);
        primaryStage.setScene(scene);
        primaryStage.setTitle("WEEK 10-HW");
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
