import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import objects.Bridge;
import objects.TrafficLight;
import Factory.AbstractFactory;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/map.fxml"));
        Parent root = loader.load();
        primaryStage.setTitle("Water pass");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

//    public static void main(String[] args) {
//        AbstractFactory factory = new AbstractFactory();
//
//        Bridge bridge = factory.createBridge();
//        bridge.nextState();
//        bridge.nextState();
//        bridge.nextState();
//        bridge.nextState();
//
//        TrafficLight trafficLight = factory.createTrafficLight();
//        trafficLight.next();
//        trafficLight.next();
//        trafficLight.next();
//    }
}
