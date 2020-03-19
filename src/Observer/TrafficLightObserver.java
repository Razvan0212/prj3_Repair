package Observer;

import interfaces.Updatable;

public class TrafficLightObserver extends Observer{
    public TrafficLightObserver(){}

    @Override
    public void setUpdatable(Updatable updatable){
        this.updatable = updatable;
    }

    @Override
    public void update() {
        this.updatable.update();
    }
}
