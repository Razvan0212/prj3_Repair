package GFXHelpers;

import javafx.animation.FadeTransition;
import javafx.animation.Transition;
import javafx.animation.TranslateTransition;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class Transitions {
    public void fadeOutTransition(double desiredValue, double seconds, Node object){
        FadeTransition fadeOut = new FadeTransition(Duration.seconds(seconds), object);
        fadeOut.setFromValue(object.getOpacity());
        fadeOut.setToValue(desiredValue);
        fadeOut.play();
    }

    public void fadeInTransition(double desiredValue, double seconds, Node object){
        FadeTransition fadeIn = new FadeTransition(Duration.seconds(seconds), object);
        fadeIn.setFromValue(object.getOpacity());
        fadeIn.setToValue(desiredValue);
        fadeIn.play();
    }

    public void moveTo(double desiredValue, double seconds, ImageView object){
        TranslateTransition move = new TranslateTransition(Duration.seconds(seconds), object);
        move.setFromX(object.getLayoutX());
        move.setToX(desiredValue);
        move.play();
    }
}
