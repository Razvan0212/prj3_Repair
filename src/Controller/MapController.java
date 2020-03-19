package Controller;

import Factory.AbstractFactory;
import Logic.runLogic;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import objects.Boat;
import objects.Bridge;
import objects.TrafficLight;

import java.awt.*;
import java.io.IOException;

public class MapController {
    @FXML
    public Button goButton;
    @FXML
    public Circle yellowUp;
    @FXML
    public Circle greenUp;
    @FXML
    public Circle redUp;
    @FXML
    public Circle yellowDown;
    @FXML
    public Circle greenDown;
    @FXML
    public Circle redDown;
    @FXML
    public Pane bridge;
    public javafx.scene.control.Button goButto;
    public ImageView boat;

    TrafficLight traficUp;
    TrafficLight traficDown;
    Bridge bridgeObj;
    Boat boatObj;

    @FXML
    public void initialize() {


        Pane thisIsAFix = bridge;
        AbstractFactory factory = new AbstractFactory();

        traficUp = factory.createTrafficLight(greenUp, yellowUp, redUp);
        traficDown = factory.createTrafficLight(greenDown, yellowDown, redDown);
        bridgeObj = factory.createBridge(thisIsAFix);
        boatObj = factory.createBoat(boat, bridgeObj);
    }

    public void start(ActionEvent actionEvent) {
        runLogic logic = new runLogic();
        Thread t1 = new Thread(){
          public void run(){
              try {
                  logic.runLights(traficUp, traficDown);
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }
          }
        };

        Thread t2 = new Thread(){
            public void run(){
                try {
                    logic.runBridge(bridgeObj);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread t3 = new Thread(){
            public void run(){
                try {
                    logic.runBoatOutsideBridge(boatObj);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        t1.start();
        t2.start();
        t3.start();
    }
}
