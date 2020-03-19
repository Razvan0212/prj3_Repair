package Observer;

import interfaces.Updatable;

public class BridgeObserver extends Observer {
    public BridgeObserver(){}

    public BridgeObserver(Updatable updatable) {
        this.updatable = updatable;
    }

    public void setUpdatable(Updatable updatable){
        this.updatable = updatable;
    }

    @Override
    public void update() {
        this.updatable.update();
    }
}
