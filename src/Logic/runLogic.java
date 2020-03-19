package Logic;

import objects.Boat;
import objects.Bridge;
import objects.TrafficLight;

public class runLogic {
    MonitorObject sync1 = new MonitorObject();

    public void runLights(TrafficLight t1, TrafficLight t2) throws InterruptedException {
        while(true) {
            synchronized (this) {
                System.out.println("Traffic lights started");
                t1.next();
                t2.next();
                Thread.sleep(2000);
                t1.next();
                t2.next();
                Thread.sleep(2000);
                t1.next();
                t2.next();
                Thread.sleep(2000);
                wait();
            }
        }
    }

    public void runBridge(Bridge b) throws InterruptedException {
        while (true) {
            Thread.sleep(2000);
            synchronized (sync1) {
                synchronized (this) {
                    System.out.println("Bridge started");
                    b.next();
                    Thread.sleep(2000);
                    b.next();
                    System.out.println("Bridge is up!");
                    sync1.wait();
                    Thread.sleep(2000);
                    b.next();
                    Thread.sleep(2000);
                    b.next();
                    Thread.sleep(2000);
                    this.notify();
                }
            }
        }
    }

    public void runBoatOutsideBridge(Boat b) throws InterruptedException {
        while (true) {
            Thread.sleep(10000);
            b.next();
            System.out.println("Boat should get going!");
            synchronized (sync1) {
                Thread.sleep(2000);
                System.out.println("Boat goes under the bridge");
                b.next();
                Thread.sleep(3600);
                sync1.notify();
            }
            b.next();
            Thread.sleep(2000);
        }
    }
}

class MonitorObject{}
